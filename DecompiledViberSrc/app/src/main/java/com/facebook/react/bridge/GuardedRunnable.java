package com.facebook.react.bridge;

public abstract class GuardedRunnable
  implements Runnable
{
  private final ReactContext mReactContext;

  public GuardedRunnable(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  public final void run()
  {
    try
    {
      runGuarded();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
    }
  }

  public abstract void runGuarded();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.GuardedRunnable
 * JD-Core Version:    0.6.2
 */