package com.facebook.react.jscexecutor;

import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.WritableNativeMap;

public class JSCExecutorFactory
  implements JavaScriptExecutorFactory
{
  private final String mAppName;
  private final String mDeviceName;

  public JSCExecutorFactory(String paramString1, String paramString2)
  {
    this.mAppName = paramString1;
    this.mDeviceName = paramString2;
  }

  public JavaScriptExecutor create()
    throws Exception
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putString("OwnerIdentity", "ReactNative");
    localWritableNativeMap.putString("AppIdentity", this.mAppName);
    localWritableNativeMap.putString("DeviceIdentity", this.mDeviceName);
    return new JSCExecutor(localWritableNativeMap);
  }

  public String toString()
  {
    return "JSIExecutor+JSCRuntime";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.jscexecutor.JSCExecutorFactory
 * JD-Core Version:    0.6.2
 */