package com.viber.jni.im2;

public class CRecvInternalMsg
{
  public final String data;
  public final int srcCID;
  public final String srcMID;
  public final long token;

  public CRecvInternalMsg(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    this.token = paramLong;
    this.srcMID = Im2Utils.checkStringValue(paramString1);
    this.srcCID = paramInt;
    this.data = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRecvInternalMsg(CRecvInternalMsg paramCRecvInternalMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRecvInternalMsg
 * JD-Core Version:    0.6.2
 */