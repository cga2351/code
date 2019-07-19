package com.snappydb.internal;

import android.text.TextUtils;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.snappydb.DB;
import com.snappydb.KeyIterator;
import com.snappydb.SnappydbException;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class DBImpl
  implements DB
{
  private static final String LIB_NAME = "snappydb-native";
  private static final int LIMIT_MAX = 2147483639;
  private String dbPath;
  private Kryo kryo;

  static
  {
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "snappydb-native";
      arrayOfObject[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.loadLibrary("snappydb-native");
    }
  }

  public DBImpl(String paramString, Kryo[] paramArrayOfKryo)
    throws SnappydbException
  {
    this.dbPath = paramString;
    if ((paramArrayOfKryo != null) && (paramArrayOfKryo.length > 0))
      this.kryo = paramArrayOfKryo[0];
    while (true)
    {
      __open(this.dbPath);
      return;
      this.kryo = new Kryo();
      this.kryo.setAsmEnabled(true);
    }
  }

  private native void __close();

  private native int __countKeys(String paramString)
    throws SnappydbException;

  private native int __countKeysBetween(String paramString1, String paramString2)
    throws SnappydbException;

  private native void __del(String paramString)
    throws SnappydbException;

  private native void __destroy(String paramString)
    throws SnappydbException;

  private native boolean __exists(String paramString)
    throws SnappydbException;

  private native String[] __findKeys(String paramString, int paramInt1, int paramInt2)
    throws SnappydbException;

  private native String[] __findKeysBetween(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SnappydbException;

  private native String __get(String paramString)
    throws SnappydbException;

  private native boolean __getBoolean(String paramString)
    throws SnappydbException;

  private native byte[] __getBytes(String paramString)
    throws SnappydbException;

  private native double __getDouble(String paramString)
    throws SnappydbException;

  private native float __getFloat(String paramString)
    throws SnappydbException;

  private native int __getInt(String paramString)
    throws SnappydbException;

  private native long __getLong(String paramString)
    throws SnappydbException;

  private native short __getShort(String paramString)
    throws SnappydbException;

  private native boolean __isOpen()
    throws SnappydbException;

  private native void __open(String paramString)
    throws SnappydbException;

  private native void __put(String paramString1, String paramString2)
    throws SnappydbException;

  private native void __put(String paramString, byte[] paramArrayOfByte)
    throws SnappydbException;

  private native void __putBoolean(String paramString, boolean paramBoolean)
    throws SnappydbException;

  private native void __putDouble(String paramString, double paramDouble)
    throws SnappydbException;

  private native void __putFloat(String paramString, float paramFloat)
    throws SnappydbException;

  private native void __putInt(String paramString, int paramInt)
    throws SnappydbException;

  private native void __putLong(String paramString, long paramLong)
    throws SnappydbException;

  private native void __putShort(String paramString, short paramShort)
    throws SnappydbException;

  private void checkArgNotEmpty(String paramString1, String paramString2)
    throws SnappydbException
  {
    if (TextUtils.isEmpty(paramString1))
      throw new SnappydbException(paramString2);
  }

  private void checkArgs(String paramString, Object paramObject)
    throws SnappydbException
  {
    checkArgNotEmpty(paramString, "Key must not be empty");
    if (paramObject == null)
      throw new SnappydbException("Value must not be empty");
  }

  private void checkKey(String paramString)
    throws SnappydbException
  {
    checkArgNotEmpty(paramString, "Key must not be empty");
  }

  private void checkOffsetLimit(int paramInt1, int paramInt2)
    throws SnappydbException
  {
    if (paramInt1 < 0)
      throw new SnappydbException("Offset must not be negative");
    if (paramInt2 <= 0)
      throw new SnappydbException("Limit must not be 0 or negative");
  }

  private void checkPrefix(String paramString)
    throws SnappydbException
  {
    checkArgNotEmpty(paramString, "Starting prefix must not be empty");
  }

  private void checkRange(String paramString1, String paramString2)
    throws SnappydbException
  {
    checkArgNotEmpty(paramString1, "Starting prefix must not be empty");
    checkArgNotEmpty(paramString1, "Ending prefix must not be empty");
  }

  native long __findKeysIterator(String paramString, boolean paramBoolean)
    throws SnappydbException;

  native void __iteratorClose(long paramLong);

  native boolean __iteratorIsValid(long paramLong, String paramString, boolean paramBoolean);

  native String[] __iteratorNextArray(long paramLong, String paramString, boolean paramBoolean, int paramInt)
    throws SnappydbException;

  public KeyIterator allKeysIterator()
    throws SnappydbException
  {
    return new KeyIteratorImpl(this, __findKeysIterator(null, false), null, false);
  }

  public KeyIterator allKeysReverseIterator()
    throws SnappydbException
  {
    return new KeyIteratorImpl(this, __findKeysIterator(null, true), null, true);
  }

  public void close()
  {
    __close();
  }

  public int countKeys(String paramString)
    throws SnappydbException
  {
    checkPrefix(paramString);
    return __countKeys(paramString);
  }

  public int countKeysBetween(String paramString1, String paramString2)
    throws SnappydbException
  {
    checkRange(paramString1, paramString2);
    return __countKeysBetween(paramString1, paramString2);
  }

  public void del(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    __del(paramString);
  }

  public void destroy()
    throws SnappydbException
  {
    __destroy(this.dbPath);
  }

  public boolean exists(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __exists(paramString);
  }

  public String[] findKeys(String paramString)
    throws SnappydbException
  {
    return findKeys(paramString, 0, 2147483639);
  }

  public String[] findKeys(String paramString, int paramInt)
    throws SnappydbException
  {
    return findKeys(paramString, paramInt, 2147483639);
  }

  public String[] findKeys(String paramString, int paramInt1, int paramInt2)
    throws SnappydbException
  {
    checkPrefix(paramString);
    checkOffsetLimit(paramInt1, paramInt2);
    return __findKeys(paramString, paramInt1, paramInt2);
  }

  public String[] findKeysBetween(String paramString1, String paramString2)
    throws SnappydbException
  {
    return findKeysBetween(paramString1, paramString2, 0, 2147483639);
  }

  public String[] findKeysBetween(String paramString1, String paramString2, int paramInt)
    throws SnappydbException
  {
    return findKeysBetween(paramString1, paramString2, paramInt, 2147483639);
  }

  public String[] findKeysBetween(String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws SnappydbException
  {
    checkRange(paramString1, paramString2);
    checkOffsetLimit(paramInt1, paramInt2);
    return __findKeysBetween(paramString1, paramString2, paramInt1, paramInt2);
  }

  public KeyIterator findKeysBetweenIterator(String paramString1, String paramString2)
    throws SnappydbException
  {
    return new KeyIteratorImpl(this, __findKeysIterator(paramString1, false), paramString2, false);
  }

  public KeyIterator findKeysBetweenReverseIterator(String paramString1, String paramString2)
    throws SnappydbException
  {
    return new KeyIteratorImpl(this, __findKeysIterator(paramString1, true), paramString2, true);
  }

  public KeyIterator findKeysIterator(String paramString)
    throws SnappydbException
  {
    return new KeyIteratorImpl(this, __findKeysIterator(paramString, false), null, false);
  }

  public KeyIterator findKeysReverseIterator(String paramString)
    throws SnappydbException
  {
    return new KeyIteratorImpl(this, __findKeysIterator(paramString, true), null, true);
  }

  public <T extends Serializable> T get(String paramString, Class<T> paramClass)
    throws SnappydbException
  {
    checkArgs(paramString, paramClass);
    if (paramClass.isArray())
      throw new SnappydbException("You should call getArray instead");
    byte[] arrayOfByte = getBytes(paramString);
    this.kryo.register(paramClass);
    Input localInput = new Input(arrayOfByte);
    try
    {
      Serializable localSerializable = (Serializable)this.kryo.readObject(localInput, paramClass);
      return localSerializable;
    }
    catch (Exception localException)
    {
      throw new SnappydbException("Maybe you tried to retrieve an array using this method ? please use getArray instead " + localException.getMessage());
    }
    finally
    {
      localInput.close();
    }
  }

  public String get(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __get(paramString);
  }

  public <T extends Serializable> T[] getArray(String paramString, Class<T> paramClass)
    throws SnappydbException
  {
    checkArgs(paramString, paramClass);
    byte[] arrayOfByte = __getBytes(paramString);
    this.kryo.register(paramClass);
    Input localInput = new Input(arrayOfByte);
    Serializable[] arrayOfSerializable1 = (Serializable[])Array.newInstance(paramClass, 0);
    try
    {
      Serializable[] arrayOfSerializable2 = (Serializable[])this.kryo.readObject(localInput, arrayOfSerializable1.getClass());
      return arrayOfSerializable2;
    }
    catch (Exception localException)
    {
      throw new SnappydbException("Maybe you tried to retrieve an array using this method ? please use getArray instead " + localException.getMessage());
    }
    finally
    {
      localInput.close();
    }
  }

  public boolean getBoolean(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getBoolean(paramString);
  }

  public byte[] getBytes(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getBytes(paramString);
  }

  public double getDouble(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getDouble(paramString);
  }

  public float getFloat(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getFloat(paramString);
  }

  public int getInt(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getInt(paramString);
  }

  public Kryo getKryoInstance()
  {
    return this.kryo;
  }

  public long getLong(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getLong(paramString);
  }

  public <T> T getObject(String paramString, Class<T> paramClass)
    throws SnappydbException
  {
    checkArgs(paramString, paramClass);
    if (paramClass.isArray())
      throw new SnappydbException("You should call getObjectArray instead");
    byte[] arrayOfByte = getBytes(paramString);
    this.kryo.register(paramClass);
    Input localInput = new Input(arrayOfByte);
    try
    {
      Object localObject2 = this.kryo.readObject(localInput, paramClass);
      return localObject2;
    }
    catch (Exception localException)
    {
      throw new SnappydbException("Maybe you tried to retrieve an array using this method ? please use getObjectArray instead " + localException.getMessage());
    }
    finally
    {
      localInput.close();
    }
  }

  public <T> T[] getObjectArray(String paramString, Class<T> paramClass)
    throws SnappydbException
  {
    checkArgs(paramString, paramClass);
    byte[] arrayOfByte = __getBytes(paramString);
    this.kryo.register(paramClass);
    Input localInput = new Input(arrayOfByte);
    Object[] arrayOfObject1 = (Object[])Array.newInstance(paramClass, 0);
    try
    {
      Object[] arrayOfObject2 = (Object[])this.kryo.readObject(localInput, arrayOfObject1.getClass());
      return arrayOfObject2;
    }
    catch (Exception localException)
    {
      throw new SnappydbException("Maybe you tried to retrieve an array using this method ? please use getArray instead " + localException.getMessage());
    }
    finally
    {
      localInput.close();
    }
  }

  public short getShort(String paramString)
    throws SnappydbException
  {
    checkKey(paramString);
    return __getShort(paramString);
  }

  public boolean isOpen()
    throws SnappydbException
  {
    return __isOpen();
  }

  public void put(String paramString, Serializable paramSerializable)
    throws SnappydbException
  {
    checkArgs(paramString, paramSerializable);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.kryo.register(paramSerializable.getClass());
    Output localOutput = new Output(localByteArrayOutputStream);
    try
    {
      this.kryo.writeObject(localOutput, paramSerializable);
      localOutput.close();
      __put(paramString, localByteArrayOutputStream.toByteArray());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new SnappydbException(localException.getMessage());
    }
  }

  public void put(String paramString, Object paramObject)
    throws SnappydbException
  {
    checkArgs(paramString, paramObject);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.kryo.register(paramObject.getClass());
    Output localOutput = new Output(localByteArrayOutputStream);
    try
    {
      this.kryo.writeObject(localOutput, paramObject);
      localOutput.close();
      __put(paramString, localByteArrayOutputStream.toByteArray());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new SnappydbException(localException.getMessage());
    }
  }

  public void put(String paramString1, String paramString2)
    throws SnappydbException
  {
    checkArgs(paramString1, paramString2);
    __put(paramString1, paramString2);
  }

  public void put(String paramString, byte[] paramArrayOfByte)
    throws SnappydbException
  {
    checkArgs(paramString, paramArrayOfByte);
    __put(paramString, paramArrayOfByte);
  }

  public void put(String paramString, Serializable[] paramArrayOfSerializable)
    throws SnappydbException
  {
    checkArgs(paramString, paramArrayOfSerializable);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.kryo.register(paramArrayOfSerializable.getClass());
    Output localOutput = new Output(localByteArrayOutputStream);
    try
    {
      this.kryo.writeObject(localOutput, paramArrayOfSerializable);
      localOutput.close();
      __put(paramString, localByteArrayOutputStream.toByteArray());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new SnappydbException("Kryo exception " + localException.getMessage());
    }
  }

  public void put(String paramString, Object[] paramArrayOfObject)
    throws SnappydbException
  {
    checkArgs(paramString, paramArrayOfObject);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.kryo.register(paramArrayOfObject.getClass());
    Output localOutput = new Output(localByteArrayOutputStream);
    try
    {
      this.kryo.writeObject(localOutput, paramArrayOfObject);
      localOutput.close();
      __put(paramString, localByteArrayOutputStream.toByteArray());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new SnappydbException("Kryo exception " + localException.getMessage());
    }
  }

  public void putBoolean(String paramString, boolean paramBoolean)
    throws SnappydbException
  {
    checkKey(paramString);
    __putBoolean(paramString, paramBoolean);
  }

  public void putDouble(String paramString, double paramDouble)
    throws SnappydbException
  {
    checkKey(paramString);
    __putDouble(paramString, paramDouble);
  }

  public void putFloat(String paramString, float paramFloat)
    throws SnappydbException
  {
    checkKey(paramString);
    __putFloat(paramString, paramFloat);
  }

  public void putInt(String paramString, int paramInt)
    throws SnappydbException
  {
    checkKey(paramString);
    __putInt(paramString, paramInt);
  }

  public void putLong(String paramString, long paramLong)
    throws SnappydbException
  {
    checkKey(paramString);
    __putLong(paramString, paramLong);
  }

  public void putShort(String paramString, short paramShort)
    throws SnappydbException
  {
    checkKey(paramString);
    __putShort(paramString, paramShort);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.snappydb.internal.DBImpl
 * JD-Core Version:    0.6.2
 */