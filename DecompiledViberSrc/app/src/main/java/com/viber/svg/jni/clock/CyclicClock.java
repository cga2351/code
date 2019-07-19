package com.viber.svg.jni.clock;

import android.os.SystemClock;

public class CyclicClock extends ClockBase
{
  private boolean mFrozen;
  private int mIterations;
  private long mStartTime = SystemClock.elapsedRealtime();

  public CyclicClock(double paramDouble)
  {
    this(0.0D, paramDouble, 2147483647);
  }

  public CyclicClock(double paramDouble1, double paramDouble2)
  {
    this(paramDouble1, paramDouble2, 2147483647);
  }

  public CyclicClock(double paramDouble1, double paramDouble2, int paramInt)
  {
    super(paramDouble1, paramDouble2);
    this.mIterations = paramInt;
  }

  public double getCurrentTime()
  {
    double d1 = (SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0D;
    boolean bool;
    if (!this.mFrozen)
      if (d1 > this.mDuration * this.mIterations)
      {
        bool = true;
        this.mFrozen = bool;
      }
    for (double d2 = d1 % this.mDuration; ; d2 = this.mDuration)
    {
      return d2 + this.mOffsetTime;
      bool = false;
      break;
    }
  }

  public boolean isTimeFrozen()
  {
    return this.mFrozen;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.CyclicClock
 * JD-Core Version:    0.6.2
 */