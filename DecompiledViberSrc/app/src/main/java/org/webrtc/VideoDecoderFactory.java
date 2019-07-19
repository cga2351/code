package org.webrtc;

import javax.annotation.Nullable;

public abstract interface VideoDecoderFactory
{
  @Deprecated
  @Nullable
  public abstract VideoDecoder createDecoder(String paramString);

  @Nullable
  @CalledByNative
  public abstract VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo);

  @CalledByNative
  public abstract VideoCodecInfo[] getSupportedCodecs();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoDecoderFactory
 * JD-Core Version:    0.6.2
 */