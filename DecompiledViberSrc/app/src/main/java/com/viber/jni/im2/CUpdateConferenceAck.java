package com.viber.jni.im2;

public class CUpdateConferenceAck
{
  public final long callToken;
  public final byte[] sdpAnswer;

  public CUpdateConferenceAck(long paramLong, byte[] paramArrayOfByte)
  {
    this.callToken = paramLong;
    this.sdpAnswer = paramArrayOfByte;
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateConferenceAck(CUpdateConferenceAck paramCUpdateConferenceAck);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateConferenceAck
 * JD-Core Version:    0.6.2
 */