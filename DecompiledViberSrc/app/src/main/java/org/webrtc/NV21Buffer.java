package org.webrtc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class NV21Buffer
  implements VideoFrame.Buffer
{
  private final byte[] data;
  private final int height;
  private final RefCountDelegate refCountDelegate;
  private final int width;

  public NV21Buffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, @Nullable Runnable paramRunnable)
  {
    this.data = paramArrayOfByte;
    this.width = paramInt1;
    this.height = paramInt2;
    this.refCountDelegate = new RefCountDelegate(paramRunnable);
  }

  private static native void nativeCropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7, int paramInt8, ByteBuffer paramByteBuffer1, int paramInt9, ByteBuffer paramByteBuffer2, int paramInt10, ByteBuffer paramByteBuffer3, int paramInt11);

  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    JavaI420Buffer localJavaI420Buffer = JavaI420Buffer.allocate(paramInt5, paramInt6);
    nativeCropAndScale(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, this.data, this.width, this.height, localJavaI420Buffer.getDataY(), localJavaI420Buffer.getStrideY(), localJavaI420Buffer.getDataU(), localJavaI420Buffer.getStrideU(), localJavaI420Buffer.getDataV(), localJavaI420Buffer.getStrideV());
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
 * Qualified Name:     org.webrtc.NV21Buffer
 * JD-Core Version:    0.6.2
 */