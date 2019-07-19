package com.viber.jni.im2;

public class CConversationSynchedMsg
{
  public final Integer chatType;
  public final Short deviceID;
  public final int flags;
  public final long lastMessageToken;
  public final String peerNumber;
  public final Long timeSent;
  public final byte[] udid;

  public CConversationSynchedMsg(byte[] paramArrayOfByte, String paramString, long paramLong, int paramInt)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = paramInt;
    this.deviceID = null;
    this.chatType = null;
    this.timeSent = null;
    init();
  }

  public CConversationSynchedMsg(byte[] paramArrayOfByte, String paramString, long paramLong, int paramInt, short paramShort)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = paramInt;
    this.deviceID = Short.valueOf(paramShort);
    this.chatType = null;
    this.timeSent = null;
    init();
  }

  public CConversationSynchedMsg(byte[] paramArrayOfByte, String paramString, long paramLong, int paramInt1, short paramShort, int paramInt2)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.flags = paramInt1;
    this.deviceID = Short.valueOf(paramShort);
    this.chatType = Integer.valueOf(paramInt2);
    this.timeSent = null;
    init();
  }

  public CConversationSynchedMsg(byte[] paramArrayOfByte, String paramString, long paramLong1, int paramInt1, short paramShort, int paramInt2, long paramLong2)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong1;
    this.flags = paramInt1;
    this.deviceID = Short.valueOf(paramShort);
    this.chatType = Integer.valueOf(paramInt2);
    this.timeSent = Long.valueOf(paramLong2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCConversationSynchedMsg(CConversationSynchedMsg paramCConversationSynchedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CConversationSynchedMsg
 * JD-Core Version:    0.6.2
 */