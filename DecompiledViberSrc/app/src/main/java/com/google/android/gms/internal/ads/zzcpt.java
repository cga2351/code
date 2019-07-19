package com.google.android.gms.internal.ads;

final class zzcpt
  implements zzbao<zzbne>
{
  zzcpt(zzcps paramzzcps, zzbob paramzzbob)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    synchronized (this.zzgem)
    {
      zzcps.zza(this.zzgem, null);
      this.zzgel.zzadb().onAdFailedToLoad(zzcgl.zze(paramThrowable));
      zzcps.zzc(this.zzgem).zzdk(60);
      zzcxz.zzc(paramThrowable, "BannerAdManagerShim.onFailure");
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpt
 * JD-Core Version:    0.6.2
 */