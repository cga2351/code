package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeUserActivitySettingsMsg
{
  public final int userActivitySetting;

  public CChangeUserActivitySettingsMsg(int paramInt)
  {
    this.userActivitySetting = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EUserActivitySettings
  {
    public static final int USER_ACTIVITY_OFF = 0;
    public static final int USER_ACTIVITY_ON = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeUserActivitySettingsMsg(CChangeUserActivitySettingsMsg paramCChangeUserActivitySettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeUserActivitySettingsMsg
 * JD-Core Version:    0.6.2
 */