package com.viber.voip.videoconvert.gpu.opengl;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class PBufferGLWrapperNative
  implements c
{
  private long mImpl = 0L;

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
      arrayOfObject[0] = "videoconvert";
      arrayOfObject[1] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.loadLibrary("videoconvert");
    }
  }

  public PBufferGLWrapperNative(int paramInt1, int paramInt2)
  {
    construct(paramInt1, paramInt2);
  }

  public native void checkEglError(String paramString);

  public native void construct(int paramInt1, int paramInt2);

  public native void doneCurrent();

  public native int getDataType();

  public native String getExtensions();

  public native int getPixelFormat();

  public native String getRenderer();

  public native String getVendor();

  public native void init();

  public boolean isExtensionSupported(String paramString)
  {
    String[] arrayOfString = getExtensions().split(" ");
    for (int i = 0; ; i++)
    {
      int j = arrayOfString.length;
      boolean bool = false;
      if (i < j)
      {
        if (arrayOfString[i].compareTo(paramString) == 0)
          bool = true;
      }
      else
        return bool;
    }
  }

  public native void makeCurrent();

  public native void optimize();

  public native void readPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ByteBuffer paramByteBuffer);

  public native void release(boolean paramBoolean);

  public native void setPresentationTime(long paramLong);

  public native boolean swapBuffers();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.opengl.PBufferGLWrapperNative
 * JD-Core Version:    0.6.2
 */