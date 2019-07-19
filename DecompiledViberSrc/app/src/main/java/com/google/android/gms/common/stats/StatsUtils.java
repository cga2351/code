package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StatsUtils
{
  @KeepForSdk
  public static String getEventKey(Context paramContext, Intent paramIntent)
  {
    return String.valueOf(System.identityHashCode(paramContext) << 32 | System.identityHashCode(paramIntent));
  }

  @KeepForSdk
  public static String getEventKey(PowerManager.WakeLock paramWakeLock, String paramString)
  {
    String str1 = String.valueOf(String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramWakeLock)));
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    String str2 = String.valueOf(paramString);
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.StatsUtils
 * JD-Core Version:    0.6.2
 */