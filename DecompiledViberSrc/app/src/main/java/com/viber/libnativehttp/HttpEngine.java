package com.viber.libnativehttp;

public class HttpEngine
{
  static
  {
    System.loadLibrary("c++_shared");
    System.loadLibrary("nativehttp");
  }

  public static native long nativeCreateHttp();

  public static native void nativeTest(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.HttpEngine
 * JD-Core Version:    0.6.2
 */