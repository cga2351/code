package com.viber.voip.phone.viber;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerTransferCall;
import com.viber.jni.dialer.DialerTransferCallListener;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av.e;
import com.viber.voip.mvp.core.d;
import com.viber.voip.mvp.core.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.af;
import com.viber.voip.ui.dialogs.b;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;

public class CallFragment<VIEW extends d> extends g<VIEW>
  implements DialerControllerDelegate.DialerTransferCall
{
  private com.viber.voip.util.e.a.a mBackgroundLoadListener;
  private CallHandler mCallHandler;
  private EngineDelegatesManager mDelegatesManager;
  private DialerController mDialerController;
  private HardwareParameters mHardwareParameters;
  protected e mImageFetcher;
  protected boolean mIsTablet;
  private PowerManager mPowerManager;
  private IRingtonePlayer mRinger;
  private ISoundService mSoundService;

  private void showTransferFailedDialog(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 3:
    default:
      b.e().f(R.string.dialog_344_message_failed).a(getActivity());
      return;
    case 1:
    case 7:
      b.d().a(new ViberDialogHandlers.af()).a(getActivity());
      return;
    case 6:
      b.e().d();
      return;
    case 4:
      b.g().b(-1, new Object[] { paramString }).a(getActivity());
      return;
    case 2:
      b.f().d();
      return;
    case 5:
    }
    b.e().f(R.string.dialog_344_message_timeout).a(getActivity());
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
  }

  public CallHandler getCallHandler()
  {
    if (this.mCallHandler == null)
      this.mCallHandler = ViberApplication.getInstance().getEngine(true).getCallHandler();
    return this.mCallHandler;
  }

  public EngineDelegatesManager getDelegatesManager()
  {
    if (this.mDelegatesManager == null)
      this.mDelegatesManager = ViberApplication.getInstance().getEngine(false).getDelegatesManager();
    return this.mDelegatesManager;
  }

  public DialerController getDialerController()
  {
    if (this.mDialerController == null)
      this.mDialerController = ViberApplication.getInstance().getEngine(true).getDialerController();
    return this.mDialerController;
  }

  public HardwareParameters getHardwareParameters()
  {
    if (this.mHardwareParameters == null)
      this.mHardwareParameters = ViberApplication.getInstance().getHardwareParameters();
    return this.mHardwareParameters;
  }

  public PowerManager getPowerManager()
  {
    if (this.mPowerManager == null)
      this.mPowerManager = ((PowerManager)ViberApplication.getApplication().getSystemService("power"));
    return this.mPowerManager;
  }

  public IRingtonePlayer getRinger()
  {
    if (this.mRinger == null)
      this.mRinger = ViberApplication.getInstance().getRingtonePlayer();
    return this.mRinger;
  }

  public ISoundService getSoundService()
  {
    if (this.mSoundService == null)
      this.mSoundService = ViberApplication.getInstance().getSoundService();
    return this.mSoundService;
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void loadPhoto(final View paramView, final Uri paramUri, final int paramInt)
  {
    dj.a(paramView, new Runnable()
    {
      public void run()
      {
        if ((paramView.getMeasuredWidth() > 0) && (paramView.getMeasuredHeight() > 0))
        {
          f.a locala;
          if (CallFragment.this.getActivity() != null)
          {
            locala = f.a(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), true).f();
            locala.b(Integer.valueOf(paramInt));
            locala.a(com.viber.voip.b.a.j);
            locala.c(true);
            if ((paramView instanceof ImageView))
              CallFragment.this.mImageFetcher.a(paramUri, (ImageView)paramView, locala.c());
          }
          else
          {
            return;
          }
          CallFragment.access$002(CallFragment.this, new com.viber.voip.util.e.a.a(paramView));
          CallFragment.this.mImageFetcher.a(paramUri, locala.c(), CallFragment.this.mBackgroundLoadListener);
          return;
        }
        dj.a(paramView, this);
      }
    });
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mImageFetcher = e.a(paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mIsTablet = ViberApplication.isTablet(getActivity());
  }

  public void onStart()
  {
    super.onStart();
    getDelegatesManager().getDialerTransferCallListener().registerDelegate(this, av.e.a.a());
  }

  public void onStop()
  {
    super.onStop();
    getDelegatesManager().getDialerTransferCallListener().removeDelegate(this);
  }

  public void onTransferFailed(int paramInt)
  {
    if ((paramInt == 3) || (paramInt == 5));
    CallInfo localCallInfo;
    do
    {
      return;
      localCallInfo = this.mCallHandler.getCallInfo();
    }
    while ((localCallInfo == null) || (getActivity() == null));
    com.viber.voip.model.a locala = localCallInfo.getCallerInfo().getContact();
    if (locala != null);
    for (String str = locala.k(); ; str = localCallInfo.getCallerInfo().getPhoneNumber())
    {
      showTransferFailedDialog(paramInt, str);
      return;
    }
  }

  public void onTransferReplyOK(long paramLong)
  {
  }

  protected class EndCallClickListener
    implements View.OnClickListener
  {
    protected EndCallClickListener()
    {
    }

    public void onClick(View paramView)
    {
      CallFragment.this.getCallHandler().handleHangup();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.CallFragment
 * JD-Core Version:    0.6.2
 */