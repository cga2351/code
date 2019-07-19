package com.google.android.gms.internal.ads;

public final class zzqz extends zzlr
{
  private static final Object zzbkr = new Object();
  private final boolean zzaus;
  private final boolean zzaut;
  private final long zzbks;
  private final long zzbkt;
  private final long zzbku;
  private final long zzbkv;

  private zzqz(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzbks = paramLong1;
    this.zzbkt = paramLong2;
    this.zzbku = 0L;
    this.zzbkv = 0L;
    this.zzaus = paramBoolean1;
    this.zzaut = false;
  }

  public zzqz(long paramLong, boolean paramBoolean)
  {
    this(paramLong, paramLong, 0L, 0L, paramBoolean, false);
  }

  public final zzlt zza(int paramInt, zzlt paramzzlt, boolean paramBoolean)
  {
    zzsk.zzc(paramInt, 0, 1);
    if (paramBoolean);
    for (Object localObject = zzbkr; ; localObject = null)
    {
      long l = this.zzbks;
      return paramzzlt.zza(localObject, localObject, 0, l, 0L, false);
    }
  }

  public final zzlu zza(int paramInt, zzlu paramzzlu, boolean paramBoolean, long paramLong)
  {
    zzsk.zzc(paramInt, 0, 1);
    boolean bool = this.zzaus;
    long l = this.zzbkt;
    paramzzlu.zzaun = null;
    paramzzlu.zzauq = -9223372036854775807L;
    paramzzlu.zzaur = -9223372036854775807L;
    paramzzlu.zzaus = bool;
    paramzzlu.zzaut = false;
    paramzzlu.zzauw = 0L;
    paramzzlu.zzack = l;
    paramzzlu.zzauu = 0;
    paramzzlu.zzauv = 0;
    paramzzlu.zzaux = 0L;
    return paramzzlu;
  }

  public final int zzc(Object paramObject)
  {
    if (zzbkr.equals(paramObject))
      return 0;
    return -1;
  }

  public final int zzhf()
  {
    return 1;
  }

  public final int zzhg()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqz
 * JD-Core Version:    0.6.2
 */