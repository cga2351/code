package com.viber.jni.im2;

import java.util.Arrays;

public class CSyncDataFromMyOtherDeviceMsg
{
  public final String downloadID;
  public final byte[] encryptedData;
  public final int fromCID;
  public final int opCode;
  public final long syncFlags;
  public final long token;

  public CSyncDataFromMyOtherDeviceMsg(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.encryptedData = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.fromCID = paramInt1;
    this.opCode = paramInt2;
    this.token = paramLong1;
    this.syncFlags = paramLong2;
    this.downloadID = null;
    init();
  }

  public CSyncDataFromMyOtherDeviceMsg(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    this.encryptedData = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.fromCID = paramInt1;
    this.opCode = paramInt2;
    this.token = paramLong1;
    this.syncFlags = paramLong2;
    this.downloadID = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSyncDataFromMyOtherDeviceMsg{encryptedData=" + Arrays.toString(this.encryptedData) + ", fromCID=" + this.fromCID + ", opCode=" + this.opCode + ", token=" + this.token + ", syncFlags=" + this.syncFlags + ", downloadID='" + this.downloadID + '\'' + '}';
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSyncDataFromMyOtherDeviceMsg(CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncDataFromMyOtherDeviceMsg
 * JD-Core Version:    0.6.2
 */