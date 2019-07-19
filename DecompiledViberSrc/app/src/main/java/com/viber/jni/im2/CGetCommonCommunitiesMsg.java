package com.viber.jni.im2;

public class CGetCommonCommunitiesMsg
{
  public final String peerEMID;
  public final int seq;

  public CGetCommonCommunitiesMsg(int paramInt, String paramString)
  {
    this.seq = paramInt;
    this.peerEMID = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetCommonCommunitiesMsg{seq=" + this.seq + ", peerEMID='" + this.peerEMID + '\'' + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetCommonCommunitiesMsg(CGetCommonCommunitiesMsg paramCGetCommonCommunitiesMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetCommonCommunitiesMsg
 * JD-Core Version:    0.6.2
 */