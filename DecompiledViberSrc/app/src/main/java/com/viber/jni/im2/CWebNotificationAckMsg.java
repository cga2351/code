package com.viber.jni.im2;

public class CWebNotificationAckMsg
{
  public final long token;

  public CWebNotificationAckMsg(long paramLong)
  {
    this.token = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCWebNotificationAckMsg(CWebNotificationAckMsg paramCWebNotificationAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CWebNotificationAckMsg
 * JD-Core Version:    0.6.2
 */