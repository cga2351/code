package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

final class zzapi
  implements SignalCallbacks
{
  zzapi(zzapd paramzzapd, zzaoz paramzzaoz)
  {
  }

  public final void onFailure(String paramString)
  {
    try
    {
      this.zzdhm.onFailure(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void onSuccess(String paramString)
  {
    try
    {
      this.zzdhm.zzdc(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapi
 * JD-Core Version:    0.6.2
 */