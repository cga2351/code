package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzki
{
  private static final byte[] zzaqt = { 0, 0, 0, 1 };
  private static final int[] zzaqu = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] zzaqv = { 0, 1, 2, 3, 4, 5, 6, 8 };

  public static byte[] zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2 + zzaqt.length];
    System.arraycopy(zzaqt, 0, arrayOfByte, 0, zzaqt.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, zzaqt.length, paramInt2);
    return arrayOfByte;
  }

  public static Pair<Integer, Integer> zzd(byte[] paramArrayOfByte)
  {
    boolean bool1 = true;
    int i = 0x1F & paramArrayOfByte[0] >> 3;
    boolean bool2;
    int j;
    if ((i == 5) || (i == 29))
    {
      bool2 = bool1;
      j = (0x7 & paramArrayOfByte[bool2]) << 1 | 0x1 & paramArrayOfByte[(bool2 + true)] >> 7;
      if (j >= 13)
        break label95;
    }
    while (true)
    {
      zzkh.checkState(bool1);
      int k = zzaqu[j];
      int m = 0xF & paramArrayOfByte[(bool2 + true)] >> 3;
      return Pair.create(Integer.valueOf(k), Integer.valueOf(m));
      bool2 = false;
      break;
      label95: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzki
 * JD-Core Version:    0.6.2
 */