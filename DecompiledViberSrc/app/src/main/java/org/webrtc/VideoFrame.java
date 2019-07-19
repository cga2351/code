package org.webrtc;

import android.graphics.Matrix;
import java.nio.ByteBuffer;

public class VideoFrame
  implements RefCounted
{
  private final Buffer buffer;
  private final int rotation;
  private final long timestampNs;

  @CalledByNative
  public VideoFrame(Buffer paramBuffer, int paramInt, long paramLong)
  {
    if (paramBuffer == null)
      throw new IllegalArgumentException("buffer not allowed to be null");
    if (paramInt % 90 != 0)
      throw new IllegalArgumentException("rotation must be a multiple of 90");
    this.buffer = paramBuffer;
    this.rotation = paramInt;
    this.timestampNs = paramLong;
  }

  @CalledByNative
  public Buffer getBuffer()
  {
    return this.buffer;
  }

  public int getRotatedHeight()
  {
    if (this.rotation % 180 == 0)
      return this.buffer.getHeight();
    return this.buffer.getWidth();
  }

  public int getRotatedWidth()
  {
    if (this.rotation % 180 == 0)
      return this.buffer.getWidth();
    return this.buffer.getHeight();
  }

  @CalledByNative
  public int getRotation()
  {
    return this.rotation;
  }

  @CalledByNative
  public long getTimestampNs()
  {
    return this.timestampNs;
  }

  @CalledByNative
  public void release()
  {
    this.buffer.release();
  }

  public void retain()
  {
    this.buffer.retain();
  }

  public static abstract interface Buffer extends RefCounted
  {
    @CalledByNative("Buffer")
    public abstract Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);

    @CalledByNative("Buffer")
    public abstract int getHeight();

    @CalledByNative("Buffer")
    public abstract int getWidth();

    @CalledByNative("Buffer")
    public abstract void release();

    @CalledByNative("Buffer")
    public abstract void retain();

    @CalledByNative("Buffer")
    public abstract VideoFrame.I420Buffer toI420();
  }

  public static abstract interface I420Buffer extends VideoFrame.Buffer
  {
    @CalledByNative("I420Buffer")
    public abstract ByteBuffer getDataU();

    @CalledByNative("I420Buffer")
    public abstract ByteBuffer getDataV();

    @CalledByNative("I420Buffer")
    public abstract ByteBuffer getDataY();

    @CalledByNative("I420Buffer")
    public abstract int getStrideU();

    @CalledByNative("I420Buffer")
    public abstract int getStrideV();

    @CalledByNative("I420Buffer")
    public abstract int getStrideY();
  }

  public static abstract interface TextureBuffer extends VideoFrame.Buffer
  {
    public abstract int getTextureId();

    public abstract Matrix getTransformMatrix();

    public abstract Type getType();

    public static enum Type
    {
      private final int glTarget;

      static
      {
        Type[] arrayOfType = new Type[2];
        arrayOfType[0] = OES;
        arrayOfType[1] = RGB;
      }

      private Type(int paramInt)
      {
        this.glTarget = paramInt;
      }

      public int getGlTarget()
      {
        return this.glTarget;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoFrame
 * JD-Core Version:    0.6.2
 */