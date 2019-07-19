package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public abstract interface RCTEventEmitter extends JavaScriptModule
{
  public abstract void receiveEvent(int paramInt, String paramString, @Nullable WritableMap paramWritableMap);

  public abstract void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.RCTEventEmitter
 * JD-Core Version:    0.6.2
 */