package com.viber.jni.webrtc;

import java.nio.Buffer;

public class SdpCompressor
{
  public static native int compressSdp(String paramString, Buffer paramBuffer);

  public static native String decompressSdp(Buffer paramBuffer, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.webrtc.SdpCompressor
 * JD-Core Version:    0.6.2
 */