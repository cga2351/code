package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetDownloadDetailsReplyMsg
{
  public final DownloadDetails[] downloadDetailsList;
  public final int seq;
  public final int status;

  public CGetDownloadDetailsReplyMsg(int paramInt1, int paramInt2, DownloadDetails[] paramArrayOfDownloadDetails)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.downloadDetailsList = ((DownloadDetails[])Im2Utils.checkArrayValue(paramArrayOfDownloadDetails, [Lcom.viber.jni.im2.DownloadDetails.class));
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetDownloadDetailsReplyMsg(CGetDownloadDetailsReplyMsg paramCGetDownloadDetailsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetDownloadDetailsReplyMsg
 * JD-Core Version:    0.6.2
 */