package com.facebook.react.fabric.jsi;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class ComponentRegistry
{
  private final HybridData mHybridData = initHybrid();

  static
  {
    FabricSoLoader.staticInit();
  }

  @DoNotStrip
  private static native HybridData initHybrid();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.jsi.ComponentRegistry
 * JD-Core Version:    0.6.2
 */