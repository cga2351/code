package org.webrtc;

import java.nio.ByteBuffer;
import java.util.Objects;
import javax.annotation.Nullable;

public class JavaI420Buffer
  implements VideoFrame.I420Buffer
{
  private final ByteBuffer dataU;
  private final ByteBuffer dataV;
  private final ByteBuffer dataY;
  private final int height;
  private final RefCountDelegate refCountDelegate;
  private final int strideU;
  private final int strideV;
  private final int strideY;
  private final int width;

  private JavaI420Buffer(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, int paramInt3, ByteBuffer paramByteBuffer2, int paramInt4, ByteBuffer paramByteBuffer3, int paramInt5, @Nullable Runnable paramRunnable)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.dataY = paramByteBuffer1;
    this.dataU = paramByteBuffer2;
    this.dataV = paramByteBuffer3;
    this.strideY = paramInt3;
    this.strideU = paramInt4;
    this.strideV = paramInt5;
    this.refCountDelegate = new RefCountDelegate(paramRunnable);
  }

  public static JavaI420Buffer allocate(int paramInt1, int paramInt2)
  {
    int i = (paramInt2 + 1) / 2;
    int j = (paramInt1 + 1) / 2;
    int k = 0 + paramInt1 * paramInt2;
    int m = k + j * i;
    ByteBuffer localByteBuffer1 = JniCommon.nativeAllocateByteBuffer(paramInt1 * paramInt2 + i * (j * 2));
    localByteBuffer1.position(0);
    localByteBuffer1.limit(k);
    ByteBuffer localByteBuffer2 = localByteBuffer1.slice();
    localByteBuffer1.position(k);
    localByteBuffer1.limit(m);
    ByteBuffer localByteBuffer3 = localByteBuffer1.slice();
    localByteBuffer1.position(m);
    localByteBuffer1.limit(m + i * j);
    return new JavaI420Buffer(paramInt1, paramInt2, localByteBuffer2, paramInt1, localByteBuffer3, j, localByteBuffer1.slice(), j, new JavaI420Buffer..Lambda.0(localByteBuffer1));
  }

  private static void checkCapacity(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 + paramInt3 * (paramInt2 - 1);
    if (paramByteBuffer.capacity() < i)
      throw new IllegalArgumentException("Buffer must be at least " + i + " bytes, but was " + paramByteBuffer.capacity());
  }

  public static VideoFrame.Buffer cropAndScaleI420(VideoFrame.I420Buffer paramI420Buffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt3 == paramInt5) && (paramInt4 == paramInt6))
    {
      ByteBuffer localByteBuffer1 = paramI420Buffer.getDataY();
      ByteBuffer localByteBuffer2 = paramI420Buffer.getDataU();
      ByteBuffer localByteBuffer3 = paramI420Buffer.getDataV();
      localByteBuffer1.position(paramInt1 + paramInt2 * paramI420Buffer.getStrideY());
      localByteBuffer2.position(paramInt1 / 2 + paramInt2 / 2 * paramI420Buffer.getStrideU());
      localByteBuffer3.position(paramInt1 / 2 + paramInt2 / 2 * paramI420Buffer.getStrideV());
      paramI420Buffer.retain();
      ByteBuffer localByteBuffer4 = localByteBuffer1.slice();
      int i = paramI420Buffer.getStrideY();
      ByteBuffer localByteBuffer5 = localByteBuffer2.slice();
      int j = paramI420Buffer.getStrideU();
      ByteBuffer localByteBuffer6 = localByteBuffer3.slice();
      int k = paramI420Buffer.getStrideV();
      Objects.requireNonNull(paramI420Buffer);
      return wrap(paramInt5, paramInt6, localByteBuffer4, i, localByteBuffer5, j, localByteBuffer6, k, JavaI420Buffer..Lambda.1.get$Lambda(paramI420Buffer));
    }
    JavaI420Buffer localJavaI420Buffer = allocate(paramInt5, paramInt6);
    nativeCropAndScaleI420(paramI420Buffer.getDataY(), paramI420Buffer.getStrideY(), paramI420Buffer.getDataU(), paramI420Buffer.getStrideU(), paramI420Buffer.getDataV(), paramI420Buffer.getStrideV(), paramInt1, paramInt2, paramInt3, paramInt4, localJavaI420Buffer.getDataY(), localJavaI420Buffer.getStrideY(), localJavaI420Buffer.getDataU(), localJavaI420Buffer.getStrideU(), localJavaI420Buffer.getDataV(), localJavaI420Buffer.getStrideV(), paramInt5, paramInt6);
    return localJavaI420Buffer;
  }

  private static native void nativeCropAndScaleI420(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ByteBuffer paramByteBuffer4, int paramInt8, ByteBuffer paramByteBuffer5, int paramInt9, ByteBuffer paramByteBuffer6, int paramInt10, int paramInt11, int paramInt12);

  public static JavaI420Buffer wrap(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, int paramInt3, ByteBuffer paramByteBuffer2, int paramInt4, ByteBuffer paramByteBuffer3, int paramInt5, @Nullable Runnable paramRunnable)
  {
    if ((paramByteBuffer1 == null) || (paramByteBuffer2 == null) || (paramByteBuffer3 == null))
      throw new IllegalArgumentException("Data buffers cannot be null.");
    if ((!paramByteBuffer1.isDirect()) || (!paramByteBuffer2.isDirect()) || (!paramByteBuffer3.isDirect()))
      throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
    ByteBuffer localByteBuffer1 = paramByteBuffer1.slice();
    ByteBuffer localByteBuffer2 = paramByteBuffer2.slice();
    ByteBuffer localByteBuffer3 = paramByteBuffer3.slice();
    int i = (paramInt1 + 1) / 2;
    int j = (paramInt2 + 1) / 2;
    checkCapacity(localByteBuffer1, paramInt1, paramInt2, paramInt3);
    checkCapacity(localByteBuffer2, i, j, paramInt4);
    checkCapacity(localByteBuffer3, i, j, paramInt5);
    return new JavaI420Buffer(paramInt1, paramInt2, localByteBuffer1, paramInt3, localByteBuffer2, paramInt4, localByteBuffer3, paramInt5, paramRunnable);
  }

  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return cropAndScaleI420(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public ByteBuffer getDataU()
  {
    return this.dataU.slice();
  }

  public ByteBuffer getDataV()
  {
    return this.dataV.slice();
  }

  public ByteBuffer getDataY()
  {
    return this.dataY.slice();
  }

  public int getHeight()
  {
    return this.height;
  }

  public int getStrideU()
  {
    return this.strideU;
  }

  public int getStrideV()
  {
    return this.strideV;
  }

  public int getStrideY()
  {
    return this.strideY;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void release()
  {
    this.refCountDelegate.release();
  }

  public void retain()
  {
    this.refCountDelegate.retain();
  }

  public VideoFrame.I420Buffer toI420()
  {
    retain();
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.JavaI420Buffer
 * JD-Core Version:    0.6.2
 */