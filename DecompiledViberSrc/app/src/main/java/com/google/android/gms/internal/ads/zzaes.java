package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaes extends zzfm
  implements zzaeq
{
  zzaes(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
  }

  public final void unregisterNativeAd()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(1, localParcel);
  }

  public final void zzi(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(3, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaes
 * JD-Core Version:    0.6.2
 */