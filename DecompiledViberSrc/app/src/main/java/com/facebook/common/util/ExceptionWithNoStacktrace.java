package com.facebook.common.util;

public class ExceptionWithNoStacktrace extends Exception
{
  public ExceptionWithNoStacktrace(String paramString)
  {
    super(paramString);
  }

  public Throwable fillInStackTrace()
  {
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ExceptionWithNoStacktrace
 * JD-Core Version:    0.6.2
 */