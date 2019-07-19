package com.viber.voip.phone;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.l.a;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.ConferenceContactsComposeListActivity;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.notif.i.a.b;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.settings.b;
import com.viber.voip.settings.d.aj;
import com.viber.voip.ui.dialogs.q;
import com.viber.voip.ui.y;
import com.viber.voip.ui.y.a;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.i;
import com.viber.voip.util.p;
import com.viber.voip.widget.PausableChronometer;

public class MinimizedCallManager extends y
  implements d.b
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int TIMEOUT = 5000;
  private static volatile MinimizedCallManager sInstance;
  private CallHandler mCallHandler = ViberApplication.getInstance().getEngine(false).getCallHandler();
  private a.b mCallNotifierListener = new a.b()
  {
    private void onCall(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, Uri paramAnonymousUri, ConferenceInfo paramAnonymousConferenceInfo)
    {
      boolean bool = true;
      MinimizedCallManager.access$202(MinimizedCallManager.this, bool);
      if (MinimizedCallManager.this.mView == null)
      {
        MinimizedCallManager.this.initMinimizedView();
        if ((!paramAnonymousString1.equals(MinimizedCallManager.this.mContext.getString(R.string.unknown))) || ("private_number".equals(paramAnonymousString2)))
          break label152;
        label59: if (paramAnonymousConferenceInfo == null)
          break label158;
        paramAnonymousString2 = p.a(paramAnonymousConferenceInfo, false);
      }
      while (true)
      {
        MinimizedCallManager.this.mName.setText(paramAnonymousString2);
        if (paramAnonymousConferenceInfo != null)
          paramAnonymousUri = Uri.parse("android.resource://com.viber.voip/drawable/ic_community_default");
        MinimizedCallManager.this.mImageFetcher.a(paramAnonymousUri, MinimizedCallManager.this.mPhoto, MinimizedCallManager.this.mFetcherConfig);
        MinimizedCallManager.this.mChronometer.setText(paramAnonymousInt);
        return;
        MinimizedCallManager.this.mView.setOnClickListener(MinimizedCallManager.this.mViewClickListener);
        break;
        label152: bool = false;
        break label59;
        label158: if (!bool)
          paramAnonymousString2 = paramAnonymousString1;
      }
    }

    private void onCallEnded(int paramAnonymousInt)
    {
      if ((MinimizedCallManager.this.mView != null) && (MinimizedCallManager.this.mChronometer != null))
        MinimizedCallManager.this.mChronometer.setText(paramAnonymousInt);
      MinimizedCallManager.access$202(MinimizedCallManager.this, false);
    }

    private void removeDelayed()
    {
      if (MinimizedCallManager.this.mView != null)
      {
        MinimizedCallManager.this.mView.setOnClickListener(null);
        av.a(av.e.a).postDelayed(new Runnable()
        {
          public void run()
          {
            if (!MinimizedCallManager.this.mIsInCall)
              MinimizedCallManager.this.removeMinimizedView();
          }
        }
        , 5000L);
      }
    }

    public void onChronometerTick(long paramAnonymousLong)
    {
      if ((MinimizedCallManager.this.mIsInCall) && (MinimizedCallManager.this.mChronometer != null))
        MinimizedCallManager.this.mChronometer.setBase(SystemClock.elapsedRealtime() - paramAnonymousLong);
    }

    public void onEndedCall(int paramAnonymousInt)
    {
      if (4 == paramAnonymousInt);
      for (int i = R.string.minimized_call_disconnected; ; i = R.string.minimized_call_ended)
      {
        onCallEnded(i);
        removeDelayed();
        return;
      }
    }

    public void onEndingCall()
    {
      onCallEnded(R.string.minimized_call_ended);
    }

    public void onFailedCall(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i = R.string.minimized_call_failed;
      if (3 == paramAnonymousInt2)
        i = R.string.minimized_call_disconnected;
      while (true)
      {
        onCallEnded(i);
        return;
        if (1 == paramAnonymousInt1)
          i = R.string.minimized_call_busy;
      }
    }

    public void onHold(boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousBoolean) && (MinimizedCallManager.this.mChronometer != null))
        MinimizedCallManager.this.mChronometer.setText(R.string.minimized_call_on_hold);
      if (ViberApplication.getInstance().getEngine(true).isGSMCallActive())
        MinimizedCallManager.this.hideInternally();
      while (ViberApplication.getInstance().isOnForeground())
        return;
      MinimizedCallManager.this.showInternally();
    }

    public void onIdleCall()
    {
      onCallEnded(R.string.minimized_call_ended);
      removeDelayed();
    }

    public void onIncomingCall(String paramAnonymousString1, String paramAnonymousString2, Uri paramAnonymousUri, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, ConferenceInfo paramAnonymousConferenceInfo)
    {
      onCall(paramAnonymousString1, paramAnonymousString2, R.string.minimized_call_incoming, paramAnonymousUri, paramAnonymousConferenceInfo);
    }

    public void onOutgoingCall(String paramAnonymousString1, String paramAnonymousString2, Uri paramAnonymousUri, ConferenceInfo paramAnonymousConferenceInfo)
    {
      onCall(paramAnonymousString1, paramAnonymousString2, R.string.minimized_call_outgoing, paramAnonymousUri, paramAnonymousConferenceInfo);
    }

    public void onReconnecting(boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousBoolean) && (MinimizedCallManager.this.mChronometer != null))
        MinimizedCallManager.this.mChronometer.setText(R.string.minimized_call_reconnecting);
    }
  };
  private PausableChronometer mChronometer;
  private f mFetcherConfig;
  private e mImageFetcher = e.a(this.mContext);
  private boolean mIsInCall;
  private TextView mName;
  private ImageView mPhoto;
  private boolean mShow;
  private final Object mSync = new Object();

  private MinimizedCallManager(Context paramContext, y.a parama, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, parama, paramLayoutInflater);
    this.mFetcherConfig = f.b(paramContext);
  }

  private com.viber.voip.p.a getCallProximityHelper()
  {
    return ViberApplication.getInstance().getPhoneApp().getCallProximityHelper();
  }

  public static MinimizedCallManager getInstance()
  {
    if (sInstance == null)
    {
      Application localApplication = ViberApplication.getApplication();
      sInstance = new MinimizedCallManager(localApplication, new y.a(localApplication)
      {
        public int height()
        {
          return this.mResources.getDimensionPixelSize(R.dimen.minimized_call_height);
        }

        public int layoutId()
        {
          return R.layout._ics_layout_minimized_call;
        }

        public int topMargin()
        {
          return this.mResources.getDimensionPixelSize(R.dimen.minimized_call_top_margin);
        }

        public int width()
        {
          return this.mResources.getDimensionPixelSize(R.dimen.minimized_call_width);
        }
      }
      , LayoutInflater.from(localApplication));
    }
    return sInstance;
  }

  public boolean endCallIfNeeded()
  {
    if ((this.mCallHandler != null) && (this.mIsInCall))
    {
      this.mCallHandler.handleHangup();
      ViberApplication.getInstance().getEngine(true).getDialerController().handleHangup();
      return true;
    }
    return false;
  }

  public void init()
  {
    ViberApplication.getInstance().getEngine(false).getCallHandler().getCallNotifier().a(this.mCallNotifierListener);
    d.c(this);
  }

  protected void initMinimizedView()
  {
    super.initMinimizedView();
    this.mPhoto = ((ImageView)this.mView.findViewById(R.id.photo));
    this.mName = ((TextView)this.mView.findViewById(R.id.name));
    this.mChronometer = ((PausableChronometer)this.mView.findViewById(R.id.chronometer));
    this.mChronometer.setFormat(this.mContext.getString(R.string.minimized_call_chronometer_format));
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    if (this.mShow)
      new ShowRunnable(null).post();
  }

  protected void onClick(View paramView)
  {
    Intent localIntent = ViberActionRunner.r.a();
    localIntent.setFlags(268435456);
    this.mContext.startActivity(localIntent);
    super.onClick(paramView);
  }

  public void onForeground()
  {
    i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  public void setCallProximityEnabled(boolean paramBoolean)
  {
    synchronized (this.mSync)
    {
      getCallProximityHelper().a(paramBoolean);
      return;
    }
  }

  public void setCallStarted(boolean paramBoolean)
  {
    Object localObject1 = this.mSync;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
      try
      {
        this.mShow = bool;
        new ShowRunnable(null).post();
        return;
      }
      finally
      {
      }
  }

  protected void showInternally()
  {
    if (!this.mIsInCall);
    label82: label87: 
    do
    {
      return;
      CallInfo localCallInfo = this.mCallHandler.getCallInfo();
      String[] arrayOfString;
      if (localCallInfo != null)
      {
        c localc = c.a(this.mContext);
        if (localCallInfo.isIncomingVideoCall())
        {
          arrayOfString = n.g;
          if (!localc.a(arrayOfString))
            break label82;
        }
      }
      for (int i = 1; ; i = 0)
      {
        if ((!dj.e(this.mContext)) || (i == 0))
          break label87;
        addMinimizedView();
        super.showInternally();
        return;
        arrayOfString = n.h;
        break;
      }
    }
    while ((!ViberApplication.getInstance().isOnForeground()) || (d.aj.a.d() <= 0));
    q.c().d();
  }

  private class ShowRunnable
    implements Runnable
  {
    private ShowRunnable()
    {
    }

    public void post()
    {
      Handler localHandler = av.a(av.e.a);
      localHandler.removeCallbacks(this);
      localHandler.postDelayed(this, 1000L);
    }

    public void run()
    {
      synchronized (MinimizedCallManager.this.mSync)
      {
        if (MinimizedCallManager.this.mShow)
        {
          String str = ViberApplication.getInstance().getActivityOnForeground();
          if ((!ViberApplication.getInstance().isOnForeground()) || (str == null) || ((!str.equals(PhoneFragmentActivity.class.getName())) && (!str.equals(TabletVideoCallActivity.class.getName())) && (!str.equals("com.viber.voip.phone.PhoneActivityFromBackground")) && (!str.equals(ConferenceContactsComposeListActivity.class.getName())) && (!ViberApplication.getInstance().getEngine(false).isGSMCallActive())))
          {
            MinimizedCallManager.this.showInternally();
            MinimizedCallManager.this.getCallProximityHelper().a(false);
          }
          return;
        }
        MinimizedCallManager.this.hideInternally();
        MinimizedCallManager.this.getCallProximityHelper().a(true);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.MinimizedCallManager
 * JD-Core Version:    0.6.2
 */