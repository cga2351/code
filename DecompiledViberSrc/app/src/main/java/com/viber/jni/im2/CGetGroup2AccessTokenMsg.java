package com.viber.jni.im2;

public class CGetGroup2AccessTokenMsg
{
  public final long groupId;
  public final int seq;

  public CGetGroup2AccessTokenMsg(long paramLong, int paramInt)
  {
    this.groupId = paramLong;
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetGroup2AccessTokenMsg(CGetGroup2AccessTokenMsg paramCGetGroup2AccessTokenMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetGroup2AccessTokenMsg
 * JD-Core Version:    0.6.2
 */