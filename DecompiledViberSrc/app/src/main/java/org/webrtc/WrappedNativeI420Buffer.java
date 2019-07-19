package org.webrtc;

import java.nio.ByteBuffer;

class WrappedNativeI420Buffer
  implements VideoFrame.I420Buffer
{
  private final ByteBuffer dataU;
  private final ByteBuffer dataV;
  private final ByteBuffer dataY;
  private final int height;
  private final long nativeBuffer;
  private final int strideU;
  private final int strideV;
  private final int strideY;
  private final int width;

  @CalledByNative
  WrappedNativeI420Buffer(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, int paramInt3, ByteBuffer paramByteBuffer2, int paramInt4, ByteBuffer paramByteBuffer3, int paramInt5, long paramLong)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.dataY = paramByteBuffer1;
    this.strideY = paramInt3;
    this.dataU = paramByteBuffer2;
    this.strideU = paramInt4;
    this.dataV = paramByteBuffer3;
    this.strideV = paramInt5;
    this.nativeBuffer = paramLong;
    retain();
  }

  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return JavaI420Buffer.cropAndScaleI420(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
    JniCommon.nativeReleaseRef(this.nativeBuffer);
  }

  public void retain()
  {
    JniCommon.nativeAddRef(this.nativeBuffer);
  }

  public VideoFrame.I420Buffer toI420()
  {
    retain();
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.WrappedNativeI420Buffer
 * JD-Core Version:    0.6.2
 */