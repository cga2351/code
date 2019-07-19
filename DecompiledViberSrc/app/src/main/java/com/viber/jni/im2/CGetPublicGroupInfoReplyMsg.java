package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetPublicGroupInfoReplyMsg
{
  public final byte flags;
  public final CGroupAttributesChanged groupAttributes;
  public final Short groupFlags;
  public final long groupID;
  public final byte groupRole;
  public final byte groupType;
  public final PublicGroupUserInfo[] members;
  public final int messageID;
  public final int seq;
  public final int status;
  public final int watchersCount;

  public CGetPublicGroupInfoReplyMsg(long paramLong, byte paramByte1, PublicGroupUserInfo[] paramArrayOfPublicGroupUserInfo, byte paramByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte3, CGroupAttributesChanged paramCGroupAttributesChanged)
  {
    this.groupID = paramLong;
    this.groupType = paramByte1;
    this.members = ((PublicGroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfPublicGroupUserInfo, [Lcom.viber.jni.im2.PublicGroupUserInfo.class));
    this.groupRole = paramByte2;
    this.watchersCount = paramInt1;
    this.messageID = paramInt2;
    this.status = paramInt3;
    this.seq = paramInt4;
    this.flags = paramByte3;
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.groupFlags = null;
    init();
  }

  public CGetPublicGroupInfoReplyMsg(long paramLong, byte paramByte1, PublicGroupUserInfo[] paramArrayOfPublicGroupUserInfo, byte paramByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte3, CGroupAttributesChanged paramCGroupAttributesChanged, short paramShort)
  {
    this.groupID = paramLong;
    this.groupType = paramByte1;
    this.members = ((PublicGroupUserInfo[])Im2Utils.checkArrayValue(paramArrayOfPublicGroupUserInfo, [Lcom.viber.jni.im2.PublicGroupUserInfo.class));
    this.groupRole = paramByte2;
    this.watchersCount = paramInt1;
    this.messageID = paramInt2;
    this.status = paramInt3;
    this.seq = paramInt4;
    this.flags = paramByte3;
    this.groupAttributes = ((CGroupAttributesChanged)Im2Utils.checkStructValue(paramCGroupAttributesChanged));
    this.groupFlags = Short.valueOf(paramShort);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int GROUP_REPLY_FAIL = 3;
    public static final int GROUP_REPLY_NOT_IN_GROUP = 1;
    public static final int GROUP_REPLY_OK = 0;
    public static final int GROUP_REPLY_TIMEOUT = 2;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetPublicGroupInfoReplyMsg(CGetPublicGroupInfoReplyMsg paramCGetPublicGroupInfoReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPublicGroupInfoReplyMsg
 * JD-Core Version:    0.6.2
 */