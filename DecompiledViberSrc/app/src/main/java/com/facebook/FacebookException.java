package com.facebook;

public class FacebookException extends RuntimeException
{
  static final long serialVersionUID = 1L;

  public FacebookException()
  {
  }

  public FacebookException(String paramString)
  {
    super(paramString);
  }

  public FacebookException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public FacebookException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.FacebookException
 * JD-Core Version:    0.6.2
 */