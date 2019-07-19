package com.viber.jni.im2;

public class CAuthenticateAppReplyMsg
{
  public final short appId;
  public final String authenticateToken;
  public final int sequence;
  public final int status;

  public CAuthenticateAppReplyMsg(String paramString, int paramInt1, int paramInt2, short paramShort)
  {
    this.authenticateToken = Im2Utils.checkStringValue(paramString);
    this.status = paramInt1;
    this.sequence = paramInt2;
    this.appId = paramShort;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCAuthenticateAppReplyMsg(CAuthenticateAppReplyMsg paramCAuthenticateAppReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAuthenticateAppReplyMsg
 * JD-Core Version:    0.6.2
 */