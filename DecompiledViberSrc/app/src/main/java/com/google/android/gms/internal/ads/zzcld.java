package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcld
  implements zzcju<zzbvw>
{
  private final zzbaj zzbrd;
  private final Executor zzffu;
  private final zzcxu zzfjp;
  private final zzcdm zzfqh;
  private final zzbwr zzfzy;
  private final Context zzlj;

  public zzcld(Context paramContext, zzbaj paramzzbaj, zzcxu paramzzcxu, Executor paramExecutor, zzbwr paramzzbwr, zzcdm paramzzcdm)
  {
    this.zzlj = paramContext;
    this.zzfjp = paramzzcxu;
    this.zzfzy = paramzzbwr;
    this.zzffu = paramExecutor;
    this.zzbrd = paramzzbaj;
    this.zzfqh = paramzzcdm;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (paramzzcxl.zzgke != null) && (paramzzcxl.zzgke.zzdkr != null);
  }

  public final zzbbi<zzbvw> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    zzcec localzzcec = new zzcec();
    zzbbi localzzbbi = zzbas.zza(zzbas.zzm(null), new zzcle(this, paramzzcxl, localzzcec, paramzzcxt), this.zzffu);
    localzzcec.getClass();
    localzzbbi.zza(zzclf.zza(localzzcec), this.zzffu);
    return localzzbbi;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcld
 * JD-Core Version:    0.6.2
 */