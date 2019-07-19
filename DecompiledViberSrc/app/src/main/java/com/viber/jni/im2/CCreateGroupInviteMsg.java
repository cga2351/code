package com.viber.jni.im2;

public class CCreateGroupInviteMsg
{
  public final long groupID;
  public final String groupName;
  public final int seq;

  public CCreateGroupInviteMsg(int paramInt, long paramLong, String paramString)
  {
    this.seq = paramInt;
    this.groupID = paramLong;
    this.groupName = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CCreateGroupInviteMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", groupName='" + this.groupName + '\'' + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCCreateGroupInviteMsg(CCreateGroupInviteMsg paramCCreateGroupInviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateGroupInviteMsg
 * JD-Core Version:    0.6.2
 */