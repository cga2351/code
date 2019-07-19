package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import javax.annotation.Nullable;

public abstract interface RCTNativeAppEventEmitter extends JavaScriptModule
{
  public abstract void emit(String paramString, @Nullable Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.RCTNativeAppEventEmitter
 * JD-Core Version:    0.6.2
 */