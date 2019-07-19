package com.viber.jni.im2;

public class CInviteToConferenceMsg
{
  public final String attachment;
  public final long callToken;
  public final String[] memberIDs;
  public final int seq;

  public CInviteToConferenceMsg(long paramLong, String[] paramArrayOfString, String paramString, int paramInt)
  {
    this.callToken = paramLong;
    this.memberIDs = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.attachment = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCInviteToConferenceMsg(CInviteToConferenceMsg paramCInviteToConferenceMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CInviteToConferenceMsg
 * JD-Core Version:    0.6.2
 */