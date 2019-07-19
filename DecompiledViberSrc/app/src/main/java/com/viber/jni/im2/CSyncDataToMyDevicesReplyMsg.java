package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSyncDataToMyDevicesReplyMsg
{
  public final int seq;
  public final int status;
  public final long token;

  public CSyncDataToMyDevicesReplyMsg(int paramInt1, int paramInt2, long paramLong)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.token = paramLong;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSyncDataToMyDevicesReplyMsg{status=" + this.status + ", seq=" + this.seq + ", token=" + this.token + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ESyncDataStatus
  {
    public static final int FAILED = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncDataToMyDevicesReplyMsg
 * JD-Core Version:    0.6.2
 */