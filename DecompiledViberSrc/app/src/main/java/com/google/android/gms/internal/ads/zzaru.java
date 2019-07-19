package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public final class zzaru extends zzfm
  implements zzars
{
  zzaru(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
  }

  public final void zza(zzayn paramzzayn)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzayn);
    zza(2, localParcel);
  }

  public final void zzb(ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramParcelFileDescriptor);
    zza(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaru
 * JD-Core Version:    0.6.2
 */