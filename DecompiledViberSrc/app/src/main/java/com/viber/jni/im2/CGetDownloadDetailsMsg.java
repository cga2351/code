package com.viber.jni.im2;

public class CGetDownloadDetailsMsg
{
  public final MediaObjectDetails[] mediaObjectList;
  public final int seq;

  public CGetDownloadDetailsMsg(int paramInt, MediaObjectDetails[] paramArrayOfMediaObjectDetails)
  {
    this.seq = paramInt;
    this.mediaObjectList = ((MediaObjectDetails[])Im2Utils.checkArrayValue(paramArrayOfMediaObjectDetails, [Lcom.viber.jni.im2.MediaObjectDetails.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetDownloadDetailsMsg(CGetDownloadDetailsMsg paramCGetDownloadDetailsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetDownloadDetailsMsg
 * JD-Core Version:    0.6.2
 */