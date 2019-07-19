package com.viber.jni.im2;

public class CGroupRemoveMembersMsg
{
  public final long groupID;
  public final String[] members;
  public final int seq;

  public CGroupRemoveMembersMsg(long paramLong, int paramInt, String[] paramArrayOfString)
  {
    this.groupID = paramLong;
    this.seq = paramInt;
    this.members = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupRemoveMembersMsg(CGroupRemoveMembersMsg paramCGroupRemoveMembersMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupRemoveMembersMsg
 * JD-Core Version:    0.6.2
 */