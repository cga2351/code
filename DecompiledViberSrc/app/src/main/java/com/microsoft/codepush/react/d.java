package com.microsoft.codepush.react;

import java.net.MalformedURLException;

public class d extends RuntimeException
{
  public d(String paramString, Throwable paramThrowable)
  {
    super("Unable to parse contents of " + paramString + ", the file may be corrupted.", paramThrowable);
  }

  public d(String paramString, MalformedURLException paramMalformedURLException)
  {
    super("The package has an invalid downloadUrl: " + paramString, paramMalformedURLException);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.d
 * JD-Core Version:    0.6.2
 */