package com.viber.jni.im2;

public class CAuthenticateAppMsg
{
  public final short appId;
  public final String identifier;
  public final short permissions;
  public final Boolean replyToServer;
  public final int sequence;

  public CAuthenticateAppMsg(short paramShort1, short paramShort2, int paramInt, String paramString)
  {
    this.appId = paramShort1;
    this.permissions = paramShort2;
    this.sequence = paramInt;
    this.identifier = Im2Utils.checkStringValue(paramString);
    this.replyToServer = null;
    init();
  }

  public CAuthenticateAppMsg(short paramShort1, short paramShort2, int paramInt, String paramString, boolean paramBoolean)
  {
    this.appId = paramShort1;
    this.permissions = paramShort2;
    this.sequence = paramInt;
    this.identifier = Im2Utils.checkStringValue(paramString);
    this.replyToServer = Boolean.valueOf(paramBoolean);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCAuthenticateAppMsg(CAuthenticateAppMsg paramCAuthenticateAppMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAuthenticateAppMsg
 * JD-Core Version:    0.6.2
 */