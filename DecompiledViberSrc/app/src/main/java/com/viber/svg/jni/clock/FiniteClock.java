package com.viber.svg.jni.clock;

import android.os.SystemClock;

public class FiniteClock extends ClockBase
{
  private AnimationEndListener mAnimationEndListener;
  private double mEndTime;
  protected boolean mIsFrozen = false;
  protected double mStartTime = SystemClock.elapsedRealtime();

  public FiniteClock(double paramDouble)
  {
    super(paramDouble);
  }

  public FiniteClock(double paramDouble1, double paramDouble2)
  {
    super(paramDouble1, paramDouble2);
  }

  private double resolveTime()
  {
    return this.mOffsetTime + (SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0D;
  }

  public double getCurrentTime()
  {
    if (!isTimeFrozen())
      return resolveTime();
    return this.mOffsetTime + this.mDuration;
  }

  public boolean isTimeFrozen()
  {
    if ((!this.mIsFrozen) && (resolveTime() < this.mOffsetTime + this.mDuration))
      return false;
    if ((!this.mIsFrozen) && (this.mAnimationEndListener != null))
      this.mAnimationEndListener.onAnimationEnd();
    this.mIsFrozen = true;
    return true;
  }

  public void reset()
  {
    this.mStartTime = SystemClock.elapsedRealtime();
    this.mIsFrozen = false;
  }

  public FiniteClock setAnimationEndListener(AnimationEndListener paramAnimationEndListener)
  {
    this.mAnimationEndListener = paramAnimationEndListener;
    return this;
  }

  public static abstract interface AnimationEndListener
  {
    public abstract void onAnimationEnd();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.clock.FiniteClock
 * JD-Core Version:    0.6.2
 */