package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaje extends zzfm
  implements zzajd
{
  zzaje(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
  }

  public final void zzcq(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(2, localParcel);
  }

  public final void zzrt()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaje
 * JD-Core Version:    0.6.2
 */