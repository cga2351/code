package com.viber.jni.im2;

public class CUpdateCommunitySettingsMsg
{
  public final int displayInvitationLink;
  public final long groupId;
  public final int seq;

  public CUpdateCommunitySettingsMsg(int paramInt1, long paramLong, int paramInt2)
  {
    this.seq = paramInt1;
    this.groupId = paramLong;
    this.displayInvitationLink = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateCommunitySettingsMsg(CUpdateCommunitySettingsMsg paramCUpdateCommunitySettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateCommunitySettingsMsg
 * JD-Core Version:    0.6.2
 */