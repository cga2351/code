package com.facebook.react.bridge;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract interface Promise
{
  @Deprecated
  public abstract void reject(String paramString);

  public abstract void reject(String paramString, @Nonnull WritableMap paramWritableMap);

  public abstract void reject(String paramString1, String paramString2);

  public abstract void reject(String paramString1, String paramString2, @Nonnull WritableMap paramWritableMap);

  public abstract void reject(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void reject(String paramString1, String paramString2, Throwable paramThrowable, WritableMap paramWritableMap);

  public abstract void reject(String paramString, Throwable paramThrowable);

  public abstract void reject(String paramString, Throwable paramThrowable, WritableMap paramWritableMap);

  public abstract void reject(Throwable paramThrowable);

  public abstract void reject(Throwable paramThrowable, WritableMap paramWritableMap);

  public abstract void resolve(@Nullable Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Promise
 * JD-Core Version:    0.6.2
 */