package com.google.android.gms.internal.ads;

public final class zzpy
  implements zzqx
{
  private final zzqx[] zzbhz;

  public zzpy(zzqx[] paramArrayOfzzqx)
  {
    this.zzbhz = paramArrayOfzzqx;
  }

  public final boolean zzel(long paramLong)
  {
    boolean bool1 = false;
    boolean bool2;
    do
    {
      long l = zzix();
      if (l == -9223372036854775808L)
        break;
      zzqx[] arrayOfzzqx = this.zzbhz;
      int i = arrayOfzzqx.length;
      int j = 0;
      bool2 = false;
      while (j < i)
      {
        zzqx localzzqx = arrayOfzzqx[j];
        if (localzzqx.zzix() == l)
          bool2 |= localzzqx.zzel(paramLong);
        j++;
      }
      bool1 |= bool2;
    }
    while (bool2);
    return bool1;
  }

  public final long zzix()
  {
    zzqx[] arrayOfzzqx = this.zzbhz;
    int i = arrayOfzzqx.length;
    int j = 0;
    long l1 = 9223372036854775807L;
    while (j < i)
    {
      long l2 = arrayOfzzqx[j].zzix();
      if (l2 != -9223372036854775808L)
        l1 = Math.min(l1, l2);
      j++;
    }
    if (l1 == 9223372036854775807L)
      l1 = -9223372036854775808L;
    return l1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpy
 * JD-Core Version:    0.6.2
 */