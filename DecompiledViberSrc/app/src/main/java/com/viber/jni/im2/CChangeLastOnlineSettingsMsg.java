package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeLastOnlineSettingsMsg
{
  public final int lastOnlineSetting;

  public CChangeLastOnlineSettingsMsg(int paramInt)
  {
    this.lastOnlineSetting = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ELastOnlineSettings
  {
    public static final int LAST_ONLINE_OFF = 0;
    public static final int LAST_ONLINE_ON = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeLastOnlineSettingsMsg(CChangeLastOnlineSettingsMsg paramCChangeLastOnlineSettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeLastOnlineSettingsMsg
 * JD-Core Version:    0.6.2
 */