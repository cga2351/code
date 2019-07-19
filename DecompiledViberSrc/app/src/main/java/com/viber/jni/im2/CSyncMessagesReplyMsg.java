package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSyncMessagesReplyMsg
{
  public final int sequence;
  public final int status;
  public final long[] tokens;

  public CSyncMessagesReplyMsg(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    this.sequence = paramInt1;
    this.tokens = ((long[])Im2Utils.checkArrayValue(paramArrayOfLong, [J.class));
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
    public static final int NOT_REG = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSyncMessagesReplyMsg(CSyncMessagesReplyMsg paramCSyncMessagesReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncMessagesReplyMsg
 * JD-Core Version:    0.6.2
 */