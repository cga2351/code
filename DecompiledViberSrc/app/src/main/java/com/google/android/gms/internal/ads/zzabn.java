package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzabn
  implements Runnable
{
  zzabn(zzabm paramzzabm)
  {
  }

  public final void run()
  {
    if (zzabk.zza(this.zzcjy.zzcjx) != null);
    try
    {
      zzabk.zza(this.zzcjy.zzcjx).onAdFailedToLoad(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not notify onAdFailedToLoad event.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabn
 * JD-Core Version:    0.6.2
 */