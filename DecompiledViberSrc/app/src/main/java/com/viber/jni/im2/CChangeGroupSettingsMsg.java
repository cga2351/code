package com.viber.jni.im2;

public class CChangeGroupSettingsMsg
{
  public final long groupID;
  public final Boolean hidden;
  public final Boolean mute;
  public final boolean smartNotifications;

  public CChangeGroupSettingsMsg(long paramLong, boolean paramBoolean)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean;
    this.mute = null;
    this.hidden = null;
    init();
  }

  public CChangeGroupSettingsMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.mute = Boolean.valueOf(paramBoolean2);
    this.hidden = null;
    init();
  }

  public CChangeGroupSettingsMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.mute = Boolean.valueOf(paramBoolean2);
    this.hidden = Boolean.valueOf(paramBoolean3);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeGroupSettingsMsg(CChangeGroupSettingsMsg paramCChangeGroupSettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeGroupSettingsMsg
 * JD-Core Version:    0.6.2
 */