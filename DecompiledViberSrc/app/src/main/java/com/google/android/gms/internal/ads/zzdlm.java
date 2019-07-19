package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzdlm
{
  private static void zza(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      paramArrayOfByte[(paramInt + i)] = ((byte)(int)(0xFF & paramLong));
      i++;
      paramLong >>= 8;
    }
  }

  private static long zze(byte[] paramArrayOfByte, int paramInt)
  {
    return 0xFFFFFFFF & (0xFF & paramArrayOfByte[paramInt] | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 8 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 3)]) << 24);
  }

  static byte[] zzf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != 32)
      throw new IllegalArgumentException("The key length in bytes must be 32.");
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0x3FFFFFF & zzg(paramArrayOfByte1, 0, 0);
    long l7 = 0x3FFFF03 & zzg(paramArrayOfByte1, 3, 2);
    long l8 = 0x3FFC0FF & zzg(paramArrayOfByte1, 6, 4);
    long l9 = 0x3F03FFF & zzg(paramArrayOfByte1, 9, 6);
    long l10 = 0xFFFFF & zzg(paramArrayOfByte1, 12, 8);
    long l11 = l7 * 5L;
    long l12 = l8 * 5L;
    long l13 = l9 * 5L;
    long l14 = l10 * 5L;
    byte[] arrayOfByte1 = new byte[17];
    for (int i = 0; i < paramArrayOfByte2.length; i += 16)
    {
      int j = Math.min(16, paramArrayOfByte2.length - i);
      System.arraycopy(paramArrayOfByte2, i, arrayOfByte1, 0, j);
      arrayOfByte1[j] = 1;
      if (j != 16)
        Arrays.fill(arrayOfByte1, j + 1, 17, (byte)0);
      long l66 = l1 + zzg(arrayOfByte1, 0, 0);
      long l67 = l2 + zzg(arrayOfByte1, 3, 2);
      long l68 = l3 + zzg(arrayOfByte1, 6, 4);
      long l69 = l4 + zzg(arrayOfByte1, 9, 6);
      long l70 = l5 + (zzg(arrayOfByte1, 12, 8) | arrayOfByte1[16] << 24);
      long l71 = l66 * l6 + l67 * l14 + l68 * l13 + l69 * l12 + l70 * l11;
      long l72 = l66 * l7 + l67 * l6 + l68 * l14 + l69 * l13 + l70 * l12;
      long l73 = l66 * l8 + l67 * l7 + l68 * l6 + l69 * l14 + l70 * l13;
      long l74 = l66 * l9 + l67 * l8 + l68 * l7 + l69 * l6 + l70 * l14;
      long l75 = l66 * l10 + l67 * l9 + l68 * l8 + l69 * l7 + l70 * l6;
      long l76 = l71 >> 26;
      long l77 = l71 & 0x3FFFFFF;
      long l78 = l76 + l72;
      long l79 = l78 >> 26;
      long l80 = l78 & 0x3FFFFFF;
      long l81 = l73 + l79;
      long l82 = l81 >> 26;
      l3 = 0x3FFFFFF & l81;
      long l83 = l74 + l82;
      long l84 = l83 >> 26;
      l4 = l83 & 0x3FFFFFF;
      long l85 = l75 + l84;
      long l86 = l85 >> 26;
      l5 = l85 & 0x3FFFFFF;
      long l87 = l77 + l86 * 5L;
      long l88 = l87 >> 26;
      l1 = 0x3FFFFFF & l87;
      l2 = l80 + l88;
    }
    long l15 = l2 >> 26;
    long l16 = l2 & 0x3FFFFFF;
    long l17 = l15 + l3;
    long l18 = l17 >> 26;
    long l19 = l17 & 0x3FFFFFF;
    long l20 = l4 + l18;
    long l21 = l20 >> 26;
    long l22 = l20 & 0x3FFFFFF;
    long l23 = l5 + l21;
    long l24 = l23 >> 26;
    long l25 = l23 & 0x3FFFFFF;
    long l26 = l1 + l24 * 5L;
    long l27 = l26 >> 26;
    long l28 = l26 & 0x3FFFFFF;
    long l29 = l16 + l27;
    long l30 = 5L + l28;
    long l31 = l30 >> 26;
    long l32 = l30 & 0x3FFFFFF;
    long l33 = l31 + l29;
    long l34 = l33 >> 26;
    long l35 = l33 & 0x3FFFFFF;
    long l36 = l34 + l19;
    long l37 = l36 >> 26;
    long l38 = l36 & 0x3FFFFFF;
    long l39 = l37 + l22;
    long l40 = l39 >> 26;
    long l41 = l39 & 0x3FFFFFF;
    long l42 = l40 + l25 - 67108864L;
    long l43 = l42 >> 63;
    long l44 = l28 & l43;
    long l45 = l29 & l43;
    long l46 = l19 & l43;
    long l47 = l22 & l43;
    long l48 = l25 & l43;
    long l49 = l43 ^ 0xFFFFFFFF;
    long l50 = l44 | l32 & l49;
    long l51 = l45 | l35 & l49;
    long l52 = l46 | l38 & l49;
    long l53 = l47 | l41 & l49;
    long l54 = l48 | l42 & l49;
    long l55 = 0xFFFFFFFF & (l50 | l51 << 26);
    long l56 = 0xFFFFFFFF & (l51 >> 6 | l52 << 20);
    long l57 = 0xFFFFFFFF & (l52 >> 12 | l53 << 14);
    long l58 = 0xFFFFFFFF & (l53 >> 18 | l54 << 8);
    long l59 = l55 + zze(paramArrayOfByte1, 16);
    long l60 = 0xFFFFFFFF & l59;
    long l61 = l56 + zze(paramArrayOfByte1, 20) + (l59 >> 32);
    long l62 = 0xFFFFFFFF & l61;
    long l63 = l57 + zze(paramArrayOfByte1, 24) + (l61 >> 32);
    long l64 = 0xFFFFFFFF & l63;
    long l65 = 0xFFFFFFFF & l58 + zze(paramArrayOfByte1, 28) + (l63 >> 32);
    byte[] arrayOfByte2 = new byte[16];
    zza(arrayOfByte2, l60, 0);
    zza(arrayOfByte2, l62, 4);
    zza(arrayOfByte2, l64, 8);
    zza(arrayOfByte2, l65, 12);
    return arrayOfByte2;
  }

  private static long zzg(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0x3FFFFFF & zze(paramArrayOfByte, paramInt1) >> paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdlm
 * JD-Core Version:    0.6.2
 */