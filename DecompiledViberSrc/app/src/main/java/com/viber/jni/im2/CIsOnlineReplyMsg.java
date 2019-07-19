package com.viber.jni.im2;

public class CIsOnlineReplyMsg
{
  public final boolean online;
  public final String phoneNumber;

  public CIsOnlineReplyMsg(String paramString, boolean paramBoolean)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString);
    this.online = paramBoolean;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCIsOnlineReplyMsg(CIsOnlineReplyMsg paramCIsOnlineReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CIsOnlineReplyMsg
 * JD-Core Version:    0.6.2
 */