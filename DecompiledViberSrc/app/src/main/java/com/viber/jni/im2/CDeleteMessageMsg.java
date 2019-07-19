package com.viber.jni.im2;

public class CDeleteMessageMsg
{
  public final Integer chatType;
  public final long groupID;
  public final long messageToken;
  public final String peerPhone;
  public final int seq;

  public CDeleteMessageMsg(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.seq = paramInt;
    this.peerPhone = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.chatType = null;
    init();
  }

  public CDeleteMessageMsg(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    this.seq = paramInt1;
    this.peerPhone = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.chatType = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCDeleteMessageMsg(CDeleteMessageMsg paramCDeleteMessageMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeleteMessageMsg
 * JD-Core Version:    0.6.2
 */