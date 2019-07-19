package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeGroupSettingsReplyMsg
{
  public final long groupID;
  public final Boolean hidden;
  public final boolean isOK;
  public final Boolean mute;
  public final Boolean recover;
  public final boolean smartNotifications;
  public final Integer status;

  public CChangeGroupSettingsReplyMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = null;
    this.hidden = null;
    this.status = null;
    this.recover = null;
    init();
  }

  public CChangeGroupSettingsReplyMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = null;
    this.status = null;
    this.recover = null;
    init();
  }

  public CChangeGroupSettingsReplyMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = Boolean.valueOf(paramBoolean4);
    this.status = null;
    this.recover = null;
    init();
  }

  public CChangeGroupSettingsReplyMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = Boolean.valueOf(paramBoolean4);
    this.status = Integer.valueOf(paramInt);
    this.recover = null;
    init();
  }

  public CChangeGroupSettingsReplyMsg(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    this.groupID = paramLong;
    this.smartNotifications = paramBoolean1;
    this.isOK = paramBoolean2;
    this.mute = Boolean.valueOf(paramBoolean3);
    this.hidden = Boolean.valueOf(paramBoolean4);
    this.status = Integer.valueOf(paramInt);
    this.recover = Boolean.valueOf(paramBoolean5);
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
    public abstract void onCChangeGroupSettingsReplyMsg(CChangeGroupSettingsReplyMsg paramCChangeGroupSettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeGroupSettingsReplyMsg
 * JD-Core Version:    0.6.2
 */