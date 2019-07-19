package com.viber.jni.im2;

public class CDeletedMessageMsg
{
  public final long groupID;
  public final long messageToken;
  public final String peerPhone;
  public final Long timeSent;

  public CDeletedMessageMsg(String paramString, long paramLong1, long paramLong2)
  {
    this.peerPhone = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeSent = null;
    init();
  }

  public CDeletedMessageMsg(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.peerPhone = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.timeSent = Long.valueOf(paramLong3);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCDeletedMessageMsg(CDeletedMessageMsg paramCDeletedMessageMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeletedMessageMsg
 * JD-Core Version:    0.6.2
 */