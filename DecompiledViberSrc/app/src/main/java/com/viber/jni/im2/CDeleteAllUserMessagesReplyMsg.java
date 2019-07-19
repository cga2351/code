package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CDeleteAllUserMessagesReplyMsg
{
  public final int seq;
  public final int seqInPG;
  public final int status;
  public final long token;

  public CDeleteAllUserMessagesReplyMsg(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.token = paramLong;
    this.seqInPG = paramInt2;
    this.status = paramInt3;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CDeleteAllUserMessagesReplyMsg{seq=" + this.seq + ", token=" + this.token + ", seqInPG=" + this.seqInPG + ", status=" + this.status + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int NOT_REG = 3;
    public static final int NO_PRIVILEGES = 4;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCDeleteAllUserMessagesReplyMsg(CDeleteAllUserMessagesReplyMsg paramCDeleteAllUserMessagesReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeleteAllUserMessagesReplyMsg
 * JD-Core Version:    0.6.2
 */