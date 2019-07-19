package com.viber.jni.im2;

public class CGetAdInfoMsg
{
  public final String mid;
  public final int seq;

  public CGetAdInfoMsg(int paramInt, String paramString)
  {
    this.seq = paramInt;
    this.mid = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetAdInfoMsg(CGetAdInfoMsg paramCGetAdInfoMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetAdInfoMsg
 * JD-Core Version:    0.6.2
 */