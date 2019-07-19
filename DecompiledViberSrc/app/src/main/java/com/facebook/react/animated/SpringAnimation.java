package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class SpringAnimation extends AnimationDriver
{
  private static final double MAX_DELTA_TIME_SEC = 0.064D;
  private static final double SOLVER_TIMESTEP_SEC = 0.001D;
  private int mCurrentLoop;
  private final PhysicsState mCurrentState = new PhysicsState(null);
  private double mDisplacementFromRestThreshold;
  private double mEndValue;
  private double mInitialVelocity;
  private int mIterations;
  private long mLastTime;
  private double mOriginalValue;
  private boolean mOvershootClampingEnabled;
  private double mRestSpeedThreshold;
  private double mSpringDamping;
  private double mSpringMass;
  private boolean mSpringStarted;
  private double mSpringStiffness;
  private double mStartValue;
  private double mTimeAccumulator;

  SpringAnimation(ReadableMap paramReadableMap)
  {
    this.mCurrentState.velocity = paramReadableMap.getDouble("initialVelocity");
    resetConfig(paramReadableMap);
  }

  private void advance(double paramDouble)
  {
    if (isAtRest());
    double d4;
    double d6;
    double d8;
    double d9;
    double d11;
    double d12;
    do
    {
      return;
      if (paramDouble > 0.064D)
        paramDouble = 0.064D;
      this.mTimeAccumulator = (paramDouble + this.mTimeAccumulator);
      double d1 = this.mSpringDamping;
      double d2 = this.mSpringMass;
      double d3 = this.mSpringStiffness;
      d4 = -this.mInitialVelocity;
      double d5 = d1 / (2.0D * Math.sqrt(d3 * d2));
      d6 = Math.sqrt(d3 / d2);
      double d7 = d6 * Math.sqrt(1.0D - d5 * d5);
      d8 = this.mEndValue - this.mStartValue;
      d9 = this.mTimeAccumulator;
      if (d5 >= 1.0D)
        break;
      double d13 = Math.exp(d9 * (d6 * -d5));
      d11 = this.mEndValue - d13 * ((d4 + d8 * (d5 * d6)) / d7 * Math.sin(d7 * d9) + d8 * Math.cos(d7 * d9));
      d12 = d13 * (d5 * d6) * (Math.sin(d7 * d9) * (d4 + d8 * (d5 * d6)) / d7 + d8 * Math.cos(d7 * d9)) - d13 * (Math.cos(d7 * d9) * (d4 + d8 * (d6 * d5)) - d7 * d8 * Math.sin(d7 * d9));
      this.mCurrentState.position = d11;
      this.mCurrentState.velocity = d12;
    }
    while ((!isAtRest()) && ((!this.mOvershootClampingEnabled) || (!isOvershooting())));
    if (this.mSpringStiffness > 0.0D)
    {
      this.mStartValue = this.mEndValue;
      this.mCurrentState.position = this.mEndValue;
    }
    while (true)
    {
      this.mCurrentState.velocity = 0.0D;
      return;
      double d10 = Math.exp(d9 * -d6);
      d11 = this.mEndValue - d10 * (d8 + d9 * (d4 + d6 * d8));
      d12 = d10 * (d4 * (d9 * d6 - 1.0D) + d9 * d8 * (d6 * d6));
      break;
      this.mEndValue = this.mCurrentState.position;
      this.mStartValue = this.mEndValue;
    }
  }

  private double getDisplacementDistanceForState(PhysicsState paramPhysicsState)
  {
    return Math.abs(this.mEndValue - paramPhysicsState.position);
  }

  private boolean isAtRest()
  {
    return (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) && ((getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold) || (this.mSpringStiffness == 0.0D));
  }

  private boolean isOvershooting()
  {
    return (this.mSpringStiffness > 0.0D) && (((this.mStartValue < this.mEndValue) && (this.mCurrentState.position > this.mEndValue)) || ((this.mStartValue > this.mEndValue) && (this.mCurrentState.position < this.mEndValue)));
  }

  public void resetConfig(ReadableMap paramReadableMap)
  {
    int i = 1;
    this.mSpringStiffness = paramReadableMap.getDouble("stiffness");
    this.mSpringDamping = paramReadableMap.getDouble("damping");
    this.mSpringMass = paramReadableMap.getDouble("mass");
    this.mInitialVelocity = this.mCurrentState.velocity;
    this.mEndValue = paramReadableMap.getDouble("toValue");
    this.mRestSpeedThreshold = paramReadableMap.getDouble("restSpeedThreshold");
    this.mDisplacementFromRestThreshold = paramReadableMap.getDouble("restDisplacementThreshold");
    this.mOvershootClampingEnabled = paramReadableMap.getBoolean("overshootClamping");
    int j;
    if (paramReadableMap.hasKey("iterations"))
    {
      j = paramReadableMap.getInt("iterations");
      this.mIterations = j;
      if (this.mIterations != 0)
        break label155;
    }
    while (true)
    {
      this.mHasFinished = i;
      this.mCurrentLoop = 0;
      this.mTimeAccumulator = 0.0D;
      this.mSpringStarted = false;
      return;
      j = i;
      break;
      label155: i = 0;
    }
  }

  public void runAnimationStep(long paramLong)
  {
    long l = paramLong / 1000000L;
    if (!this.mSpringStarted)
    {
      if (this.mCurrentLoop == 0)
      {
        this.mOriginalValue = this.mAnimatedValue.mValue;
        this.mCurrentLoop = 1;
      }
      PhysicsState localPhysicsState = this.mCurrentState;
      double d = this.mAnimatedValue.mValue;
      localPhysicsState.position = d;
      this.mStartValue = d;
      this.mLastTime = l;
      this.mTimeAccumulator = 0.0D;
      this.mSpringStarted = true;
    }
    advance((l - this.mLastTime) / 1000.0D);
    this.mLastTime = l;
    this.mAnimatedValue.mValue = this.mCurrentState.position;
    if (isAtRest())
    {
      if ((this.mIterations == -1) || (this.mCurrentLoop < this.mIterations))
      {
        this.mSpringStarted = false;
        this.mAnimatedValue.mValue = this.mOriginalValue;
        this.mCurrentLoop = (1 + this.mCurrentLoop);
      }
    }
    else
      return;
    this.mHasFinished = true;
  }

  private static class PhysicsState
  {
    double position;
    double velocity;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.SpringAnimation
 * JD-Core Version:    0.6.2
 */