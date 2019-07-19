package com.google.android.gms.internal.ads;

import java.util.Collections;

public final class zzkg
{
  private static final int[] zzaqp = { 48000, 44100, 32000 };
  private static final int[] zzaqq = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] zzaqr = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] zzaqs = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };

  public static int zza(int paramInt1, int paramInt2)
  {
    return (768000 + paramInt2 * (paramInt1 << 3)) / 1536000;
  }

  public static zzhj zza(zzkm paramzzkm)
  {
    int i = (0xC0 & paramzzkm.readUnsignedByte()) >> 6;
    int j = zzaqp[i];
    int k = paramzzkm.readUnsignedByte();
    int m = zzaqq[((k & 0x38) >> 3)];
    if ((k & 0x4) != 0)
      m++;
    return zzhj.zzb("audio/ac3", -1, -1L, m, j, Collections.emptyList());
  }

  public static zzhj zzb(zzkm paramzzkm)
  {
    paramzzkm.zzac(2);
    int i = (0xC0 & paramzzkm.readUnsignedByte()) >> 6;
    int j = zzaqp[i];
    int k = paramzzkm.readUnsignedByte();
    int m = zzaqq[((k & 0xE) >> 1)];
    if ((k & 0x1) != 0)
      m++;
    return zzhj.zza("audio/eac3", -1, m, j, Collections.emptyList());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzkg
 * JD-Core Version:    0.6.2
 */