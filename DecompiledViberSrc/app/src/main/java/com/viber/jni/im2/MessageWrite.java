package com.viber.jni.im2;

import java.util.Set;

public class MessageWrite
{
  private long mPtr = 0L;

  MessageWrite(int paramInt)
  {
    this.mPtr = Im2MessageNative.createMessageWrite(paramInt);
  }

  MessageWrite(String paramString)
  {
    this.mPtr = Im2MessageNative.createMessageWrite(paramString);
  }

  public void destroy()
  {
    if (this.mPtr != 0L)
    {
      Im2MessageNative.destroyMessageWrite(this.mPtr);
      this.mPtr = 0L;
    }
  }

  protected void finalize()
  {
    destroy();
  }

  long getHandle()
  {
    return this.mPtr;
  }

  public boolean isValid()
  {
    return Im2MessageNative.isValid(this.mPtr);
  }

  public void setBoolean(String paramString, boolean paramBoolean)
  {
    Im2MessageNative.setBoolean(this.mPtr, paramString, paramBoolean);
  }

  public void setMapNumberToMessage(String paramString, int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Im2MessageNative.setMapNumberToMessage(this.mPtr, paramString, paramInt, paramArrayOfLong1, paramArrayOfLong2);
  }

  public void setMapNumberToNumber(String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Im2MessageNative.setMapNumberToNumber(this.mPtr, paramString, paramInt1, paramInt2, paramArrayOfLong1, paramArrayOfLong2);
  }

  public void setMapNumberToString(String paramString, int paramInt, long[] paramArrayOfLong, String[] paramArrayOfString)
  {
    Im2MessageNative.setMapNumberToString(this.mPtr, paramString, paramInt, paramArrayOfLong, paramArrayOfString);
  }

  public void setMapStringToMessage(String paramString, String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    Im2MessageNative.setMapStringToMessage(this.mPtr, paramString, paramArrayOfString, paramArrayOfLong);
  }

  public void setMapStringToNumber(String paramString, int paramInt, String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    Im2MessageNative.setMapStringToNumber(this.mPtr, paramString, paramInt, paramArrayOfString, paramArrayOfLong);
  }

  public void setMapStringToString(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Im2MessageNative.setMapStringToString(this.mPtr, paramString, paramArrayOfString1, paramArrayOfString2);
  }

  public void setMessage(String paramString, MessageWrite paramMessageWrite)
  {
    Im2MessageNative.setMessage(this.mPtr, paramString, paramMessageWrite.getHandle());
  }

  public void setMessageArray(String paramString, MessageWrite[] paramArrayOfMessageWrite)
  {
    long[] arrayOfLong = new long[paramArrayOfMessageWrite.length];
    for (int i = 0; i < paramArrayOfMessageWrite.length; i++)
      arrayOfLong[i] = paramArrayOfMessageWrite[i].getHandle();
    Im2MessageNative.setMessageArray(this.mPtr, paramString, arrayOfLong);
  }

  public void setS16(String paramString, short paramShort)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 5, paramShort);
  }

  public void setS16Array(String paramString, short[] paramArrayOfShort)
  {
    Im2MessageNative.setShortArray(this.mPtr, paramString, paramArrayOfShort);
  }

  public void setS32(String paramString, int paramInt)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 6, paramInt);
  }

  public void setS32Array(String paramString, int[] paramArrayOfInt)
  {
    Im2MessageNative.setIntArray(this.mPtr, paramString, paramArrayOfInt);
  }

  public void setS64(String paramString, long paramLong)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 7, paramLong);
  }

  public void setS64Array(String paramString, long[] paramArrayOfLong)
  {
    Im2MessageNative.setLongArray(this.mPtr, paramString, paramArrayOfLong);
  }

  public void setS8(String paramString, byte paramByte)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 4, paramByte);
  }

  public void setS8Array(String paramString, byte[] paramArrayOfByte)
  {
    Im2MessageNative.setByteArray(this.mPtr, paramString, paramArrayOfByte);
  }

  public void setString(String paramString1, String paramString2)
  {
    Im2MessageNative.setString(this.mPtr, paramString1, paramString2);
  }

  public void setStringArray(String paramString, String[] paramArrayOfString)
  {
    Im2MessageNative.setStringArray(this.mPtr, paramString, paramArrayOfString);
  }

  public void setStringSet(String paramString, Set<String> paramSet)
  {
    String[] arrayOfString = (String[])paramSet.toArray(new String[0]);
    Im2MessageNative.setStringSet(this.mPtr, paramString, arrayOfString);
  }

  public void setU16(String paramString, short paramShort)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 1, 0xFFFF & paramShort);
  }

  public void setU16Array(String paramString, short[] paramArrayOfShort)
  {
    Im2MessageNative.setShortArray(this.mPtr, paramString, paramArrayOfShort);
  }

  public void setU32(String paramString, int paramInt)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 2, 0xFFFFFFFF & paramInt);
  }

  public void setU32Array(String paramString, int[] paramArrayOfInt)
  {
    Im2MessageNative.setIntArray(this.mPtr, paramString, paramArrayOfInt);
  }

  public void setU64(String paramString, long paramLong)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 3, paramLong);
  }

  public void setU64Array(String paramString, long[] paramArrayOfLong)
  {
    Im2MessageNative.setLongArray(this.mPtr, paramString, paramArrayOfLong);
  }

  public void setU8(String paramString, byte paramByte)
  {
    Im2MessageNative.setNumber(this.mPtr, paramString, 0, 0xFF & paramByte);
  }

  public void setU8Array(String paramString, byte[] paramArrayOfByte)
  {
    Im2MessageNative.setByteArray(this.mPtr, paramString, paramArrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.MessageWrite
 * JD-Core Version:    0.6.2
 */