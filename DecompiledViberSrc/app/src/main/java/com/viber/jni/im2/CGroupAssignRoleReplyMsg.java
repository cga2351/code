package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupAssignRoleReplyMsg
{
  public final long groupID;
  public final int groupRevision;
  public final GroupMemberActionStatus[] members;
  public final long messageToken;
  public final int role;
  public final int seq;
  public final int seqInPG;
  public final int status;

  public CGroupAssignRoleReplyMsg(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, int paramInt5, GroupMemberActionStatus[] paramArrayOfGroupMemberActionStatus)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.status = paramInt2;
    this.role = paramInt3;
    this.messageToken = paramLong2;
    this.groupRevision = paramInt4;
    this.seqInPG = paramInt5;
    this.members = ((GroupMemberActionStatus[])Im2Utils.checkArrayValue(paramArrayOfGroupMemberActionStatus, [Lcom.viber.jni.im2.GroupMemberActionStatus.class));
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EGroupAssignRoleStatus
  {
    public static final int ALREADY_TAKEN = 4;
    public static final int FAILED = 5;
    public static final int NOT_EXPECTED_IN_FLOW = 7;
    public static final int NOT_IN_GROUP = 3;
    public static final int NOT_VIBER = 1;
    public static final int NO_RIGHTS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 6;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupAssignRoleReplyMsg(CGroupAssignRoleReplyMsg paramCGroupAssignRoleReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAssignRoleReplyMsg
 * JD-Core Version:    0.6.2
 */