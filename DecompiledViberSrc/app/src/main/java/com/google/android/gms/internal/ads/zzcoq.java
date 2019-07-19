package com.google.android.gms.internal.ads;

public final class zzcoq<AdT>
  implements zzcju<AdT>
{
  private final zzczs zzgbk;
  private final zzbbm zzgci;
  private final zzadn zzgco;
  private final zzcot<AdT> zzgcv;

  public zzcoq(zzczs paramzzczs, zzbbm paramzzbbm, zzadn paramzzadn, zzcot<AdT> paramzzcot)
  {
    this.zzgbk = paramzzczs;
    this.zzgci = paramzzbbm;
    this.zzgco = paramzzadn;
    this.zzgcv = paramzzcot;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (this.zzgco != null) && (paramzzcxl.zzgke != null) && (paramzzcxl.zzgke.zzdkr != null);
  }

  public final zzbbi<AdT> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    zzbbs localzzbbs = new zzbbs();
    zzcoy localzzcoy = new zzcoy();
    localzzcoy.zza(new zzcos(this, localzzbbs, paramzzcxt, paramzzcxl, localzzcoy));
    zzadi localzzadi = new zzadi(localzzcoy, paramzzcxl.zzgke.zzdkp, paramzzcxl.zzgke.zzdkr);
    return this.zzgbk.zzv(zzczr.zzgnj).zza(new zzcor(this, localzzadi), this.zzgci).zzx(zzczr.zzgnk).zzb(localzzbbs).zzane();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcoq
 * JD-Core Version:    0.6.2
 */