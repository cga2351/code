package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupAddWatchersReplyMsg
{
  public final String group2AccessToken;
  public final long groupID;
  public final boolean isJoinReply;
  public final long messageToken;
  public final int seq;
  public final int status;
  public final GroupAddWatchersStatus[] watchers;

  public CGroupAddWatchersReplyMsg(long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, GroupAddWatchersStatus[] paramArrayOfGroupAddWatchersStatus)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong2;
    this.isJoinReply = paramBoolean;
    this.watchers = ((GroupAddWatchersStatus[])Im2Utils.checkArrayValue(paramArrayOfGroupAddWatchersStatus, [Lcom.viber.jni.im2.GroupAddWatchersStatus.class));
    this.group2AccessToken = null;
    init();
  }

  public CGroupAddWatchersReplyMsg(long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, GroupAddWatchersStatus[] paramArrayOfGroupAddWatchersStatus, String paramString)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong2;
    this.isJoinReply = paramBoolean;
    this.watchers = ((GroupAddWatchersStatus[])Im2Utils.checkArrayValue(paramArrayOfGroupAddWatchersStatus, [Lcom.viber.jni.im2.GroupAddWatchersStatus.class));
    this.group2AccessToken = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int GROUP_ADD_TOO_MANY_GROUPS = 4;
    public static final int GROUP_ADD_WATCHERS_ALREADY_WATCHING = 2;
    public static final int GROUP_ADD_WATCHERS_BANNED = 7;
    public static final int GROUP_ADD_WATCHERS_BLOCKED = 8;
    public static final int GROUP_ADD_WATCHERS_FAILED = 5;
    public static final int GROUP_ADD_WATCHERS_NOT_IN_GROUP = 3;
    public static final int GROUP_ADD_WATCHERS_NOT_VIBER = 1;
    public static final int GROUP_ADD_WATCHERS_OK = 0;
    public static final int GROUP_ADD_WATCHERS_TIMEOUT = 6;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupAddWatchersReplyMsg(CGroupAddWatchersReplyMsg paramCGroupAddWatchersReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAddWatchersReplyMsg
 * JD-Core Version:    0.6.2
 */