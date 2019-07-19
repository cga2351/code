package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupAddMembersReplyMsg
{
  public final long groupID;
  public final int groupRevision;
  public final GroupMemberActionStatus[] members;
  public final long messageToken;
  public final int seq;
  public final int seqInPG;
  public final int status;

  public CGroupAddMembersReplyMsg(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4, GroupMemberActionStatus[] paramArrayOfGroupMemberActionStatus)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong2;
    this.groupRevision = paramInt3;
    this.seqInPG = paramInt4;
    this.members = ((GroupMemberActionStatus[])Im2Utils.checkArrayValue(paramArrayOfGroupMemberActionStatus, [Lcom.viber.jni.im2.GroupMemberActionStatus.class));
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int GROUP_ADD_FAILED = 5;
    public static final int GROUP_ADD_NOT_IN_GROUP = 4;
    public static final int GROUP_ADD_NOT_VIBER = 1;
    public static final int GROUP_ADD_NO_RIGHTS = 2;
    public static final int GROUP_ADD_OK = 0;
    public static final int GROUP_ADD_TIMEOUT = 6;
    public static final int GROUP_ADD_TOO_MANY_MEMBERS = 3;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupAddMembersReplyMsg(CGroupAddMembersReplyMsg paramCGroupAddMembersReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAddMembersReplyMsg
 * JD-Core Version:    0.6.2
 */