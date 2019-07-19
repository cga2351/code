package com.viber.voip.audioptt;

class LibSpeex
{
  static
  {
    System.loadLibrary("speexjni");
  }

  public static native boolean nDecodeBuffer(long paramLong1, byte[] paramArrayOfByte, long paramLong2, short[] paramArrayOfShort);

  public static native void nDestroySpxDecoder(long paramLong);

  public static native void nDestroySpxEncoder(long paramLong);

  public static native long nEncodeBuffer(long paramLong1, short[] paramArrayOfShort, byte[] paramArrayOfByte, long paramLong2);

  public static native long nGetDecoderFrameSize(long paramLong);

  public static native long nGetEncoderFrameSize(long paramLong);

  public static native long nInitSpxDecoder();

  public static native long nInitSpxEncoder();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.audioptt.LibSpeex
 * JD-Core Version:    0.6.2
 */