package com.viber.jni.im2;

public class CGroupMessageData
{
  public final long timeSent;
  public final long token;

  public CGroupMessageData(long paramLong1, long paramLong2)
  {
    this.token = paramLong1;
    this.timeSent = paramLong2;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupMessageData
 * JD-Core Version:    0.6.2
 */