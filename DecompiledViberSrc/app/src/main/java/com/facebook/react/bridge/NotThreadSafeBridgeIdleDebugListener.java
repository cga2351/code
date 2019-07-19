package com.facebook.react.bridge;

public abstract interface NotThreadSafeBridgeIdleDebugListener
{
  public abstract void onBridgeDestroyed();

  public abstract void onTransitionToBridgeBusy();

  public abstract void onTransitionToBridgeIdle();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
 * JD-Core Version:    0.6.2
 */