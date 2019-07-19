package com.viber.jni.im2;

import java.util.Map;

public class CGetUserActivityReplyMsg
{
  public final int seq;
  public final Map<String, Short> userActivityData;

  public CGetUserActivityReplyMsg(Map<String, Short> paramMap, int paramInt)
  {
    this.userActivityData = Im2Utils.checkMapValue(paramMap);
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetUserActivityReplyMsg(CGetUserActivityReplyMsg paramCGetUserActivityReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUserActivityReplyMsg
 * JD-Core Version:    0.6.2
 */