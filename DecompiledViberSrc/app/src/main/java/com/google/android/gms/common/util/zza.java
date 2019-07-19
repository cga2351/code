package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zza
{
  private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private static long zzgt;
  private static float zzgu = (0.0F / 0.0F);

  @TargetApi(20)
  public static int zzg(Context paramContext)
  {
    int i = 1;
    if ((paramContext == null) || (paramContext.getApplicationContext() == null))
      return -1;
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, filter);
    int j;
    if (localIntent == null)
    {
      j = 0;
      if ((j & 0x7) == 0)
        break label72;
    }
    PowerManager localPowerManager;
    label72: for (int k = i; ; k = 0)
    {
      localPowerManager = (PowerManager)paramContext.getSystemService("power");
      if (localPowerManager != null)
        break label78;
      return -1;
      j = localIntent.getIntExtra("plugged", 0);
      break;
    }
    label78: boolean bool;
    int m;
    label99: int n;
    if (PlatformVersion.isAtLeastKitKatWatch())
    {
      bool = localPowerManager.isInteractive();
      if (!bool)
        break label125;
      m = i;
      n = m << 1;
      if (k == 0)
        break label131;
    }
    while (true)
    {
      return n | i;
      bool = localPowerManager.isScreenOn();
      break;
      label125: m = 0;
      break label99;
      label131: i = 0;
    }
  }

  public static float zzh(Context paramContext)
  {
    try
    {
      if ((SystemClock.elapsedRealtime() - zzgt < 60000L) && (!Float.isNaN(zzgu)));
      for (float f = zzgu; ; f = zzgu)
      {
        return f;
        Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, filter);
        if (localIntent != null)
        {
          int i = localIntent.getIntExtra("level", -1);
          int j = localIntent.getIntExtra("scale", -1);
          zzgu = i / j;
        }
        zzgt = SystemClock.elapsedRealtime();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zza
 * JD-Core Version:    0.6.2
 */