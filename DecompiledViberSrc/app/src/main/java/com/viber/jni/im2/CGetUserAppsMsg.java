package com.viber.jni.im2;

public class CGetUserAppsMsg
{
  public final String phoneNumber;
  public final int seq;

  public CGetUserAppsMsg(String paramString, int paramInt)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetUserAppsMsg(CGetUserAppsMsg paramCGetUserAppsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUserAppsMsg
 * JD-Core Version:    0.6.2
 */