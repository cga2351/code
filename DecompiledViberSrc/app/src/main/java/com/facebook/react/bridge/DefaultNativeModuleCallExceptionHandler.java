package com.facebook.react.bridge;

public class DefaultNativeModuleCallExceptionHandler
  implements NativeModuleCallExceptionHandler
{
  public void handleException(Exception paramException)
  {
    if ((paramException instanceof RuntimeException))
      throw ((RuntimeException)paramException);
    throw new RuntimeException(paramException);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler
 * JD-Core Version:    0.6.2
 */