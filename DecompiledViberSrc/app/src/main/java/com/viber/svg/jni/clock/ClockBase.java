package com.viber.svg.jni.clock;

import com.viber.svg.jni.TimeAware.Clock;

public abstract class ClockBase
  implements TimeAware.Clock
{
  protected double mDuration = 1.0D;
  protected double mOffsetTime = 0.0D;

  ClockBase(double paramDouble)
  {
    this.mDuration = paramDouble;
  }

  ClockBase(double paramDouble1, double paramDouble2)
  {
    this.mOffsetTime = paramDouble1;
    this.mDuration = paramDouble2;
  }

  protected double getDuration()
  {
    return this.mDuration;
  }

  public ClockBase setDuration(double paramDouble)
  {
    this.mDuration = paramDouble;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.ClockBase
 * JD-Core Version:    0.6.2
 */