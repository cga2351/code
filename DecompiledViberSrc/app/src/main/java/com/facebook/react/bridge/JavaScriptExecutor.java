package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract class JavaScriptExecutor
{
  private final HybridData mHybridData;

  protected JavaScriptExecutor(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public void close()
  {
    this.mHybridData.resetNative();
  }

  public abstract String getName();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaScriptExecutor
 * JD-Core Version:    0.6.2
 */