package com.viber.jni.im2;

public class CSendBackAckBase
{
  public final long messageToken;

  public CSendBackAckBase(long paramLong)
  {
    this.messageToken = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendBackAckBase(CSendBackAckBase paramCSendBackAckBase);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendBackAckBase
 * JD-Core Version:    0.6.2
 */