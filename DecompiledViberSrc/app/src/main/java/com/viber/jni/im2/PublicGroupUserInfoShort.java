package com.viber.jni.im2;

public class PublicGroupUserInfoShort
{
  public final byte groupRole;
  public final String phoneNumber;

  public PublicGroupUserInfoShort(String paramString, byte paramByte)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    this.groupRole = paramByte;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.PublicGroupUserInfoShort
 * JD-Core Version:    0.6.2
 */