package com.viber.jni.im2;

public class CSecretChatReceivedEventMsg
{
  public final int eventType;
  public final int flags;
  public final long groupID;
  public final String mid;
  public final int timebombInSec;
  public final long token;

  public CSecretChatReceivedEventMsg(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mid = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong1;
    this.token = paramLong2;
    this.eventType = paramInt1;
    this.timebombInSec = paramInt2;
    this.flags = paramInt3;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSecretChatReceivedEventMsg{mid='" + this.mid + '\'' + ", groupID=" + this.groupID + ", token=" + this.token + ", eventType=" + this.eventType + ", timebombInSec=" + this.timebombInSec + ", flags=" + this.flags + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSecretChatReceivedEventMsg(CSecretChatReceivedEventMsg paramCSecretChatReceivedEventMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSecretChatReceivedEventMsg
 * JD-Core Version:    0.6.2
 */