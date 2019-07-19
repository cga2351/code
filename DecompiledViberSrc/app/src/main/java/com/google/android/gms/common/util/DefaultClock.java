package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock
  implements Clock
{
  private static final DefaultClock zzgk = new DefaultClock();

  @KeepForSdk
  public static Clock getInstance()
  {
    return zzgk;
  }

  public long currentThreadTimeMillis()
  {
    return SystemClock.currentThreadTimeMillis();
  }

  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }

  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }

  public long nanoTime()
  {
    return System.nanoTime();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.DefaultClock
 * JD-Core Version:    0.6.2
 */