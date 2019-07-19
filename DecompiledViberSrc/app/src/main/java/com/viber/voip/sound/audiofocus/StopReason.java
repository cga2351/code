package com.viber.voip.sound.audiofocus;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface StopReason
{
  public static final int AUDIO_FOCUS_LOSS = 1;
  public static final int NORMAL;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.audiofocus.StopReason
 * JD-Core Version:    0.6.2
 */