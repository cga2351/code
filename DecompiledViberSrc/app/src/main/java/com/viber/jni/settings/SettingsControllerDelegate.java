package com.viber.jni.settings;

public abstract interface SettingsControllerDelegate
{
  public abstract void onChangeLastOnlineSettingsReply(int paramInt1, int paramInt2);

  public abstract void onChangeReadNotificationsSettingsReply(int paramInt1, int paramInt2);

  public abstract void onChangeUserActivitySettingsReply(int paramInt1, int paramInt2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.settings.SettingsControllerDelegate
 * JD-Core Version:    0.6.2
 */