package com.facebook.react.bridge;

public class JSCJavaScriptExecutorFactory
  implements JavaScriptExecutorFactory
{
  private final String mAppName;
  private final String mDeviceName;

  public JSCJavaScriptExecutorFactory(String paramString1, String paramString2)
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
    return new JSCJavaScriptExecutor(localWritableNativeMap);
  }

  public String toString()
  {
    return "JSCExecutor";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSCJavaScriptExecutorFactory
 * JD-Core Version:    0.6.2
 */