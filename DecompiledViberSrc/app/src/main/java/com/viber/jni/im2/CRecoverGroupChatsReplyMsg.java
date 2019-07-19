package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Map;

public class CRecoverGroupChatsReplyMsg
{
  public final byte chunkSeq;
  public final RecoveredGroupChatInfo[] groupChats;
  public final boolean last;
  public final RecoveredSecureGroupChatInfo[] secureGroupChats;
  public final int seq;
  public final int status;
  public final Map<String, ChatUserInfo> users;

  public CRecoverGroupChatsReplyMsg(int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean, Map<String, ChatUserInfo> paramMap, RecoveredGroupChatInfo[] paramArrayOfRecoveredGroupChatInfo, RecoveredSecureGroupChatInfo[] paramArrayOfRecoveredSecureGroupChatInfo)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.chunkSeq = paramByte;
    this.last = paramBoolean;
    this.users = Im2Utils.checkMapValue(paramMap);
    this.groupChats = ((RecoveredGroupChatInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupChatInfo, [Lcom.viber.jni.im2.RecoveredGroupChatInfo.class));
    this.secureGroupChats = ((RecoveredSecureGroupChatInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredSecureGroupChatInfo, [Lcom.viber.jni.im2.RecoveredSecureGroupChatInfo.class));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CRecoverGroupChatsReplyMsg{status=" + this.status + ", seq=" + this.seq + ", chunkSeq=" + this.chunkSeq + ", last=" + this.last + ", users=" + this.users + ", groupChats=" + Arrays.toString(this.groupChats) + ", secureGroupChats=" + Arrays.toString(this.secureGroupChats) + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int NO_GROUPS = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRecoverGroupChatsReplyMsg(CRecoverGroupChatsReplyMsg paramCRecoverGroupChatsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRecoverGroupChatsReplyMsg
 * JD-Core Version:    0.6.2
 */