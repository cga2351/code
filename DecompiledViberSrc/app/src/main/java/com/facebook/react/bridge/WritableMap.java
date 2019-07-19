package com.facebook.react.bridge;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract interface WritableMap extends ReadableMap
{
  public abstract void merge(@Nonnull ReadableMap paramReadableMap);

  public abstract void putArray(@Nonnull String paramString, @Nullable WritableArray paramWritableArray);

  public abstract void putBoolean(@Nonnull String paramString, boolean paramBoolean);

  public abstract void putDouble(@Nonnull String paramString, double paramDouble);

  public abstract void putInt(@Nonnull String paramString, int paramInt);

  public abstract void putMap(@Nonnull String paramString, @Nullable WritableMap paramWritableMap);

  public abstract void putNull(@Nonnull String paramString);

  public abstract void putString(@Nonnull String paramString1, @Nullable String paramString2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableMap
 * JD-Core Version:    0.6.2
 */