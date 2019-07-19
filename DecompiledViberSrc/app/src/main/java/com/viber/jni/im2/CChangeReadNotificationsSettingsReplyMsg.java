package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeReadNotificationsSettingsReplyMsg
{
  public final int readNotificationsSetting;
  public final int status;

  public CChangeReadNotificationsSettingsReplyMsg(int paramInt1, int paramInt2)
  {
    this.readNotificationsSetting = paramInt1;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int NOT_REG = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCChangeReadNotificationsSettingsReplyMsg(CChangeReadNotificationsSettingsReplyMsg paramCChangeReadNotificationsSettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeReadNotificationsSettingsReplyMsg
 * JD-Core Version:    0.6.2
 */