package com.viber.jni.im2;

public class CGetGroupMessageStatusMsg
{
  public final long groupId;
  public final CGroupMessageDataWithSender[] messagesWS;
  public final int seq;

  public CGetGroupMessageStatusMsg(int paramInt, long paramLong, CGroupMessageDataWithSender[] paramArrayOfCGroupMessageDataWithSender)
  {
    this.seq = paramInt;
    this.groupId = paramLong;
    this.messagesWS = ((CGroupMessageDataWithSender[])Im2Utils.checkArrayValue(paramArrayOfCGroupMessageDataWithSender, [Lcom.viber.jni.im2.CGroupMessageDataWithSender.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetGroupMessageStatusMsg(CGetGroupMessageStatusMsg paramCGetGroupMessageStatusMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetGroupMessageStatusMsg
 * JD-Core Version:    0.6.2
 */