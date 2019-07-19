package com.viber.voip.videoconvert.gpu.d;

import android.media.MediaCodecInfo;
import android.os.Build.VERSION;

public class f extends a
{
  public f(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    super(paramMediaCodecInfo, paramString, paramInt);
  }

  public int d()
  {
    if (Build.VERSION.SDK_INT < 18)
      return 2048;
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.d.f
 * JD-Core Version:    0.6.2
 */