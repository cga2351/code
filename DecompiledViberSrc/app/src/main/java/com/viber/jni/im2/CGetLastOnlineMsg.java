package com.viber.jni.im2;

public class CGetLastOnlineMsg
{
  public final String[] contactPhones;
  public final int seq;

  public CGetLastOnlineMsg(String[] paramArrayOfString, int paramInt)
  {
    this.contactPhones = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetLastOnlineMsg(CGetLastOnlineMsg paramCGetLastOnlineMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetLastOnlineMsg
 * JD-Core Version:    0.6.2
 */