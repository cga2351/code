package com.google.android.gms.internal.ads;

final class zzdpy
  implements zzdph
{
  private final int flags;
  private final String info;
  private final Object[] zzhjr;
  private final zzdpj zzhju;

  zzdpy(zzdpj paramzzdpj, String paramString, Object[] paramArrayOfObject)
  {
    this.zzhju = paramzzdpj;
    this.info = paramString;
    this.zzhjr = paramArrayOfObject;
    int i = 1;
    int j = paramString.charAt(0);
    if (j < 55296)
    {
      this.flags = j;
      return;
    }
    int k = j & 0x1FFF;
    int m = 13;
    int i1;
    while (true)
    {
      int n = i + 1;
      i1 = paramString.charAt(i);
      if (i1 < 55296)
        break;
      k |= (i1 & 0x1FFF) << m;
      m += 13;
      i = n;
    }
    this.flags = (k | i1 << m);
  }

  public final int zzayz()
  {
    if ((0x1 & this.flags) == 1)
      return zzdoa.zze.zzhhs;
    return zzdoa.zze.zzhht;
  }

  public final boolean zzaza()
  {
    return (0x2 & this.flags) == 2;
  }

  public final zzdpj zzazb()
  {
    return this.zzhju;
  }

  final String zzazi()
  {
    return this.info;
  }

  final Object[] zzazj()
  {
    return this.zzhjr;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpy
 * JD-Core Version:    0.6.2
 */