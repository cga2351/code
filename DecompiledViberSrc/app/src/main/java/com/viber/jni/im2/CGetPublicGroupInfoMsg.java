package com.viber.jni.im2;

public class CGetPublicGroupInfoMsg
{
  public final long groupID;
  public final Integer seq;

  public CGetPublicGroupInfoMsg(long paramLong)
  {
    this.groupID = paramLong;
    this.seq = null;
    init();
  }

  public CGetPublicGroupInfoMsg(long paramLong, int paramInt)
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
    public abstract void handleCGetPublicGroupInfoMsg(CGetPublicGroupInfoMsg paramCGetPublicGroupInfoMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPublicGroupInfoMsg
 * JD-Core Version:    0.6.2
 */