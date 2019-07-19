package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaue extends zzfm
  implements zzauc
{
  zzaue(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
  }

  public final void onRewardedAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(2, localParcel);
  }

  public final void onRewardedAdLoaded()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaue
 * JD-Core Version:    0.6.2
 */