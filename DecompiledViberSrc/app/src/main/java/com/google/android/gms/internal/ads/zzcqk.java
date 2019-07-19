package com.google.android.gms.internal.ads;

final class zzcqk
  implements zzbao<zzcda>
{
  zzcqk(zzcqi paramzzcqi, zzcde paramzzcde)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    synchronized (this.zzgfo)
    {
      zzcqi.zza(this.zzgfo, null);
      this.zzgfh.zzadb().onAdFailedToLoad(zzcgl.zze(paramThrowable));
      zzcxz.zzc(paramThrowable, "NonagonRewardedVideoAdImpl.onFailure");
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqk
 * JD-Core Version:    0.6.2
 */