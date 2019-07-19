package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzatw extends zzfm
  implements zzatu
{
  zzatw(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
  }

  public final Bundle getAdMetadata()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(9, obtainAndWriteInterfaceToken());
    Bundle localBundle = (Bundle)zzfo.zza(localParcel, Bundle.CREATOR);
    localParcel.recycle();
    return localBundle;
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(4, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final boolean isLoaded()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(3, obtainAndWriteInterfaceToken());
    boolean bool = zzfo.zza(localParcel);
    localParcel.recycle();
    return bool;
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zzfo.writeBoolean(localParcel, paramBoolean);
    zza(10, localParcel);
  }

  public final void zza(zzaam paramzzaam)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaam);
    zza(8, localParcel);
  }

  public final void zza(zzatx paramzzatx)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzatx);
    zza(2, localParcel);
  }

  public final void zza(zzauf paramzzauf)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzauf);
    zza(6, localParcel);
  }

  public final void zza(zzaun paramzzaun)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaun);
    zza(7, localParcel);
  }

  public final void zza(zzxx paramzzxx, zzauc paramzzauc)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzxx);
    zzfo.zza(localParcel, paramzzauc);
    zza(1, localParcel);
  }

  public final void zzj(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(5, localParcel);
  }

  public final zzatr zzqh()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(11, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
      if ((localIInterface instanceof zzatr))
        localObject = (zzatr)localIInterface;
      else
        localObject = new zzatt(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatw
 * JD-Core Version:    0.6.2
 */