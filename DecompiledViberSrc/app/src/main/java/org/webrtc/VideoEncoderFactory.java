package org.webrtc;

import javax.annotation.Nullable;

public abstract interface VideoEncoderFactory
{
  @Nullable
  @CalledByNative
  public abstract VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo);

  @CalledByNative
  public abstract VideoCodecInfo[] getSupportedCodecs();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoEncoderFactory
 * JD-Core Version:    0.6.2
 */