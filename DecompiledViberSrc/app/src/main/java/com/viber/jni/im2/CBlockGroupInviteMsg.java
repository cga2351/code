package com.viber.jni.im2;

public class CBlockGroupInviteMsg
{
  public final boolean block;
  public final long groupID;
  public final int seq;

  public CBlockGroupInviteMsg(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.groupID = paramLong;
    this.seq = paramInt;
    this.block = paramBoolean;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCBlockGroupInviteMsg(CBlockGroupInviteMsg paramCBlockGroupInviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBlockGroupInviteMsg
 * JD-Core Version:    0.6.2
 */