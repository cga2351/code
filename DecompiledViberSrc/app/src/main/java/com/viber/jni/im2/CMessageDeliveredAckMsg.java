package com.viber.jni.im2;

public class CMessageDeliveredAckMsg
{
  public final long messageToken;

  public CMessageDeliveredAckMsg(long paramLong)
  {
    this.messageToken = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCMessageDeliveredAckMsg(CMessageDeliveredAckMsg paramCMessageDeliveredAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessageDeliveredAckMsg
 * JD-Core Version:    0.6.2
 */