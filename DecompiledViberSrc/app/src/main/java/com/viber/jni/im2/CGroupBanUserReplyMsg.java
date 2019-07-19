package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupBanUserReplyMsg
{
  public final int groupRevision;
  public final long messageToken;
  public final int numWatchers;
  public final int seq;
  public final int status;

  public CGroupBanUserReplyMsg(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong;
    this.groupRevision = paramInt3;
    this.numWatchers = paramInt4;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGroupBanUserReplyMsg{seq=" + this.seq + ", status=" + this.status + ", messageToken=" + this.messageToken + ", groupRevision=" + this.groupRevision + ", numWatchers=" + this.numWatchers + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int EXCEEDED_LIMIT = 5;
    public static final int FAILED = 1;
    public static final int NOT_VIBER = 3;
    public static final int NO_PRIVILEGES = 4;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupBanUserReplyMsg(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupBanUserReplyMsg
 * JD-Core Version:    0.6.2
 */