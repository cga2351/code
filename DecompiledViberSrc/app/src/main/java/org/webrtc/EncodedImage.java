package org.webrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class EncodedImage
{
  public final ByteBuffer buffer;
  public final long captureTimeMs;
  public final long captureTimeNs;
  public final boolean completeFrame;
  public final int encodedHeight;
  public final int encodedWidth;
  public final FrameType frameType;
  public final Integer qp;
  public final int rotation;

  @CalledByNative
  private EncodedImage(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong, FrameType paramFrameType, int paramInt3, boolean paramBoolean, Integer paramInteger)
  {
    this.buffer = paramByteBuffer;
    this.encodedWidth = paramInt1;
    this.encodedHeight = paramInt2;
    this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(paramLong);
    this.captureTimeNs = paramLong;
    this.frameType = paramFrameType;
    this.rotation = paramInt3;
    this.completeFrame = paramBoolean;
    this.qp = paramInteger;
  }

  public static Builder builder()
  {
    return new Builder(null);
  }

  public static class Builder
  {
    private ByteBuffer buffer;
    private long captureTimeNs;
    private boolean completeFrame;
    private int encodedHeight;
    private int encodedWidth;
    private EncodedImage.FrameType frameType;
    private Integer qp;
    private int rotation;

    public EncodedImage createEncodedImage()
    {
      return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp, null);
    }

    public Builder setBuffer(ByteBuffer paramByteBuffer)
    {
      this.buffer = paramByteBuffer;
      return this;
    }

    @Deprecated
    public Builder setCaptureTimeMs(long paramLong)
    {
      this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(paramLong);
      return this;
    }

    public Builder setCaptureTimeNs(long paramLong)
    {
      this.captureTimeNs = paramLong;
      return this;
    }

    public Builder setCompleteFrame(boolean paramBoolean)
    {
      this.completeFrame = paramBoolean;
      return this;
    }

    public Builder setEncodedHeight(int paramInt)
    {
      this.encodedHeight = paramInt;
      return this;
    }

    public Builder setEncodedWidth(int paramInt)
    {
      this.encodedWidth = paramInt;
      return this;
    }

    public Builder setFrameType(EncodedImage.FrameType paramFrameType)
    {
      this.frameType = paramFrameType;
      return this;
    }

    public Builder setQp(Integer paramInteger)
    {
      this.qp = paramInteger;
      return this;
    }

    public Builder setRotation(int paramInt)
    {
      this.rotation = paramInt;
      return this;
    }
  }

  public static enum FrameType
  {
    private final int nativeIndex;

    static
    {
      VideoFrameDelta = new FrameType("VideoFrameDelta", 2, 4);
      FrameType[] arrayOfFrameType = new FrameType[3];
      arrayOfFrameType[0] = EmptyFrame;
      arrayOfFrameType[1] = VideoFrameKey;
      arrayOfFrameType[2] = VideoFrameDelta;
    }

    private FrameType(int paramInt)
    {
      this.nativeIndex = paramInt;
    }

    @CalledByNative("FrameType")
    static FrameType fromNativeIndex(int paramInt)
    {
      for (FrameType localFrameType : values())
        if (localFrameType.getNative() == paramInt)
          return localFrameType;
      throw new IllegalArgumentException("Unknown native frame type: " + paramInt);
    }

    public int getNative()
    {
      return this.nativeIndex;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.EncodedImage
 * JD-Core Version:    0.6.2
 */