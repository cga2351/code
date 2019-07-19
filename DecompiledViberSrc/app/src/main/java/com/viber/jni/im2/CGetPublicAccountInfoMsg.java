package com.viber.jni.im2;

public class CGetPublicAccountInfoMsg
{
  public final long publicChatId;
  public final int seq;

  public CGetPublicAccountInfoMsg(int paramInt, long paramLong)
  {
    this.seq = paramInt;
    this.publicChatId = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetPublicAccountInfoMsg(CGetPublicAccountInfoMsg paramCGetPublicAccountInfoMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPublicAccountInfoMsg
 * JD-Core Version:    0.6.2
 */