package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetPersonalProfileReplyMsg
{
  public final int recallAfter;
  public final int status;
  public final String stickerClusterId;

  public CGetPersonalProfileReplyMsg(int paramInt1, int paramInt2, String paramString)
  {
    this.status = paramInt1;
    this.recallAfter = paramInt2;
    this.stickerClusterId = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int PROFILE_STATUS_FAILED = 1;
    public static final int PROFILE_STATUS_OK = 0;
    public static final int PROFILE_STATUS_TIMEOUT = 2;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetPersonalProfileReplyMsg(CGetPersonalProfileReplyMsg paramCGetPersonalProfileReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPersonalProfileReplyMsg
 * JD-Core Version:    0.6.2
 */