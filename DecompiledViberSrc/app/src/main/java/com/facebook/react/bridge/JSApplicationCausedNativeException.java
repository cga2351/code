package com.facebook.react.bridge;

import javax.annotation.Nullable;

public class JSApplicationCausedNativeException extends RuntimeException
{
  public JSApplicationCausedNativeException(String paramString)
  {
    super(paramString);
  }

  public JSApplicationCausedNativeException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSApplicationCausedNativeException
 * JD-Core Version:    0.6.2
 */