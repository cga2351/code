package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CDeleteMessageReplyMsg
{
  public final long messageToken;
  public final int seq;
  public final int status;

  public CDeleteMessageReplyMsg(int paramInt1, long paramLong, int paramInt2)
  {
    this.seq = paramInt1;
    this.messageToken = paramLong;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 3;
    public static final int NOT_REG = 1;
    public static final int OK = 0;
    public static final int PUBLIC_GROUP_ERROR = 4;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCDeleteMessageReplyMsg(CDeleteMessageReplyMsg paramCDeleteMessageReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeleteMessageReplyMsg
 * JD-Core Version:    0.6.2
 */