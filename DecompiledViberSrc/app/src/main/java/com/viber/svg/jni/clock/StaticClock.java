package com.viber.svg.jni.clock;

import com.viber.svg.jni.TimeAware.Clock;

public class StaticClock
  implements TimeAware.Clock
{
  protected final double mTime;

  StaticClock(double paramDouble)
  {
    this.mTime = paramDouble;
  }

  public double getCurrentTime()
  {
    return this.mTime;
  }

  public boolean isTimeFrozen()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.StaticClock
 * JD-Core Version:    0.6.2
 */