package com.facebook.jni;

public class JniTerminateHandler
{
  public static void handleTerminate(Throwable paramThrowable)
    throws Throwable
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (localUncaughtExceptionHandler == null)
      return;
    localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.JniTerminateHandler
 * JD-Core Version:    0.6.2
 */