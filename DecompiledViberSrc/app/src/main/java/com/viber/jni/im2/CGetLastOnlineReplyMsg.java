package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CGetLastOnlineReplyMsg
{
  public final Map<String, OnlineData> lastOnlineData;
  public final int seq;
  public final Integer status;

  public CGetLastOnlineReplyMsg(Map<String, OnlineData> paramMap, int paramInt)
  {
    this.lastOnlineData = Im2Utils.checkMapValue(paramMap);
    this.seq = paramInt;
    this.status = null;
    init();
  }

  public CGetLastOnlineReplyMsg(Map<String, OnlineData> paramMap, int paramInt1, int paramInt2)
  {
    this.lastOnlineData = Im2Utils.checkMapValue(paramMap);
    this.seq = paramInt1;
    this.status = Integer.valueOf(paramInt2);
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
    public abstract void onCGetLastOnlineReplyMsg(CGetLastOnlineReplyMsg paramCGetLastOnlineReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetLastOnlineReplyMsg
 * JD-Core Version:    0.6.2
 */