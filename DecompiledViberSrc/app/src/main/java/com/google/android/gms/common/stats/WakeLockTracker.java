package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class WakeLockTracker
{

  @VisibleForTesting
  private static boolean zzfb = false;
  private static WakeLockTracker zzgb = new WakeLockTracker();
  private static Boolean zzgc;

  @KeepForSdk
  public static WakeLockTracker getInstance()
  {
    return zzgb;
  }

  @KeepForSdk
  public void registerAcquireEvent(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    List localList = Arrays.asList(new String[] { paramString4 });
    registerEvent(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 7, paramString1, paramString2, paramString3, paramInt, localList);
  }

  @KeepForSdk
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList)
  {
    registerEvent(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }

  @KeepForSdk
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong)
  {
    if (zzgc == null)
      zzgc = Boolean.valueOf(false);
    if (!zzgc.booleanValue());
    long l1;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        String str2 = String.valueOf(paramString1);
        if (str2.length() != 0);
        for (String str3 = "missing wakeLock key. ".concat(str2); ; str3 = new String("missing wakeLock key. "))
        {
          Log.e("WakeLockTracker", str3);
          return;
        }
      }
      l1 = System.currentTimeMillis();
    }
    while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    if ((paramList != null) && (paramList.size() == 1))
      if ("com.google.android.gms".equals(paramList.get(0)))
        paramList = null;
    for (List<String> localList = paramList; ; localList = paramList)
    {
      long l2 = SystemClock.elapsedRealtime();
      int i = zza.zzg(paramContext);
      String str1 = paramContext.getPackageName();
      if ("com.google.android.gms".equals(str1))
        str1 = null;
      WakeLockEvent localWakeLockEvent = new WakeLockEvent(l1, paramInt1, paramString2, paramInt2, localList, paramString1, l2, i, paramString3, str1, zza.zzh(paramContext), paramLong, paramString4);
      try
      {
        paramContext.startService(new Intent().setComponent(LoggingConstants.zzfg).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", localWakeLockEvent));
        return;
      }
      catch (Exception localException)
      {
        Log.wtf("WakeLockTracker", localException);
        return;
      }
    }
  }

  @KeepForSdk
  public void registerReleaseEvent(Context paramContext, Intent paramIntent)
  {
    registerEvent(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 8, null, null, null, 0, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockTracker
 * JD-Core Version:    0.6.2
 */