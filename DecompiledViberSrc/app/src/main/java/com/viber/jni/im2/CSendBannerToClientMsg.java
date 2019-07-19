package com.viber.jni.im2;

public class CSendBannerToClientMsg
{
  public final String bannerInfo;
  public final Long endTime;
  public final long messageToken;
  public final String tag;

  public CSendBannerToClientMsg(long paramLong)
  {
    this.messageToken = paramLong;
    this.bannerInfo = null;
    this.endTime = null;
    this.tag = null;
    init();
  }

  public CSendBannerToClientMsg(long paramLong, String paramString)
  {
    this.messageToken = paramLong;
    this.bannerInfo = Im2Utils.checkStringValue(paramString);
    this.endTime = null;
    this.tag = null;
    init();
  }

  public CSendBannerToClientMsg(long paramLong1, String paramString, long paramLong2)
  {
    this.messageToken = paramLong1;
    this.bannerInfo = Im2Utils.checkStringValue(paramString);
    this.endTime = Long.valueOf(paramLong2);
    this.tag = null;
    init();
  }

  public CSendBannerToClientMsg(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    this.messageToken = paramLong1;
    this.bannerInfo = Im2Utils.checkStringValue(paramString1);
    this.endTime = Long.valueOf(paramLong2);
    this.tag = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendBannerToClientMsg(CSendBannerToClientMsg paramCSendBannerToClientMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendBannerToClientMsg
 * JD-Core Version:    0.6.2
 */