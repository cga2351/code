package com.viber.jni.im2;

public class CSecondaryDeviceDetailsElement
{
  public final long lastLogin;
  public final String location;
  public final String oSName;
  public final String oSVersion;
  public final int system;
  public final String systemName;
  public final String viberVersion;

  public CSecondaryDeviceDetailsElement(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, long paramLong, String paramString5)
  {
    this.oSName = Im2Utils.checkStringValue(paramString1);
    this.oSVersion = Im2Utils.checkStringValue(paramString2);
    this.viberVersion = Im2Utils.checkStringValue(paramString3);
    this.system = paramInt;
    this.systemName = Im2Utils.checkStringValue(paramString4);
    this.lastLogin = paramLong;
    this.location = Im2Utils.checkStringValue(paramString5);
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSecondaryDeviceDetailsElement
 * JD-Core Version:    0.6.2
 */