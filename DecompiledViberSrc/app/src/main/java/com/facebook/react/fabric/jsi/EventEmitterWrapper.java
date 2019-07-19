package com.facebook.react.fabric.jsi;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

@SuppressLint({"MissingNativeLoadLibrary"})
public class EventEmitterWrapper
{

  @DoNotStrip
  private final HybridData mHybridData = initHybrid();

  static
  {
    FabricSoLoader.staticInit();
  }

  private static native HybridData initHybrid();

  private native void invokeEvent(String paramString, NativeMap paramNativeMap);

  public void invoke(String paramString, WritableMap paramWritableMap)
  {
    if (paramWritableMap == null);
    for (Object localObject = new WritableNativeMap(); ; localObject = (NativeMap)paramWritableMap)
    {
      invokeEvent(paramString, (NativeMap)localObject);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.jsi.EventEmitterWrapper
 * JD-Core Version:    0.6.2
 */