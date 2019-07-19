package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

final class zzcsk<S extends zzcuy>
{
  private final Clock zzbsb;
  public final zzbbi<S> zzggy;
  private final long zzggz;

  public zzcsk(zzbbi<S> paramzzbbi, long paramLong, Clock paramClock)
  {
    this.zzggy = paramzzbbi;
    this.zzbsb = paramClock;
    this.zzggz = (paramLong + paramClock.elapsedRealtime());
  }

  public final boolean hasExpired()
  {
    return this.zzggz < this.zzbsb.elapsedRealtime();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcsk
 * JD-Core Version:    0.6.2
 */