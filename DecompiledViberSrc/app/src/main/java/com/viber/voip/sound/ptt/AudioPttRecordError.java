package com.viber.voip.sound.ptt;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AudioPttRecordError
{
  public static final int CALL = 1;
  public static final int FAILED = 2;
  public static final int NO_ERROR;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPttRecordError
 * JD-Core Version:    0.6.2
 */