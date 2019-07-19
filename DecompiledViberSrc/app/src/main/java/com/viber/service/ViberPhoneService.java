package com.viber.service;

import android.content.Intent;
import android.os.IBinder;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import javax.inject.Inject;

public class ViberPhoneService extends ViberIntentService
{
  private static final Logger c = ViberEnv.getLogger();

  @Inject
  dagger.a<CallHandler> a;

  @Inject
  dagger.a<DialerController> b;

  public ViberPhoneService()
  {
    super("ViberPhoneService");
  }

  private void a()
  {
    CallInfo localCallInfo = ((CallHandler)this.a.get()).getCallInfo();
    if (localCallInfo == null)
      return;
    localCallInfo.getInCallState().setUserReaction(true);
    ((DialerController)this.b.get()).handleDecline();
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    dagger.android.a.a(this);
    super.onCreate();
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null)
      return;
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -1182276683:
    }
    while (true)
    {
      switch (i)
      {
      default:
        return;
      case 0:
      }
      a();
      return;
      if (str.equals("com.viber.voip.action.REJECT_CALL"))
        i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.ViberPhoneService
 * JD-Core Version:    0.6.2
 */