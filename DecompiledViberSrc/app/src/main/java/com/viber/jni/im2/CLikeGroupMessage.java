package com.viber.jni.im2;

public class CLikeGroupMessage
{
  public final boolean action;
  public final long groupId;
  public final String messageSenderPhoneNumber;
  public final long messageToken;
  public final int seq;

  public CLikeGroupMessage(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.messageSenderPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.messageToken = paramLong1;
    this.groupId = paramLong2;
    this.seq = paramInt;
    this.action = paramBoolean;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCLikeGroupMessage(CLikeGroupMessage paramCLikeGroupMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CLikeGroupMessage
 * JD-Core Version:    0.6.2
 */