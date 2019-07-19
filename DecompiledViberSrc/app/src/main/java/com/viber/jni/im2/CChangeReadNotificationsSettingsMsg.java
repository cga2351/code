package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeReadNotificationsSettingsMsg
{
  public final int readNotificationsSetting;

  public CChangeReadNotificationsSettingsMsg(int paramInt)
  {
    this.readNotificationsSetting = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EReadNotificationsSettings
  {
    public static final int READ_NOTIFICATION_OFF = 0;
    public static final int READ_NOTIFICATION_ON = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeReadNotificationsSettingsMsg(CChangeReadNotificationsSettingsMsg paramCChangeReadNotificationsSettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeReadNotificationsSettingsMsg
 * JD-Core Version:    0.6.2
 */