package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcka
  implements zzcju<zzbne>
{
  private final Executor zzffu;
  private final zzcxu zzfjp;
  private final zzcdm zzfqh;
  private final zzbob zzfzo;
  private final zzban<zzcxl, zzayc> zzfzp;
  private final Context zzlj;

  public zzcka(zzbob paramzzbob, Context paramContext, Executor paramExecutor, zzcdm paramzzcdm, zzcxu paramzzcxu, zzban<zzcxl, zzayc> paramzzban)
  {
    this.zzlj = paramContext;
    this.zzfzo = paramzzbob;
    this.zzffu = paramExecutor;
    this.zzfqh = paramzzcdm;
    this.zzfjp = paramzzcxu;
    this.zzfzp = paramzzban;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (paramzzcxl.zzgke != null) && (paramzzcxl.zzgke.zzdkr != null);
  }

  public final zzbbi<zzbne> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return zzbas.zza(zzbas.zzm(null), new zzckb(this, paramzzcxt, paramzzcxl), this.zzffu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcka
 * JD-Core Version:    0.6.2
 */