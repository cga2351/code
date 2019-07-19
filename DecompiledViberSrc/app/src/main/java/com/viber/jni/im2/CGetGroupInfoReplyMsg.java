package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetGroupInfoReplyMsg
{
  public final Integer flags;
  public final CGroupAttributesChanged groupAttributes;
  public final long groupID;
  public final String groupName;
  public final Integer groupRole;
  public final byte[] inviteLinkEnc;
  public final GroupUserInfo[] members;
  public final GroupUserChanged[] membersWithRole;
  public final Integer seq;
  public final int status;
  public final byte[] tag;
  public final Integer timebombInSec;

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt;
    this.flags = null;
    this.seq = null;
    this.groupAttributes = null;
    this.membersWithRole = null;
    this.groupRole = null;
    this.timebombInSec = null;
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = null;
    this.groupAttributes = null;
    this.membersWithRole = null;
    this.groupRole = null;
    this.timebombInSec = null;
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = null;
    this.membersWithRole = null;
    this.groupRole = null;
    this.timebombInSec = null;
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3, CGroupAttributesChanged paramCGroupAttributesChanged)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.membersWithRole = null;
    this.groupRole = null;
    this.timebombInSec = null;
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.membersWithRole = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.groupRole = null;
    this.timebombInSec = null;
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt4)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.membersWithRole = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.groupRole = Integer.valueOf(paramInt4);
    this.timebombInSec = null;
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt4, int paramInt5)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.membersWithRole = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.groupRole = Integer.valueOf(paramInt4);
    this.timebombInSec = Integer.valueOf(paramInt5);
    this.inviteLinkEnc = null;
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.membersWithRole = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.groupRole = Integer.valueOf(paramInt4);
    this.timebombInSec = Integer.valueOf(paramInt5);
    this.inviteLinkEnc = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.tag = null;
    init();
  }

  public CGetGroupInfoReplyMsg(long paramLong, String paramString, GroupUserInfo[] paramArrayOfGroupUserInfo, int paramInt1, int paramInt2, int paramInt3, CGroupAttributesChanged paramCGroupAttributesChanged, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt4, int paramInt5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    this.members = ((GroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfGroupUserInfo, [Lcom.viber.jni.im2.GroupUserInfo.class));
    this.status = paramInt1;
    this.flags = Integer.valueOf(paramInt2);
    this.seq = Integer.valueOf(paramInt3);
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.membersWithRole = ((GroupUserChanged[])Im2Utils.checkArrayValue(paramArrayOfGroupUserChanged, [Lcom.viber.jni.im2.GroupUserChanged.class));
    this.groupRole = Integer.valueOf(paramInt4);
    this.timebombInSec = Integer.valueOf(paramInt5);
    this.inviteLinkEnc = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte1, [B.class));
    this.tag = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte2, [B.class));
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EFlags
  {
    public static final int GROUP_FLAGS_NO_SMART_NOTIFICATION = 1;
    public static final int GROUP_FLAGS_SECRET_CHAT = 4;
    public static final int GROUP_FLAGS_SECURE_GROUP = 2;
    public static final int GROUP_FLAGS_SMART_NOTIFICATION;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int GROUP_REPLY_NOT_IN_GROUP = 1;
    public static final int GROUP_REPLY_OK = 0;
    public static final int GROUP_REPLY_TIMEOUT = 2;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetGroupInfoReplyMsg(CGetGroupInfoReplyMsg paramCGetGroupInfoReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetGroupInfoReplyMsg
 * JD-Core Version:    0.6.2
 */