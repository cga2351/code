package com.viber.jni.im2;

public class CAcceptGroupInviteMsg
{
  public final String invitationString;
  public final int seq;

  public CAcceptGroupInviteMsg(String paramString, int paramInt)
  {
    this.invitationString = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CAcceptGroupInviteMsg{invitationString='" + this.invitationString + '\'' + ", seq=" + this.seq + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCAcceptGroupInviteMsg(CAcceptGroupInviteMsg paramCAcceptGroupInviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CAcceptGroupInviteMsg
 * JD-Core Version:    0.6.2
 */