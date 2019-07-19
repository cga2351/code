package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendActionOnPGReplyMsg
{
  public final long actionToken;
  public final int clientAction;
  public final int context;
  public final long groupID;
  public final long messageToken;
  public final int seqInPG;
  public final int status;

  public CSendActionOnPGReplyMsg(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3)
  {
    this.status = paramInt1;
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.seqInPG = paramInt2;
    this.clientAction = paramInt3;
    this.context = paramInt4;
    this.actionToken = paramLong3;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int PG_SEND_ACTION_FAILED = 4;
    public static final int PG_SEND_ACTION_NOT_REG = 2;
    public static final int PG_SEND_ACTION_OK = 1;
    public static final int PG_SEND_ACTION_TIMELIMIT_FAIL = 5;
    public static final int PG_SEND_ACTION_TIMEOUT = 3;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendActionOnPGReplyMsg(CSendActionOnPGReplyMsg paramCSendActionOnPGReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendActionOnPGReplyMsg
 * JD-Core Version:    0.6.2
 */