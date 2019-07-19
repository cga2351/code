package com.viber.jni.im2;

public class CGetInviteLinksMsg
{
  public final long groupID;
  public final String[] memberIDs;
  public final int seq;

  public CGetInviteLinksMsg(int paramInt, long paramLong, String[] paramArrayOfString)
  {
    this.seq = paramInt;
    this.groupID = paramLong;
    this.memberIDs = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetInviteLinksMsg(CGetInviteLinksMsg paramCGetInviteLinksMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetInviteLinksMsg
 * JD-Core Version:    0.6.2
 */