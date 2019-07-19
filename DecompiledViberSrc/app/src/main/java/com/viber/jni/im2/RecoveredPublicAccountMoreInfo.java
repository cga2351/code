package com.viber.jni.im2;

import java.util.Arrays;

public class RecoveredPublicAccountMoreInfo
{
  public final CMoreUserInfo moreInfo;
  public final PinInfo[] pinsInfo;
  public final long publicChatId;

  public RecoveredPublicAccountMoreInfo(long paramLong, PinInfo[] paramArrayOfPinInfo, CMoreUserInfo paramCMoreUserInfo)
  {
    this.publicChatId = paramLong;
    this.pinsInfo = ((PinInfo[])Im2Utils.checkArrayValue(paramArrayOfPinInfo, [Lcom.viber.jni.im2.PinInfo.class));
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "RecoveredPublicAccountMoreInfo{publicChatId=" + this.publicChatId + ", pinsInfo=" + Arrays.toString(this.pinsInfo) + ", moreInfo=" + this.moreInfo + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredPublicAccountMoreInfo
 * JD-Core Version:    0.6.2
 */