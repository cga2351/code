package com.viber.jni.im2;

public class CUpdateUnsavedContactDetailsAckMsg
{
  public final long token;

  public CUpdateUnsavedContactDetailsAckMsg(long paramLong)
  {
    this.token = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateUnsavedContactDetailsAckMsg(CUpdateUnsavedContactDetailsAckMsg paramCUpdateUnsavedContactDetailsAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUnsavedContactDetailsAckMsg
 * JD-Core Version:    0.6.2
 */