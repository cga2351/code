package com.viber.jni.im2;

import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MessageRead
{
  private boolean mOwned;
  private long mPtr = 0L;

  MessageRead(long paramLong, boolean paramBoolean)
  {
    this.mPtr = paramLong;
    this.mOwned = paramBoolean;
  }

  public void destroy()
  {
    if (this.mPtr != 0L)
    {
      if (this.mOwned)
        Im2MessageNative.destroyMessageRead(this.mPtr);
      this.mPtr = 0L;
    }
  }

  public void finalize()
  {
    destroy();
  }

  public boolean getBoolean(String paramString)
  {
    return Im2MessageNative.getBoolean(this.mPtr, paramString);
  }

  public MapNumberToMessageData getMapNumberToMessage(String paramString, int paramInt)
  {
    new HashMap();
    Bundle localBundle = Im2MessageNative.getMapNumberToMessage(this.mPtr, paramString, paramInt);
    MapNumberToMessageData localMapNumberToMessageData = new MapNumberToMessageData();
    localMapNumberToMessageData.keys = localBundle.getLongArray("Keys");
    localMapNumberToMessageData.values = localBundle.getLongArray("Values");
    return localMapNumberToMessageData;
  }

  public MapNumberToNumberData getMapNumberToNumber(String paramString, int paramInt1, int paramInt2)
  {
    new HashMap();
    Bundle localBundle = Im2MessageNative.getMapNumberToNumber(this.mPtr, paramString, paramInt1, paramInt2);
    MapNumberToNumberData localMapNumberToNumberData = new MapNumberToNumberData();
    localMapNumberToNumberData.keys = localBundle.getLongArray("Keys");
    localMapNumberToNumberData.values = localBundle.getLongArray("Values");
    return localMapNumberToNumberData;
  }

  public MapNumberToStringData getMapNumberToString(String paramString, int paramInt)
  {
    Bundle localBundle = Im2MessageNative.getMapNumberToString(this.mPtr, paramString, paramInt);
    MapNumberToStringData localMapNumberToStringData = new MapNumberToStringData();
    localMapNumberToStringData.keys = localBundle.getLongArray("Keys");
    localMapNumberToStringData.values = localBundle.getStringArray("Values");
    return localMapNumberToStringData;
  }

  public MapStringToMessageData getMapStringToMessage(String paramString)
  {
    new HashMap();
    Bundle localBundle = Im2MessageNative.getMapStringToMessage(this.mPtr, paramString);
    MapStringToMessageData localMapStringToMessageData = new MapStringToMessageData();
    localMapStringToMessageData.keys = localBundle.getStringArray("Keys");
    localMapStringToMessageData.values = localBundle.getLongArray("Values");
    return localMapStringToMessageData;
  }

  public MapStringToNumberData getMapStringToNumber(String paramString, int paramInt)
  {
    new HashMap();
    Bundle localBundle = Im2MessageNative.getMapStringToNumber(this.mPtr, paramString, paramInt);
    MapStringToNumberData localMapStringToNumberData = new MapStringToNumberData();
    localMapStringToNumberData.keys = localBundle.getStringArray("Keys");
    localMapStringToNumberData.values = localBundle.getLongArray("Values");
    return localMapStringToNumberData;
  }

  public MapStringToStringData getMapStringToString(String paramString)
  {
    Bundle localBundle = Im2MessageNative.getMapStringToString(this.mPtr, paramString);
    MapStringToStringData localMapStringToStringData = new MapStringToStringData();
    localMapStringToStringData.keys = localBundle.getStringArray("Keys");
    localMapStringToStringData.values = localBundle.getStringArray("Values");
    return localMapStringToStringData;
  }

  public MessageRead getMessage(String paramString)
  {
    return new MessageRead(Im2MessageNative.getMessage(this.mPtr, paramString), true);
  }

  public MessageRead[] getMessageArray(String paramString)
  {
    long[] arrayOfLong = Im2MessageNative.getMessageArray(this.mPtr, paramString);
    MessageRead[] arrayOfMessageRead = new MessageRead[arrayOfLong.length];
    for (int i = 0; i < arrayOfLong.length; i++)
      arrayOfMessageRead[i] = new MessageRead(arrayOfLong[i], true);
    return arrayOfMessageRead;
  }

  public int getMessageId()
  {
    return Im2MessageNative.getMessageId(this.mPtr);
  }

  public short getS16(String paramString)
  {
    return (short)(int)Im2MessageNative.getNumber(this.mPtr, paramString, 5);
  }

  public short[] getS16Array(String paramString)
  {
    return Im2MessageNative.getShortArray(this.mPtr, paramString);
  }

  public int getS32(String paramString)
  {
    return (int)Im2MessageNative.getNumber(this.mPtr, paramString, 6);
  }

  public int[] getS32Array(String paramString)
  {
    return Im2MessageNative.getIntArray(this.mPtr, paramString);
  }

  public long getS64(String paramString)
  {
    return Im2MessageNative.getNumber(this.mPtr, paramString, 7);
  }

  public long[] getS64Array(String paramString)
  {
    return Im2MessageNative.getLongArray(this.mPtr, paramString);
  }

  public byte getS8(String paramString)
  {
    return (byte)(int)Im2MessageNative.getNumber(this.mPtr, paramString, 4);
  }

  public byte[] getS8Array(String paramString)
  {
    return Im2MessageNative.getByteArray(this.mPtr, paramString);
  }

  public String getString(String paramString)
  {
    return Im2MessageNative.getString(this.mPtr, paramString);
  }

  public String[] getStringArray(String paramString)
  {
    return Im2MessageNative.getStringArray(this.mPtr, paramString);
  }

  public Set<String> getStringSet(String paramString)
  {
    String[] arrayOfString = Im2MessageNative.getStringSet(this.mPtr, paramString);
    HashSet localHashSet = new HashSet();
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      localHashSet.add(arrayOfString[j]);
    return localHashSet;
  }

  public short getU16(String paramString)
  {
    return (short)(int)Im2MessageNative.getNumber(this.mPtr, paramString, 1);
  }

  public short[] getU16Array(String paramString)
  {
    return Im2MessageNative.getShortArray(this.mPtr, paramString);
  }

  public int getU32(String paramString)
  {
    return (int)Im2MessageNative.getNumber(this.mPtr, paramString, 2);
  }

  public int[] getU32Array(String paramString)
  {
    return Im2MessageNative.getIntArray(this.mPtr, paramString);
  }

  public long getU64(String paramString)
  {
    return Im2MessageNative.getNumber(this.mPtr, paramString, 3);
  }

  public long[] getU64Array(String paramString)
  {
    return Im2MessageNative.getLongArray(this.mPtr, paramString);
  }

  public byte getU8(String paramString)
  {
    return (byte)(int)Im2MessageNative.getNumber(this.mPtr, paramString, 0);
  }

  public byte[] getU8Array(String paramString)
  {
    return Im2MessageNative.getByteArray(this.mPtr, paramString);
  }

  public static class MapNumberToMessageData
  {
    public long[] keys;
    public long[] values;

    MapNumberToMessageData()
    {
    }

    MapNumberToMessageData(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      this.keys = paramArrayOfLong1;
      this.values = paramArrayOfLong2;
    }
  }

  public static class MapNumberToNumberData
  {
    public long[] keys;
    public long[] values;

    MapNumberToNumberData()
    {
    }

    MapNumberToNumberData(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      this.keys = paramArrayOfLong1;
      this.values = paramArrayOfLong2;
    }
  }

  public static class MapNumberToStringData
  {
    public long[] keys;
    public String[] values;

    MapNumberToStringData()
    {
    }

    MapNumberToStringData(long[] paramArrayOfLong, String[] paramArrayOfString)
    {
      this.keys = paramArrayOfLong;
      this.values = paramArrayOfString;
    }
  }

  public static class MapStringToMessageData
  {
    public String[] keys;
    public long[] values;

    MapStringToMessageData()
    {
    }

    MapStringToMessageData(String[] paramArrayOfString, long[] paramArrayOfLong)
    {
      this.keys = paramArrayOfString;
      this.values = paramArrayOfLong;
    }
  }

  public static class MapStringToNumberData
  {
    public String[] keys;
    public long[] values;

    MapStringToNumberData()
    {
    }

    MapStringToNumberData(String[] paramArrayOfString, long[] paramArrayOfLong)
    {
      this.keys = paramArrayOfString;
      this.values = paramArrayOfLong;
    }
  }

  public static class MapStringToStringData
  {
    public String[] keys;
    public String[] values;

    MapStringToStringData()
    {
    }

    MapStringToStringData(String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      this.keys = paramArrayOfString1;
      this.values = paramArrayOfString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.MessageRead
 * JD-Core Version:    0.6.2
 */