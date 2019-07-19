package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetUserAppsReplyMsg
{
  public final short[] apps;
  public final int seq;
  public final int status;

  public CGetUserAppsReplyMsg(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.apps = ((short[])Im2Utils.checkArrayValue(paramArrayOfShort, [S.class));
    this.seq = paramInt1;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EUserAppsReply
  {
    public static final int TIMEOUT = 2;
    public static final int USER_APPS_REPLY_FAIL = 1;
    public static final int USER_APPS_REPLY_OK = 0;
    public static final int USER_APPS_REPLY_TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetUserAppsReplyMsg(CGetUserAppsReplyMsg paramCGetUserAppsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUserAppsReplyMsg
 * JD-Core Version:    0.6.2
 */