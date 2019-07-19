package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

abstract class AnimationDriver
{
  ValueAnimatedNode mAnimatedValue;
  Callback mEndCallback;
  boolean mHasFinished = false;
  int mId;

  public void resetConfig(ReadableMap paramReadableMap)
  {
    throw new JSApplicationCausedNativeException("Animation config for " + getClass().getSimpleName() + " cannot be reset");
  }

  public abstract void runAnimationStep(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.AnimationDriver
 * JD-Core Version:    0.6.2
 */