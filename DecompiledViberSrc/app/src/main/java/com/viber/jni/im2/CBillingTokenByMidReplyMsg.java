package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CBillingTokenByMidReplyMsg
{
  public final int status;
  public final long timestamp;
  public final String token;
  public final byte[] udid;

  public CBillingTokenByMidReplyMsg(int paramInt, byte[] paramArrayOfByte, long paramLong, String paramString)
  {
    this.status = paramInt;
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.timestamp = paramLong;
    this.token = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCBillingTokenByMidReplyMsg(CBillingTokenByMidReplyMsg paramCBillingTokenByMidReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBillingTokenByMidReplyMsg
 * JD-Core Version:    0.6.2
 */