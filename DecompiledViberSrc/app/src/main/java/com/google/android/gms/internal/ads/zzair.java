package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzair extends zzfm
  implements zzaip
{
  zzair(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
  }

  public final void onInitializationFailed(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(3, localParcel);
  }

  public final void onInitializationSucceeded()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzair
 * JD-Core Version:    0.6.2
 */