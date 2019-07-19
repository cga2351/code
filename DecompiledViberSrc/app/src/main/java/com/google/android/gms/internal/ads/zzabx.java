package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzabx
  implements Runnable
{
  zzabx(zzabw paramzzabw)
  {
  }

  public final void run()
  {
    if (zzabw.zza(this.zzcke) != null);
    try
    {
      zzabw.zza(this.zzcke).onRewardedVideoAdFailedToLoad(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabx
 * JD-Core Version:    0.6.2
 */