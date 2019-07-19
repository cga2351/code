package org.webrtc;

import java.util.HashMap;
import java.util.Map;

class H264Utils
{
  public static VideoCodecInfo DEFAULT_H264_BASELINE_PROFILE_CODEC = new VideoCodecInfo("H264", getDefaultH264Params(false));
  public static VideoCodecInfo DEFAULT_H264_HIGH_PROFILE_CODEC = new VideoCodecInfo("H264", getDefaultH264Params(true));
  public static final String H264_CONSTRAINED_BASELINE_3_1 = "42e01f";
  public static final String H264_CONSTRAINED_HIGH_3_1 = "640c1f";
  public static final String H264_FMTP_LEVEL_ASYMMETRY_ALLOWED = "level-asymmetry-allowed";
  public static final String H264_FMTP_PACKETIZATION_MODE = "packetization-mode";
  public static final String H264_FMTP_PROFILE_LEVEL_ID = "profile-level-id";
  public static final String H264_LEVEL_3_1 = "1f";
  public static final String H264_PROFILE_CONSTRAINED_BASELINE = "42e0";
  public static final String H264_PROFILE_CONSTRAINED_HIGH = "640c";

  public static Map<String, String> getDefaultH264Params(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("level-asymmetry-allowed", "1");
    localHashMap.put("packetization-mode", "1");
    if (paramBoolean);
    for (String str = "640c1f"; ; str = "42e01f")
    {
      localHashMap.put("profile-level-id", str);
      return localHashMap;
    }
  }

  public static boolean isSameH264Profile(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    return nativeIsSameH264Profile(paramMap1, paramMap2);
  }

  private static native boolean nativeIsSameH264Profile(Map<String, String> paramMap1, Map<String, String> paramMap2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.H264Utils
 * JD-Core Version:    0.6.2
 */