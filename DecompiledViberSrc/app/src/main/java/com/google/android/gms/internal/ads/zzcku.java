package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzcku
  implements zzcju<zzbne>
{
  private final ScheduledExecutorService zzfiw;
  private final zzbrl zzfkw;
  private final zzbbm zzfqw;
  private final zzbob zzgad;
  private final zzcka zzgae;

  public zzcku(zzbob paramzzbob, zzcka paramzzcka, zzbrl paramzzbrl, ScheduledExecutorService paramScheduledExecutorService, zzbbm paramzzbbm)
  {
    this.zzgad = paramzzbob;
    this.zzgae = paramzzcka;
    this.zzfkw = paramzzbrl;
    this.zzfiw = paramScheduledExecutorService;
    this.zzfqw = paramzzbbm;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (paramzzcxt.zzgkx.zzfjp.zzamn() != null) && (this.zzgae.zza(paramzzcxt, paramzzcxl));
  }

  public final zzbbi<zzbne> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return this.zzfqw.zza(new zzckv(this, paramzzcxt, paramzzcxl));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcku
 * JD-Core Version:    0.6.2
 */