package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcbo
{
  private final Executor zzffu;
  private final zzbuz zzfmv;
  private final zzbmx zzfry;

  zzcbo(Executor paramExecutor, zzbmx paramzzbmx, zzbuz paramzzbuz)
  {
    this.zzffu = paramExecutor;
    this.zzfmv = paramzzbuz;
    this.zzfry = paramzzbmx;
  }

  public final void zzk(zzbha paramzzbha)
  {
    if (paramzzbha == null)
      return;
    this.zzfmv.zzq(paramzzbha.getView());
    this.zzfmv.zza(new zzcbp(paramzzbha), this.zzffu);
    this.zzfmv.zza(new zzcbq(paramzzbha), this.zzffu);
    this.zzfmv.zza(this.zzfry, this.zzffu);
    this.zzfry.zzg(paramzzbha);
    paramzzbha.zza("/trackActiveViewUnit", new zzcbr(this));
    paramzzbha.zza("/untrackActiveViewUnit", new zzcbs(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcbo
 * JD-Core Version:    0.6.2
 */