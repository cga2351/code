package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzdbf extends zzfm
  implements zzdbe
{
  zzdbf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.gass.internal.IGassService");
  }

  public final zzdbc zza(zzdba paramzzdba)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramzzdba);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    zzdbc localzzdbc = (zzdbc)zzfo.zza(localParcel2, zzdbc.CREATOR);
    localParcel2.recycle();
    return localzzdbc;
  }

  public final void zza(zzdax paramzzdax)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzdax);
    zza(2, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbf
 * JD-Core Version:    0.6.2
 */