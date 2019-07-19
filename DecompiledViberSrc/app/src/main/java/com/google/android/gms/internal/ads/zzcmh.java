package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcmh extends zzaor
{
  private zzcjx<zzaow, zzckz> zzfzw;

  private zzcmh(zzcmf paramzzcmf, zzcjx paramzzcjx)
  {
    this.zzfzw = paramzzcjx;
  }

  public final void zza(zzanh paramzzanh)
    throws RemoteException
  {
    zzcmf.zza(this.zzgbb, paramzzanh);
    ((zzckz)this.zzfzw.zzfzn).onAdLoaded();
  }

  public final void zzdb(String paramString)
    throws RemoteException
  {
    ((zzckz)this.zzfzw.zzfzn).onAdFailedToLoad(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmh
 * JD-Core Version:    0.6.2
 */