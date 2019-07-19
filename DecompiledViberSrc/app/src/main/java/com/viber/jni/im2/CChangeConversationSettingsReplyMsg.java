package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeConversationSettingsReplyMsg
{
  public final Boolean hidden;
  public final boolean isOK;
  public final Boolean mute;
  public final String peerPhoneNumber;
  public final boolean smartNotifications;
  public final Integer status;

  public CChangeConversationSettingsReplyMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = null;
    this.hidden = null;
    this.status = null;
    init();
  }

  public CChangeConversationSettingsReplyMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = null;
    this.status = null;
    init();
  }

  public CChangeConversationSettingsReplyMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = Boolean.valueOf(paramBoolean4);
    this.status = null;
    init();
  }

  public CChangeConversationSettingsReplyMsg(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    this.peerPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = Boolean.valueOf(paramBoolean4);
    this.status = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCChangeConversationSettingsReplyMsg(CChangeConversationSettingsReplyMsg paramCChangeConversationSettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeConversationSettingsReplyMsg
 * JD-Core Version:    0.6.2
 */