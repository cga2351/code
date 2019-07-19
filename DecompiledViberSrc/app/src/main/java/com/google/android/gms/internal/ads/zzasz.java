package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzasz extends zzfm
  implements zzasx
{
  zzasz(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
  }

  public final void destroy()
    throws RemoteException
  {
    zza(8, obtainAndWriteInterfaceToken());
  }

  public final Bundle getAdMetadata()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(15, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(12, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final boolean isLoaded()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(5, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void pause()
    throws RemoteException
  {
    zza(6, obtainAndWriteInterfaceToken());
  }

  public final void resume()
    throws RemoteException
  {
    zza(7, obtainAndWriteInterfaceToken());
  }

  public final void setAppPackageName(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(17, localParcel);
  }

  public final void setCustomData(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(19, localParcel);
  }

  public final void setImmersiveMode(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(34, localParcel);
  }

  public final void setUserId(String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zza(13, localParcel);
  }

  public final void show()
    throws RemoteException
  {
    zza(2, obtainAndWriteInterfaceToken());
  }

  public final void zza(zzasv paramzzasv)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzasv);
    zza(16, localParcel);
  }

  public final void zza(zzatc paramzzatc)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzatc);
    zza(3, localParcel);
  }

  public final void zza(zzati paramzzati)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzati);
    zza(1, localParcel);
  }

  public final void zza(zzzn paramzzzn)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzzn);
    zza(14, localParcel);
  }

  public final void zzk(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(18, localParcel);
  }

  public final void zzl(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(9, localParcel);
  }

  public final void zzm(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(10, localParcel);
  }

  public final void zzn(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(11, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasz
 * JD-Core Version:    0.6.2
 */