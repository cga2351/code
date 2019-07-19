package com.viber.jni.im2;

public class CGroupAddMemberMsg
{
  public final Integer chatType;
  public final String clientPhone;
  public final long groupID;

  public CGroupAddMemberMsg(long paramLong, String paramString)
  {
    this.groupID = paramLong;
    this.clientPhone = Im2Utils.checkStringValue(paramString);
    this.chatType = null;
    init();
  }

  public CGroupAddMemberMsg(long paramLong, String paramString, int paramInt)
  {
    this.groupID = paramLong;
    this.clientPhone = Im2Utils.checkStringValue(paramString);
    this.chatType = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupAddMemberMsg(CGroupAddMemberMsg paramCGroupAddMemberMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAddMemberMsg
 * JD-Core Version:    0.6.2
 */