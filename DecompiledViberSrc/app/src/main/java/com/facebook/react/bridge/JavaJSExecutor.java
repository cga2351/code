package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface JavaJSExecutor
{
  public abstract void close();

  @DoNotStrip
  public abstract String executeJSCall(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException;

  @DoNotStrip
  public abstract void loadApplicationScript(String paramString)
    throws JavaJSExecutor.ProxyExecutorException;

  @DoNotStrip
  public abstract void setGlobalVariable(String paramString1, String paramString2);

  public static abstract interface Factory
  {
    public abstract JavaJSExecutor create()
      throws Exception;
  }

  public static class ProxyExecutorException extends Exception
  {
    public ProxyExecutorException(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaJSExecutor
 * JD-Core Version:    0.6.2
 */