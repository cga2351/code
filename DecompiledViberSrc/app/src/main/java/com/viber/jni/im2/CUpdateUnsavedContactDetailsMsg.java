package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateUnsavedContactDetailsMsg
{
  public final String clientName;
  public final String downloadID;
  public final int flags;
  public final String newPhoneNumber;
  public final String phoneNumber;
  public final long token;

  public CUpdateUnsavedContactDetailsMsg(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.token = paramLong;
    this.phoneNumber = Im2Utils.checkStringValue(paramString1);
    this.downloadID = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.flags = paramInt;
    this.newPhoneNumber = null;
    init();
  }

  public CUpdateUnsavedContactDetailsMsg(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.token = paramLong;
    this.phoneNumber = Im2Utils.checkStringValue(paramString1);
    this.downloadID = Im2Utils.checkStringValue(paramString2);
    this.clientName = Im2Utils.checkStringValue(paramString3);
    this.flags = paramInt;
    this.newPhoneNumber = Im2Utils.checkStringValue(paramString4);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EFlags
  {
    public static final int NAME_UPDATE = 2;
    public static final int NO_UPDATE = 0;
    public static final int PHONE_NUMBER_CHANGED = 4;
    public static final int PHOTO_UPDATE = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateUnsavedContactDetailsMsg(CUpdateUnsavedContactDetailsMsg paramCUpdateUnsavedContactDetailsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUnsavedContactDetailsMsg
 * JD-Core Version:    0.6.2
 */