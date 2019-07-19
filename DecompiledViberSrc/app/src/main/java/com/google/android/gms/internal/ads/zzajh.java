package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzajh extends zzfm
  implements zzajf
{
  zzajh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
  }

  public final void zza(zzajb paramzzajb)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzajb);
    zza(1, localParcel);
  }

  public final void zzcr(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(2, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzajh
 * JD-Core Version:    0.6.2
 */