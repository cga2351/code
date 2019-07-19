package com.viber.jni.im2;

public class CSendUserIsTypingMsg
{
  public final Boolean active;
  public final Integer chatType;
  public final Integer deviceID;
  public final String fromNumber;

  public CSendUserIsTypingMsg(String paramString)
  {
    this.fromNumber = Im2Utils.checkStringValue(paramString);
    this.active = null;
    this.deviceID = null;
    this.chatType = null;
    init();
  }

  public CSendUserIsTypingMsg(String paramString, boolean paramBoolean)
  {
    this.fromNumber = Im2Utils.checkStringValue(paramString);
    this.active = Boolean.valueOf(paramBoolean);
    this.deviceID = null;
    this.chatType = null;
    init();
  }

  public CSendUserIsTypingMsg(String paramString, boolean paramBoolean, int paramInt)
  {
    this.fromNumber = Im2Utils.checkStringValue(paramString);
    this.active = Boolean.valueOf(paramBoolean);
    this.deviceID = Integer.valueOf(paramInt);
    this.chatType = null;
    init();
  }

  public CSendUserIsTypingMsg(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.fromNumber = Im2Utils.checkStringValue(paramString);
    this.active = Boolean.valueOf(paramBoolean);
    this.deviceID = Integer.valueOf(paramInt1);
    this.chatType = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  public boolean isSecondaryDevice()
  {
    return Im2Utils.isSecondaryDevice(this.deviceID.intValue());
  }

  public String toString()
  {
    return "CSendUserIsTypingMsg{fromNumber='" + this.fromNumber + '\'' + ", active=" + this.active + ", deviceID=" + this.deviceID + ", chatType=" + this.chatType + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendUserIsTypingMsg(CSendUserIsTypingMsg paramCSendUserIsTypingMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendUserIsTypingMsg
 * JD-Core Version:    0.6.2
 */