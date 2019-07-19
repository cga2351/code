package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetViberIdReplyMsg
{
  public final String email;
  public final int flags;
  public final CMoreUserInfo moreUserInfo;
  public final int seq;
  public final int status;
  public final int version;

  public CGetViberIdReplyMsg(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, CMoreUserInfo paramCMoreUserInfo)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.version = paramInt3;
    this.flags = paramInt4;
    this.email = Im2Utils.checkStringValue(paramString);
    this.moreUserInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetViberIdReplyMsg{seq=" + this.seq + ", status=" + this.status + ", version=" + this.version + ", flags=" + this.flags + ", email='" + this.email + '\'' + ", moreUserInfo=" + this.moreUserInfo + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EServerStatus
  {
    public static final int ERR_GENERIC = 1;
    public static final int ERR_NOT_REG = 3;
    public static final int ERR_TIMEOUT = 2;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetViberIdReplyMsg(CGetViberIdReplyMsg paramCGetViberIdReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetViberIdReplyMsg
 * JD-Core Version:    0.6.2
 */