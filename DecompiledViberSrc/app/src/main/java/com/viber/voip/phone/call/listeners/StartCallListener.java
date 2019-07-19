package com.viber.voip.phone.call.listeners;

import android.app.Application;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerControllerDelegate.DialerIncomingScreen;
import com.viber.jni.dialer.DialerControllerDelegate.DialerOutgoingScreen;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.notif.i.i;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.registration.AuthSecondaryActivity;
import com.viber.voip.util.ViberActionRunner.a;
import com.viber.voip.util.ViberActionRunner.ad;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.cf;
import java.util.Map;

public class StartCallListener
  implements DialerControllerDelegate.DialerIncomingScreen, DialerControllerDelegate.DialerOutgoingScreen, CallHandler.CallInfoReadyListener
{
  private static final Logger L = ViberEnv.getLogger();
  private CallInfo mCallInfo;
  private CallScreenKeeperHack mCallScreenKeeperHack = new CallScreenKeeperHack(null);
  private Application mContext;
  private boolean mShowCall = false;
  private boolean mShowIncoming = false;

  public StartCallListener(Application paramApplication)
  {
    this.mContext = paramApplication;
  }

  public void hideCall(String paramString, boolean paramBoolean)
  {
    this.mCallInfo = null;
    this.mShowCall = false;
  }

  public void hideReception()
  {
    this.mCallScreenKeeperHack.stop();
    this.mCallInfo = null;
    this.mShowIncoming = false;
  }

  public void onCallInfoReady(CallInfo paramCallInfo)
  {
    this.mCallInfo = paramCallInfo;
    if (this.mShowCall)
      ViberActionRunner.r.b(this.mContext, ViberApplication.isTablet(this.mContext)).a(this.mContext);
    while (!this.mShowIncoming)
      return;
    ViberActionRunner.r.a(this.mContext, ViberApplication.getInstance().isOnForeground(), this.mCallInfo).a(this.mContext);
  }

  public void showCall(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mShowCall = true;
    if (this.mCallInfo != null)
      ViberActionRunner.r.b(this.mContext, ViberApplication.isTablet(this.mContext)).a(this.mContext);
  }

  public void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    this.mCallScreenKeeperHack.start();
    this.mShowIncoming = true;
    if (this.mCallInfo != null)
      ViberActionRunner.r.a(this.mContext, ViberApplication.getInstance().isOnForeground(), this.mCallInfo).a(this.mContext);
  }

  private class CallScreenKeeperHack
    implements Runnable
  {
    private static final int UPDATE_INTERVAL_MS = 1000;
    private cf mon = new cf(av.a(av.e.e), this, 1000L);

    private CallScreenKeeperHack()
    {
    }

    boolean needShowReception()
    {
      if (!i.a())
      {
        ViberApplication localViberApplication = ViberApplication.getInstance();
        String[] arrayOfString = new String[2];
        arrayOfString[0] = PhoneFragmentActivity.class.getName();
        arrayOfString[1] = AuthSecondaryActivity.class.getName();
        if (!localViberApplication.isActivityOnForeground(arrayOfString))
          return true;
      }
      return false;
    }

    public void run()
    {
      if ((needShowReception()) && (StartCallListener.this.mCallInfo != null))
        ViberActionRunner.r.a(StartCallListener.this.mContext, ViberApplication.getInstance().isOnForeground(), StartCallListener.this.mCallInfo).a(StartCallListener.this.mContext);
    }

    public void start()
    {
      this.mon.a();
    }

    public void stop()
    {
      this.mon.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.StartCallListener
 * JD-Core Version:    0.6.2
 */