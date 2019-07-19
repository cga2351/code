package org.webrtc;

class WebRtcClassLoader
{
  @CalledByNative
  static Object getClassLoader()
  {
    return WebRtcClassLoader.class.getClassLoader();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.WebRtcClassLoader
 * JD-Core Version:    0.6.2
 */