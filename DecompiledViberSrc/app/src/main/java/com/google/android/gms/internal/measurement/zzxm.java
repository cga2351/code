package com.google.android.gms.internal.measurement;

final class zzxm
{
  private static void zza(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, char[] paramArrayOfChar, int paramInt)
    throws zzuv
  {
    if ((zzg(paramByte2)) || ((paramByte1 << 28) + (paramByte2 + 112) >> 30 != 0) || (zzg(paramByte3)) || (zzg(paramByte4)))
      throw zzuv.zzwx();
    int i = (paramByte1 & 0x7) << 18 | (paramByte2 & 0x3F) << 12 | (paramByte3 & 0x3F) << 6 | paramByte4 & 0x3F;
    paramArrayOfChar[paramInt] = ((char)(55232 + (i >>> 10)));
    paramArrayOfChar[(paramInt + 1)] = ((char)(56320 + (i & 0x3FF)));
  }

  private static void zza(byte paramByte1, byte paramByte2, byte paramByte3, char[] paramArrayOfChar, int paramInt)
    throws zzuv
  {
    if ((zzg(paramByte2)) || ((paramByte1 == -32) && (paramByte2 < -96)) || ((paramByte1 == -19) && (paramByte2 >= -96)) || (zzg(paramByte3)))
      throw zzuv.zzwx();
    paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0xF) << 12 | (paramByte2 & 0x3F) << 6 | paramByte3 & 0x3F));
  }

  private static void zza(byte paramByte1, byte paramByte2, char[] paramArrayOfChar, int paramInt)
    throws zzuv
  {
    if ((paramByte1 < -62) || (zzg(paramByte2)))
      throw zzuv.zzwx();
    paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0x1F) << 6 | paramByte2 & 0x3F));
  }

  private static void zza(byte paramByte, char[] paramArrayOfChar, int paramInt)
  {
    paramArrayOfChar[paramInt] = ((char)paramByte);
  }

  private static boolean zzd(byte paramByte)
  {
    return paramByte >= 0;
  }

  private static boolean zze(byte paramByte)
  {
    return paramByte < -32;
  }

  private static boolean zzf(byte paramByte)
  {
    return paramByte < -16;
  }

  private static boolean zzg(byte paramByte)
  {
    return paramByte > -65;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxm
 * JD-Core Version:    0.6.2
 */