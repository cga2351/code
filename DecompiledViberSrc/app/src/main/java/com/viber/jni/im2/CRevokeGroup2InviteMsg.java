package com.viber.jni.im2;

public class CRevokeGroup2InviteMsg
{
  public final long groupID;
  public final int seq;

  public CRevokeGroup2InviteMsg(int paramInt, long paramLong)
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
    return "CRevokeGroup2InviteMsg{seq=" + this.seq + ", groupID=" + this.groupID + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCRevokeGroup2InviteMsg(CRevokeGroup2InviteMsg paramCRevokeGroup2InviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRevokeGroup2InviteMsg
 * JD-Core Version:    0.6.2
 */