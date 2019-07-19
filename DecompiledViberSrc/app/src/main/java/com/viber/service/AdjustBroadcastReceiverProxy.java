package com.viber.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.AdjustReferrerReceiver;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.bf;

public class AdjustBroadcastReceiverProxy extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  public boolean a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("referrer") != null;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (a(paramIntent))
      d.bf.o.a(true);
    new AdjustReferrerReceiver().onReceive(paramContext, paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.AdjustBroadcastReceiverProxy
 * JD-Core Version:    0.6.2
 */