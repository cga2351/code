package org.webrtc;

import javax.annotation.Nullable;

public abstract class VideoDecoderFactory$$CC
{
  @Deprecated
  @Nullable
  public static VideoDecoder createDecoder(VideoDecoderFactory arg0, String arg1)
  {
  }

  @Nullable
  @CalledByNative
  public static VideoDecoder createDecoder(VideoDecoderFactory arg0, VideoCodecInfo arg1)
  {
  }

  @CalledByNative
  public static VideoCodecInfo[] getSupportedCodecs(VideoDecoderFactory arg0)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoDecoderFactory..CC
 * JD-Core Version:    0.6.2
 */