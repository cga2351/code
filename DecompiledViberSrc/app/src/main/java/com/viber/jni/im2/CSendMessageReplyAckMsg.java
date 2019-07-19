package com.viber.jni.im2;

public class CSendMessageReplyAckMsg
{
  public final long messageToken;

  public CSendMessageReplyAckMsg(long paramLong)
  {
    this.messageToken = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendMessageReplyAckMsg(CSendMessageReplyAckMsg paramCSendMessageReplyAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendMessageReplyAckMsg
 * JD-Core Version:    0.6.2
 */