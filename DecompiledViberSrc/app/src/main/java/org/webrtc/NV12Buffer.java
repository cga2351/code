package org.webrtc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class NV12Buffer
  implements VideoFrame.Buffer
{
  private final ByteBuffer buffer;
  private final int height;
  private final RefCountDelegate refCountDelegate;
  private final int sliceHeight;
  private final int stride;
  private final int width;

  public NV12Buffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer, @Nullable Runnable paramRunnable)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.stride = paramInt3;
    this.sliceHeight = paramInt4;
    this.buffer = paramByteBuffer;
    this.refCountDelegate = new RefCountDelegate(paramRunnable);
  }

  private static native void nativeCropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ByteBuffer paramByteBuffer1, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ByteBuffer paramByteBuffer2, int paramInt11, ByteBuffer paramByteBuffer3, int paramInt12, ByteBuffer paramByteBuffer4, int paramInt13);

  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    JavaI420Buffer localJavaI420Buffer = JavaI420Buffer.allocate(paramInt5, paramInt6);
    nativeCropAndScale(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, this.buffer, this.width, this.height, this.stride, this.sliceHeight, localJavaI420Buffer.getDataY(), localJavaI420Buffer.getStrideY(), localJavaI420Buffer.getDataU(), localJavaI420Buffer.getStrideU(), localJavaI420Buffer.getDataV(), localJavaI420Buffer.getStrideV());
    return localJavaI420Buffer;
  }

  public int getHeight()
  {
    return this.height;
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
    return (VideoFrame.I420Buffer)cropAndScale(0, 0, this.width, this.height, this.width, this.height);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.NV12Buffer
 * JD-Core Version:    0.6.2
 */