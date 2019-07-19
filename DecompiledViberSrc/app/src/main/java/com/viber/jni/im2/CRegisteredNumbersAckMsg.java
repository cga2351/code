package com.viber.jni.im2;

public class CRegisteredNumbersAckMsg
{
  public final Long token;

  public CRegisteredNumbersAckMsg()
  {
    this.token = null;
    init();
  }

  public CRegisteredNumbersAckMsg(long paramLong)
  {
    this.token = Long.valueOf(paramLong);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCRegisteredNumbersAckMsg(CRegisteredNumbersAckMsg paramCRegisteredNumbersAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRegisteredNumbersAckMsg
 * JD-Core Version:    0.6.2
 */