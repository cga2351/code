package com.viber.jni.im2;

public class CMessageReceivedReplyableAckMsg
{
  public final int clientStatus;
  public final String clientStatusInfo;
  public final int flags;
  public final long messageToken;
  public final int seq;

  public CMessageReceivedReplyableAckMsg(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    this.seq = paramInt1;
    this.messageToken = paramLong;
    this.flags = paramInt2;
    this.clientStatus = paramInt3;
    this.clientStatusInfo = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCMessageReceivedReplyableAckMsg(CMessageReceivedReplyableAckMsg paramCMessageReceivedReplyableAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessageReceivedReplyableAckMsg
 * JD-Core Version:    0.6.2
 */