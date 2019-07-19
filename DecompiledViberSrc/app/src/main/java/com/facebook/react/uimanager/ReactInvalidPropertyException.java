package com.facebook.react.uimanager;

public class ReactInvalidPropertyException extends RuntimeException
{
  public ReactInvalidPropertyException(String paramString1, String paramString2, String paramString3)
  {
    super("Invalid React property `" + paramString1 + "` with value `" + paramString2 + "`, expected " + paramString3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactInvalidPropertyException
 * JD-Core Version:    0.6.2
 */