package com.viber.jni;

public class CallStatistics
{
  private boolean answered;
  private final String audioCodec;
  private final int avgQualityScore;
  private final int avgRTT;
  private final long callDuration;
  private boolean callStarted;
  private final long callToken;
  private final int handoverCount;
  private final String hsIPAddr;
  private final String localIpAddr;
  private final int maxParticipants;
  private final int maxQualityScore;
  private final int maxRTT;
  private final int minHsRTT;
  private final int minQualityScore;
  private final int minRTT;
  private final int netowrkType;

  public CallStatistics(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt9, String paramString3, boolean paramBoolean2, int paramInt10)
  {
    this.localIpAddr = paramString1;
    this.hsIPAddr = paramString2;
    this.minHsRTT = paramInt1;
    this.minRTT = paramInt2;
    this.maxRTT = paramInt3;
    this.avgRTT = paramInt4;
    this.minQualityScore = paramInt5;
    this.maxQualityScore = paramInt6;
    this.avgQualityScore = paramInt7;
    this.maxParticipants = paramInt8;
    this.callStarted = paramBoolean1;
    this.callToken = paramLong1;
    this.callDuration = paramLong2;
    this.handoverCount = paramInt9;
    this.audioCodec = paramString3;
    this.answered = paramBoolean2;
    this.netowrkType = paramInt10;
  }

  public String toString()
  {
    return "CallStatistics: [ localIpAddr: " + this.localIpAddr + " hsIPAddr: " + this.hsIPAddr + " minHsRTT: " + this.minHsRTT + " minRTT: " + this.minRTT + " maxRTT: " + this.maxRTT + " avgRTT: " + this.avgRTT + " minQualityScore: " + this.minQualityScore + " maxQualityScore: " + this.maxQualityScore + " avgQualityScore: " + this.avgQualityScore + " maxParticipants: " + this.maxParticipants + " maxParticipants: " + this.maxParticipants + " callStarted: " + this.callStarted + " callToken: " + this.callToken + " callDuration: " + this.callDuration + " handoverCount: " + this.handoverCount + " audioCodec: " + this.audioCodec + " answered: " + this.answered + " netowrkType: " + this.netowrkType + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CallStatistics
 * JD-Core Version:    0.6.2
 */