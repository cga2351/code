package com.viber.jni.im2;

public class CSyncActionOnPGAckMsg
{
  public final long actionToken;

  public CSyncActionOnPGAckMsg(long paramLong)
  {
    this.actionToken = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSyncActionOnPGAckMsg(CSyncActionOnPGAckMsg paramCSyncActionOnPGAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncActionOnPGAckMsg
 * JD-Core Version:    0.6.2
 */