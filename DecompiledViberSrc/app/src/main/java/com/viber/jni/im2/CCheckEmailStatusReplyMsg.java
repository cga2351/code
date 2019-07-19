package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CCheckEmailStatusReplyMsg
{
  public final boolean promotionsAgreed;
  public final int seq;
  public final int status;

  public CCheckEmailStatusReplyMsg(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.promotionsAgreed = paramBoolean;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCheckEmailStatusReplyMsg{seq=" + this.seq + ", status=" + this.status + ", promotionsAgreed=" + this.promotionsAgreed + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EServerStatus
  {
    public static final int EMAIL_NOT_REGISTERED = 3;
    public static final int EMAIL_REGISTERED = 4;
    public static final int ERR_EMAIL_INVALID = 5;
    public static final int ERR_GENERIC = 1;
    public static final int ERR_TIMEOUT = 2;
    public static final int ERR_TOO_MANY_REQUESTS = 6;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCCheckEmailStatusReplyMsg(CCheckEmailStatusReplyMsg paramCCheckEmailStatusReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCheckEmailStatusReplyMsg
 * JD-Core Version:    0.6.2
 */