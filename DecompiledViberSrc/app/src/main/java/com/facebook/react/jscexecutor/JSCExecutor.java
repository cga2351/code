package com.facebook.react.jscexecutor;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;

@DoNotStrip
class JSCExecutor extends JavaScriptExecutor
{
  static
  {
    SoLoader.loadLibrary("jscexecutor");
  }

  JSCExecutor(ReadableNativeMap paramReadableNativeMap)
  {
    super(initHybrid(paramReadableNativeMap));
  }

  private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);

  public String getName()
  {
    return "JSCExecutor";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.jscexecutor.JSCExecutor
 * JD-Core Version:    0.6.2
 */