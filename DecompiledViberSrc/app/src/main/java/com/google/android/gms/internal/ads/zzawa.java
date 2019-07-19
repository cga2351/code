package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzawa extends zzfm
  implements zzavz
{
  zzawa(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
  }

  public final void onError(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(2, localParcel);
  }

  public final void zzk(String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zza(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawa
 * JD-Core Version:    0.6.2
 */