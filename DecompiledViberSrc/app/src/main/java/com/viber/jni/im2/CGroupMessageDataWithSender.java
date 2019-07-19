package com.viber.jni.im2;

public class CGroupMessageDataWithSender
{
  public final String senderPhoneNumber;
  public final long timeSent;
  public final long token;

  public CGroupMessageDataWithSender(long paramLong1, long paramLong2, String paramString)
  {
    this.token = paramLong1;
    this.timeSent = paramLong2;
    this.senderPhoneNumber = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupMessageDataWithSender
 * JD-Core Version:    0.6.2
 */