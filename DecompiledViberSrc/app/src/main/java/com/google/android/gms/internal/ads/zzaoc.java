package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaoc
  implements Runnable
{
  zzaoc(zzanv paramzzanv)
  {
  }

  public final void run()
  {
    try
    {
      zzanv.zza(this.zzdgz).onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaoc
 * JD-Core Version:    0.6.2
 */