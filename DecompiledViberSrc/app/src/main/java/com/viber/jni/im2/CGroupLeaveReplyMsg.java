package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupLeaveReplyMsg
{
  public final long groupID;
  public final Long messageToken;
  public final int status;

  public CGroupLeaveReplyMsg(long paramLong, int paramInt)
  {
    this.groupID = paramLong;
    this.status = paramInt;
    this.messageToken = null;
    init();
  }

  public CGroupLeaveReplyMsg(long paramLong1, int paramInt, long paramLong2)
  {
    this.groupID = paramLong1;
    this.status = paramInt;
    this.messageToken = Long.valueOf(paramLong2);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int GROUP_LEAVE_OK = 1;
    public static final int NOT_IN_GROUP = 2;
    public static final int TIMEOUT = 3;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupLeaveReplyMsg(CGroupLeaveReplyMsg paramCGroupLeaveReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupLeaveReplyMsg
 * JD-Core Version:    0.6.2
 */