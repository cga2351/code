package com.viber.jni.im2;

public class CGetMyCommunitySettingsMsg
{
  public final int seq;

  public CGetMyCommunitySettingsMsg(int paramInt)
  {
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetMyCommunitySettingsMsg{seq=" + this.seq + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetMyCommunitySettingsMsg(CGetMyCommunitySettingsMsg paramCGetMyCommunitySettingsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetMyCommunitySettingsMsg
 * JD-Core Version:    0.6.2
 */