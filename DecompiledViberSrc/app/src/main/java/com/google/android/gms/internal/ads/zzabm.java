package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.RemoteException;

final class zzabm extends zzzb
{
  private zzabm(zzabk paramzzabk)
  {
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    return null;
  }

  public final boolean isLoading()
    throws RemoteException
  {
    return false;
  }

  public final void zza(zzxx paramzzxx)
    throws RemoteException
  {
    zza(paramzzxx, 1);
  }

  public final void zza(zzxx paramzzxx, int paramInt)
    throws RemoteException
  {
    zzbae.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
    zzazu.zzyr.post(new zzabn(this));
  }

  public final String zzpj()
    throws RemoteException
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabm
 * JD-Core Version:    0.6.2
 */