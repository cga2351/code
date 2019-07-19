package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

public final class zzchp
{
  private final Executor zzfiv;
  private final zzcxu zzfjp;
  private final zzbaj zzfxa;
  private final Context zzlj;

  public zzchp(Context paramContext, zzbaj paramzzbaj, zzcxu paramzzcxu, Executor paramExecutor)
  {
    this.zzlj = paramContext;
    this.zzfxa = paramzzbaj;
    this.zzfjp = paramzzcxu;
    this.zzfiv = paramExecutor;
  }

  protected final zzbbi<zzcxt> zzakg()
  {
    zzalk localzzalk = zzk.zzlt().zzb(this.zzlj, this.zzfxa).zza("google.afma.response.normalize", zzalp.zzddk, zzalp.zzddk);
    zzxr localzzxr = this.zzfjp.zzghg.zzchc;
    return zzbas.zza(zzbas.zza(zzbas.zza(zzbas.zzm(""), new zzchq(this, localzzxr), this.zzfiv), new zzchr(localzzalk), this.zzfiv), new zzchs(this), this.zzfiv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchp
 * JD-Core Version:    0.6.2
 */