package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupAddMemberReplyMsg
{
  public final String clientPhone;
  public final long groupID;
  public final Long messageToken;
  public final int status;

  public CGroupAddMemberReplyMsg(long paramLong, String paramString, int paramInt)
  {
    this.groupID = paramLong;
    this.clientPhone = Im2Utils.checkStringValue(paramString);
    this.status = paramInt;
    this.messageToken = null;
    init();
  }

  public CGroupAddMemberReplyMsg(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    this.groupID = paramLong1;
    this.clientPhone = Im2Utils.checkStringValue(paramString);
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
    public static final int GROUP_MEMBER_ADD_OK = 1;
    public static final int GROUP_MEMBER_ALREADY_IN_GROUP = 4;
    public static final int GROUP_MEMBER_FAILED = 6;
    public static final int GROUP_MEMBER_INSECURE = 8;
    public static final int GROUP_MEMBER_NOT_VIBER = 2;
    public static final int GROUP_MEMBER_NO_GROUPS = 3;
    public static final int GROUP_MEMBER_SECURE_PEER_LIST_INVALID = 9;
    public static final int GROUP_MEMBER_TIMEOUT = 7;
    public static final int GROUP_MEMBER_TOO_MANY_MEMBERS = 5;
    public static final int GROUP_MEMBER_UNSUPPORTED_SECRET_CHAT = 10;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupAddMemberReplyMsg(CGroupAddMemberReplyMsg paramCGroupAddMemberReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAddMemberReplyMsg
 * JD-Core Version:    0.6.2
 */