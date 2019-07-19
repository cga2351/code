package com.facebook.react.fabric;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;

public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback
{
  private final ReactContext mReactContext;

  protected GuardedFrameCallback(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  public final void doFrame(long paramLong)
  {
    try
    {
      doFrameGuarded(paramLong);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
    }
  }

  protected abstract void doFrameGuarded(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.GuardedFrameCallback
 * JD-Core Version:    0.6.2
 */