package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendPublicGroupInviteMsg
{
  public final Integer chatType;
  public final long groupID;
  public final Integer inviteType;
  public final int seq;
  public final Integer timebombInSec;
  public final Long toGroup;
  public final String[] toNumbers;

  public CSendPublicGroupInviteMsg(int paramInt, long paramLong, String[] paramArrayOfString)
  {
    this.seq = paramInt;
    this.groupID = paramLong;
    this.toNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.toGroup = null;
    this.inviteType = null;
    this.chatType = null;
    this.timebombInSec = null;
    init();
  }

  public CSendPublicGroupInviteMsg(int paramInt, long paramLong1, String[] paramArrayOfString, long paramLong2)
  {
    this.seq = paramInt;
    this.groupID = paramLong1;
    this.toNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.toGroup = Long.valueOf(paramLong2);
    this.inviteType = null;
    this.chatType = null;
    this.timebombInSec = null;
    init();
  }

  public CSendPublicGroupInviteMsg(int paramInt1, long paramLong1, String[] paramArrayOfString, long paramLong2, int paramInt2)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.toNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.toGroup = Long.valueOf(paramLong2);
    this.inviteType = Integer.valueOf(paramInt2);
    this.chatType = null;
    this.timebombInSec = null;
    init();
  }

  public CSendPublicGroupInviteMsg(int paramInt1, long paramLong1, String[] paramArrayOfString, long paramLong2, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.toNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.toGroup = Long.valueOf(paramLong2);
    this.inviteType = Integer.valueOf(paramInt2);
    this.chatType = Integer.valueOf(paramInt3);
    this.timebombInSec = null;
    init();
  }

  public CSendPublicGroupInviteMsg(int paramInt1, long paramLong1, String[] paramArrayOfString, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.toNumbers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.toGroup = Long.valueOf(paramLong2);
    this.inviteType = Integer.valueOf(paramInt2);
    this.chatType = Integer.valueOf(paramInt3);
    this.timebombInSec = Integer.valueOf(paramInt4);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EInviteType
  {
    public static final int PUBLIC_ACCOUNT = 1;
    public static final int PUBLIC_ACCOUNT_INFO = 2;
    public static final int PUBLIC_CHAT;
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendPublicGroupInviteMsg(CSendPublicGroupInviteMsg paramCSendPublicGroupInviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendPublicGroupInviteMsg
 * JD-Core Version:    0.6.2
 */