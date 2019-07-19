package com.viber.jni.im2;

public class CRegisteredContactInfo
{
  public static final int PHONE_NUMBER_CHANGED = 1;
  public final String downloadID;
  public final int flags;
  public final String mid;
  public final CMoreUserInfo moreInfo;
  public final String phoneNumber;
  public final String vid;

  public CRegisteredContactInfo(String paramString1, String paramString2, String paramString3, String paramString4, CMoreUserInfo paramCMoreUserInfo, int paramInt)
  {
    this.mid = Im2Utils.checkStringValue(paramString1);
    this.vid = Im2Utils.checkStringValue(paramString2);
    this.phoneNumber = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    this.flags = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CRegisteredContactInfo{mid='" + this.mid + '\'' + ", vid='" + this.vid + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", downloadID='" + this.downloadID + '\'' + ", moreInfo=" + this.moreInfo + ", flags=" + this.flags + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRegisteredContactInfo
 * JD-Core Version:    0.6.2
 */