package com.viber.voip.registration.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;

public class SmsBroadcastReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    EventBus localEventBus;
    if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(paramIntent.getAction()))
    {
      Status localStatus = (Status)paramIntent.getParcelableExtra("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
      localEventBus = com.viber.voip.h.a.b();
      if (localStatus != null)
        switch (localStatus.getStatusCode())
        {
        default:
        case 0:
        case 15:
        }
    }
    do
    {
      String str;
      do
      {
        return;
        str = paramIntent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
      }
      while (da.a(str));
      localEventBus.postSticky(new a(str));
      return;
    }
    while (ViberApplication.isActivated());
    b.a(SmsRetriever.getClient(paramContext));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.sms.SmsBroadcastReceiver
 * JD-Core Version:    0.6.2
 */