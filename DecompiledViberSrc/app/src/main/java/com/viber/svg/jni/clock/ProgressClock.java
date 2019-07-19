package com.viber.svg.jni.clock;

public class ProgressClock extends ClockBase
{
  private double mProgress = 0.0D;

  public ProgressClock(double paramDouble)
  {
    super(paramDouble);
  }

  public ProgressClock(double paramDouble1, double paramDouble2)
  {
    super(paramDouble1, paramDouble2);
  }

  public double getCurrentTime()
  {
    return this.mOffsetTime + this.mProgress * this.mDuration;
  }

  public boolean isTimeFrozen()
  {
    return true;
  }

  public ProgressClock setProgress(double paramDouble)
  {
    this.mProgress = paramDouble;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.ProgressClock
 * JD-Core Version:    0.6.2
 */