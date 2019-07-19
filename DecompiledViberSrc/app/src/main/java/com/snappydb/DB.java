package com.snappydb;

import com.esotericsoftware.kryo.Kryo;
import java.io.Serializable;

public abstract interface DB
{
  public abstract KeyIterator allKeysIterator()
    throws SnappydbException;

  public abstract KeyIterator allKeysReverseIterator()
    throws SnappydbException;

  public abstract void close()
    throws SnappydbException;

  public abstract int countKeys(String paramString)
    throws SnappydbException;

  public abstract int countKeysBetween(String paramString1, String paramString2)
    throws SnappydbException;

  public abstract void del(String paramString)
    throws SnappydbException;

  public abstract void destroy()
    throws SnappydbException;

  public abstract boolean exists(String paramString)
    throws SnappydbException;

  public abstract String[] findKeys(String paramString)
    throws SnappydbException;

  public abstract String[] findKeys(String paramString, int paramInt)
    throws SnappydbException;

  public abstract String[] findKeys(String paramString, int paramInt1, int paramInt2)
    throws SnappydbException;

  public abstract String[] findKeysBetween(String paramString1, String paramString2)
    throws SnappydbException;

  public abstract String[] findKeysBetween(String paramString1, String paramString2, int paramInt)
    throws SnappydbException;

  public abstract String[] findKeysBetween(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SnappydbException;

  public abstract KeyIterator findKeysBetweenIterator(String paramString1, String paramString2)
    throws SnappydbException;

  public abstract KeyIterator findKeysBetweenReverseIterator(String paramString1, String paramString2)
    throws SnappydbException;

  public abstract KeyIterator findKeysIterator(String paramString)
    throws SnappydbException;

  public abstract KeyIterator findKeysReverseIterator(String paramString)
    throws SnappydbException;

  public abstract <T extends Serializable> T get(String paramString, Class<T> paramClass)
    throws SnappydbException;

  public abstract String get(String paramString)
    throws SnappydbException;

  public abstract <T extends Serializable> T[] getArray(String paramString, Class<T> paramClass)
    throws SnappydbException;

  public abstract boolean getBoolean(String paramString)
    throws SnappydbException;

  public abstract byte[] getBytes(String paramString)
    throws SnappydbException;

  public abstract double getDouble(String paramString)
    throws SnappydbException;

  public abstract float getFloat(String paramString)
    throws SnappydbException;

  public abstract int getInt(String paramString)
    throws SnappydbException;

  public abstract Kryo getKryoInstance();

  public abstract long getLong(String paramString)
    throws SnappydbException;

  public abstract <T> T getObject(String paramString, Class<T> paramClass)
    throws SnappydbException;

  public abstract <T> T[] getObjectArray(String paramString, Class<T> paramClass)
    throws SnappydbException;

  public abstract short getShort(String paramString)
    throws SnappydbException;

  public abstract boolean isOpen()
    throws SnappydbException;

  public abstract void put(String paramString, Serializable paramSerializable)
    throws SnappydbException;

  public abstract void put(String paramString, Object paramObject)
    throws SnappydbException;

  public abstract void put(String paramString1, String paramString2)
    throws SnappydbException;

  public abstract void put(String paramString, byte[] paramArrayOfByte)
    throws SnappydbException;

  public abstract void put(String paramString, Serializable[] paramArrayOfSerializable)
    throws SnappydbException;

  public abstract void put(String paramString, Object[] paramArrayOfObject)
    throws SnappydbException;

  public abstract void putBoolean(String paramString, boolean paramBoolean)
    throws SnappydbException;

  public abstract void putDouble(String paramString, double paramDouble)
    throws SnappydbException;

  public abstract void putFloat(String paramString, float paramFloat)
    throws SnappydbException;

  public abstract void putInt(String paramString, int paramInt)
    throws SnappydbException;

  public abstract void putLong(String paramString, long paramLong)
    throws SnappydbException;

  public abstract void putShort(String paramString, short paramShort)
    throws SnappydbException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.snappydb.DB
 * JD-Core Version:    0.6.2
 */