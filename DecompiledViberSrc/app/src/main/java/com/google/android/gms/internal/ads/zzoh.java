package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzoh
{
  private final zzst zzbac = new zzst(8);
  private int zzbch;

  private final long zzc(zzno paramzzno)
    throws IOException, InterruptedException
  {
    int i = 0;
    paramzzno.zzc(this.zzbac.data, 0, 1);
    int j = 0xFF & this.zzbac.data[0];
    if (j == 0)
      return -9223372036854775808L;
    int k = 128;
    int m = 0;
    while ((j & k) == 0)
    {
      int i1 = k >> 1;
      m++;
      k = i1;
    }
    int n = j & (k ^ 0xFFFFFFFF);
    paramzzno.zzc(this.zzbac.data, 1, m);
    while (i < m)
    {
      n = (n << 8) + (0xFF & this.zzbac.data[(i + 1)]);
      i++;
    }
    this.zzbch += m + 1;
    return n;
  }

  public final boolean zza(zzno paramzzno)
    throws IOException, InterruptedException
  {
    long l1 = paramzzno.getLength();
    long l2;
    int i;
    long l3;
    if ((l1 == -1L) || (l1 > 1024L))
    {
      l2 = 1024L;
      i = (int)l2;
      paramzzno.zzc(this.zzbac.data, 0, 4);
      l3 = this.zzbac.zzge();
      this.zzbch = 4;
    }
    while (true)
    {
      if (l3 == 440786851L)
        break label144;
      int j = 1 + this.zzbch;
      this.zzbch = j;
      if (j == i)
      {
        return false;
        l2 = l1;
        break;
      }
      paramzzno.zzc(this.zzbac.data, 0, 1);
      l3 = 0xFFFFFF00 & l3 << 8 | 0xFF & this.zzbac.data[0];
    }
    label144: long l4 = zzc(paramzzno);
    long l5 = this.zzbch;
    if ((l4 == -9223372036854775808L) || ((l1 != -1L) && (l5 + l4 >= l1)))
      return false;
    long l6;
    do
    {
      Object localObject;
      if (localObject != 0L)
      {
        paramzzno.zzar((int)localObject);
        this.zzbch = ((int)(localObject + this.zzbch));
      }
      if (this.zzbch >= l5 + l4)
        break;
      if (zzc(paramzzno) == -9223372036854775808L)
        return false;
      l6 = zzc(paramzzno);
    }
    while ((l6 >= 0L) && (l6 <= 2147483647L));
    return false;
    return this.zzbch == l4 + l5;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzoh
 * JD-Core Version:    0.6.2
 */