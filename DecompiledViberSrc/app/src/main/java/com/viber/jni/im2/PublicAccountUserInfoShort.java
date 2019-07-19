package com.viber.jni.im2;

public class PublicAccountUserInfoShort
{
  public final byte groupRole;
  public final String mid;

  public PublicAccountUserInfoShort(String paramString, byte paramByte)
  {
    this.mid = Im2Utils.checkStringValue(paramString);
    this.groupRole = paramByte;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.PublicAccountUserInfoShort
 * JD-Core Version:    0.6.2
 */