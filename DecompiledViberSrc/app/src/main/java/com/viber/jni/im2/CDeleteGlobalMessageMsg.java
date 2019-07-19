package com.viber.jni.im2;

public class CDeleteGlobalMessageMsg
{
  public final long groupID;
  public final long messageToken;
  public final int seq;
  public final int seqInPG;

  public CDeleteGlobalMessageMsg(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    this.seq = paramInt1;
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.seqInPG = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCDeleteGlobalMessageMsg(CDeleteGlobalMessageMsg paramCDeleteGlobalMessageMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeleteGlobalMessageMsg
 * JD-Core Version:    0.6.2
 */