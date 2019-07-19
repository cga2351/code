package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetAdInfoReplyMsg
{
  public final String adInfo;
  public final int seq;
  public final int status;
  public final Long waitIntervalForNextQuery;

  public CGetAdInfoReplyMsg(int paramInt1, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.adInfo = Im2Utils.checkStringValue(paramString);
    this.waitIntervalForNextQuery = null;
    init();
  }

  public CGetAdInfoReplyMsg(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.adInfo = Im2Utils.checkStringValue(paramString);
    this.waitIntervalForNextQuery = Long.valueOf(paramLong);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetAdInfoReplyMsg(CGetAdInfoReplyMsg paramCGetAdInfoReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetAdInfoReplyMsg
 * JD-Core Version:    0.6.2
 */