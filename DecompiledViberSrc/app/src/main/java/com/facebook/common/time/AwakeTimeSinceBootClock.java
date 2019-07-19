package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class AwakeTimeSinceBootClock
  implements MonotonicClock
{

  @DoNotStrip
  private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

  @DoNotStrip
  public static AwakeTimeSinceBootClock get()
  {
    return INSTANCE;
  }

  @DoNotStrip
  public long now()
  {
    return SystemClock.uptimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.time.AwakeTimeSinceBootClock
 * JD-Core Version:    0.6.2
 */