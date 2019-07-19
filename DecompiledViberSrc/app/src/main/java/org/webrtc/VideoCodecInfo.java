package org.webrtc;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class VideoCodecInfo
{
  public static final String H264_CONSTRAINED_BASELINE_3_1 = "42e01f";
  public static final String H264_CONSTRAINED_HIGH_3_1 = "640c1f";
  public static final String H264_FMTP_LEVEL_ASYMMETRY_ALLOWED = "level-asymmetry-allowed";
  public static final String H264_FMTP_PACKETIZATION_MODE = "packetization-mode";
  public static final String H264_FMTP_PROFILE_LEVEL_ID = "profile-level-id";
  public static final String H264_LEVEL_3_1 = "1f";
  public static final String H264_PROFILE_CONSTRAINED_BASELINE = "42e0";
  public static final String H264_PROFILE_CONSTRAINED_HIGH = "640c";
  public final String name;
  public final Map<String, String> params;

  @Deprecated
  public final int payload;

  @Deprecated
  public VideoCodecInfo(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.payload = paramInt;
    this.name = paramString;
    this.params = paramMap;
  }

  @CalledByNative
  public VideoCodecInfo(String paramString, Map<String, String> paramMap)
  {
    this.payload = 0;
    this.name = paramString;
    this.params = paramMap;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null);
    do
    {
      return false;
      if (paramObject == this)
        return bool;
    }
    while (!(paramObject instanceof VideoCodecInfo));
    VideoCodecInfo localVideoCodecInfo = (VideoCodecInfo)paramObject;
    if ((this.name.equalsIgnoreCase(localVideoCodecInfo.name)) && (this.params.equals(localVideoCodecInfo.params)));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  @CalledByNative
  String getName()
  {
    return this.name;
  }

  @CalledByNative
  Map getParams()
  {
    return this.params;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.name.toUpperCase(Locale.ROOT);
    arrayOfObject[1] = this.params;
    return Arrays.hashCode(arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoCodecInfo
 * JD-Core Version:    0.6.2
 */