package com.appboy;

import a.a.dm;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appboy.f.c;

public class AppboyBootReceiver extends BroadcastReceiver
{
  private static final String a = c.a(AppboyBootReceiver.class);

  boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      c.d(a, "Null intent received. Doing nothing.");
      return false;
    }
    if (paramContext == null)
    {
      c.d(a, "Null context received for intent " + paramIntent.toString() + ". Doing nothing.");
      return false;
    }
    c.c(a, "Received broadcast message. Message: " + paramIntent.toString());
    if ("android.intent.action.BOOT_COMPLETED".equals(paramIntent.getAction()))
    {
      c.c(a, "Boot complete intent received. Initializing.");
      dm.a(paramContext);
      a.a(paramContext);
      return true;
    }
    c.d(a, "Unknown intent " + paramIntent.toString() + " received. Doing nothing.");
    return false;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a(paramContext, paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.AppboyBootReceiver
 * JD-Core Version:    0.6.2
 */