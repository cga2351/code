package org.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class HardwareVideoDecoderFactory
  implements VideoDecoderFactory
{
  private static final String TAG = "HardwareVideoDecoderFactory";
  private final EglBase.Context sharedContext;

  @Deprecated
  public HardwareVideoDecoderFactory()
  {
    this(null);
  }

  public HardwareVideoDecoderFactory(EglBase.Context paramContext)
  {
    this.sharedContext = paramContext;
  }

  @Nullable
  private MediaCodecInfo findCodecForType(VideoCodecType paramVideoCodecType)
  {
    if (Build.VERSION.SDK_INT < 19)
      return null;
    int i = 0;
    while (i < MediaCodecList.getCodecCount())
      try
      {
        MediaCodecInfo localMediaCodecInfo2 = MediaCodecList.getCodecInfoAt(i);
        localMediaCodecInfo1 = localMediaCodecInfo2;
        if ((localMediaCodecInfo1 == null) || (localMediaCodecInfo1.isEncoder()))
          i++;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        MediaCodecInfo localMediaCodecInfo1;
        do
          while (true)
          {
            Logging.e("HardwareVideoDecoderFactory", "Cannot retrieve encoder codec info", localIllegalArgumentException);
            localMediaCodecInfo1 = null;
          }
        while (!isSupportedCodec(localMediaCodecInfo1, paramVideoCodecType));
        return localMediaCodecInfo1;
      }
    return null;
  }

  private boolean isH264HighProfileSupported(MediaCodecInfo paramMediaCodecInfo)
  {
    String str = paramMediaCodecInfo.getName();
    if ((Build.VERSION.SDK_INT >= 21) && (str.startsWith("OMX.qcom.")));
    while ((Build.VERSION.SDK_INT >= 23) && (str.startsWith("OMX.Exynos.")))
      return true;
    return false;
  }

  private boolean isHardwareSupported(MediaCodecInfo paramMediaCodecInfo, VideoCodecType paramVideoCodecType)
  {
    String str = paramMediaCodecInfo.getName();
    switch (1.$SwitchMap$org$webrtc$VideoCodecType[paramVideoCodecType.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    do
    {
      do
      {
        do
          return false;
        while ((!str.startsWith("OMX.qcom.")) && (!str.startsWith("OMX.Intel.")) && (!str.startsWith("OMX.Exynos.")) && (!str.startsWith("OMX.Nvidia.")));
        return true;
      }
      while ((!str.startsWith("OMX.qcom.")) && (!str.startsWith("OMX.Exynos.")));
      return true;
    }
    while ((!str.startsWith("OMX.qcom.")) && (!str.startsWith("OMX.Intel.")) && (!str.startsWith("OMX.Exynos.")));
    return true;
  }

  private boolean isSupportedCodec(MediaCodecInfo paramMediaCodecInfo, VideoCodecType paramVideoCodecType)
  {
    if (!MediaCodecUtils.codecSupportsType(paramMediaCodecInfo, paramVideoCodecType));
    while (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, paramMediaCodecInfo.getCapabilitiesForType(paramVideoCodecType.mimeType())) == null)
      return false;
    return isHardwareSupported(paramMediaCodecInfo, paramVideoCodecType);
  }

  public VideoDecoder createDecoder(String paramString)
  {
    return VideoDecoderFactory..CC.createDecoder(this, paramString);
  }

  @Nullable
  public VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoCodecType localVideoCodecType = VideoCodecType.valueOf(paramVideoCodecInfo.getName());
    MediaCodecInfo localMediaCodecInfo = findCodecForType(localVideoCodecType);
    if (localMediaCodecInfo == null)
      return null;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(localVideoCodecType.mimeType());
    return new HardwareVideoDecoder(new MediaCodecWrapperFactoryImpl(), localMediaCodecInfo.getName(), localVideoCodecType, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, localCodecCapabilities).intValue(), this.sharedContext);
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
 * Qualified Name:     org.webrtc.HardwareVideoDecoderFactory
 * JD-Core Version:    0.6.2
 */