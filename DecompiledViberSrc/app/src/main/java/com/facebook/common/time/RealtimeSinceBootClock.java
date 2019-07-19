package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class RealtimeSinceBootClock
  implements MonotonicClock
{
  private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

  @DoNotStrip
  public static RealtimeSinceBootClock get()
  {
    return INSTANCE;
  }

  public long now()
  {
    return SystemClock.elapsedRealtime();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.time.RealtimeSinceBootClock
 * JD-Core Version:    0.6.2
 */