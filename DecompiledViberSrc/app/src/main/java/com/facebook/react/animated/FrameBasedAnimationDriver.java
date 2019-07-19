package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class FrameBasedAnimationDriver extends AnimationDriver
{
  private static final double FRAME_TIME_MILLIS = 16.666666666666668D;
  private int mCurrentLoop;
  private double[] mFrames;
  private double mFromValue;
  private int mIterations;
  private long mStartFrameTimeNanos;
  private double mToValue;

  FrameBasedAnimationDriver(ReadableMap paramReadableMap)
  {
    resetConfig(paramReadableMap);
  }

  public void resetConfig(ReadableMap paramReadableMap)
  {
    int i = 1;
    ReadableArray localReadableArray = paramReadableMap.getArray("frames");
    int j = localReadableArray.size();
    if ((this.mFrames == null) || (this.mFrames.length != j))
      this.mFrames = new double[j];
    for (int k = 0; k < j; k++)
      this.mFrames[k] = localReadableArray.getDouble(k);
    double d;
    int m;
    if (paramReadableMap.hasKey("toValue"))
    {
      d = paramReadableMap.getDouble("toValue");
      this.mToValue = d;
      if (!paramReadableMap.hasKey("iterations"))
        break label160;
      m = paramReadableMap.getInt("iterations");
      label123: this.mIterations = m;
      this.mCurrentLoop = i;
      if (this.mIterations != 0)
        break label166;
    }
    while (true)
    {
      this.mHasFinished = i;
      this.mStartFrameTimeNanos = -1L;
      return;
      d = 0.0D;
      break;
      label160: m = i;
      break label123;
      label166: i = 0;
    }
  }

  public void runAnimationStep(long paramLong)
  {
    if (this.mStartFrameTimeNanos < 0L)
    {
      this.mStartFrameTimeNanos = paramLong;
      if (this.mCurrentLoop == 1)
        this.mFromValue = this.mAnimatedValue.mValue;
    }
    int i = (int)Math.round((paramLong - this.mStartFrameTimeNanos) / 1000000L / 16.666666666666668D);
    if (i < 0)
      throw new IllegalStateException("Calculated frame index should never be lower than 0");
    if (this.mHasFinished)
      return;
    double d;
    if (i >= -1 + this.mFrames.length)
    {
      d = this.mToValue;
      if ((this.mIterations == -1) || (this.mCurrentLoop < this.mIterations))
      {
        this.mStartFrameTimeNanos = -1L;
        this.mCurrentLoop = (1 + this.mCurrentLoop);
      }
    }
    while (true)
    {
      this.mAnimatedValue.mValue = d;
      return;
      this.mHasFinished = true;
      continue;
      d = this.mFromValue + this.mFrames[i] * (this.mToValue - this.mFromValue);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.FrameBasedAnimationDriver
 * JD-Core Version:    0.6.2
 */