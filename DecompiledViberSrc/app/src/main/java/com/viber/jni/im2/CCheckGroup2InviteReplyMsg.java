package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CCheckGroup2InviteReplyMsg
{
  public final Long communityPrivileges;
  public final Integer groupFlags;
  public final long groupID;
  public final String groupName;
  public final String iconDownloadID;
  public final long inviteToken;
  public final int seq;
  public final int status;
  public final String tagLine;

  public CCheckGroup2InviteReplyMsg(int paramInt1, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString2);
    this.tagLine = Im2Utils.checkStringValue(paramString3);
    this.inviteToken = paramLong2;
    this.status = paramInt2;
    this.communityPrivileges = null;
    this.groupFlags = null;
    init();
  }

  public CCheckGroup2InviteReplyMsg(int paramInt1, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt2, long paramLong3)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString2);
    this.tagLine = Im2Utils.checkStringValue(paramString3);
    this.inviteToken = paramLong2;
    this.status = paramInt2;
    this.communityPrivileges = Long.valueOf(paramLong3);
    this.groupFlags = null;
    init();
  }

  public CCheckGroup2InviteReplyMsg(int paramInt1, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt2, long paramLong3, int paramInt3)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.groupName = Im2Utils.checkStringValue(paramString1);
    this.iconDownloadID = Im2Utils.checkStringValue(paramString2);
    this.tagLine = Im2Utils.checkStringValue(paramString3);
    this.inviteToken = paramLong2;
    this.status = paramInt2;
    this.communityPrivileges = Long.valueOf(paramLong3);
    this.groupFlags = Integer.valueOf(paramInt3);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCheckGroup2InviteReplyMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", groupName='" + this.groupName + '\'' + ", iconDownloadID='" + this.iconDownloadID + '\'' + ", tagLine='" + this.tagLine + '\'' + ", inviteToken=" + this.inviteToken + ", status=" + this.status + ", communityPrivileges=" + this.communityPrivileges + ", groupFlags=" + this.groupFlags + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int ALREADY_FOLLOWER = 6;
    public static final int ALREADY_MEMBER = 5;
    public static final int FAILED = 1;
    public static final int GROUP_DOESNT_EXIST = 3;
    public static final int INVITE_DOESNT_EXIST = 4;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
    public static final int TOO_MANY_FOLLOWERS = 7;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCCheckGroup2InviteReplyMsg(CCheckGroup2InviteReplyMsg paramCCheckGroup2InviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCheckGroup2InviteReplyMsg
 * JD-Core Version:    0.6.2
 */