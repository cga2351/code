package com.viber.jni.im2;

public class CBillingTokenReplyMsg
{
  public final long timestamp;
  public final String token;

  public CBillingTokenReplyMsg(long paramLong, String paramString)
  {
    this.timestamp = paramLong;
    this.token = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCBillingTokenReplyMsg(CBillingTokenReplyMsg paramCBillingTokenReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBillingTokenReplyMsg
 * JD-Core Version:    0.6.2
 */