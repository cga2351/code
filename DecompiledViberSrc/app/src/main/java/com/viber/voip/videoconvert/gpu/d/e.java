package com.viber.voip.videoconvert.gpu.d;

import android.media.MediaCodecInfo;
import com.viber.voip.videoconvert.gpu.encoders.c.b;

public class e extends a
{
  boolean e;

  public e(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    super(paramMediaCodecInfo, paramString, paramInt);
  }

  public c.b c()
  {
    if (!this.e)
    {
      com.viber.voip.videoconvert.e.a().a("forcing I420 input format for NVidia");
      this.e = true;
    }
    return c.b.g;
  }

  public int f()
  {
    return 16;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.d.e
 * JD-Core Version:    0.6.2
 */