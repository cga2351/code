package com.google.android.exoplayer2.d;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public final class e
{
  public static void a(MediaFormat paramMediaFormat, ColorInfo paramColorInfo)
  {
    if (paramColorInfo != null)
    {
      a(paramMediaFormat, "color-transfer", paramColorInfo.colorTransfer);
      a(paramMediaFormat, "color-standard", paramColorInfo.colorSpace);
      a(paramMediaFormat, "color-range", paramColorInfo.colorRange);
      a(paramMediaFormat, "hdr-static-info", paramColorInfo.hdrStaticInfo);
    }
  }

  public static void a(MediaFormat paramMediaFormat, String paramString, float paramFloat)
  {
    if (paramFloat != -1.0F)
      paramMediaFormat.setFloat(paramString, paramFloat);
  }

  public static void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1)
      paramMediaFormat.setInteger(paramString, paramInt);
  }

  public static void a(MediaFormat paramMediaFormat, String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
      paramMediaFormat.setByteBuffer(paramString, ByteBuffer.wrap(paramArrayOfByte));
  }

  public static void a(MediaFormat paramMediaFormat, List<byte[]> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      paramMediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[])paramList.get(i)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.d.e
 * JD-Core Version:    0.6.2
 */