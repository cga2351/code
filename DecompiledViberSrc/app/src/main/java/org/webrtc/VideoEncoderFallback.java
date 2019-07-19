package org.webrtc;

public class VideoEncoderFallback extends WrappedNativeVideoEncoder
{
  private final VideoEncoder fallback;
  private final VideoEncoder primary;

  public VideoEncoderFallback(VideoEncoder paramVideoEncoder1, VideoEncoder paramVideoEncoder2)
  {
    this.fallback = paramVideoEncoder1;
    this.primary = paramVideoEncoder2;
  }

  private static native long nativeCreateEncoder(VideoEncoder paramVideoEncoder1, VideoEncoder paramVideoEncoder2);

  public long createNativeVideoEncoder()
  {
    return nativeCreateEncoder(this.fallback, this.primary);
  }

  public boolean isHardwareEncoder()
  {
    return this.primary.isHardwareEncoder();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoEncoderFallback
 * JD-Core Version:    0.6.2
 */