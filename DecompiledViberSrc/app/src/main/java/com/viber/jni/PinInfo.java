package com.viber.jni;

public class PinInfo
{
  private String MsgInfo;
  private long PinTime;
  private int SeqInPG;
  private long Token;

  public PinInfo()
  {
  }

  public PinInfo(String paramString, long paramLong1, int paramInt, long paramLong2)
  {
    this.MsgInfo = paramString;
    this.Token = paramLong1;
    this.SeqInPG = paramInt;
    this.PinTime = paramLong2;
  }

  public String getMsgInfo()
  {
    return this.MsgInfo;
  }

  public long getPinTime()
  {
    return this.PinTime;
  }

  public int getSeqInPG()
  {
    return this.SeqInPG;
  }

  public long getToken()
  {
    return this.Token;
  }

  public String toString()
  {
    return "PinInfo{MsgInfo='" + this.MsgInfo + '\'' + ", Token=" + this.Token + ", SeqInPG=" + this.SeqInPG + ", PinTime=" + this.PinTime + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PinInfo
 * JD-Core Version:    0.6.2
 */