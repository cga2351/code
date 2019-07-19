package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.WakeLockTracker;

@KeepForSdk
@ShowFirstParty
public abstract class GCoreWakefulBroadcastReceiver extends WakefulBroadcastReceiver
{
  private static String TAG = "GCoreWakefulBroadcastReceiver";

  @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
  @KeepForSdk
  public static boolean completeWakefulIntent(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
      return false;
    if (paramContext != null)
    {
      WakeLockTracker.getInstance().registerReleaseEvent(paramContext, paramIntent);
      return WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
    }
    String str1 = TAG;
    String str2 = String.valueOf(paramIntent.toUri(0));
    if (str2.length() != 0);
    for (String str3 = "context shouldn't be null. intent: ".concat(str2); ; str3 = new String("context shouldn't be null. intent: "))
    {
      Log.w(str1, str3);
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.stats.GCoreWakefulBroadcastReceiver
 * JD-Core Version:    0.6.2
 */