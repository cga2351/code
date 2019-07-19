package com.viber.voip.phone.call;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CallInfoCallSource
{
  public static final int CONTACT_DETAILS_GSM_CALL = 2;
  public static final int CONTACT_DETAILS_VIBER_CALL = 3;
  public static final int CONTACT_DETAILS_VIDEO_CALL = 4;
  public static final int CONTACT_DETAILS_VO_CALL = 1;
  public static final int NONE;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallInfoCallSource
 * JD-Core Version:    0.6.2
 */