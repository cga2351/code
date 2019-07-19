package com.viber.jni.im2;

public class CDeleteAllUserMessagesMsg
{
  public final long groupID;
  public final int seq;
  public final String user;

  public CDeleteAllUserMessagesMsg(int paramInt, long paramLong, String paramString)
  {
    this.seq = paramInt;
    this.groupID = paramLong;
    this.user = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CDeleteAllUserMessagesMsg{seq=" + this.seq + ", groupID=" + this.groupID + ", user='" + this.user + '\'' + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCDeleteAllUserMessagesMsg(CDeleteAllUserMessagesMsg paramCDeleteAllUserMessagesMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CDeleteAllUserMessagesMsg
 * JD-Core Version:    0.6.2
 */