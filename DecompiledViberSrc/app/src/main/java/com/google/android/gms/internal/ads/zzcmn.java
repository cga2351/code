package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

public final class zzcmn extends zzcmm<zzbne>
{
  private final zzbtu zzeqd;
  private final zzbxj zzeqe;
  private final zzcov zzezw;
  private final ViewGroup zzfgt;
  private final zzbta zzfil;
  private final zzbjn zzgbc;
  private final zzbqx.zza zzgbd;

  public zzcmn(zzbjn paramzzbjn, zzbqx.zza paramzza, zzcov paramzzcov, zzbtu paramzzbtu, zzbxj paramzzbxj, zzbta paramzzbta, ViewGroup paramViewGroup)
  {
    this.zzgbc = paramzzbjn;
    this.zzgbd = paramzza;
    this.zzezw = paramzzcov;
    this.zzeqd = paramzzbtu;
    this.zzeqe = paramzzbxj;
    this.zzfil = paramzzbta;
    this.zzfgt = paramViewGroup;
  }

  protected final zzbbi<zzbne> zza(zzcxu paramzzcxu, Bundle paramBundle)
  {
    return this.zzgbc.zzacj().zzb(this.zzgbd.zza(paramzzcxu).zze(paramBundle).zzagh()).zzb(this.zzeqd).zza(this.zzezw).zzb(this.zzeqe).zza(new zzbow(this.zzfil)).zza(new zzbnb(this.zzfgt)).zzads().zzadu();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmn
 * JD-Core Version:    0.6.2
 */