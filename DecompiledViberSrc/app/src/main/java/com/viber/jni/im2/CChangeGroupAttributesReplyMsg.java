package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeGroupAttributesReplyMsg
{
  public final long groupID;
  public final int groupRevision;
  public final Byte isChangePa;
  public final long messageToken;
  public final int seq;
  public final int seqInPG;
  public final int status;

  public CChangeGroupAttributesReplyMsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.groupID = paramLong1;
    this.status = paramInt1;
    this.messageToken = paramLong2;
    this.seq = paramInt2;
    this.groupRevision = paramInt3;
    this.seqInPG = paramInt4;
    this.isChangePa = null;
    init();
  }

  public CChangeGroupAttributesReplyMsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, byte paramByte)
  {
    this.groupID = paramLong1;
    this.status = paramInt1;
    this.messageToken = paramLong2;
    this.seq = paramInt2;
    this.groupRevision = paramInt3;
    this.seqInPG = paramInt4;
    this.isChangePa = Byte.valueOf(paramByte);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int CREATE_PA_NOT_SUPPORTED = 12;
    public static final int EMAIL_NOT_VALID = 10;
    public static final int FAILED = 7;
    public static final int GROUP_NON_EXISTENT = 5;
    public static final int GROUP_OLD_REVISION = 6;
    public static final int NAME_FORBIDDEN = 8;
    public static final int NOT_REG = 3;
    public static final int NO_PRIVILEDGES = 2;
    public static final int OK = 1;
    public static final int TAGLINE_FORBIDDEN = 9;
    public static final int TIMEOUT = 4;
    public static final int WEBSITE_NOT_VALID = 11;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCChangeGroupAttributesReplyMsg(CChangeGroupAttributesReplyMsg paramCChangeGroupAttributesReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeGroupAttributesReplyMsg
 * JD-Core Version:    0.6.2
 */