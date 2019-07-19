package org.webrtc;

class VP9Decoder extends WrappedNativeVideoDecoder
{
  static native long nativeCreateDecoder();

  static native boolean nativeIsSupported();

  public long createNativeVideoDecoder()
  {
    return nativeCreateDecoder();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VP9Decoder
 * JD-Core Version:    0.6.2
 */