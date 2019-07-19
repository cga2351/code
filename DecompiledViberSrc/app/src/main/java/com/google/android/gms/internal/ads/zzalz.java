package com.google.android.gms.internal.ads;

@zzare
public final class zzalz
{
  private zzaki zzddy;
  private zzbbs<zzalg> zzddz;

  zzalz(zzaki paramzzaki)
  {
    this.zzddy = paramzzaki;
  }

  private final void zzsd()
  {
    if (this.zzddz == null)
    {
      this.zzddz = new zzbbs();
      zzbbs localzzbbs = this.zzddz;
      this.zzddy.zzb(null).zza(new zzama(localzzbbs), new zzamb(localzzbbs));
    }
  }

  public final zzame zzb(String paramString, zzaln paramzzaln, zzalm paramzzalm)
  {
    zzsd();
    return new zzame(this.zzddz, paramString, paramzzaln, paramzzalm);
  }

  public final void zzc(String paramString, zzahn<? super zzalg> paramzzahn)
  {
    zzsd();
    this.zzddz = ((zzbbs)zzbas.zza(this.zzddz, new zzamc(paramString, paramzzahn), zzbbn.zzeah));
  }

  public final void zzd(String paramString, zzahn<? super zzalg> paramzzahn)
  {
    this.zzddz = ((zzbbs)zzbas.zza(this.zzddz, new zzamd(paramString, paramzzahn), zzbbn.zzeah));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzalz
 * JD-Core Version:    0.6.2
 */