package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;

public abstract interface JSTimers extends JavaScriptModule
{
  public abstract void callIdleCallbacks(double paramDouble);

  public abstract void callTimers(WritableArray paramWritableArray);

  public abstract void emitTimeDriftWarning(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.JSTimers
 * JD-Core Version:    0.6.2
 */