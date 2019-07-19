package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzic
  implements zzip
{
  private volatile zzhj zzado;
  private final zzik zzahw;
  private final zzhm zzahx;
  private boolean zzahy;
  private long zzahz;
  private long zzaia;
  private volatile long zzaib;

  public zzic(zzjl paramzzjl)
  {
    this.zzahw = new zzik(paramzzjl);
    this.zzahx = new zzhm(0);
    this.zzahy = true;
    this.zzahz = -9223372036854775808L;
    this.zzaia = -9223372036854775808L;
    this.zzaib = -9223372036854775808L;
  }

  private final boolean zzfg()
  {
    boolean bool = this.zzahw.zzb(this.zzahx);
    if (this.zzahy)
      while ((bool) && (!this.zzahx.zzep()))
      {
        this.zzahw.zzfs();
        bool = this.zzahw.zzb(this.zzahx);
      }
    if (!bool);
    while ((this.zzaia != -9223372036854775808L) && (this.zzahx.zzaga >= this.zzaia))
      return false;
    return true;
  }

  public final void clear()
  {
    this.zzahw.clear();
    this.zzahy = true;
    this.zzahz = -9223372036854775808L;
    this.zzaia = -9223372036854775808L;
    this.zzaib = -9223372036854775808L;
  }

  public final boolean isEmpty()
  {
    return !zzfg();
  }

  public final int zza(zzie paramzzie, int paramInt)
    throws IOException, InterruptedException
  {
    return this.zzahw.zzb(paramzzie, paramInt);
  }

  public void zza(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.zzaib = Math.max(this.zzaib, paramLong);
    this.zzahw.zza(paramLong, paramInt1, this.zzahw.zzft() - paramInt2 - paramInt3, paramInt2, paramArrayOfByte);
  }

  public final void zza(zzhj paramzzhj)
  {
    this.zzado = paramzzhj;
  }

  public final void zza(zzkm paramzzkm, int paramInt)
  {
    this.zzahw.zzb(paramzzkm, paramInt);
  }

  public final boolean zza(zzhm paramzzhm)
  {
    if (!zzfg())
      return false;
    this.zzahw.zzc(paramzzhm);
    this.zzahy = false;
    this.zzahz = paramzzhm.zzaga;
    return true;
  }

  public final void zzdr(long paramLong)
  {
    while ((this.zzahw.zzb(this.zzahx)) && (this.zzahx.zzaga < paramLong))
    {
      this.zzahw.zzfs();
      this.zzahy = true;
    }
    this.zzahz = -9223372036854775808L;
  }

  public final boolean zzds(long paramLong)
  {
    return this.zzahw.zzds(paramLong);
  }

  public final boolean zzfd()
  {
    return this.zzado != null;
  }

  public final zzhj zzfe()
  {
    return this.zzado;
  }

  public final long zzff()
  {
    return this.zzaib;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzic
 * JD-Core Version:    0.6.2
 */