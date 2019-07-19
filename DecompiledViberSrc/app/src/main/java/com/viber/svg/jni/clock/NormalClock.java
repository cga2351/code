package com.viber.svg.jni.clock;

import com.viber.svg.jni.TimeAware.Clock;

public class NormalClock
  implements TimeAware.Clock
{
  private final long mInitTime = System.currentTimeMillis();

  public double getCurrentTime()
  {
    return (System.currentTimeMillis() - this.mInitTime) / 1000.0D;
  }

  public boolean isTimeFrozen()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.NormalClock
 * JD-Core Version:    0.6.2
 */