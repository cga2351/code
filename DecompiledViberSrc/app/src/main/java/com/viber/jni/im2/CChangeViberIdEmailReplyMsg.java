package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeViberIdEmailReplyMsg
{
  public final int flags;
  public final int seq;
  public final int status;
  public final int version;

  public CChangeViberIdEmailReplyMsg(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.flags = paramInt3;
    this.version = paramInt4;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EServerStatus
  {
    public static final int ERR_GENERIC = 1;
    public static final int ERR_INVALID_EMAIL = 4;
    public static final int ERR_INVALID_PASSWORD = 5;
    public static final int ERR_NOT_REG = 3;
    public static final int ERR_TIMEOUT = 2;
    public static final int ERR_TOO_MANY_REQUESTS = 6;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCChangeViberIdEmailReplyMsg(CChangeViberIdEmailReplyMsg paramCChangeViberIdEmailReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeViberIdEmailReplyMsg
 * JD-Core Version:    0.6.2
 */