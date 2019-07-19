package com.viber.voip.user.viberid;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ViberIdPasswordValidationResult
{
  public static final int EMAIL_MATCH_PASSWORD_ERROR = 2;
  public static final int NOT_VALID = 1;
  public static final int RETYPE_PASSWORD_MISMATCH = 3;
  public static final int VALID;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdPasswordValidationResult
 * JD-Core Version:    0.6.2
 */