package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CRegisterViberIdReplyMsg
{
  public final int seq;
  public final int status;
  public final int version;

  public CRegisterViberIdReplyMsg(int paramInt1, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.version = paramInt3;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CRegisterViberIdReplyMsg{seq=" + this.seq + ", status=" + this.status + ", version=" + this.version + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EServerStatus
  {
    public static final int ERR_EMAIL_INVALID = 5;
    public static final int ERR_GENERIC = 2;
    public static final int ERR_NOT_REG = 4;
    public static final int ERR_PASSWORD_INVALID = 6;
    public static final int ERR_PASSWORD_MISMATCHED = 8;
    public static final int ERR_TIMEOUT = 3;
    public static final int ERR_TOO_MANY_REQUESTS = 9;
    public static final int SUCCESS = 1;
    public static final int TIMEOUT = 3;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRegisterViberIdReplyMsg(CRegisterViberIdReplyMsg paramCRegisterViberIdReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRegisterViberIdReplyMsg
 * JD-Core Version:    0.6.2
 */