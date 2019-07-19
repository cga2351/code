package com.viber.svg.jni;

import android.util.Log;

public class Logger
{
  private static Backend backend;
  private String tag;

  private Logger(String paramString)
  {
    this.tag = paramString;
  }

  public static Logger create(String paramString)
  {
    return new Logger(paramString);
  }

  private void logToBackend(int paramInt, String paramString1, String paramString2)
  {
    if (backend != null)
    {
      backend.log(paramInt, paramString1, paramString2);
      return;
    }
    Log.println(paramInt, paramString1, paramString2);
  }

  public static void setBackend(Backend paramBackend)
  {
    backend = paramBackend;
  }

  public void debug(String paramString)
  {
    logToBackend(3, this.tag, paramString);
  }

  public void debug(String paramString, Throwable paramThrowable)
  {
    logToBackend(3, this.tag, paramString + '\n' + Log.getStackTraceString(paramThrowable));
  }

  public void warn(String paramString)
  {
    logToBackend(5, this.tag, paramString);
  }

  public void warn(String paramString, Throwable paramThrowable)
  {
    logToBackend(5, this.tag, paramString + '\n' + Log.getStackTraceString(paramThrowable));
  }

  private static abstract interface Backend
  {
    public abstract void log(int paramInt, String paramString1, String paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.Logger
 * JD-Core Version:    0.6.2
 */