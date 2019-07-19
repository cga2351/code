package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CAcceptGroupInviteReplyMsg
{
  public final long groupID;
  public final String groupName;
  public final int seq;
  public final int status;

  public CAcceptGroupInviteReplyMsg(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.groupID = paramLong;
    this.status = paramInt2;
    this.groupName = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CAcceptGroupInviteReplyMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", status=" + this.status + ", groupName='" + this.groupName + '\'' + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int ALREADY_IN_GROUP = 4;
    public static final int FAILED = 1;
    public static final int GROUP_DOESNT_EXIST = 3;
    public static final int INVITE_DOESNT_EXIST = 5;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
    public static final int TOO_MANY_MEMBERS = 6;
    public static final int UNSUPPORTED_E2E = 7;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCAcceptGroupInviteReplyMsg(CAcceptGroupInviteReplyMsg paramCAcceptGroupInviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAcceptGroupInviteReplyMsg
 * JD-Core Version:    0.6.2
 */