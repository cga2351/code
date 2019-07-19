package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzqg
  implements zzqw
{
  private final int track;

  public zzqg(zzpz paramzzpz, int paramInt)
  {
    this.track = paramInt;
  }

  public final boolean isReady()
  {
    return this.zzbis.zzbd(this.track);
  }

  public final int zzb(zzlj paramzzlj, zznd paramzznd, boolean paramBoolean)
  {
    return this.zzbis.zza(this.track, paramzzlj, paramzznd, paramBoolean);
  }

  public final void zzeo(long paramLong)
  {
    this.zzbis.zzf(this.track, paramLong);
  }

  public final void zzjb()
    throws IOException
  {
    this.zzbis.zzjb();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqg
 * JD-Core Version:    0.6.2
 */