package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CppSystemErrorException extends CppException
{
  int errorCode;

  @DoNotStrip
  public CppSystemErrorException(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = paramInt;
  }

  public int getErrorCode()
  {
    return this.errorCode;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.CppSystemErrorException
 * JD-Core Version:    0.6.2
 */