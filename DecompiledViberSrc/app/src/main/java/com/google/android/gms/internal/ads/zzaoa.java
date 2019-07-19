package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.a.a;

final class zzaoa
  implements Runnable
{
  zzaoa(zzanv paramzzanv, a.a parama)
  {
  }

  public final void run()
  {
    try
    {
      zzanv.zza(this.zzdgz).onAdFailedToLoad(zzaoh.zza(this.zzdha));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaoa
 * JD-Core Version:    0.6.2
 */