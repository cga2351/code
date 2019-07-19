package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendMessageReplyMsg
{
  public final long messageToken;
  public final String msgInfo;
  public final Integer securityStatus;
  public final int seq;
  public final Integer seqInPG;
  public final int status;

  public CSendMessageReplyMsg(int paramInt1, long paramLong, int paramInt2)
  {
    this.seq = paramInt1;
    this.messageToken = paramLong;
    this.status = paramInt2;
    this.seqInPG = null;
    this.msgInfo = null;
    this.securityStatus = null;
    init();
  }

  public CSendMessageReplyMsg(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.messageToken = paramLong;
    this.status = paramInt2;
    this.seqInPG = Integer.valueOf(paramInt3);
    this.msgInfo = null;
    this.securityStatus = null;
    init();
  }

  public CSendMessageReplyMsg(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    this.seq = paramInt1;
    this.messageToken = paramLong;
    this.status = paramInt2;
    this.seqInPG = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString);
    this.securityStatus = null;
    init();
  }

  public CSendMessageReplyMsg(int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    this.seq = paramInt1;
    this.messageToken = paramLong;
    this.status = paramInt2;
    this.seqInPG = Integer.valueOf(paramInt3);
    this.msgInfo = Im2Utils.checkStringValue(paramString);
    this.securityStatus = Integer.valueOf(paramInt4);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ERecipientSecurityStatus
  {
    public static final int SEC_STATUS_OK = 0;
    public static final int SEC_STATUS_SHOULD_SECURE = 1;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int APP_INVITE_BLOCKED = 11;
    public static final int E2E_SECURE_MESSAGE_TO_INSECURE_TARGET = 12;
    public static final int E2E_SECURE_MESSAGE_WHEN_PRIMARY_INSECURE = 13;
    public static final int E2E_SECURE_PEER_LIST_INVALID = 8;
    public static final int E2E_SECURE_SELF_LIST_INVALID = 9;
    public static final int E2E_SECURE_UNSUPPORTED_MSG_TYPE = 10;
    public static final int FAILED_TO_SEND = 21;
    public static final int INVALID_PARAMETER = 22;
    public static final int INVALID_TEXT = 3;
    public static final int INVALID_TIMEBOMB = 19;
    public static final int LARGE_THUMBNAIL_SIZE_TOO_BIG = 6;
    public static final int NOT_REG = 0;
    public static final int NO_SENDING_PRIVILEGES = 20;
    public static final int OK = 1;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 16;
    public static final int PUBLIC_ACCOUNT_NOT_FOUND = 14;
    public static final int PUBLIC_ACCOUNT_NOT_READY = 15;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 17;
    public static final int TEXT_SIZE_TOO_BIG = 5;
    public static final int THUMBNAIL_SIZE_TOO_BIG = 4;
    public static final int TIMEOUT = 2;
    public static final int UNSUPPORTED_MSG_TYPE_PG = 7;
    public static final int UNSUPPORTED_SECRET_CHAT = 18;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendMessageReplyMsg(CSendMessageReplyMsg paramCSendMessageReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendMessageReplyMsg
 * JD-Core Version:    0.6.2
 */