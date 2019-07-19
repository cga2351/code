package com.viber.jni.im2;

public class CMessagesSynchedAckMsg
{
  public final long[] ackedDeletedTokens;
  public final long[] ackedReadTokens;
  public final byte[] udid;

  public CMessagesSynchedAckMsg(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.ackedReadTokens = ((long[])Im2Utils.checkArrayValue(paramArrayOfLong, [J.class));
    this.ackedDeletedTokens = null;
    init();
  }

  public CMessagesSynchedAckMsg(byte[] paramArrayOfByte, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.ackedReadTokens = ((long[])Im2Utils.checkArrayValue(paramArrayOfLong1, [J.class));
    this.ackedDeletedTokens = ((long[])Im2Utils.checkArrayValue(paramArrayOfLong2, [J.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCMessagesSynchedAckMsg(CMessagesSynchedAckMsg paramCMessagesSynchedAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessagesSynchedAckMsg
 * JD-Core Version:    0.6.2
 */