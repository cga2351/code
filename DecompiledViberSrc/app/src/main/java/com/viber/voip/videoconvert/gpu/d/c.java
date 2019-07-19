package com.viber.voip.videoconvert.gpu.d;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;

@TargetApi(16)
public class c
{
  public static b a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    String str = paramMediaCodecInfo.getName();
    if (str.startsWith("OMX.SEC.avc.enc"))
      return new g(paramMediaCodecInfo, paramString, paramInt);
    if (str.startsWith("OMX.IMG.TOPAZ.VIDEO.Encoder"))
      return new h(paramMediaCodecInfo, paramString, paramInt);
    if (str.startsWith("OMX.qcom.video.encoder.avc"))
      return new f(paramMediaCodecInfo, paramString, paramInt);
    if (str.startsWith("OMX.Nvidia.h264.encoder"))
      return new e(paramMediaCodecInfo, paramString, paramInt);
    if (str.startsWith("OMX.MTK.VIDEO.ENCODER"))
      return new d(paramMediaCodecInfo, paramString, paramInt);
    return new a(paramMediaCodecInfo, paramString, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.d.c
 * JD-Core Version:    0.6.2
 */