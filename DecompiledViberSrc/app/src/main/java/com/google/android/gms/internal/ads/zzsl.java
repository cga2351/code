package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzsl
{
  private static final byte[] zzaqt = { 0, 0, 0, 1 };
  private static final int[] zzaqu = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] zzaqv = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };

  private static int zza(zzss paramzzss)
  {
    int i = paramzzss.zzbn(5);
    if (i == 31)
      i = 32 + paramzzss.zzbn(6);
    return i;
  }

  public static byte[] zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2 + zzaqt.length];
    System.arraycopy(zzaqt, 0, arrayOfByte, 0, zzaqt.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, zzaqt.length, paramInt2);
    return arrayOfByte;
  }

  private static int zzb(zzss paramzzss)
  {
    int i = paramzzss.zzbn(4);
    if (i == 15)
      return paramzzss.zzbn(24);
    if (i < 13);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      return zzaqu[i];
    }
  }

  public static Pair<Integer, Integer> zzf(byte[] paramArrayOfByte)
  {
    zzss localzzss = new zzss(paramArrayOfByte);
    int i = zza(localzzss);
    int j = zzb(localzzss);
    int k = localzzss.zzbn(4);
    if ((i == 5) || (i == 29))
    {
      j = zzb(localzzss);
      if (zza(localzzss) == 22)
        k = localzzss.zzbn(4);
    }
    int m = zzaqv[k];
    if (m != -1);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      return Pair.create(Integer.valueOf(j), Integer.valueOf(m));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsl
 * JD-Core Version:    0.6.2
 */