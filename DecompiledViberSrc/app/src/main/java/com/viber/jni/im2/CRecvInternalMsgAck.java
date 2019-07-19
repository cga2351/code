package com.viber.jni.im2;

public class CRecvInternalMsgAck
{
  public final long token;

  public CRecvInternalMsgAck(long paramLong)
  {
    this.token = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCRecvInternalMsgAck(CRecvInternalMsgAck paramCRecvInternalMsgAck);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRecvInternalMsgAck
 * JD-Core Version:    0.6.2
 */