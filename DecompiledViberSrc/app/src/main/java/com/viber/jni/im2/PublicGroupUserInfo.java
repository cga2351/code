package com.viber.jni.im2;

public class PublicGroupUserInfo
{
  public final String clientName;
  public final String downloadID;
  public final String encryptedPhoneNumber;
  public final byte groupRole;
  public final String phoneNumber;

  public PublicGroupUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, byte paramByte)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString1);
    this.encryptedPhoneNumber = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.groupRole = paramByte;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.PublicGroupUserInfo
 * JD-Core Version:    0.6.2
 */