package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzlv
{
  private static final int[] zzauy = { 1, 2, 3, 6 };
  private static final int[] zzauz = { 48000, 44100, 32000 };
  private static final int[] zzava = { 24000, 22050, 16000 };
  private static final int[] zzavb = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] zzavc = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] zzavd = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };

  public static zzlh zza(zzst paramzzst, String paramString1, String paramString2, zzne paramzzne)
  {
    int i = (0xC0 & paramzzst.readUnsignedByte()) >> 6;
    int j = zzauz[i];
    int k = paramzzst.readUnsignedByte();
    int m = zzavb[((k & 0x38) >> 3)];
    if ((k & 0x4) != 0)
      m++;
    return zzlh.zza(paramString1, "audio/ac3", null, -1, -1, m, j, null, null, 0, paramString2);
  }

  public static zzlh zzb(zzst paramzzst, String paramString1, String paramString2, zzne paramzzne)
  {
    paramzzst.zzac(2);
    int i = (0xC0 & paramzzst.readUnsignedByte()) >> 6;
    int j = zzauz[i];
    int k = paramzzst.readUnsignedByte();
    int m = zzavb[((k & 0xE) >> 1)];
    if ((k & 0x1) != 0)
      m++;
    return zzlh.zza(paramString1, "audio/eac3", null, -1, -1, m, j, null, null, 0, paramString2);
  }

  public static int zzh(ByteBuffer paramByteBuffer)
  {
    if ((0xC0 & paramByteBuffer.get(4 + paramByteBuffer.position())) >> 6 == 3);
    for (int i = 6; ; i = zzauy[((0x30 & paramByteBuffer.get(4 + paramByteBuffer.position())) >> 4)])
      return i * 256;
  }

  public static int zzhi()
  {
    return 1536;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzlv
 * JD-Core Version:    0.6.2
 */