package com.viber.jni.im2;

public class CCreateGroup2InviteMsg
{
  public final long groupID;
  public final int seq;

  public CCreateGroup2InviteMsg(int paramInt, long paramLong)
  {
    this.seq = paramInt;
    this.groupID = paramLong;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCreateGroup2InviteMsg{seq=" + this.seq + ", groupID=" + this.groupID + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCCreateGroup2InviteMsg(CCreateGroup2InviteMsg paramCCreateGroup2InviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateGroup2InviteMsg
 * JD-Core Version:    0.6.2
 */