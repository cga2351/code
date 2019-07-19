package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CPublicAccountSubscriberUpdateReplyMsg
{
  public final long messageToken;
  public final int seq;
  public final int status;
  public final int subscriberOperation;

  public CPublicAccountSubscriberUpdateReplyMsg(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong;
    this.subscriberOperation = paramInt3;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int MISSING_WEBHOOK = 6;
    public static final int OK = 0;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 5;
    public static final int PUBLIC_ACCOUNT_NOT_EXIST = 3;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 7;
    public static final int SUBSCRIBER_IS_NOT_VIBER = 4;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCPublicAccountSubscriberUpdateReplyMsg(CPublicAccountSubscriberUpdateReplyMsg paramCPublicAccountSubscriberUpdateReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CPublicAccountSubscriberUpdateReplyMsg
 * JD-Core Version:    0.6.2
 */