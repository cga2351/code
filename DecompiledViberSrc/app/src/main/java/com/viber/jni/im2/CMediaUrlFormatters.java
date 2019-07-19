package com.viber.jni.im2;

public class CMediaUrlFormatters
{
  public final String downloadPgUrl;
  public final String downloadPhotoUrl;
  public final String downloadUrl;
  public final String unblockerDownloadPgUrl;
  public final String unblockerDownloadPhotoUrl;
  public final String unblockerDownloadUrl;

  public CMediaUrlFormatters(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.downloadUrl = Im2Utils.checkStringValue(paramString1);
    this.unblockerDownloadUrl = Im2Utils.checkStringValue(paramString2);
    this.downloadPhotoUrl = Im2Utils.checkStringValue(paramString3);
    this.unblockerDownloadPhotoUrl = Im2Utils.checkStringValue(paramString4);
    this.downloadPgUrl = Im2Utils.checkStringValue(paramString5);
    this.unblockerDownloadPgUrl = Im2Utils.checkStringValue(paramString6);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CMediaUrlFormatters{downloadUrl='" + this.downloadUrl + '\'' + ", unblockerDownloadUrl='" + this.unblockerDownloadUrl + '\'' + ", downloadPhotoUrl='" + this.downloadPhotoUrl + '\'' + ", unblockerDownloadPhotoUrl='" + this.unblockerDownloadPhotoUrl + '\'' + ", downloadPgUrl='" + this.downloadPgUrl + '\'' + ", unblockerDownloadPgUrl='" + this.unblockerDownloadPgUrl + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMediaUrlFormatters
 * JD-Core Version:    0.6.2
 */