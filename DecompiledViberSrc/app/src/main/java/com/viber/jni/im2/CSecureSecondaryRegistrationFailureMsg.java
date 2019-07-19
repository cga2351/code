package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSecureSecondaryRegistrationFailureMsg
{
  public final int status;
  public final long token;

  public CSecureSecondaryRegistrationFailureMsg(long paramLong, int paramInt)
  {
    this.token = paramLong;
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EFailCode
  {
    public static final int GENERAL_FAILURE = 0;
    public static final int NO_ACT_CODE = 1;
    public static final int VERSION_MISMATCH = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSecureSecondaryRegistrationFailureMsg(CSecureSecondaryRegistrationFailureMsg paramCSecureSecondaryRegistrationFailureMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSecureSecondaryRegistrationFailureMsg
 * JD-Core Version:    0.6.2
 */