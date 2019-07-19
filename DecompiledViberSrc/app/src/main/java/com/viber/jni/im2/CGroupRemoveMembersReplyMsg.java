package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGroupRemoveMembersReplyMsg
{
  public final long groupID;
  public final int groupRevision;
  public final GroupMemberActionStatus[] members;
  public final long messageToken;
  public final Integer numWatchers;
  public final int seq;
  public final int seqInPG;
  public final int status;

  public CGroupRemoveMembersReplyMsg(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4, GroupMemberActionStatus[] paramArrayOfGroupMemberActionStatus)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong2;
    this.groupRevision = paramInt3;
    this.seqInPG = paramInt4;
    this.members = ((GroupMemberActionStatus[])Im2Utils.checkArrayValue(paramArrayOfGroupMemberActionStatus, [Lcom.viber.jni.im2.GroupMemberActionStatus.class));
    this.numWatchers = null;
    init();
  }

  public CGroupRemoveMembersReplyMsg(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4, GroupMemberActionStatus[] paramArrayOfGroupMemberActionStatus, int paramInt5)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.status = paramInt2;
    this.messageToken = paramLong2;
    this.groupRevision = paramInt3;
    this.seqInPG = paramInt4;
    this.members = ((GroupMemberActionStatus[])Im2Utils.checkArrayValue(paramArrayOfGroupMemberActionStatus, [Lcom.viber.jni.im2.GroupMemberActionStatus.class));
    this.numWatchers = Integer.valueOf(paramInt5);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGroupRemoveMembersReplyMsg{groupID=" + this.groupID + ", seq=" + this.seq + ", status=" + this.status + ", messageToken=" + this.messageToken + ", groupRevision=" + this.groupRevision + ", seqInPG=" + this.seqInPG + ", members=" + Arrays.toString(this.members) + ", numWatchers=" + this.numWatchers + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int NOT_VIBER = 1;
    public static final int NO_RIGHTS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 5;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupRemoveMembersReplyMsg(CGroupRemoveMembersReplyMsg paramCGroupRemoveMembersReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupRemoveMembersReplyMsg
 * JD-Core Version:    0.6.2
 */