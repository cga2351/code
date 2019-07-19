package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public final class zzbfa
  implements zzll
{
  private long zzaca = 15000000L;
  private int zzbmh;
  private final zzrz zzegv = new zzrz(true, 65536);
  private long zzegw = 30000000L;
  private long zzegx = 2500000L;
  private long zzegy = 5000000L;
  private boolean zzegz;

  zzbfa()
  {
    this(15000, 30000, 2500L, 5000L);
  }

  private zzbfa(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
  }

  @VisibleForTesting
  private final void zzk(boolean paramBoolean)
  {
    this.zzbmh = 0;
    this.zzegz = false;
    if (paramBoolean)
      this.zzegv.reset();
  }

  public final void onStopped()
  {
    zzk(true);
  }

  public final void zza(zzlo[] paramArrayOfzzlo, zzrb paramzzrb, zzro paramzzro)
  {
    int i = 0;
    this.zzbmh = 0;
    while (i < paramArrayOfzzlo.length)
    {
      if (paramzzro.zzbi(i) != null)
        this.zzbmh += zzsy.zzbt(paramArrayOfzzlo[i].getTrackType());
      i++;
    }
    this.zzegv.zzbl(this.zzbmh);
  }

  public final void zzda(int paramInt)
  {
    long l = 1000L * paramInt;
    try
    {
      this.zzegx = l;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzdb(int paramInt)
  {
    long l = 1000L * paramInt;
    try
    {
      this.zzegy = l;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzdg(int paramInt)
  {
    long l = 1000L * paramInt;
    try
    {
      this.zzaca = l;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzdh(int paramInt)
  {
    long l = 1000L * paramInt;
    try
    {
      this.zzegw = l;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzee()
  {
    zzk(true);
  }

  public final boolean zzee(long paramLong)
  {
    while (true)
    {
      try
      {
        int i;
        if (paramLong > this.zzegw)
        {
          i = 0;
          if (this.zzegv.zzga() >= this.zzbmh)
          {
            j = 1;
            if (i == 2)
              break label124;
            bool1 = false;
            if (i == 1)
            {
              boolean bool2 = this.zzegz;
              bool1 = false;
              if (bool2)
              {
                bool1 = false;
                if (j == 0)
                  break label124;
              }
            }
            this.zzegz = bool1;
            boolean bool3 = this.zzegz;
            return bool3;
          }
        }
        else
        {
          long l = this.zzaca;
          if (paramLong < l)
          {
            i = 2;
            continue;
          }
          i = 1;
          continue;
        }
        int j = 0;
        continue;
      }
      finally
      {
      }
      label124: boolean bool1 = true;
    }
  }

  public final boolean zzf(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      long l = this.zzegy;
      if ((l <= 0L) || (paramLong >= l));
      for (boolean bool = true; ; bool = false)
      {
        return bool;
        l = this.zzegx;
        break;
      }
    }
    finally
    {
    }
  }

  public final void zzhd()
  {
    zzk(false);
  }

  public final zzrt zzhe()
  {
    return this.zzegv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfa
 * JD-Core Version:    0.6.2
 */