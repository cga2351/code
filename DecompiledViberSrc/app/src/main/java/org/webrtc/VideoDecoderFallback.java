package org.webrtc;

public class VideoDecoderFallback extends WrappedNativeVideoDecoder
{
  private final VideoDecoder fallback;
  private final VideoDecoder primary;

  public VideoDecoderFallback(VideoDecoder paramVideoDecoder1, VideoDecoder paramVideoDecoder2)
  {
    this.fallback = paramVideoDecoder1;
    this.primary = paramVideoDecoder2;
  }

  private static native long nativeCreateDecoder(VideoDecoder paramVideoDecoder1, VideoDecoder paramVideoDecoder2);

  public long createNativeVideoDecoder()
  {
    return nativeCreateDecoder(this.fallback, this.primary);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoDecoderFallback
 * JD-Core Version:    0.6.2
 */