package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzamy extends zzfm
  implements zzamw
{
  zzamy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
  }

  public final void onAdClicked()
    throws RemoteException
  {
    zza(1, obtainAndWriteInterfaceToken());
  }

  public final void onAdClosed()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void onAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(3, localParcel);
  }

  public final void onAdImpression()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final void onAdLeftApplication()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void onAdLoaded()
    throws RemoteException
  {
    zza(6, obtainAndWriteInterfaceToken());
  }

  public final void onAdOpened()
    throws RemoteException
  {
    zza(5, obtainAndWriteInterfaceToken());
  }

  public final void onAppEvent(String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zza(9, localParcel);
  }

  public final void onVideoEnd()
    throws RemoteException
  {
    zza(11, obtainAndWriteInterfaceToken());
  }

  public final void onVideoPause()
    throws RemoteException
  {
    zza(15, obtainAndWriteInterfaceToken());
  }

  public final void onVideoPlay()
    throws RemoteException
  {
    zza(20, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzafd paramzzafd, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzafd);
    localParcel.writeString(paramString);
    zza(10, localParcel);
  }

  public final void zza(zzamz paramzzamz)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzamz);
    zza(7, localParcel);
  }

  public final void zza(zzatr paramzzatr)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzatr);
    zza(16, localParcel);
  }

  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramBundle);
    zza(19, localParcel);
  }

  public final void zzb(zzatp paramzzatp)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzatp);
    zza(14, localParcel);
  }

  public final void zzcs(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    zza(17, localParcel);
  }

  public final void zzcz(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(12, localParcel);
  }

  public final void zzsm()
    throws RemoteException
  {
    zza(13, obtainAndWriteInterfaceToken());
  }

  public final void zzsn()
    throws RemoteException
  {
    zza(18, obtainAndWriteInterfaceToken());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamy
 * JD-Core Version:    0.6.2
 */