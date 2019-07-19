package com.viber.jni.im2;

public class CConversationSynchedAckMsg
{
  public final Integer flags;
  public final long lastMessageToken;
  public final String peerNumber;

  public CConversationSynchedAckMsg(String paramString, long paramLong)
  {
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = null;
    init();
  }

  public CConversationSynchedAckMsg(String paramString, long paramLong, int paramInt)
  {
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCConversationSynchedAckMsg(CConversationSynchedAckMsg paramCConversationSynchedAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CConversationSynchedAckMsg
 * JD-Core Version:    0.6.2
 */