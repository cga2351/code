package org.webrtc;

abstract class WrappedNativeVideoDecoder
  implements VideoDecoder
{
  public abstract long createNativeVideoDecoder();

  public VideoCodecStatus decode(EncodedImage paramEncodedImage, VideoDecoder.DecodeInfo paramDecodeInfo)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public String getImplementationName()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public boolean getPrefersLateDecoding()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public VideoCodecStatus initDecode(VideoDecoder.Settings paramSettings, VideoDecoder.Callback paramCallback)
  {
    throw new UnsupportedOperationException("Not implemented.");
  }

  public VideoCodecStatus release()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.WrappedNativeVideoDecoder
 * JD-Core Version:    0.6.2
 */