package com.viber.jni.im2;

public class CCreateGroupInviteReplyMsg
{
  public final long groupID;
  public final String inviteLinkData;
  public final int seq;
  public final int status;

  public CCreateGroupInviteReplyMsg(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.groupID = paramLong;
    this.status = paramInt2;
    this.inviteLinkData = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCreateGroupInviteReplyMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", status=" + this.status + ", inviteLinkData='" + this.inviteLinkData + '\'' + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCCreateGroupInviteReplyMsg(CCreateGroupInviteReplyMsg paramCCreateGroupInviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateGroupInviteReplyMsg
 * JD-Core Version:    0.6.2
 */