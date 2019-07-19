package com.viber.jni.im2;

public class CContactSavedInConversationNotificationMsg
{
  public final String savedPhone;
  public final int seq;

  public CContactSavedInConversationNotificationMsg(String paramString, int paramInt)
  {
    this.savedPhone = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCContactSavedInConversationNotificationMsg(CContactSavedInConversationNotificationMsg paramCContactSavedInConversationNotificationMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CContactSavedInConversationNotificationMsg
 * JD-Core Version:    0.6.2
 */