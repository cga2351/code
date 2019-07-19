package com.viber.jni.im2;

public class CUpdateMyCommunitySettingsMsg
{
  public final long groupId;
  public final int seq;
  public final String settings;

  public CUpdateMyCommunitySettingsMsg(int paramInt, long paramLong, String paramString)
  {
    this.seq = paramInt;
    this.groupId = paramLong;
    this.settings = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CUpdateMyCommunitySettingsMsg{seq=" + this.seq + ", groupId=" + this.groupId + ", settings='" + this.settings + '\'' + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateMyCommunitySettingsMsg(CUpdateMyCommunitySettingsMsg paramCUpdateMyCommunitySettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateMyCommunitySettingsMsg
 * JD-Core Version:    0.6.2
 */