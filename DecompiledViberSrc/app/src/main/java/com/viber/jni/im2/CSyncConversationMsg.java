package com.viber.jni.im2;

public class CSyncConversationMsg
{
  public final Integer chatType;
  public final int flags;
  public final long lastMessageToken;
  public final String peerNumber;

  public CSyncConversationMsg(String paramString, long paramLong, int paramInt)
  {
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = paramInt;
    this.chatType = null;
    init();
  }

  public CSyncConversationMsg(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = paramInt1;
    this.chatType = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSyncConversationMsg(CSyncConversationMsg paramCSyncConversationMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncConversationMsg
 * JD-Core Version:    0.6.2
 */