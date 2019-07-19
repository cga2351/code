package org.webrtc;

class VP9Encoder extends WrappedNativeVideoEncoder
{
  static native long nativeCreateEncoder();

  static native boolean nativeIsSupported();

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
 * Qualified Name:     org.webrtc.VP9Encoder
 * JD-Core Version:    0.6.2
 */