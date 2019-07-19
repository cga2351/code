package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CDeleteGlobalMessageReplyMsg
{
  public final long groupID;
  public final long messageToken;
  public final int seq;
  public final int seqInPG;
  public final int status;

  public CDeleteGlobalMessageReplyMsg(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.seqInPG = paramInt2;
    this.status = paramInt3;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 2;
    public static final int NO_PRIVILEGES = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCDeleteGlobalMessageReplyMsg(CDeleteGlobalMessageReplyMsg paramCDeleteGlobalMessageReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeleteGlobalMessageReplyMsg
 * JD-Core Version:    0.6.2
 */