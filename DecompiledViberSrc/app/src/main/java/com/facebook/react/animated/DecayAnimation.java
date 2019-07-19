package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class DecayAnimation extends AnimationDriver
{
  private int mCurrentLoop;
  private double mDeceleration;
  private double mFromValue;
  private int mIterations;
  private double mLastValue;
  private long mStartFrameTimeMillis;
  private final double mVelocity;

  public DecayAnimation(ReadableMap paramReadableMap)
  {
    this.mVelocity = paramReadableMap.getDouble("velocity");
    resetConfig(paramReadableMap);
  }

  public void resetConfig(ReadableMap paramReadableMap)
  {
    int i = 1;
    this.mDeceleration = paramReadableMap.getDouble("deceleration");
    int j;
    if (paramReadableMap.hasKey("iterations"))
    {
      j = paramReadableMap.getInt("iterations");
      this.mIterations = j;
      this.mCurrentLoop = i;
      if (this.mIterations != 0)
        break label79;
    }
    while (true)
    {
      this.mHasFinished = i;
      this.mStartFrameTimeMillis = -1L;
      this.mFromValue = 0.0D;
      this.mLastValue = 0.0D;
      return;
      j = i;
      break;
      label79: i = 0;
    }
  }

  public void runAnimationStep(long paramLong)
  {
    long l = paramLong / 1000000L;
    if (this.mStartFrameTimeMillis == -1L)
    {
      this.mStartFrameTimeMillis = (l - 16L);
      if (this.mFromValue != this.mLastValue)
        break label168;
      this.mFromValue = this.mAnimatedValue.mValue;
    }
    while (true)
    {
      this.mLastValue = this.mAnimatedValue.mValue;
      double d = this.mFromValue + this.mVelocity / (1.0D - this.mDeceleration) * (1.0D - Math.exp(-(1.0D - this.mDeceleration) * (l - this.mStartFrameTimeMillis)));
      if (Math.abs(this.mLastValue - d) < 0.1D)
      {
        if ((this.mIterations != -1) && (this.mCurrentLoop >= this.mIterations))
          break;
        this.mStartFrameTimeMillis = -1L;
        this.mCurrentLoop = (1 + this.mCurrentLoop);
      }
      this.mLastValue = d;
      this.mAnimatedValue.mValue = d;
      return;
      label168: this.mAnimatedValue.mValue = this.mFromValue;
    }
    this.mHasFinished = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.DecayAnimation
 * JD-Core Version:    0.6.2
 */