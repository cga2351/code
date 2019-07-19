package com.viber.jni.im2;

public class CIsOnlineMsg
{
  public final String phoneNumber;

  public CIsOnlineMsg(String paramString)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCIsOnlineMsg(CIsOnlineMsg paramCIsOnlineMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CIsOnlineMsg
 * JD-Core Version:    0.6.2
 */