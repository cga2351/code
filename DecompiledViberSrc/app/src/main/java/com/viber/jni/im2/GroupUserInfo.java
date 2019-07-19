package com.viber.jni.im2;

public class GroupUserInfo
{
  public final String clientName;
  public final String downloadID;
  public final String phoneNumber;

  public GroupUserInfo(String paramString1, String paramString2, String paramString3)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.downloadID = Im2Utils.checkStringValue(paramString3);
    init();
  }

  private void init()
  {
  }

  public com.viber.jni.GroupUserInfo toLegacyGroupUserInfo()
  {
    return new com.viber.jni.GroupUserInfo(this.phoneNumber, this.clientName, this.downloadID);
  }

  public String toString()
  {
    return "GroupUserInfo{phoneNumber='" + this.phoneNumber + '\'' + ", clientName='" + this.clientName + '\'' + ", downloadID='" + this.downloadID + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.GroupUserInfo
 * JD-Core Version:    0.6.2
 */