package com.google.android.gms.internal.ads;

final class zzcqf
  implements zzbao<zzcda>
{
  zzcqf(zzcqe paramzzcqe, zzcde paramzzcde)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    synchronized (this.zzgfi)
    {
      zzcqe.zza(this.zzgfi, null);
      this.zzgfh.zzadb().onAdFailedToLoad(zzcgl.zze(paramThrowable));
      zzcxz.zzc(paramThrowable, "NonagonRewardedAdImpl.onFailure");
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqf
 * JD-Core Version:    0.6.2
 */