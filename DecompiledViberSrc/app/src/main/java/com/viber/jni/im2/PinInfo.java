package com.viber.jni.im2;

public class PinInfo
{
  public final CMoreUserInfo moreInfo;
  public final String msgInfo;
  public final long pinTime;
  public final int seqInPG;
  public final long token;

  public PinInfo(long paramLong1, int paramInt, String paramString, long paramLong2, CMoreUserInfo paramCMoreUserInfo)
  {
    this.token = paramLong1;
    this.seqInPG = paramInt;
    this.msgInfo = Im2Utils.checkStringValue(paramString);
    this.pinTime = paramLong2;
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public com.viber.jni.PinInfo toLegacyPinInfo()
  {
    return new com.viber.jni.PinInfo(this.msgInfo, this.token, this.seqInPG, this.pinTime);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.PinInfo
 * JD-Core Version:    0.6.2
 */