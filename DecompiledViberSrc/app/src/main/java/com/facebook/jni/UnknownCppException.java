package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class UnknownCppException extends CppException
{
  @DoNotStrip
  public UnknownCppException()
  {
    super("Unknown");
  }

  @DoNotStrip
  public UnknownCppException(String paramString)
  {
    super(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.UnknownCppException
 * JD-Core Version:    0.6.2
 */