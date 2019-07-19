package com.viber.jni.im2;

public class CReadData
{
  public final String phoneNumber;
  public final long timeSeen;

  public CReadData(String paramString, long paramLong)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    this.timeSeen = paramLong;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CReadData
 * JD-Core Version:    0.6.2
 */