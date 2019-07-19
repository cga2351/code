package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.google.android.exoplayer2.g.ag;

public final class a
{
  private static final String[] a = null;
  private final int b;

  public a(int paramInt)
  {
    this.b = paramInt;
  }

  public a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  private static void a(String paramString)
  {
  }

  private static boolean a(ConnectivityManager paramConnectivityManager)
  {
    if (ag.a < 23)
      return true;
    Network localNetwork = paramConnectivityManager.getActiveNetwork();
    if (localNetwork == null)
    {
      a("No active network.");
      return false;
    }
    NetworkCapabilities localNetworkCapabilities = paramConnectivityManager.getNetworkCapabilities(localNetwork);
    if ((localNetworkCapabilities == null) || (!localNetworkCapabilities.hasCapability(16)));
    for (boolean bool = true; ; bool = false)
    {
      a("Network capability validated: " + bool);
      if (!bool)
        break;
      return false;
    }
  }

  private static boolean a(ConnectivityManager paramConnectivityManager, NetworkInfo paramNetworkInfo)
  {
    int i = 1;
    if (ag.a >= 16)
      i = paramConnectivityManager.isActiveNetworkMetered();
    int j;
    do
    {
      return i;
      j = paramNetworkInfo.getType();
    }
    while ((j != i) && (j != 7) && (j != 9));
    return false;
  }

  private boolean b(Context paramContext)
  {
    int i = a();
    if (i == 0);
    boolean bool1;
    do
    {
      ConnectivityManager localConnectivityManager;
      NetworkInfo localNetworkInfo;
      do
      {
        return true;
        localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
        {
          a("No network info or no connection.");
          return false;
        }
        if (!a(localConnectivityManager))
          return false;
      }
      while (i == 1);
      if (i == 3)
      {
        boolean bool2 = localNetworkInfo.isRoaming();
        a("Roaming: " + bool2);
        if (!bool2);
        for (boolean bool3 = true; ; bool3 = false)
          return bool3;
      }
      bool1 = a(localConnectivityManager, localNetworkInfo);
      a("Metered network: " + bool1);
      if (i != 2)
        break;
    }
    while (!bool1);
    return false;
    if (i == 4)
      return bool1;
    throw new IllegalStateException();
  }

  private boolean c(Context paramContext)
  {
    boolean bool;
    if (!b())
      bool = true;
    int i;
    do
    {
      Intent localIntent;
      do
      {
        return bool;
        localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        bool = false;
      }
      while (localIntent == null);
      i = localIntent.getIntExtra("status", -1);
      if (i == 2)
        break;
      bool = false;
    }
    while (i != 5);
    return true;
  }

  private boolean d(Context paramContext)
  {
    if (!c())
      return true;
    PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
    boolean bool;
    if (ag.a >= 23)
      bool = localPowerManager.isDeviceIdleMode();
    while (true)
    {
      return bool;
      if (ag.a >= 20)
      {
        if (!localPowerManager.isInteractive())
          bool = true;
        else
          bool = false;
      }
      else if (!localPowerManager.isScreenOn())
        bool = true;
      else
        bool = false;
    }
  }

  public int a()
  {
    return 0x7 & this.b;
  }

  public boolean a(Context paramContext)
  {
    return (b(paramContext)) && (c(paramContext)) && (d(paramContext));
  }

  public boolean b()
  {
    return (0x10 & this.b) != 0;
  }

  public boolean c()
  {
    return (0x8 & this.b) != 0;
  }

  public String toString()
  {
    return super.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.scheduler.a
 * JD-Core Version:    0.6.2
 */