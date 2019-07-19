package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateUserPhotoReplyMsg
{
  public final int status;

  public CUpdateUserPhotoReplyMsg(int paramInt)
  {
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int TIMEOUT = 2;
    public static final int USER_PHOTO_CHANGE_FAILED = 0;
    public static final int USER_PHOTO_CHANGE_OK = 1;
    public static final int USER_PHOTO_CHANGE_TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateUserPhotoReplyMsg(CUpdateUserPhotoReplyMsg paramCUpdateUserPhotoReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUserPhotoReplyMsg
 * JD-Core Version:    0.6.2
 */