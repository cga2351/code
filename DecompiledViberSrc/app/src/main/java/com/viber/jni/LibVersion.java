package com.viber.jni;

public class LibVersion
{
  private static String ClientCoreVersion;
  private static String InterfacesVersion;
  private static String VoiceLibVersion;
  private static String WebRTCVersion;

  public static String getClientCoreVersion()
  {
    return ClientCoreVersion;
  }

  public static String getInterfacesVersion()
  {
    return InterfacesVersion;
  }

  public static String getNativeVersionString()
  {
    return "VoiceLib:" + VoiceLibVersion + ";  ClientCore:" + ClientCoreVersion + ";  WebRTC:" + WebRTCVersion + ";  interfaces:" + InterfacesVersion;
  }

  public static String getVoiceLibVersion()
  {
    return VoiceLibVersion;
  }

  public static String getWebRTCVersion()
  {
    return WebRTCVersion;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.LibVersion
 * JD-Core Version:    0.6.2
 */