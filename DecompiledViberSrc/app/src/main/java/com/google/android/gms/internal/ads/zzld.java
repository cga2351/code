package com.google.android.gms.internal.ads;

import android.util.Log;

final class zzld
{
  public final int index;
  public boolean zzacs;
  private final zzlo[] zzaro;
  private final zzrp zzarp;
  private final zzlp[] zzasi;
  private final zzll zzasj;
  private final zzql zzaso;
  public final zzqj zzasw;
  public final Object zzasx;
  public final zzqw[] zzasy;
  private final boolean[] zzasz;
  public final long zzata;
  public int zzatb;
  public long zzatc;
  public boolean zzatd;
  public boolean zzate;
  public zzld zzatf;
  public zzrr zzatg;
  private zzrr zzath;

  public zzld(zzlo[] paramArrayOfzzlo, zzlp[] paramArrayOfzzlp, long paramLong1, zzrp paramzzrp, zzll paramzzll, zzql paramzzql, Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong2)
  {
    this.zzaro = paramArrayOfzzlo;
    this.zzasi = paramArrayOfzzlp;
    this.zzata = paramLong1;
    this.zzarp = paramzzrp;
    this.zzasj = paramzzll;
    this.zzaso = paramzzql;
    this.zzasx = zzsk.checkNotNull(paramObject);
    this.index = paramInt1;
    this.zzatb = paramInt2;
    this.zzatd = paramBoolean;
    this.zzatc = paramLong2;
    this.zzasy = new zzqw[paramArrayOfzzlo.length];
    this.zzasz = new boolean[paramArrayOfzzlo.length];
    this.zzasw = paramzzql.zza(paramInt2, paramzzll.zzhe());
  }

  public final void release()
  {
    try
    {
      this.zzaso.zzb(this.zzasw);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("ExoPlayerImplInternal", "Period release failed.", localRuntimeException);
    }
  }

  public final long zza(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    zzro localzzro = this.zzatg.zzblz;
    int i = 0;
    if (i < localzzro.length)
    {
      boolean[] arrayOfBoolean = this.zzasz;
      if ((!paramBoolean) && (this.zzatg.zza(this.zzath, i)));
      for (int k = 1; ; k = 0)
      {
        arrayOfBoolean[i] = k;
        i++;
        break;
      }
    }
    long l = this.zzasw.zza(localzzro.zzjs(), this.zzasz, this.zzasy, paramArrayOfBoolean, paramLong);
    this.zzath = this.zzatg;
    this.zzate = false;
    int j = 0;
    if (j < this.zzasy.length)
    {
      if (this.zzasy[j] != null)
      {
        if (localzzro.zzbi(j) != null);
        for (boolean bool2 = true; ; bool2 = false)
        {
          zzsk.checkState(bool2);
          this.zzate = true;
          j++;
          break;
        }
      }
      if (localzzro.zzbi(j) == null);
      for (boolean bool1 = true; ; bool1 = false)
      {
        zzsk.checkState(bool1);
        break;
      }
    }
    this.zzasj.zza(this.zzaro, this.zzatg.zzbly, localzzro);
    return l;
  }

  public final void zzd(int paramInt, boolean paramBoolean)
  {
    this.zzatb = paramInt;
    this.zzatd = paramBoolean;
  }

  public final long zze(long paramLong, boolean paramBoolean)
  {
    return zza(paramLong, false, new boolean[this.zzaro.length]);
  }

  public final long zzgz()
  {
    return this.zzata - this.zzatc;
  }

  public final boolean zzha()
  {
    return (this.zzacs) && ((!this.zzate) || (this.zzasw.zzdu() == -9223372036854775808L));
  }

  public final boolean zzhb()
    throws zzku
  {
    zzrr localzzrr1 = this.zzarp.zza(this.zzasi, this.zzasw.zziz());
    zzrr localzzrr2 = this.zzath;
    int j;
    if (localzzrr2 == null)
      j = 0;
    while (j != 0)
    {
      return false;
      for (int i = 0; ; i++)
      {
        if (i >= localzzrr1.zzblz.length)
          break label74;
        if (!localzzrr1.zza(localzzrr2, i))
        {
          j = 0;
          break;
        }
      }
      label74: j = 1;
    }
    this.zzatg = localzzrr1;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzld
 * JD-Core Version:    0.6.2
 */