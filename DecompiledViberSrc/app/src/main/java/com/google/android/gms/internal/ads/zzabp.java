package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzabp
  implements Runnable
{
  zzabp(zzabo paramzzabo)
  {
  }

  public final void run()
  {
    if (zzabo.zza(this.zzcjz) != null);
    try
    {
      zzabo.zza(this.zzcjz).onAdFailedToLoad(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not notify onAdFailedToLoad event.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabp
 * JD-Core Version:    0.6.2
 */