package com.viber.jni.im2;

public class CCreateGroup2InviteReplyMsg
{
  public final long groupID;
  public final String inviteLink;
  public final int seq;
  public final int status;

  public CCreateGroup2InviteReplyMsg(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.groupID = paramLong;
    this.status = paramInt2;
    this.inviteLink = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCreateGroup2InviteReplyMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", status=" + this.status + ", inviteLink='" + this.inviteLink + '\'' + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCCreateGroup2InviteReplyMsg(CCreateGroup2InviteReplyMsg paramCCreateGroup2InviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateGroup2InviteReplyMsg
 * JD-Core Version:    0.6.2
 */