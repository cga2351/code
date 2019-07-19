package com.viber.jni.im2;

public class CGroupSynchedMsg
{
  public final int flags;
  public final long groupID;
  public final Long lastMessageToken;
  public final Integer seqInPG;

  public CGroupSynchedMsg(long paramLong, int paramInt)
  {
    this.groupID = paramLong;
    this.flags = paramInt;
    this.lastMessageToken = null;
    this.seqInPG = null;
    init();
  }

  public CGroupSynchedMsg(long paramLong1, int paramInt, long paramLong2)
  {
    this.groupID = paramLong1;
    this.flags = paramInt;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.seqInPG = null;
    init();
  }

  public CGroupSynchedMsg(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    this.groupID = paramLong1;
    this.flags = paramInt1;
    this.lastMessageToken = Long.valueOf(paramLong2);
    this.seqInPG = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupSynchedMsg(CGroupSynchedMsg paramCGroupSynchedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupSynchedMsg
 * JD-Core Version:    0.6.2
 */