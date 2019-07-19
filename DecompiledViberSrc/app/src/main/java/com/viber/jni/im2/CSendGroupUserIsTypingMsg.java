package com.viber.jni.im2;

public class CSendGroupUserIsTypingMsg
{
  public final boolean active;
  public final Short deviceID;
  public final String fromNumber;
  public final long groupID;

  public CSendGroupUserIsTypingMsg(long paramLong, String paramString, boolean paramBoolean)
  {
    this.groupID = paramLong;
    this.fromNumber = Im2Utils.checkStringValue(paramString);
    this.active = paramBoolean;
    this.deviceID = null;
    init();
  }

  public CSendGroupUserIsTypingMsg(long paramLong, String paramString, boolean paramBoolean, short paramShort)
  {
    this.groupID = paramLong;
    this.fromNumber = Im2Utils.checkStringValue(paramString);
    this.active = paramBoolean;
    this.deviceID = Short.valueOf(paramShort);
    init();
  }

  private void init()
  {
  }

  public boolean isSecondaryDevice()
  {
    return Im2Utils.isSecondaryDevice(this.deviceID.shortValue());
  }

  public String toString()
  {
    return "CSendGroupUserIsTypingMsg{groupID=" + this.groupID + ", fromNumber='" + this.fromNumber + '\'' + ", active=" + this.active + ", deviceID=" + this.deviceID + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendGroupUserIsTypingMsg(CSendGroupUserIsTypingMsg paramCSendGroupUserIsTypingMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendGroupUserIsTypingMsg
 * JD-Core Version:    0.6.2
 */