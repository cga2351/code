package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

final class zzano
  implements InitializationCompleteCallback
{
  zzano(zzanm paramzzanm, zzaip paramzzaip)
  {
  }

  public final void onInitializationFailed(String paramString)
  {
    try
    {
      this.zzdgm.onInitializationFailed(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void onInitializationSucceeded()
  {
    try
    {
      this.zzdgm.onInitializationSucceeded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzano
 * JD-Core Version:    0.6.2
 */