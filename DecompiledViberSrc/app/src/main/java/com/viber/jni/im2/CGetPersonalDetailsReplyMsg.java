package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetPersonalDetailsReplyMsg
{
  public final String email;
  public final int emailFlags;
  public final int seq;
  public final int status;

  public CGetPersonalDetailsReplyMsg(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.email = Im2Utils.checkStringValue(paramString);
    this.emailFlags = paramInt3;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EPersonalDetailsStatus
  {
    public static final int ERR_GENERIC = 1;
    public static final int ERR_NOT_REG = 3;
    public static final int ERR_TIMEOUT = 2;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EmailFlagsMask
  {
    public static final int EFG_EMAIL_EXISTS = 1;
    public static final int EFG_EMAIL_INVALID = 8;
    public static final int EFG_EMAIL_VERIFIED = 2;
    public static final int EFG_USER_CONSENT = 4;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetPersonalDetailsReplyMsg(CGetPersonalDetailsReplyMsg paramCGetPersonalDetailsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPersonalDetailsReplyMsg
 * JD-Core Version:    0.6.2
 */