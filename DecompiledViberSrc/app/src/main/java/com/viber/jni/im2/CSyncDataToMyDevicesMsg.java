package com.viber.jni.im2;

import java.util.Arrays;

public class CSyncDataToMyDevicesMsg
{
  public final byte[] encryptedData;
  public final Long objectID;
  public final int opCode;
  public final int seq;
  public final long syncFlags;

  public CSyncDataToMyDevicesMsg(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    this.encryptedData = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.opCode = paramInt1;
    this.syncFlags = paramLong;
    this.seq = paramInt2;
    this.objectID = null;
    init();
  }

  public CSyncDataToMyDevicesMsg(byte[] paramArrayOfByte, int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.encryptedData = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.opCode = paramInt1;
    this.syncFlags = paramLong1;
    this.seq = paramInt2;
    this.objectID = Long.valueOf(paramLong2);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSyncDataToMyDevicesMsg{encryptedData=" + Arrays.toString(this.encryptedData) + ", opCode=" + this.opCode + ", syncFlags=" + this.syncFlags + ", seq=" + this.seq + ", objectID=" + this.objectID + '}';
  }

  public static abstract interface Sender
  {
    public abstract void handleCSyncDataToMyDevicesMsg(CSyncDataToMyDevicesMsg paramCSyncDataToMyDevicesMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncDataToMyDevicesMsg
 * JD-Core Version:    0.6.2
 */