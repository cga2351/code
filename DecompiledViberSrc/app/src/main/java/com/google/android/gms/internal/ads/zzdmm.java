package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzdmm
{
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzdmn paramzzdmn)
    throws zzdoj
  {
    if (paramInt1 >>> 3 == 0)
      throw zzdoj.zzayg();
    int n;
    switch (paramInt1 & 0x7)
    {
    case 4:
    default:
      throw zzdoj.zzayg();
    case 0:
      n = zzb(paramArrayOfByte, paramInt2, paramzzdmn);
    case 5:
    case 1:
    case 2:
    case 3:
    }
    int i;
    int m;
    do
    {
      return n;
      return paramInt2 + 4;
      return paramInt2 + 8;
      return zza(paramArrayOfByte, paramInt2, paramzzdmn) + paramzzdmn.zzhcl;
      i = 0x4 | paramInt1 & 0xFFFFFFF8;
      int j = 0;
      for (int k = paramInt2; k < paramInt3; k = zza(j, paramArrayOfByte, k, paramInt3, paramzzdmn))
      {
        k = zza(paramArrayOfByte, k, paramzzdmn);
        j = paramzzdmn.zzhcl;
        if (j == i)
          break;
      }
      m = j;
      n = k;
    }
    while ((n <= paramInt3) && (m == i));
    throw zzdoj.zzayj();
  }

  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzdoi<?> paramzzdoi, zzdmn paramzzdmn)
  {
    zzdob localzzdob = (zzdob)paramzzdoi;
    int i = zza(paramArrayOfByte, paramInt2, paramzzdmn);
    localzzdob.zzgp(paramzzdmn.zzhcl);
    while (i < paramInt3)
    {
      int j = zza(paramArrayOfByte, i, paramzzdmn);
      if (paramInt1 != paramzzdmn.zzhcl)
        break;
      i = zza(paramArrayOfByte, j, paramzzdmn);
      localzzdob.zzgp(paramzzdmn.zzhcl);
    }
    return i;
  }

  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzdqt paramzzdqt, zzdmn paramzzdmn)
    throws zzdoj
  {
    if (paramInt1 >>> 3 == 0)
      throw zzdoj.zzayg();
    switch (paramInt1 & 0x7)
    {
    case 4:
    default:
      throw zzdoj.zzayg();
    case 0:
      int i3 = zzb(paramArrayOfByte, paramInt2, paramzzdmn);
      paramzzdqt.zzc(paramInt1, Long.valueOf(paramzzdmn.zzhcm));
      return i3;
    case 5:
      paramzzdqt.zzc(paramInt1, Integer.valueOf(zzf(paramArrayOfByte, paramInt2)));
      return paramInt2 + 4;
    case 1:
      paramzzdqt.zzc(paramInt1, Long.valueOf(zzg(paramArrayOfByte, paramInt2)));
      return paramInt2 + 8;
    case 2:
      int i1 = zza(paramArrayOfByte, paramInt2, paramzzdmn);
      int i2 = paramzzdmn.zzhcl;
      if (i2 < 0)
        throw zzdoj.zzaye();
      if (i2 > paramArrayOfByte.length - i1)
        throw zzdoj.zzayd();
      if (i2 == 0)
        paramzzdqt.zzc(paramInt1, zzdmq.zzhcr);
      while (true)
      {
        return i1 + i2;
        paramzzdqt.zzc(paramInt1, zzdmq.zzi(paramArrayOfByte, i1, i2));
      }
    case 3:
    }
    zzdqt localzzdqt = zzdqt.zzbaa();
    int i = 0x4 | paramInt1 & 0xFFFFFFF8;
    int j = 0;
    for (int k = paramInt2; k < paramInt3; k = zza(j, paramArrayOfByte, k, paramInt3, localzzdqt, paramzzdmn))
    {
      k = zza(paramArrayOfByte, k, paramzzdmn);
      j = paramzzdmn.zzhcl;
      if (j == i)
        break;
    }
    int m = j;
    int n = k;
    if ((n > paramInt3) || (m != i))
      throw zzdoj.zzayj();
    paramzzdqt.zzc(paramInt1, localzzdqt);
    return n;
  }

  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, zzdmn paramzzdmn)
  {
    int i = paramInt1 & 0x7F;
    int j = paramInt2 + 1;
    int k = paramArrayOfByte[paramInt2];
    if (k >= 0)
    {
      paramzzdmn.zzhcl = (i | k << 7);
      return j;
    }
    int m = i | (k & 0x7F) << 7;
    int n = j + 1;
    int i1 = paramArrayOfByte[j];
    if (i1 >= 0)
    {
      paramzzdmn.zzhcl = (m | i1 << 14);
      return n;
    }
    int i2 = m | (i1 & 0x7F) << 14;
    int i3 = n + 1;
    int i4 = paramArrayOfByte[n];
    if (i4 >= 0)
    {
      paramzzdmn.zzhcl = (i2 | i4 << 21);
      return i3;
    }
    int i5 = i2 | (i4 & 0x7F) << 21;
    int i6 = i3 + 1;
    int i7 = paramArrayOfByte[i3];
    if (i7 >= 0)
    {
      paramzzdmn.zzhcl = (i5 | i7 << 28);
      return i6;
    }
    int i8 = i5 | (i7 & 0x7F) << 28;
    while (true)
    {
      int i9 = i6 + 1;
      if (paramArrayOfByte[i6] >= 0)
      {
        paramzzdmn.zzhcl = i8;
        return i9;
      }
      i6 = i9;
    }
  }

  static int zza(zzdqa<?> paramzzdqa, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzdoi<?> paramzzdoi, zzdmn paramzzdmn)
    throws IOException
  {
    int i = zza(paramzzdqa, paramArrayOfByte, paramInt2, paramInt3, paramzzdmn);
    paramzzdoi.add(paramzzdmn.zzhcn);
    while (i < paramInt3)
    {
      int j = zza(paramArrayOfByte, i, paramzzdmn);
      if (paramInt1 != paramzzdmn.zzhcl)
        break;
      i = zza(paramzzdqa, paramArrayOfByte, j, paramInt3, paramzzdmn);
      paramzzdoi.add(paramzzdmn.zzhcn);
    }
    return i;
  }

  static int zza(zzdqa paramzzdqa, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzdmn paramzzdmn)
    throws IOException
  {
    zzdpn localzzdpn = (zzdpn)paramzzdqa;
    Object localObject = localzzdpn.newInstance();
    int i = localzzdpn.zza(localObject, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramzzdmn);
    localzzdpn.zzaa(localObject);
    paramzzdmn.zzhcn = localObject;
    return i;
  }

  static int zza(zzdqa paramzzdqa, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzdmn paramzzdmn)
    throws IOException
  {
    int i = paramInt1 + 1;
    int j = paramArrayOfByte[paramInt1];
    if (j < 0)
      i = zza(j, paramArrayOfByte, i, paramzzdmn);
    for (int k = paramzzdmn.zzhcl; ; k = j)
    {
      if ((k < 0) || (k > paramInt2 - i))
        throw zzdoj.zzayd();
      Object localObject = paramzzdqa.newInstance();
      paramzzdqa.zza(localObject, paramArrayOfByte, i, i + k, paramzzdmn);
      paramzzdqa.zzaa(localObject);
      paramzzdmn.zzhcn = localObject;
      return i + k;
    }
  }

  static int zza(byte[] paramArrayOfByte, int paramInt, zzdmn paramzzdmn)
  {
    int i = paramInt + 1;
    int j = paramArrayOfByte[paramInt];
    if (j >= 0)
    {
      paramzzdmn.zzhcl = j;
      return i;
    }
    return zza(j, paramArrayOfByte, i, paramzzdmn);
  }

  static int zza(byte[] paramArrayOfByte, int paramInt, zzdoi<?> paramzzdoi, zzdmn paramzzdmn)
    throws IOException
  {
    zzdob localzzdob = (zzdob)paramzzdoi;
    int i = zza(paramArrayOfByte, paramInt, paramzzdmn);
    int j = i + paramzzdmn.zzhcl;
    while (i < j)
    {
      i = zza(paramArrayOfByte, i, paramzzdmn);
      localzzdob.zzgp(paramzzdmn.zzhcl);
    }
    if (i != j)
      throw zzdoj.zzayd();
    return i;
  }

  static int zzb(byte[] paramArrayOfByte, int paramInt, zzdmn paramzzdmn)
  {
    int i = 7;
    int j = paramInt + 1;
    long l1 = paramArrayOfByte[paramInt];
    if (l1 >= 0L)
    {
      paramzzdmn.zzhcm = l1;
      return j;
    }
    long l2 = l1 & 0x7F;
    int k = j + 1;
    int m = paramArrayOfByte[j];
    long l3 = l2 | (m & 0x7F) << i;
    int n = k;
    long l4 = l3;
    int i1 = m;
    while (i1 < 0)
    {
      int i2 = n + 1;
      i1 = paramArrayOfByte[n];
      int i3 = i + 7;
      l4 |= (i1 & 0x7F) << i3;
      i = i3;
      n = i2;
    }
    paramzzdmn.zzhcm = l4;
    return n;
  }

  static int zzc(byte[] paramArrayOfByte, int paramInt, zzdmn paramzzdmn)
    throws zzdoj
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzdmn);
    int j = paramzzdmn.zzhcl;
    if (j < 0)
      throw zzdoj.zzaye();
    if (j == 0)
    {
      paramzzdmn.zzhcn = "";
      return i;
    }
    paramzzdmn.zzhcn = new String(paramArrayOfByte, i, j, zzdoc.UTF_8);
    return i + j;
  }

  static int zzd(byte[] paramArrayOfByte, int paramInt, zzdmn paramzzdmn)
    throws zzdoj
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzdmn);
    int j = paramzzdmn.zzhcl;
    if (j < 0)
      throw zzdoj.zzaye();
    if (j == 0)
    {
      paramzzdmn.zzhcn = "";
      return i;
    }
    paramzzdmn.zzhcn = zzdra.zzn(paramArrayOfByte, i, j);
    return i + j;
  }

  static int zze(byte[] paramArrayOfByte, int paramInt, zzdmn paramzzdmn)
    throws zzdoj
  {
    int i = zza(paramArrayOfByte, paramInt, paramzzdmn);
    int j = paramzzdmn.zzhcl;
    if (j < 0)
      throw zzdoj.zzaye();
    if (j > paramArrayOfByte.length - i)
      throw zzdoj.zzayd();
    if (j == 0)
    {
      paramzzdmn.zzhcn = zzdmq.zzhcr;
      return i;
    }
    paramzzdmn.zzhcn = zzdmq.zzi(paramArrayOfByte, i, j);
    return i + j;
  }

  static int zzf(byte[] paramArrayOfByte, int paramInt)
  {
    return 0xFF & paramArrayOfByte[paramInt] | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 8 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 3)]) << 24;
  }

  static long zzg(byte[] paramArrayOfByte, int paramInt)
  {
    return 0xFF & paramArrayOfByte[paramInt] | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 8 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 3)]) << 24 | (0xFF & paramArrayOfByte[(paramInt + 4)]) << 32 | (0xFF & paramArrayOfByte[(paramInt + 5)]) << 40 | (0xFF & paramArrayOfByte[(paramInt + 6)]) << 48 | (0xFF & paramArrayOfByte[(paramInt + 7)]) << 56;
  }

  static double zzh(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(zzg(paramArrayOfByte, paramInt));
  }

  static float zzi(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(zzf(paramArrayOfByte, paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmm
 * JD-Core Version:    0.6.2
 */