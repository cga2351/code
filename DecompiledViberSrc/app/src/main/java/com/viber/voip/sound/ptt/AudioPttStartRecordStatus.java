package com.viber.voip.sound.ptt;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AudioPttStartRecordStatus
{
  public static final int FAILED = 3;
  public static final int IN_CALL = 2;
  public static final int NO_SPACE = 1;
  public static final int OK;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPttStartRecordStatus
 * JD-Core Version:    0.6.2
 */