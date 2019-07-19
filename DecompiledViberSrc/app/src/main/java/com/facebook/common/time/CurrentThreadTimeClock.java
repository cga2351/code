package com.facebook.common.time;

import android.os.SystemClock;

public class CurrentThreadTimeClock
  implements Clock
{
  public long now()
  {
    return SystemClock.currentThreadTimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.time.CurrentThreadTimeClock
 * JD-Core Version:    0.6.2
 */