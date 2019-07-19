package com.google.android.gms.internal.ads;

final class zzdrb
{
  private static void zza(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, char[] paramArrayOfChar, int paramInt)
    throws zzdoj
  {
    if ((zzh(paramByte2)) || ((paramByte1 << 28) + (paramByte2 + 112) >> 30 != 0) || (zzh(paramByte3)) || (zzh(paramByte4)))
      throw zzdoj.zzayk();
    int i = (paramByte1 & 0x7) << 18 | (paramByte2 & 0x3F) << 12 | (paramByte3 & 0x3F) << 6 | paramByte4 & 0x3F;
    paramArrayOfChar[paramInt] = ((char)(55232 + (i >>> 10)));
    paramArrayOfChar[(paramInt + 1)] = ((char)(56320 + (i & 0x3FF)));
  }

  private static void zza(byte paramByte1, byte paramByte2, byte paramByte3, char[] paramArrayOfChar, int paramInt)
    throws zzdoj
  {
    if ((zzh(paramByte2)) || ((paramByte1 == -32) && (paramByte2 < -96)) || ((paramByte1 == -19) && (paramByte2 >= -96)) || (zzh(paramByte3)))
      throw zzdoj.zzayk();
    paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0xF) << 12 | (paramByte2 & 0x3F) << 6 | paramByte3 & 0x3F));
  }

  private static void zza(byte paramByte1, byte paramByte2, char[] paramArrayOfChar, int paramInt)
    throws zzdoj
  {
    if ((paramByte1 < -62) || (zzh(paramByte2)))
      throw zzdoj.zzayk();
    paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0x1F) << 6 | paramByte2 & 0x3F));
  }

  private static void zza(byte paramByte, char[] paramArrayOfChar, int paramInt)
  {
    paramArrayOfChar[paramInt] = ((char)paramByte);
  }

  private static boolean zze(byte paramByte)
  {
    return paramByte >= 0;
  }

  private static boolean zzf(byte paramByte)
  {
    return paramByte < -32;
  }

  private static boolean zzg(byte paramByte)
  {
    return paramByte < -16;
  }

  private static boolean zzh(byte paramByte)
  {
    return paramByte > -65;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdrb
 * JD-Core Version:    0.6.2
 */