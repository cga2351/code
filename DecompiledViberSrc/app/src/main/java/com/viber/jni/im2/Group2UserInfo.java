package com.viber.jni.im2;

public class Group2UserInfo
{
  public final String clientName;
  public final String downloadID;
  public final String encryptedPhoneNumber;
  public final String mid;
  public final CMoreUserInfo moreUserInfo;
  public final String realPhoneNumber;

  public Group2UserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CMoreUserInfo paramCMoreUserInfo)
  {
    this.realPhoneNumber = Im2Utils.checkStringValue(paramString1);
    this.mid = Im2Utils.checkStringValue(paramString2);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString3);
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.downloadID = Im2Utils.checkStringValue(paramString5);
    this.moreUserInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "Group2UserInfo{realPhoneNumber='" + this.realPhoneNumber + '\'' + ", mid='" + this.mid + '\'' + ", encryptedPhoneNumber='" + this.encryptedPhoneNumber + '\'' + ", clientName='" + this.clientName + '\'' + ", downloadID='" + this.downloadID + '\'' + ", moreUserInfo=" + this.moreUserInfo + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Group2UserInfo
 * JD-Core Version:    0.6.2
 */