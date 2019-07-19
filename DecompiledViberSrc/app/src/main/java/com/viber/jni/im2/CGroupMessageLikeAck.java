package com.viber.jni.im2;

public class CGroupMessageLikeAck
{
  public final long likeToken;

  public CGroupMessageLikeAck(long paramLong)
  {
    this.likeToken = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupMessageLikeAck(CGroupMessageLikeAck paramCGroupMessageLikeAck);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupMessageLikeAck
 * JD-Core Version:    0.6.2
 */