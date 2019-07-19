package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcls extends zzaoo
{
  private zzcjx<zzaow, zzckz> zzfzw;

  private zzcls(zzclp paramzzclp, zzcjx paramzzcjx)
  {
    this.zzfzw = paramzzcjx;
  }

  public final void zzdb(String paramString)
    throws RemoteException
  {
    ((zzckz)this.zzfzw.zzfzn).onAdFailedToLoad(0);
  }

  public final void zzsw()
    throws RemoteException
  {
    ((zzckz)this.zzfzw.zzfzn).onAdLoaded();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcls
 * JD-Core Version:    0.6.2
 */