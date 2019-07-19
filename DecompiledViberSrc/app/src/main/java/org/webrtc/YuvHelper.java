package org.webrtc;

import java.nio.ByteBuffer;

public class YuvHelper
{
  public static void I420Copy(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5)
  {
    int i = (paramInt5 + 1) / 2;
    int j = (paramInt4 + 1) / 2;
    int k = paramInt4 * paramInt5 + 2 * (j * i);
    if (paramByteBuffer4.capacity() < k)
      throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + k + " was " + paramByteBuffer4.capacity());
    int m = paramInt5 * paramInt4;
    int n = m + i * j;
    paramByteBuffer4.position(0);
    ByteBuffer localByteBuffer1 = paramByteBuffer4.slice();
    paramByteBuffer4.position(m);
    ByteBuffer localByteBuffer2 = paramByteBuffer4.slice();
    paramByteBuffer4.position(n);
    nativeI420Copy(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, localByteBuffer1, paramInt4, localByteBuffer2, j, paramByteBuffer4.slice(), j, paramInt4, paramInt5);
  }

  public static void I420Copy(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8)
  {
    nativeI420Copy(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramByteBuffer5, paramInt5, paramByteBuffer6, paramInt6, paramInt7, paramInt8);
  }

  public static void I420Rotate(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5, int paramInt6)
  {
    int i;
    if (paramInt6 % 180 == 0)
    {
      i = paramInt4;
      if (paramInt6 % 180 != 0)
        break label115;
    }
    int k;
    int m;
    label115: for (int j = paramInt5; ; j = paramInt4)
    {
      k = (j + 1) / 2;
      m = (i + 1) / 2;
      int n = i * j + 2 * (m * k);
      if (paramByteBuffer4.capacity() >= n)
        break label122;
      throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + n + " was " + paramByteBuffer4.capacity());
      i = paramInt5;
      break;
    }
    label122: int i1 = j * i;
    int i2 = i1 + k * m;
    paramByteBuffer4.position(0);
    ByteBuffer localByteBuffer1 = paramByteBuffer4.slice();
    paramByteBuffer4.position(i1);
    ByteBuffer localByteBuffer2 = paramByteBuffer4.slice();
    paramByteBuffer4.position(i2);
    nativeI420Rotate(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, localByteBuffer1, i, localByteBuffer2, m, paramByteBuffer4.slice(), m, paramInt4, paramInt5, paramInt6);
  }

  public static void I420Rotate(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    nativeI420Rotate(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramByteBuffer5, paramInt5, paramByteBuffer6, paramInt6, paramInt7, paramInt8, paramInt9);
  }

  public static void I420ToNV12(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5)
  {
    int i = (paramInt4 + 1) / 2;
    int j = (paramInt5 + 1) / 2;
    int k = paramInt4 * paramInt5 + 2 * (j * i);
    if (paramByteBuffer4.capacity() < k)
      throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + k + " was " + paramByteBuffer4.capacity());
    int m = paramInt5 * paramInt4;
    paramByteBuffer4.position(0);
    ByteBuffer localByteBuffer = paramByteBuffer4.slice();
    paramByteBuffer4.position(m);
    nativeI420ToNV12(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, localByteBuffer, paramInt4, paramByteBuffer4.slice(), i * 2, paramInt4, paramInt5);
  }

  public static void I420ToNV12(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, int paramInt6, int paramInt7)
  {
    nativeI420ToNV12(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramByteBuffer5, paramInt5, paramInt6, paramInt7);
  }

  public static void copyPlane(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4)
  {
    nativeCopyPlane(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramInt3, paramInt4);
  }

  private static native void nativeCopyPlane(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4);

  private static native void nativeI420Copy(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8);

  private static native void nativeI420Rotate(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8, int paramInt9);

  private static native void nativeI420ToNV12(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, int paramInt6, int paramInt7);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.YuvHelper
 * JD-Core Version:    0.6.2
 */