package com.viber.jni.im2;

public class DownloadDetails
{
  public final String bucketName;
  public final String downloadID;
  public final long objectID;

  public DownloadDetails(long paramLong, String paramString1, String paramString2)
  {
    this.objectID = paramLong;
    this.downloadID = Im2Utils.checkStringValue(paramString1);
    this.bucketName = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.DownloadDetails
 * JD-Core Version:    0.6.2
 */