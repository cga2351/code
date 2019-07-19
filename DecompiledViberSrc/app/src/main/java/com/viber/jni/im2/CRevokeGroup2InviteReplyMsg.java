package com.viber.jni.im2;

public class CRevokeGroup2InviteReplyMsg
{
  public final long groupID;
  public final int seq;
  public final int status;

  public CRevokeGroup2InviteReplyMsg(int paramInt1, long paramLong, int paramInt2)
  {
    this.seq = paramInt1;
    this.groupID = paramLong;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CRevokeGroup2InviteReplyMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", status=" + this.status + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRevokeGroup2InviteReplyMsg(CRevokeGroup2InviteReplyMsg paramCRevokeGroup2InviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRevokeGroup2InviteReplyMsg
 * JD-Core Version:    0.6.2
 */