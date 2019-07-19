package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGetUsersDetailsV2ReplyMsg
{
  public final int inputType;
  public final int seq;
  public final int status;
  public final CGetUserDetailsV2[] usersDetails;

  public CGetUsersDetailsV2ReplyMsg(int paramInt1, int paramInt2, CGetUserDetailsV2[] paramArrayOfCGetUserDetailsV2, int paramInt3)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.usersDetails = ((CGetUserDetailsV2[])Im2Utils.checkArrayValue(paramArrayOfCGetUserDetailsV2, [Lcom.viber.jni.im2.CGetUserDetailsV2.class));
    this.inputType = paramInt3;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetUsersDetailsV2ReplyMsg{status=" + this.status + ", seq=" + this.seq + ", usersDetails=" + Arrays.toString(this.usersDetails) + ", inputType=" + this.inputType + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetUsersDetailsV2ReplyMsg(CGetUsersDetailsV2ReplyMsg paramCGetUsersDetailsV2ReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUsersDetailsV2ReplyMsg
 * JD-Core Version:    0.6.2
 */