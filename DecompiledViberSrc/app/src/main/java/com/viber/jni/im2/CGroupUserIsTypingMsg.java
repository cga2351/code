package com.viber.jni.im2;

public class CGroupUserIsTypingMsg
{
  public final boolean active;
  public final long groupID;

  public CGroupUserIsTypingMsg(long paramLong, boolean paramBoolean)
  {
    this.groupID = paramLong;
    this.active = paramBoolean;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupUserIsTypingMsg(CGroupUserIsTypingMsg paramCGroupUserIsTypingMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupUserIsTypingMsg
 * JD-Core Version:    0.6.2
 */