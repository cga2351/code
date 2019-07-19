package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzyz extends zzfm
  implements zzyx
{
  zzyz(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IAdListener");
  }

  public final void onAdClicked()
    throws RemoteException
  {
    zza(6, obtainAndWriteInterfaceToken());
  }

  public final void onAdClosed()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }

  public final void onAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(2, localParcel);
  }

  public final void onAdImpression()
    throws RemoteException
  {
    zza(7, obtainAndWriteInterfaceToken());
  }

  public final void onAdLeftApplication()
    throws RemoteException
  {
    zza(3, obtainAndWriteInterfaceToken());
  }

  public final void onAdLoaded()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void onAdOpened()
    throws RemoteException
  {
    zza(5, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyz
 * JD-Core Version:    0.6.2
 */