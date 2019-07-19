package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzatz extends zzfm
  implements zzatx
{
  zzatz(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
  }

  public final void onRewardedAdClosed()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void onRewardedAdFailedToShow(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(4, localParcel);
  }

  public final void onRewardedAdOpened()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzatr paramzzatr)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzatr);
    zza(3, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatz
 * JD-Core Version:    0.6.2
 */