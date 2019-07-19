package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzcnf extends zzaou
{
  private zzcjx<zzaow, zzckz> zzfzw;

  private zzcnf(zzcnc paramzzcnc, zzcjx paramzzcjx)
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcnf
 * JD-Core Version:    0.6.2
 */