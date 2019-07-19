package com.viber.jni.im2;

public class CGroupSynchedAckMsg
{
  public final Integer flags;
  public final long groupID;
  public final Long lastMessageToken;
  public final byte[] udid;

  public CGroupSynchedAckMsg(byte[] paramArrayOfByte, long paramLong)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.groupID = paramLong;
    this.lastMessageToken = null;
    this.flags = null;
    init();
  }

  public CGroupSynchedAckMsg(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.groupID = paramLong1;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.flags = null;
    init();
  }

  public CGroupSynchedAckMsg(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.groupID = paramLong1;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.flags = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupSynchedAckMsg(CGroupSynchedAckMsg paramCGroupSynchedAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupSynchedAckMsg
 * JD-Core Version:    0.6.2
 */