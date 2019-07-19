package com.viber.jni.im2;

public class CCheckGroup2InviteMsg
{
  public final String invitationString;
  public final int seq;

  public CCheckGroup2InviteMsg(String paramString, int paramInt)
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
    return "CCheckGroup2InviteMsg{invitationString='" + this.invitationString + '\'' + ", seq=" + this.seq + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCCheckGroup2InviteMsg(CCheckGroup2InviteMsg paramCCheckGroup2InviteMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCheckGroup2InviteMsg
 * JD-Core Version:    0.6.2
 */