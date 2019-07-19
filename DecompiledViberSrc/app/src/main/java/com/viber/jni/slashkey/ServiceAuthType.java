package com.viber.jni.slashkey;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ServiceAuthType
{
  public static final int NONE = 0;
  public static final int REDIRECT_LINK = 1;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.ServiceAuthType
 * JD-Core Version:    0.6.2
 */