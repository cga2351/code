package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
abstract interface ReactCallback
{
  @DoNotStrip
  public abstract void decrementPendingJSCalls();

  @DoNotStrip
  public abstract void incrementPendingJSCalls();

  @DoNotStrip
  public abstract void onBatchComplete();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactCallback
 * JD-Core Version:    0.6.2
 */