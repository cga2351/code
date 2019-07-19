package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

public class HardwareVideoEncoderFactory
  implements VideoEncoderFactory
{
  private static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList(new String[] { "SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4" });
  private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
  private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
  private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
  private static final String TAG = "HardwareVideoEncoderFactory";
  private final boolean enableH264HighProfile;
  private final boolean enableIntelVp8Encoder;

  @Nullable
  private final EglBase14.Context sharedContext;

  public HardwareVideoEncoderFactory(EglBase.Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramContext instanceof EglBase14.Context));
    for (this.sharedContext = ((EglBase14.Context)paramContext); ; this.sharedContext = null)
    {
      this.enableIntelVp8Encoder = paramBoolean1;
      this.enableH264HighProfile = paramBoolean2;
      return;
      Logging.w("HardwareVideoEncoderFactory", "No shared EglBase.Context.  Encoders will not use texture mode.");
    }
  }

  @Deprecated
  public HardwareVideoEncoderFactory(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(null, paramBoolean1, paramBoolean2);
  }

  private BitrateAdjuster createBitrateAdjuster(VideoCodecType paramVideoCodecType, String paramString)
  {
    if (paramString.startsWith("OMX.Exynos."))
    {
      if (paramVideoCodecType == VideoCodecType.VP8)
        return new DynamicBitrateAdjuster();
      return new FramerateBitrateAdjuster();
    }
    return new BaseBitrateAdjuster();
  }

  @Nullable
  private MediaCodecInfo findCodecForType(VideoCodecType paramVideoCodecType)
  {
    int i = 0;
    while (i < MediaCodecList.getCodecCount())
      try
      {
        MediaCodecInfo localMediaCodecInfo2 = MediaCodecList.getCodecInfoAt(i);
        localMediaCodecInfo1 = localMediaCodecInfo2;
        if ((localMediaCodecInfo1 == null) || (!localMediaCodecInfo1.isEncoder()))
          i++;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        MediaCodecInfo localMediaCodecInfo1;
        do
          while (true)
          {
            Logging.e("HardwareVideoEncoderFactory", "Cannot retrieve encoder codec info", localIllegalArgumentException);
            localMediaCodecInfo1 = null;
          }
        while (!isSupportedCodec(localMediaCodecInfo1, paramVideoCodecType));
        return localMediaCodecInfo1;
      }
    return null;
  }

  private int getForcedKeyFrameIntervalMs(VideoCodecType paramVideoCodecType, String paramString)
  {
    if ((paramVideoCodecType == VideoCodecType.VP8) && (paramString.startsWith("OMX.qcom.")))
    {
      if ((Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22));
      do
      {
        return 15000;
        if (Build.VERSION.SDK_INT == 23)
          return 20000;
      }
      while (Build.VERSION.SDK_INT > 23);
    }
    return 0;
  }

  private int getKeyFrameIntervalSec(VideoCodecType paramVideoCodecType)
  {
    switch (1.$SwitchMap$org$webrtc$VideoCodecType[paramVideoCodecType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unsupported VideoCodecType " + paramVideoCodecType);
    case 1:
    case 2:
      return 100;
    case 3:
    }
    return 20;
  }

  private boolean isH264HighProfileSupported(MediaCodecInfo paramMediaCodecInfo)
  {
    return (this.enableH264HighProfile) && (Build.VERSION.SDK_INT > 23) && (paramMediaCodecInfo.getName().startsWith("OMX.Exynos."));
  }

  private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo paramMediaCodecInfo, VideoCodecType paramVideoCodecType)
  {
    switch (1.$SwitchMap$org$webrtc$VideoCodecType[paramVideoCodecType.ordinal()])
    {
    default:
      return false;
    case 1:
      return isHardwareSupportedInCurrentSdkVp8(paramMediaCodecInfo);
    case 2:
      return isHardwareSupportedInCurrentSdkVp9(paramMediaCodecInfo);
    case 3:
    }
    return isHardwareSupportedInCurrentSdkH264(paramMediaCodecInfo);
  }

  private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo paramMediaCodecInfo)
  {
    if (H264_HW_EXCEPTION_MODELS.contains(Build.MODEL));
    String str;
    do
    {
      return false;
      str = paramMediaCodecInfo.getName();
    }
    while (((!str.startsWith("OMX.qcom.")) || (Build.VERSION.SDK_INT < 19)) && ((!str.startsWith("OMX.Exynos.")) || (Build.VERSION.SDK_INT < 21)));
    return true;
  }

  private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo paramMediaCodecInfo)
  {
    String str = paramMediaCodecInfo.getName();
    return ((str.startsWith("OMX.qcom.")) && (Build.VERSION.SDK_INT >= 19)) || ((str.startsWith("OMX.Exynos.")) && (Build.VERSION.SDK_INT >= 23)) || ((str.startsWith("OMX.Intel.")) && (Build.VERSION.SDK_INT >= 21) && (this.enableIntelVp8Encoder));
  }

  private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo paramMediaCodecInfo)
  {
    String str = paramMediaCodecInfo.getName();
    return ((str.startsWith("OMX.qcom.")) || (str.startsWith("OMX.Exynos."))) && (Build.VERSION.SDK_INT >= 24);
  }

  private boolean isSupportedCodec(MediaCodecInfo paramMediaCodecInfo, VideoCodecType paramVideoCodecType)
  {
    if (!MediaCodecUtils.codecSupportsType(paramMediaCodecInfo, paramVideoCodecType));
    while (MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, paramMediaCodecInfo.getCapabilitiesForType(paramVideoCodecType.mimeType())) == null)
      return false;
    return isHardwareSupportedInCurrentSdk(paramMediaCodecInfo, paramVideoCodecType);
  }

  @Nullable
  public VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoCodecType localVideoCodecType = VideoCodecType.valueOf(paramVideoCodecInfo.name);
    MediaCodecInfo localMediaCodecInfo = findCodecForType(localVideoCodecType);
    if (localMediaCodecInfo == null);
    String str1;
    Integer localInteger1;
    Integer localInteger2;
    boolean bool1;
    boolean bool2;
    do
    {
      return null;
      str1 = localMediaCodecInfo.getName();
      String str2 = localVideoCodecType.mimeType();
      localInteger1 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, localMediaCodecInfo.getCapabilitiesForType(str2));
      localInteger2 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, localMediaCodecInfo.getCapabilitiesForType(str2));
      if (localVideoCodecType != VideoCodecType.H264)
        break;
      bool1 = H264Utils.isSameH264Profile(paramVideoCodecInfo.params, MediaCodecUtils.getCodecProperties(localVideoCodecType, true));
      bool2 = H264Utils.isSameH264Profile(paramVideoCodecInfo.params, MediaCodecUtils.getCodecProperties(localVideoCodecType, false));
    }
    while (((!bool1) && (!bool2)) || ((bool1) && (!isH264HighProfileSupported(localMediaCodecInfo))));
    return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), str1, localVideoCodecType, localInteger1, localInteger2, paramVideoCodecInfo.params, getKeyFrameIntervalSec(localVideoCodecType), getForcedKeyFrameIntervalMs(localVideoCodecType, str1), createBitrateAdjuster(localVideoCodecType, str1), this.sharedContext);
  }

  public VideoCodecInfo[] getSupportedCodecs()
  {
    ArrayList localArrayList = new ArrayList();
    VideoCodecType[] arrayOfVideoCodecType = new VideoCodecType[3];
    arrayOfVideoCodecType[0] = VideoCodecType.VP8;
    arrayOfVideoCodecType[1] = VideoCodecType.VP9;
    arrayOfVideoCodecType[2] = VideoCodecType.H264;
    int i = arrayOfVideoCodecType.length;
    for (int j = 0; j < i; j++)
    {
      VideoCodecType localVideoCodecType = arrayOfVideoCodecType[j];
      MediaCodecInfo localMediaCodecInfo = findCodecForType(localVideoCodecType);
      if (localMediaCodecInfo != null)
      {
        String str = localVideoCodecType.name();
        if ((localVideoCodecType == VideoCodecType.H264) && (isH264HighProfileSupported(localMediaCodecInfo)))
          localArrayList.add(new VideoCodecInfo(str, MediaCodecUtils.getCodecProperties(localVideoCodecType, true)));
        localArrayList.add(new VideoCodecInfo(str, MediaCodecUtils.getCodecProperties(localVideoCodecType, false)));
      }
    }
    return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.HardwareVideoEncoderFactory
 * JD-Core Version:    0.6.2
 */