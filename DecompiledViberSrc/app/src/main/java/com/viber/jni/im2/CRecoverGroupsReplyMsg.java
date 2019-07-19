package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CRecoverGroupsReplyMsg
{
  public final Byte chunkSeq;
  public final RecoveredGroupInfo[] groups;
  public final RecoveredGroupInfoEx[] groupsEx;
  public final Boolean last;
  public final Map<String, String> phone2Encrypted;
  public final RecoveredPublicGroupInfo[] publicGroups;
  public final RecoveredSecureGroupInfo[] secureGroups;
  public final Integer seq;
  public final int status;
  public final Map<String, GroupUserInfo> users;

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt;
    this.seq = null;
    this.publicGroups = null;
    this.phone2Encrypted = null;
    this.chunkSeq = null;
    this.last = null;
    this.groupsEx = null;
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = null;
    this.phone2Encrypted = null;
    this.chunkSeq = null;
    this.last = null;
    this.groupsEx = null;
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2, RecoveredPublicGroupInfo[] paramArrayOfRecoveredPublicGroupInfo)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = ((RecoveredPublicGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicGroupInfo, [Lcom.viber.jni.im2.RecoveredPublicGroupInfo.class));
    this.phone2Encrypted = null;
    this.chunkSeq = null;
    this.last = null;
    this.groupsEx = null;
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2, RecoveredPublicGroupInfo[] paramArrayOfRecoveredPublicGroupInfo, Map<String, String> paramMap1)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = ((RecoveredPublicGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicGroupInfo, [Lcom.viber.jni.im2.RecoveredPublicGroupInfo.class));
    this.phone2Encrypted = Im2Utils.checkMapValue(paramMap1);
    this.chunkSeq = null;
    this.last = null;
    this.groupsEx = null;
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2, RecoveredPublicGroupInfo[] paramArrayOfRecoveredPublicGroupInfo, Map<String, String> paramMap1, byte paramByte)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = ((RecoveredPublicGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicGroupInfo, [Lcom.viber.jni.im2.RecoveredPublicGroupInfo.class));
    this.phone2Encrypted = Im2Utils.checkMapValue(paramMap1);
    this.chunkSeq = Byte.valueOf(paramByte);
    this.last = null;
    this.groupsEx = null;
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2, RecoveredPublicGroupInfo[] paramArrayOfRecoveredPublicGroupInfo, Map<String, String> paramMap1, byte paramByte, boolean paramBoolean)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = ((RecoveredPublicGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicGroupInfo, [Lcom.viber.jni.im2.RecoveredPublicGroupInfo.class));
    this.phone2Encrypted = Im2Utils.checkMapValue(paramMap1);
    this.chunkSeq = Byte.valueOf(paramByte);
    this.last = Boolean.valueOf(paramBoolean);
    this.groupsEx = null;
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2, RecoveredPublicGroupInfo[] paramArrayOfRecoveredPublicGroupInfo, Map<String, String> paramMap1, byte paramByte, boolean paramBoolean, RecoveredGroupInfoEx[] paramArrayOfRecoveredGroupInfoEx)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = ((RecoveredPublicGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicGroupInfo, [Lcom.viber.jni.im2.RecoveredPublicGroupInfo.class));
    this.phone2Encrypted = Im2Utils.checkMapValue(paramMap1);
    this.chunkSeq = Byte.valueOf(paramByte);
    this.last = Boolean.valueOf(paramBoolean);
    this.groupsEx = ((RecoveredGroupInfoEx[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfoEx, [Lcom.viber.jni.im2.RecoveredGroupInfoEx.class));
    this.secureGroups = null;
    init();
  }

  public CRecoverGroupsReplyMsg(RecoveredGroupInfo[] paramArrayOfRecoveredGroupInfo, Map<String, GroupUserInfo> paramMap, int paramInt1, int paramInt2, RecoveredPublicGroupInfo[] paramArrayOfRecoveredPublicGroupInfo, Map<String, String> paramMap1, byte paramByte, boolean paramBoolean, RecoveredGroupInfoEx[] paramArrayOfRecoveredGroupInfoEx, RecoveredSecureGroupInfo[] paramArrayOfRecoveredSecureGroupInfo)
  {
    this.groups = ((RecoveredGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfo, [Lcom.viber.jni.im2.RecoveredGroupInfo.class));
    this.users = Im2Utils.checkMapValue(paramMap);
    this.status = paramInt1;
    this.seq = Integer.valueOf(paramInt2);
    this.publicGroups = ((RecoveredPublicGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredPublicGroupInfo, [Lcom.viber.jni.im2.RecoveredPublicGroupInfo.class));
    this.phone2Encrypted = Im2Utils.checkMapValue(paramMap1);
    this.chunkSeq = Byte.valueOf(paramByte);
    this.last = Boolean.valueOf(paramBoolean);
    this.groupsEx = ((RecoveredGroupInfoEx[])Im2Utils.checkArrayValue(paramArrayOfRecoveredGroupInfoEx, [Lcom.viber.jni.im2.RecoveredGroupInfoEx.class));
    this.secureGroups = ((RecoveredSecureGroupInfo[])Im2Utils.checkArrayValue(paramArrayOfRecoveredSecureGroupInfo, [Lcom.viber.jni.im2.RecoveredSecureGroupInfo.class));
    init();
  }

  private void init()
  {
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
    public abstract void onCRecoverGroupsReplyMsg(CRecoverGroupsReplyMsg paramCRecoverGroupsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRecoverGroupsReplyMsg
 * JD-Core Version:    0.6.2
 */