package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateSelfUserDetailsMsg
{
  public final String downloadID;
  public final int flags;
  public final String name;
  public final long token;

  public CUpdateSelfUserDetailsMsg(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this.token = paramLong;
    this.downloadID = Im2Utils.checkStringValue(paramString1);
    this.name = Im2Utils.checkStringValue(paramString2);
    this.flags = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EFlags
  {
    public static final int SELF_USER_DETAILS_NAME_UPDATE = 2;
    public static final int SELF_USER_DETAILS_NO_UPDATE = 0;
    public static final int SELF_USER_DETAILS_PHOTO_UPDATE = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateSelfUserDetailsMsg(CUpdateSelfUserDetailsMsg paramCUpdateSelfUserDetailsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateSelfUserDetailsMsg
 * JD-Core Version:    0.6.2
 */