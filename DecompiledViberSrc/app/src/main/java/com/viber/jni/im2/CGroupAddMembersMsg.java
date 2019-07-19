package com.viber.jni.im2;

public class CGroupAddMembersMsg
{
  public final Integer chatType;
  public final long groupID;
  public final GroupAddMember[] members;
  public final int seq;

  public CGroupAddMembersMsg(long paramLong, int paramInt, GroupAddMember[] paramArrayOfGroupAddMember)
  {
    this.groupID = paramLong;
    this.seq = paramInt;
    this.members = ((GroupAddMember[])Im2Utils.checkArrayValue(paramArrayOfGroupAddMember, [Lcom.viber.jni.im2.GroupAddMember.class));
    this.chatType = null;
    init();
  }

  public CGroupAddMembersMsg(long paramLong, int paramInt1, GroupAddMember[] paramArrayOfGroupAddMember, int paramInt2)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.members = ((GroupAddMember[])Im2Utils.checkArrayValue(paramArrayOfGroupAddMember, [Lcom.viber.jni.im2.GroupAddMember.class));
    this.chatType = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupAddMembersMsg(CGroupAddMembersMsg paramCGroupAddMembersMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAddMembersMsg
 * JD-Core Version:    0.6.2
 */