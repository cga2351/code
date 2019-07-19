package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@TargetApi(18)
class MediaCodecUtils
{
  static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
  static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
  static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
  static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
  static final int[] DECODER_COLOR_FORMATS = { 19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876 };
  static final int[] ENCODER_COLOR_FORMATS = { 19, 21, 2141391872, 2141391876 };
  static final String EXYNOS_PREFIX = "OMX.Exynos.";
  static final String INTEL_PREFIX = "OMX.Intel.";
  static final String NVIDIA_PREFIX = "OMX.Nvidia.";
  static final String QCOM_PREFIX = "OMX.qcom.";
  private static final String TAG = "MediaCodecUtils";
  static final int[] TEXTURE_COLOR_FORMATS = { 2130708361 };

  static boolean codecSupportsType(MediaCodecInfo paramMediaCodecInfo, VideoCodecType paramVideoCodecType)
  {
    String[] arrayOfString = paramMediaCodecInfo.getSupportedTypes();
    int i = arrayOfString.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        String str = arrayOfString[j];
        if (paramVideoCodecType.mimeType().equals(str))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  static Map<String, String> getCodecProperties(VideoCodecType paramVideoCodecType, boolean paramBoolean)
  {
    switch (1.$SwitchMap$org$webrtc$VideoCodecType[paramVideoCodecType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unsupported codec: " + paramVideoCodecType);
    case 1:
    case 2:
      return new HashMap();
    case 3:
    }
    return H264Utils.getDefaultH264Params(paramBoolean);
  }

  @Nullable
  static Integer selectColorFormat(int[] paramArrayOfInt, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      for (int i1 : paramCodecCapabilities.colorFormats)
        if (i1 == k)
          return Integer.valueOf(i1);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaCodecUtils
 * JD-Core Version:    0.6.2
 */