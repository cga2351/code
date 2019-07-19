package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcnk
  implements zzcju<zzcda>
{
  private final zzbaj zzbrd;
  private final Executor zzffu;
  private final zzcxu zzfjp;
  private final zzcdm zzfqh;
  private final zzcde zzgbq;
  private final Context zzlj;

  public zzcnk(Context paramContext, zzbaj paramzzbaj, zzcxu paramzzcxu, Executor paramExecutor, zzcde paramzzcde, zzcdm paramzzcdm)
  {
    this.zzlj = paramContext;
    this.zzfjp = paramzzcxu;
    this.zzgbq = paramzzcde;
    this.zzffu = paramExecutor;
    this.zzbrd = paramzzbaj;
    this.zzfqh = paramzzcdm;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (paramzzcxl.zzgke != null) && (paramzzcxl.zzgke.zzdkr != null);
  }

  public final zzbbi<zzcda> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    zzcec localzzcec = new zzcec();
    zzbbi localzzbbi = zzbas.zza(zzbas.zzm(null), new zzcnl(this, paramzzcxl, localzzcec, paramzzcxt), this.zzffu);
    localzzcec.getClass();
    localzzbbi.zza(zzcnm.zza(localzzcec), this.zzffu);
    return localzzbbi;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcnk
 * JD-Core Version:    0.6.2
 */