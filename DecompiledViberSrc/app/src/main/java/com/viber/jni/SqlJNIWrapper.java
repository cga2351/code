package com.viber.jni;

import java.lang.reflect.Method;

public class SqlJNIWrapper
{
  static
  {
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "ViberRTC";
      arrayOfObject1[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = "VoipEngineNative";
      arrayOfObject2[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject2);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.loadLibrary("ViberRTC");
      System.loadLibrary("VoipEngineNative");
    }
  }

  public static final native boolean continueSelectExecution(long paramLong1, long paramLong2);

  public static final native long createNativeSqlWrapper(String paramString);

  public static final native void deinit(long paramLong);

  public static final native boolean destroyNativeSelectState(long paramLong1, long paramLong2);

  public static final native int exec(long paramLong, String paramString);

  public static final native int getColumnIndex(long paramLong1, long paramLong2, String paramString);

  public static final native String getColumnName(long paramLong1, long paramLong2, int paramInt);

  public static final native String getDbFileName(long paramLong);

  public static final native int getRowsCount(long paramLong1, long paramLong2);

  public static final native int init(long paramLong);

  public static final native boolean resetSelectExecution(long paramLong1, long paramLong2);

  public static final native long select(long paramLong, String paramString, char[] paramArrayOfChar, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.SqlJNIWrapper
 * JD-Core Version:    0.6.2
 */