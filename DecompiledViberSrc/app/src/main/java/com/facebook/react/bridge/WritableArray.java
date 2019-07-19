package com.facebook.react.bridge;

import javax.annotation.Nullable;

public abstract interface WritableArray extends ReadableArray
{
  public abstract void pushArray(@Nullable WritableArray paramWritableArray);

  public abstract void pushBoolean(boolean paramBoolean);

  public abstract void pushDouble(double paramDouble);

  public abstract void pushInt(int paramInt);

  public abstract void pushMap(@Nullable WritableMap paramWritableMap);

  public abstract void pushNull();

  public abstract void pushString(@Nullable String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableArray
 * JD-Core Version:    0.6.2
 */