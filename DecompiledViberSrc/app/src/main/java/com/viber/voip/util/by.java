package com.viber.voip.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.viber.common.b.b;
import com.viber.voip.settings.d.af;

public class by
{
  public static void a()
  {
    d.af.f.a(false);
  }

  public static boolean a(Context paramContext)
  {
    if (d.af.f.d())
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      return (localNetworkInfo != null) && (localNetworkInfo.getType() == 0) && (localTelephonyManager.isNetworkRoaming());
    }
    return false;
  }

  @TargetApi(17)
  public static boolean b(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null)
      bool = false;
    do
    {
      do
      {
        return bool;
        if (Build.VERSION.SDK_INT >= 17)
          break;
      }
      while (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0);
      return false;
    }
    while (Settings.Global.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.by
 * JD-Core Version:    0.6.2
 */