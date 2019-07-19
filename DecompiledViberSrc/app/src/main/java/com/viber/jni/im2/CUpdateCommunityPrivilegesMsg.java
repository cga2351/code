package com.viber.jni.im2;

public class CUpdateCommunityPrivilegesMsg
{
  public final long globalPrivileges;
  public final long groupID;
  public final int seq;

  public CUpdateCommunityPrivilegesMsg(int paramInt, long paramLong1, long paramLong2)
  {
    this.seq = paramInt;
    this.groupID = paramLong1;
    this.globalPrivileges = paramLong2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateCommunityPrivilegesMsg(CUpdateCommunityPrivilegesMsg paramCUpdateCommunityPrivilegesMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateCommunityPrivilegesMsg
 * JD-Core Version:    0.6.2
 */