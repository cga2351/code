package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzarp extends zzfm
  implements zzarn
{
  zzarp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
  }

  public final zzarj zza(zzarh paramzzarh)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramzzarh);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    zzarj localzzarj = (zzarj)zzfo.zza(localParcel2, zzarj.CREATOR);
    localParcel2.recycle();
    return localzzarj;
  }

  public final void zza(zzarh paramzzarh, zzarq paramzzarq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzarh);
    zzfo.zza(localParcel, paramzzarq);
    zza(2, localParcel);
  }

  public final void zza(zzary paramzzary, zzars paramzzars)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzary);
    zzfo.zza(localParcel, paramzzars);
    zza(4, localParcel);
  }

  public final void zzb(zzary paramzzary, zzars paramzzars)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzary);
    zzfo.zza(localParcel, paramzzars);
    zza(5, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzarp
 * JD-Core Version:    0.6.2
 */