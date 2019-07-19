package com.viber.jni.im2;

public class CUserIsTypingMsg
{
  public final Boolean active;
  public final Integer chatType;
  public final String toNumber;

  public CUserIsTypingMsg(String paramString)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString);
    this.active = null;
    this.chatType = null;
    init();
  }

  public CUserIsTypingMsg(String paramString, boolean paramBoolean)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString);
    this.active = Boolean.valueOf(paramBoolean);
    this.chatType = null;
    init();
  }

  public CUserIsTypingMsg(String paramString, boolean paramBoolean, int paramInt)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString);
    this.active = Boolean.valueOf(paramBoolean);
    this.chatType = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUserIsTypingMsg(CUserIsTypingMsg paramCUserIsTypingMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUserIsTypingMsg
 * JD-Core Version:    0.6.2
 */