package com.viber.jni.im2;

public class CConferenceMemberStatusInd
{
  public final long callToken;
  public final int cid;
  public final String mid;
  public final int status;

  public CConferenceMemberStatusInd(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    this.callToken = paramLong;
    this.mid = paramString;
    this.cid = paramInt1;
    this.status = paramInt2;
  }

  public String toString()
  {
    return "CConferenceMemberStatusInd{callToken=" + this.callToken + ", mid='" + this.mid + '\'' + ", cid=" + this.cid + ", status=" + this.status + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCConferenceMemberStatusInd(CConferenceMemberStatusInd paramCConferenceMemberStatusInd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CConferenceMemberStatusInd
 * JD-Core Version:    0.6.2
 */