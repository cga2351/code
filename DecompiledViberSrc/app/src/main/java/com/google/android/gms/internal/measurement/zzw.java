package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzw extends zzq
  implements zzu
{
  zzw(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
  }

  public final Bundle zza(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel1, paramBundle);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    Bundle localBundle = (Bundle)zzs.zza(localParcel2, Bundle.CREATOR);
    localParcel2.recycle();
    return localBundle;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzw
 * JD-Core Version:    0.6.2
 */