package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract class NativeArray
  implements NativeArrayInterface
{

  @DoNotStrip
  private HybridData mHybridData;

  static
  {
    ReactBridge.staticInit();
  }

  protected NativeArray(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public native String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeArray
 * JD-Core Version:    0.6.2
 */