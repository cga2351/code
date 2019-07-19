package com.viber.jni.im2;

public class CSendInternalMsg
{
  public final String data;
  public final int seq;
  public final String toMID;

  public CSendInternalMsg(int paramInt, String paramString1, String paramString2)
  {
    this.seq = paramInt;
    this.toMID = Im2Utils.checkStringValue(paramString1);
    this.data = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendInternalMsg(CSendInternalMsg paramCSendInternalMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendInternalMsg
 * JD-Core Version:    0.6.2
 */