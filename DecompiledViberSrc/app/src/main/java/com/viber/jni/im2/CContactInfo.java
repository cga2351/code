package com.viber.jni.im2;

public class CContactInfo
{
  public final String clientName;
  public final String clientPhone;
  public final String clientSortName;

  public CContactInfo(String paramString1, String paramString2, String paramString3)
  {
    this.clientPhone = Im2Utils.checkStringValue(paramString1);
    this.clientName = Im2Utils.checkStringValue(paramString2);
    this.clientSortName = Im2Utils.checkStringValue(paramString3);
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CContactInfo
 * JD-Core Version:    0.6.2
 */