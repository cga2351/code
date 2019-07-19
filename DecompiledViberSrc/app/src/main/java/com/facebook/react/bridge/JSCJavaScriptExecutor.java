package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
class JSCJavaScriptExecutor extends JavaScriptExecutor
{
  static
  {
    ReactBridge.staticInit();
  }

  JSCJavaScriptExecutor(ReadableNativeMap paramReadableNativeMap)
  {
    super(initHybrid(paramReadableNativeMap));
  }

  private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);

  public String getName()
  {
    return "JSCJavaScriptExecutor";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSCJavaScriptExecutor
 * JD-Core Version:    0.6.2
 */