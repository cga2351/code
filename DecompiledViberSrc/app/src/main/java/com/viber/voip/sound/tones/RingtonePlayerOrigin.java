package com.viber.voip.sound.tones;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@interface RingtonePlayerOrigin
{
  public static final int CALL = 1;
  public static final int CUSTOM_TONE = 3;
  public static final int NONE = 0;
  public static final int SAMPLE_BACKUP = 4;
  public static final int STICKER_PROMO = 2;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.RingtonePlayerOrigin
 * JD-Core Version:    0.6.2
 */