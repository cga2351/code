package com.viber.voip.flatbuffers.library;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class NativeJsonFlatBuffersParser
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
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "FlatBuffersParser";
      arrayOfObject[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.loadLibrary("FlatBuffersParser");
    }
  }

  public static ByteBuffer a(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = parseJsonNative(paramString1, paramString2);
    if (arrayOfByte == null)
      return null;
    return ByteBuffer.wrap(arrayOfByte);
  }

  public static native byte[] parseJsonNative(String paramString1, String paramString2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.library.NativeJsonFlatBuffersParser
 * JD-Core Version:    0.6.2
 */