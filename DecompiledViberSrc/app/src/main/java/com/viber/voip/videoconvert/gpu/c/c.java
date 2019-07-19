package com.viber.voip.videoconvert.gpu.c;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import com.viber.voip.videoconvert.gpu.a.c.b;
import java.util.Iterator;
import java.util.List;

@TargetApi(16)
public class c
{
  public static b a(long paramLong1, long paramLong2)
  {
    com.viber.voip.videoconvert.gpu.a.c localc = new com.viber.voip.videoconvert.gpu.a.c();
    localc.a(new c.b());
    List localList = localc.a();
    com.viber.voip.videoconvert.e.a().a("media decoders on this device:");
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      MediaCodecInfo localMediaCodecInfo2 = (MediaCodecInfo)localIterator1.next();
      com.viber.voip.videoconvert.e.a().a("\t" + localMediaCodecInfo2.getName());
    }
    Iterator localIterator2 = localList.iterator();
    while (localIterator2.hasNext())
    {
      MediaCodecInfo localMediaCodecInfo1 = (MediaCodecInfo)localIterator2.next();
      if (localMediaCodecInfo1.getName().equalsIgnoreCase("OMX.TI.DUCATI1.VIDEO.DECODER"))
        return new h(paramLong1, paramLong2);
      if (localMediaCodecInfo1.getName().equalsIgnoreCase("OMX.Intel.VideoDecoder.AVC"))
        return new e(paramLong1, paramLong2);
      if (localMediaCodecInfo1.getName().equalsIgnoreCase("OMX.Intel.hw_vd.h264"))
        return new d(paramLong1, paramLong2);
      if (localMediaCodecInfo1.getName().equalsIgnoreCase("OMX.Nvidia.h264.decode"))
        return new g(paramLong1, paramLong2);
      if (localMediaCodecInfo1.getName().equalsIgnoreCase("OMX.MTK.VIDEO.DECODER.AVC"))
        return new f(paramLong1, paramLong2);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.c.c
 * JD-Core Version:    0.6.2
 */