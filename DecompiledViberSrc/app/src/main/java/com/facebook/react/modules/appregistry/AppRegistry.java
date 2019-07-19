package com.facebook.react.modules.appregistry;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;

public abstract interface AppRegistry extends JavaScriptModule
{
  public abstract void runApplication(String paramString, WritableMap paramWritableMap);

  public abstract void startHeadlessTask(int paramInt, String paramString, WritableMap paramWritableMap);

  public abstract void unmountApplicationComponentAtRootTag(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.appregistry.AppRegistry
 * JD-Core Version:    0.6.2
 */