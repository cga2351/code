package org.webrtc;

class VP8Encoder extends WrappedNativeVideoEncoder
{
  static native long nativeCreateEncoder();

  public long createNativeVideoEncoder()
  {
    return nativeCreateEncoder();
  }

  public boolean isHardwareEncoder()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VP8Encoder
 * JD-Core Version:    0.6.2
 */