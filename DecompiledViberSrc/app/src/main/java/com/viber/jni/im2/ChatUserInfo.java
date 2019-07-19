package com.viber.jni.im2;

public class ChatUserInfo
{
  public final String clientName;
  public final String downloadID;
  public final String encryptedPhoneNumber;
  public final byte groupRole;
  public final String mid;
  public final CMoreUserInfo moreInfo;
  public final String phoneNumber;
  public final String vid;

  public ChatUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte, CMoreUserInfo paramCMoreUserInfo)
  {
    this.mid = Im2Utils.checkStringValue(paramString1);
    this.vid = Im2Utils.checkStringValue(paramString2);
    this.phoneNumber = Im2Utils.checkStringValue(paramString3);
    this.clientName = Im2Utils.checkStringValue(paramString4);
    this.downloadID = Im2Utils.checkStringValue(paramString5);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString6);
    this.groupRole = paramByte;
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public com.viber.jni.ChatUserInfo toLegacyChatUserInfo()
  {
    return new com.viber.jni.ChatUserInfo(this.mid, this.vid, this.phoneNumber, this.clientName, this.downloadID, this.encryptedPhoneNumber, this.groupRole);
  }

  public com.viber.jni.ChatUserInfo toLegacyChatUserInfoWithRole(byte paramByte)
  {
    return new com.viber.jni.ChatUserInfo(this.mid, this.vid, this.phoneNumber, this.clientName, this.downloadID, this.encryptedPhoneNumber, paramByte);
  }

  public String toString()
  {
    return "ChatUserInfo{mid='" + this.mid + '\'' + ", vid='" + this.vid + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", clientName='" + this.clientName + '\'' + ", downloadID='" + this.downloadID + '\'' + ", encryptedPhoneNumber='" + this.encryptedPhoneNumber + '\'' + ", groupRole=" + this.groupRole + ", moreInfo=" + this.moreInfo + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.ChatUserInfo
 * JD-Core Version:    0.6.2
 */