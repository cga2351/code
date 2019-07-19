package com.viber.jni.im2;

public class CSyncDataFromMyOtherDeviceAckMsg
{
  public final long token;

  public CSyncDataFromMyOtherDeviceAckMsg(long paramLong)
  {
    this.token = paramLong;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSyncDataFromMyOtherDeviceAckMsg{token=" + this.token + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCSyncDataFromMyOtherDeviceAckMsg(CSyncDataFromMyOtherDeviceAckMsg paramCSyncDataFromMyOtherDeviceAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncDataFromMyOtherDeviceAckMsg
 * JD-Core Version:    0.6.2
 */