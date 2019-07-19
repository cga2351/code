package com.adsnative.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class a
{
  public static NetworkInfo a(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }

  public static boolean b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = a(paramContext);
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }

  public static boolean c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = a(paramContext);
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected()) && (localNetworkInfo.getType() == 1);
  }

  public static boolean d(Context paramContext)
  {
    NetworkInfo localNetworkInfo = a(paramContext);
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected()) && (localNetworkInfo.getType() == 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.a
 * JD-Core Version:    0.6.2
 */