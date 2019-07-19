package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzate extends zzfm
  implements zzatc
{
  zzate(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
  }

  public final void onRewardedVideoAdClosed()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void onRewardedVideoAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(7, localParcel);
  }

  public final void onRewardedVideoAdLeftApplication()
    throws RemoteException
  {
    zza(6, obtainAndWriteInterfaceToken());
  }

  public final void onRewardedVideoAdLoaded()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }

  public final void onRewardedVideoAdOpened()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void onRewardedVideoCompleted()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final void onRewardedVideoStarted()
    throws RemoteException
  {
    zza(3, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzass paramzzass)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzass);
    zza(5, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzate
 * JD-Core Version:    0.6.2
 */