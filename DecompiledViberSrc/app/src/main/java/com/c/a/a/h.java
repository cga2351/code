package com.c.a.a;

import java.io.IOException;

public class h extends IOException
{
  protected e a;

  protected h(String paramString, e parame)
  {
    this(paramString, parame, null);
  }

  protected h(String paramString, e parame, Throwable paramThrowable)
  {
    super(paramString);
    if (paramThrowable != null)
      initCause(paramThrowable);
    this.a = parame;
  }

  public e a()
  {
    return this.a;
  }

  protected String b()
  {
    return null;
  }

  public String getMessage()
  {
    String str1 = super.getMessage();
    if (str1 == null)
      str1 = "N/A";
    e locale = a();
    String str2 = b();
    if ((locale != null) || (str2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(str1);
      if (str2 != null)
        localStringBuilder.append(str2);
      if (locale != null)
      {
        localStringBuilder.append('\n');
        localStringBuilder.append(" at ");
        localStringBuilder.append(locale.toString());
      }
      str1 = localStringBuilder.toString();
    }
    return str1;
  }

  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.h
 * JD-Core Version:    0.6.2
 */