package com.google.android.gms.internal.ads;

import java.io.IOException;

@zzare
final class zzbek
  implements zzjp
{
  private final zzjp zzegh;
  private final long zzegi;
  private final zzjp zzegj;
  private long zzegk;

  zzbek(zzjp paramzzjp1, int paramInt, zzjp paramzzjp2)
  {
    this.zzegh = paramzzjp1;
    this.zzegi = paramInt;
    this.zzegj = paramzzjp2;
  }

  public final void close()
    throws IOException
  {
    this.zzegh.close();
    this.zzegj.close();
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = this.zzegk < this.zzegi;
    int i = 0;
    if (bool)
    {
      int m = (int)Math.min(paramInt2, this.zzegi - this.zzegk);
      i = this.zzegh.read(paramArrayOfByte, paramInt1, m);
      this.zzegk += i;
    }
    if (this.zzegk >= this.zzegi)
    {
      int j = paramInt2 - i;
      int k = this.zzegj.read(paramArrayOfByte, paramInt1 + i, j);
      i += k;
      this.zzegk += k;
    }
    return i;
  }

  public final long zza(zzjq paramzzjq)
    throws IOException
  {
    zzjq localzzjq1;
    zzjq localzzjq2;
    if (paramzzjq.zzahv >= this.zzegi)
    {
      localzzjq1 = null;
      if (paramzzjq.zzcd == -1L)
        break label178;
      boolean bool = paramzzjq.zzahv + paramzzjq.zzcd < this.zzegi;
      localzzjq2 = null;
      if (bool)
        break label178;
      if (localzzjq1 == null)
        break label266;
    }
    label266: for (long l5 = this.zzegh.zza(localzzjq1); ; l5 = 0L)
    {
      if (localzzjq2 != null);
      for (long l6 = this.zzegj.zza(localzzjq2); ; l6 = 0L)
      {
        this.zzegk = paramzzjq.zzahv;
        if ((l5 == -1L) || (l6 == -1L))
        {
          return -1L;
          long l1 = paramzzjq.zzahv;
          if (paramzzjq.zzcd != -1L);
          for (long l2 = Math.min(paramzzjq.zzcd, this.zzegi - l1); ; l2 = this.zzegi - l1)
          {
            localzzjq1 = new zzjq(paramzzjq.uri, l1, l2, null);
            break;
          }
          label178: long l3 = Math.max(this.zzegi, paramzzjq.zzahv);
          if (paramzzjq.zzcd != -1L);
          for (long l4 = Math.min(paramzzjq.zzcd, paramzzjq.zzahv + paramzzjq.zzcd - this.zzegi); ; l4 = -1L)
          {
            localzzjq2 = new zzjq(paramzzjq.uri, l3, l4, null);
            break;
          }
        }
        return l5 + l6;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbek
 * JD-Core Version:    0.6.2
 */