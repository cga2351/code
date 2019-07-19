package com.viber.jni.im2;

public class CUpdateConferenceInd
{
  public final long callToken;
  public final byte[] sdpOffer;

  public CUpdateConferenceInd(long paramLong, byte[] paramArrayOfByte)
  {
    this.callToken = paramLong;
    this.sdpOffer = paramArrayOfByte;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateConferenceInd(CUpdateConferenceInd paramCUpdateConferenceInd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateConferenceInd
 * JD-Core Version:    0.6.2
 */