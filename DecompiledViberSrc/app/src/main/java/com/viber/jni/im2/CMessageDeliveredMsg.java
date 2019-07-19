package com.viber.jni.im2;

public class CMessageDeliveredMsg
{
  public final Integer flags;
  public final String fromCanonizedNumber;
  public final Integer messageSeq;
  public final long messageToken;
  public final Integer seqInPG;
  public final long timeDelivered;

  public CMessageDeliveredMsg(long paramLong1, long paramLong2)
  {
    this.messageToken = paramLong1;
    this.timeDelivered = paramLong2;
    this.messageSeq = null;
    this.flags = null;
    this.fromCanonizedNumber = null;
    this.seqInPG = null;
    init();
  }

  public CMessageDeliveredMsg(long paramLong1, long paramLong2, int paramInt)
  {
    this.messageToken = paramLong1;
    this.timeDelivered = paramLong2;
    this.messageSeq = Integer.valueOf(paramInt);
    this.flags = null;
    this.fromCanonizedNumber = null;
    this.seqInPG = null;
    init();
  }

  public CMessageDeliveredMsg(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.messageToken = paramLong1;
    this.timeDelivered = paramLong2;
    this.messageSeq = Integer.valueOf(paramInt1);
    this.flags = Integer.valueOf(paramInt2);
    this.fromCanonizedNumber = null;
    this.seqInPG = null;
    init();
  }

  public CMessageDeliveredMsg(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    this.messageToken = paramLong1;
    this.timeDelivered = paramLong2;
    this.messageSeq = Integer.valueOf(paramInt1);
    this.flags = Integer.valueOf(paramInt2);
    this.fromCanonizedNumber = Im2Utils.checkStringValue(paramString);
    this.seqInPG = null;
    init();
  }

  public CMessageDeliveredMsg(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.messageToken = paramLong1;
    this.timeDelivered = paramLong2;
    this.messageSeq = Integer.valueOf(paramInt1);
    this.flags = Integer.valueOf(paramInt2);
    this.fromCanonizedNumber = Im2Utils.checkStringValue(paramString);
    this.seqInPG = Integer.valueOf(paramInt3);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCMessageDeliveredMsg(CMessageDeliveredMsg paramCMessageDeliveredMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessageDeliveredMsg
 * JD-Core Version:    0.6.2
 */