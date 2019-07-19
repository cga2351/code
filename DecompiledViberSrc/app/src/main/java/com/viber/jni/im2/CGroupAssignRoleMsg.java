package com.viber.jni.im2;

public class CGroupAssignRoleMsg
{
  public final long groupID;
  public final String[] members;
  public final int role;
  public final int seq;

  public CGroupAssignRoleMsg(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.members = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.role = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupAssignRoleMsg(CGroupAssignRoleMsg paramCGroupAssignRoleMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAssignRoleMsg
 * JD-Core Version:    0.6.2
 */