package com.viber.jni.im2;

public class CRevokeGroupInviteMsg
{
  public final long groupID;
  public final int seq;

  public CRevokeGroupInviteMsg(int paramInt, long paramLong)
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
    return "CRevokeGroupInviteMsg{seq=" + this.seq + ", groupID=" + this.groupID + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCRevokeGroupInviteMsg(CRevokeGroupInviteMsg paramCRevokeGroupInviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRevokeGroupInviteMsg
 * JD-Core Version:    0.6.2
 */