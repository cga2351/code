package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetGroupMessageStatusReplyMsg
{
  public final long groupId;
  public final CGroupMessageStatus[] messages;
  public final int seq;
  public final int status;

  public CGetGroupMessageStatusReplyMsg(int paramInt1, long paramLong, int paramInt2, CGroupMessageStatus[] paramArrayOfCGroupMessageStatus)
  {
    this.seq = paramInt1;
    this.groupId = paramLong;
    this.status = paramInt2;
    this.messages = ((CGroupMessageStatus[])Im2Utils.checkArrayValue(paramArrayOfCGroupMessageStatus, [Lcom.viber.jni.im2.CGroupMessageStatus.class));
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_FAILURE = 1;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_GROUP_NOT_FOUND = 4;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_INVALID_DATA = 3;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_OK = 0;
    public static final int GET_GROUP_MESSAGE_STATUS_REPLY_TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetGroupMessageStatusReplyMsg(CGetGroupMessageStatusReplyMsg paramCGetGroupMessageStatusReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetGroupMessageStatusReplyMsg
 * JD-Core Version:    0.6.2
 */