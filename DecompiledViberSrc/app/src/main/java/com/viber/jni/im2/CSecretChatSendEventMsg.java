package com.viber.jni.im2;

public class CSecretChatSendEventMsg
{
  public final int eventType;
  public final long groupID;
  public final String mid;
  public final int seq;
  public final int timebombInSec;

  public CSecretChatSendEventMsg(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.mid = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong;
    this.eventType = paramInt2;
    this.timebombInSec = paramInt3;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSecretChatSendEventMsg{seq=" + this.seq + ", mid='" + this.mid + '\'' + ", groupID=" + this.groupID + ", eventType=" + this.eventType + ", timebombInSec=" + this.timebombInSec + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCSecretChatSendEventMsg(CSecretChatSendEventMsg paramCSecretChatSendEventMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSecretChatSendEventMsg
 * JD-Core Version:    0.6.2
 */