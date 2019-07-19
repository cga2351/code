package com.viber.jni.im2;

public class CChangeConversationSettingsMsg
{
  public final Boolean hidden;
  public final Boolean mute;
  public final String peerPhoneNumber;
  public final boolean smartNotifications;

  public CChangeConversationSettingsMsg(String paramString, boolean paramBoolean)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.smartNotifications = paramBoolean;
    this.mute = null;
    this.hidden = null;
    init();
  }

  public CChangeConversationSettingsMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.smartNotifications = paramBoolean1;
    this.mute = Boolean.valueOf(paramBoolean2);
    this.hidden = null;
    init();
  }

  public CChangeConversationSettingsMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
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
    public abstract void handleCChangeConversationSettingsMsg(CChangeConversationSettingsMsg paramCChangeConversationSettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeConversationSettingsMsg
 * JD-Core Version:    0.6.2
 */