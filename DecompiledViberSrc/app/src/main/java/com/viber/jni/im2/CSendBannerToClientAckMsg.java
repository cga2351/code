package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendBannerToClientAckMsg
{
  public final long messageToken;
  public final int status;

  public CSendBannerToClientAckMsg(long paramLong, int paramInt)
  {
    this.messageToken = paramLong;
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EBannerStatus
  {
    public static final int FAILED = 2;
    public static final int INVALID_FORMAT = 1;
    public static final int OK;
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendBannerToClientAckMsg(CSendBannerToClientAckMsg paramCSendBannerToClientAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendBannerToClientAckMsg
 * JD-Core Version:    0.6.2
 */