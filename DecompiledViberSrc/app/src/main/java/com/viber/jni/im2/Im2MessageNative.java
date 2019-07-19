package com.viber.jni.im2;

import android.os.Bundle;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Im2MessageNative
{
  static native long createMessageWrite(int paramInt);

  static native long createMessageWrite(String paramString);

  static native void destroyMessageRead(long paramLong);

  static native void destroyMessageWrite(long paramLong);

  static native boolean getBoolean(long paramLong, String paramString);

  static native byte[] getByteArray(long paramLong, String paramString);

  static native int[] getIntArray(long paramLong, String paramString);

  static native long[] getLongArray(long paramLong, String paramString);

  static native Bundle getMapNumberToMessage(long paramLong, String paramString, int paramInt);

  static native Bundle getMapNumberToNumber(long paramLong, String paramString, int paramInt1, int paramInt2);

  static native Bundle getMapNumberToString(long paramLong, String paramString, int paramInt);

  static native Bundle getMapStringToMessage(long paramLong, String paramString);

  static native Bundle getMapStringToNumber(long paramLong, String paramString, int paramInt);

  static native Bundle getMapStringToString(long paramLong, String paramString);

  static native long getMessage(long paramLong, String paramString);

  static native long[] getMessageArray(long paramLong, String paramString);

  static native int getMessageId(long paramLong);

  static native long getNumber(long paramLong, String paramString, int paramInt);

  static native short[] getShortArray(long paramLong, String paramString);

  static native String getString(long paramLong, String paramString);

  static native String[] getStringArray(long paramLong, String paramString);

  static native String[] getStringSet(long paramLong, String paramString);

  static native boolean isValid(long paramLong);

  static native void setBoolean(long paramLong, String paramString, boolean paramBoolean);

  static native void setByteArray(long paramLong, String paramString, byte[] paramArrayOfByte);

  static native void setIntArray(long paramLong, String paramString, int[] paramArrayOfInt);

  static native void setLongArray(long paramLong, String paramString, long[] paramArrayOfLong);

  static native void setMapNumberToMessage(long paramLong, String paramString, int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2);

  static native void setMapNumberToNumber(long paramLong, String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong1, long[] paramArrayOfLong2);

  static native void setMapNumberToString(long paramLong, String paramString, int paramInt, long[] paramArrayOfLong, String[] paramArrayOfString);

  static native void setMapStringToMessage(long paramLong, String paramString, String[] paramArrayOfString, long[] paramArrayOfLong);

  static native void setMapStringToNumber(long paramLong, String paramString, int paramInt, String[] paramArrayOfString, long[] paramArrayOfLong);

  static native void setMapStringToString(long paramLong, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);

  static native void setMessage(long paramLong1, String paramString, long paramLong2);

  static native void setMessageArray(long paramLong, String paramString, long[] paramArrayOfLong);

  static native void setNumber(long paramLong1, String paramString, int paramInt, long paramLong2);

  static native void setShortArray(long paramLong, String paramString, short[] paramArrayOfShort);

  static native void setString(long paramLong, String paramString1, String paramString2);

  static native void setStringArray(long paramLong, String paramString, String[] paramArrayOfString);

  static native void setStringSet(long paramLong, String paramString, String[] paramArrayOfString);

  @Retention(RetentionPolicy.SOURCE)
  public static @interface NumberType
  {
    public static final int S16 = 5;
    public static final int S32 = 6;
    public static final int S64 = 7;
    public static final int S8 = 4;
    public static final int U16 = 1;
    public static final int U32 = 2;
    public static final int U64 = 3;
    public static final int U8;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2MessageNative
 * JD-Core Version:    0.6.2
 */