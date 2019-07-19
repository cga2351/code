package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzmr
{
  private static final int[] zzaxn = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final int[] zzaxo = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int[] zzaxp = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };

  public static int zzj(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    return 1 + ((0x1 & paramByteBuffer.get(i + 4)) << 6 | (0xFC & paramByteBuffer.get(i + 5)) >> 2) << 5;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmr
 * JD-Core Version:    0.6.2
 */