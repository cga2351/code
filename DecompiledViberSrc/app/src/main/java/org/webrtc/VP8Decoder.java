package org.webrtc;

class VP8Decoder extends WrappedNativeVideoDecoder
{
  static native long nativeCreateDecoder();

  public long createNativeVideoDecoder()
  {
    return nativeCreateDecoder();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VP8Decoder
 * JD-Core Version:    0.6.2
 */