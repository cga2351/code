package com.google.android.gms.internal.ads;

final class zzcqd
  implements zzbao<zzbvw>
{
  zzcqd(zzcqc paramzzcqc, zzbwr paramzzbwr)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    synchronized (this.zzgfb)
    {
      zzcqc.zza(this.zzgfb, null);
      this.zzgfa.zzadb().onAdFailedToLoad(zzcgl.zze(paramThrowable));
      zzcxz.zzc(paramThrowable, "InterstitialAdManagerShim.onFailure");
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqd
 * JD-Core Version:    0.6.2
 */