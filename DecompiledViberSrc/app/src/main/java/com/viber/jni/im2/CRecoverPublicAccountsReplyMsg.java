package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Map;

public class CRecoverPublicAccountsReplyMsg
{
  public final byte chunkSeq;
  public final boolean last;
  public final RecoveredPublicAccountInfo[] publicAccounts;
  public final RecoveredPublicAccountDeleteAllUsersMessages[] publicAccountsDeleteAllUsersMessages;
  public final RecoveredPublicAccountMoreInfo[] publicAccountsMoreInfo;
  public final int seq;
  public final int status;
  public final Map<String, ChatUserInfo> users;

  public CRecoverPublicAccountsReplyMsg(int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean, Map<String, ChatUserInfo> paramMap, RecoveredPublicAccountInfo[] paramArrayOfRecoveredPublicAccountInfo)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.chunkSeq = paramByte;
    this.last = paramBoolean;
    this.users = Im2Utils.checkMapValue(paramMap);
    this.publicAccounts = ((RecoveredPublicAccountInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicAccountInfo, [Lcom.viber.jni.im2.RecoveredPublicAccountInfo.class));
    this.publicAccountsMoreInfo = null;
    this.publicAccountsDeleteAllUsersMessages = null;
    init();
  }

  public CRecoverPublicAccountsReplyMsg(int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean, Map<String, ChatUserInfo> paramMap, RecoveredPublicAccountInfo[] paramArrayOfRecoveredPublicAccountInfo, RecoveredPublicAccountMoreInfo[] paramArrayOfRecoveredPublicAccountMoreInfo)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.chunkSeq = paramByte;
    this.last = paramBoolean;
    this.users = Im2Utils.checkMapValue(paramMap);
    this.publicAccounts = ((RecoveredPublicAccountInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicAccountInfo, [Lcom.viber.jni.im2.RecoveredPublicAccountInfo.class));
    this.publicAccountsMoreInfo = ((RecoveredPublicAccountMoreInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicAccountMoreInfo, [Lcom.viber.jni.im2.RecoveredPublicAccountMoreInfo.class));
    this.publicAccountsDeleteAllUsersMessages = null;
    init();
  }

  public CRecoverPublicAccountsReplyMsg(int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean, Map<String, ChatUserInfo> paramMap, RecoveredPublicAccountInfo[] paramArrayOfRecoveredPublicAccountInfo, RecoveredPublicAccountMoreInfo[] paramArrayOfRecoveredPublicAccountMoreInfo, RecoveredPublicAccountDeleteAllUsersMessages[] paramArrayOfRecoveredPublicAccountDeleteAllUsersMessages)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.chunkSeq = paramByte;
    this.last = paramBoolean;
    this.users = Im2Utils.checkMapValue(paramMap);
    this.publicAccounts = ((RecoveredPublicAccountInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicAccountInfo, [Lcom.viber.jni.im2.RecoveredPublicAccountInfo.class));
    this.publicAccountsMoreInfo = ((RecoveredPublicAccountMoreInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicAccountMoreInfo, [Lcom.viber.jni.im2.RecoveredPublicAccountMoreInfo.class));
    this.publicAccountsDeleteAllUsersMessages = ((RecoveredPublicAccountDeleteAllUsersMessages[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicAccountDeleteAllUsersMessages, [Lcom.viber.jni.im2.RecoveredPublicAccountDeleteAllUsersMessages.class));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CRecoverPublicAccountsReplyMsg{status=" + this.status + ", seq=" + this.seq + ", chunkSeq=" + this.chunkSeq + ", last=" + this.last + ", users=" + this.users + ", publicAccounts=" + Arrays.toString(this.publicAccounts) + ", publicAccountsMoreInfo=" + Arrays.toString(this.publicAccountsMoreInfo) + ", publicAccountsDeleteAllUsersMessages=" + Arrays.toString(this.publicAccountsDeleteAllUsersMessages) + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRecoverPublicAccountsReplyMsg(CRecoverPublicAccountsReplyMsg paramCRecoverPublicAccountsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRecoverPublicAccountsReplyMsg
 * JD-Core Version:    0.6.2
 */