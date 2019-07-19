package com.google.android.gms.internal.measurement;

final class zzwj
  implements zzvt
{
  private final int flags;
  private final String info;
  private final Object[] zzcat;
  private final zzvv zzcaw;

  zzwj(zzvv paramzzvv, String paramString, Object[] paramArrayOfObject)
  {
    this.zzcaw = paramzzvv;
    this.info = paramString;
    this.zzcat = paramArrayOfObject;
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

  public final int zzxm()
  {
    if ((0x1 & this.flags) == 1)
      return zzuo.zze.zzbyu;
    return zzuo.zze.zzbyv;
  }

  public final boolean zzxn()
  {
    return (0x2 & this.flags) == 2;
  }

  public final zzvv zzxo()
  {
    return this.zzcaw;
  }

  final String zzxv()
  {
    return this.info;
  }

  final Object[] zzxw()
  {
    return this.zzcat;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwj
 * JD-Core Version:    0.6.2
 */