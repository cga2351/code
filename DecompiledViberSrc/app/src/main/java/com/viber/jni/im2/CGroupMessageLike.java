package com.viber.jni.im2;

public class CGroupMessageLike
{
  public final boolean action;
  public final int flags;
  public final long groupId;
  public final String likeSenderPhoneNumber;
  public final long likeToken;
  public final long messageToken;
  public final long timeSent;

  public CGroupMessageLike(long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt, boolean paramBoolean, long paramLong4)
  {
    this.groupId = paramLong1;
    this.likeToken = paramLong2;
    this.messageToken = paramLong3;
    this.likeSenderPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.flags = paramInt;
    this.action = paramBoolean;
    this.timeSent = paramLong4;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGroupMessageLike(CGroupMessageLike paramCGroupMessageLike);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupMessageLike
 * JD-Core Version:    0.6.2
 */