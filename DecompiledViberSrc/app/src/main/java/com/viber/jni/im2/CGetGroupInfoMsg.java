package com.viber.jni.im2;

public class CGetGroupInfoMsg
{
  public final long groupID;
  public final Integer seq;

  public CGetGroupInfoMsg(long paramLong)
  {
    this.groupID = paramLong;
    this.seq = null;
    init();
  }

  public CGetGroupInfoMsg(long paramLong, int paramInt)
  {
    this.groupID = paramLong;
    this.seq = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetGroupInfoMsg(CGetGroupInfoMsg paramCGetGroupInfoMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetGroupInfoMsg
 * JD-Core Version:    0.6.2
 */