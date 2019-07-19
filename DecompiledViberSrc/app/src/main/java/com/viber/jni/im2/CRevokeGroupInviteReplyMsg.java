package com.viber.jni.im2;

public class CRevokeGroupInviteReplyMsg
{
  public final long groupID;
  public final int seq;
  public final int status;

  public CRevokeGroupInviteReplyMsg(int paramInt1, long paramLong, int paramInt2)
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
    return "CRevokeGroupInviteReplyMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", status=" + this.status + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCRevokeGroupInviteReplyMsg(CRevokeGroupInviteReplyMsg paramCRevokeGroupInviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRevokeGroupInviteReplyMsg
 * JD-Core Version:    0.6.2
 */