package com.viber.jni.im2;

public class CSyncActionOnPGMsg
{
  public final long actionToken;
  public final int clientAction;
  public final long groupID;
  public final long messageToken;
  public final int seqInPG;

  public CSyncActionOnPGMsg(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.clientAction = paramInt2;
    this.actionToken = paramLong3;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSyncActionOnPGMsg(CSyncActionOnPGMsg paramCSyncActionOnPGMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncActionOnPGMsg
 * JD-Core Version:    0.6.2
 */