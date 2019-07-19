package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendInternalMsgReply
{
  public final int seq;
  public final int status;
  public final long token;

  public CSendInternalMsgReply(int paramInt1, long paramLong, int paramInt2)
  {
    this.seq = paramInt1;
    this.token = paramLong;
    this.status = paramInt2;
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
    public abstract void onCSendInternalMsgReply(CSendInternalMsgReply paramCSendInternalMsgReply);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendInternalMsgReply
 * JD-Core Version:    0.6.2
 */