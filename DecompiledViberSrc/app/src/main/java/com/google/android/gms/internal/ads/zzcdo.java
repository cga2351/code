package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class zzcdo
{
  private final zzavc zzbqx;
  private final zzdh zzekq;
  private final Executor zzffu;
  private final zzbsd zzfjg;
  private final zzbsu zzflp;
  private final zzbrh zzfms;
  private final zzbmm zzfmt;
  private final zzbuz zzfmv;
  private final zzbsr zzfsq;
  private final zzbto zzfsr;
  private final zzb zzfti;
  private final zzbrx zzftj;
  private final zzbtk zzftk;

  public zzcdo(zzbrh paramzzbrh, zzbsd paramzzbsd, zzbsr paramzzbsr, zzbsu paramzzbsu, zzbto paramzzbto, Executor paramExecutor, zzbuz paramzzbuz, zzbmm paramzzbmm, zzb paramzzb, zzbrx paramzzbrx, @Nullable zzavc paramzzavc, zzdh paramzzdh, zzbtk paramzzbtk)
  {
    this.zzfms = paramzzbrh;
    this.zzfjg = paramzzbsd;
    this.zzfsq = paramzzbsr;
    this.zzflp = paramzzbsu;
    this.zzfsr = paramzzbto;
    this.zzffu = paramExecutor;
    this.zzfmv = paramzzbuz;
    this.zzfmt = paramzzbmm;
    this.zzfti = paramzzb;
    this.zzftj = paramzzbrx;
    this.zzbqx = paramzzavc;
    this.zzekq = paramzzdh;
    this.zzftk = paramzzbtk;
  }

  public static zzbbi<?> zza(zzbha paramzzbha, String paramString1, String paramString2)
  {
    zzbbs localzzbbs = new zzbbs();
    paramzzbha.zzaai().zza(new zzcdx(localzzbbs));
    paramzzbha.zzb(paramString1, paramString2, null);
    return localzzbbs;
  }

  public final void zzb(zzbha paramzzbha, boolean paramBoolean)
  {
    paramzzbha.zzaai().zza(new zzcdp(this), this.zzfsq, this.zzflp, new zzcdq(this), new zzcdr(this), paramBoolean, null, this.zzfti, new zzcdy(this), this.zzbqx);
    paramzzbha.setOnTouchListener(new zzcds(this));
    paramzzbha.setOnClickListener(new zzcdt(this));
    zzaci localzzaci = zzact.zzcrh;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      zzdc localzzdc = this.zzekq.zzcg();
      if (localzzdc != null)
        localzzdc.zzb(paramzzbha.getView());
    }
    this.zzfmv.zza(paramzzbha, this.zzffu);
    this.zzfmv.zza(new zzcdu(paramzzbha), this.zzffu);
    this.zzfmv.zzq(paramzzbha.getView());
    paramzzbha.zza("/trackActiveViewUnit", new zzcdv(this, paramzzbha));
    this.zzfmt.zzq(paramzzbha);
    this.zzftj.zza(new zzcdw(paramzzbha), this.zzffu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcdo
 * JD-Core Version:    0.6.2
 */