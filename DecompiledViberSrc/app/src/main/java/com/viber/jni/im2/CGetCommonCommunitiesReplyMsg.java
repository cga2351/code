package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class CGetCommonCommunitiesReplyMsg
{
  public final long[] groups;
  public final int seq;
  public final int status;

  public CGetCommonCommunitiesReplyMsg(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.groups = ((long[])Im2Utils.checkArrayValue(paramArrayOfLong, [J.class));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetCommonCommunitiesReplyMsg{seq=" + this.seq + ", status=" + this.status + ", groups=" + Arrays.toString(this.groups) + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int NOT_REG = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetCommonCommunitiesReplyMsg(CGetCommonCommunitiesReplyMsg paramCGetCommonCommunitiesReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetCommonCommunitiesReplyMsg
 * JD-Core Version:    0.6.2
 */