package com.viber.voip.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.storage.c;

public class SDCardBroadcastReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    localViberApplication.initApplication();
    String str = paramIntent.getAction();
    if ("android.intent.action.MEDIA_MOUNTED".equals(str))
      localViberApplication.getMediaMountManager().a();
    while (!"android.intent.action.MEDIA_UNMOUNTED".equals(str))
      return;
    localViberApplication.getMediaMountManager().b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.SDCardBroadcastReceiver
 * JD-Core Version:    0.6.2
 */