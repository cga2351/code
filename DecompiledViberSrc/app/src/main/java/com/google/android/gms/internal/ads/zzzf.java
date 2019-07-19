package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzzf extends zzfm
  implements zzzd
{
  zzzf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
  }

  public final void zza(PublisherAdViewOptions paramPublisherAdViewOptions)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramPublisherAdViewOptions);
    zza(9, localParcel);
  }

  public final void zza(zzadx paramzzadx)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzadx);
    zza(6, localParcel);
  }

  public final void zza(zzafh paramzzafh)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzafh);
    zza(3, localParcel);
  }

  public final void zza(zzafk paramzzafk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzafk);
    zza(4, localParcel);
  }

  public final void zza(zzaft paramzzaft, zzyb paramzzyb)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaft);
    zzfo.zza(localParcel, paramzzyb);
    zza(8, localParcel);
  }

  public final void zza(zzafw paramzzafw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzafw);
    zza(10, localParcel);
  }

  public final void zza(zzaiz paramzzaiz)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzaiz);
    zza(13, localParcel);
  }

  public final void zza(zzajf paramzzajf)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzajf);
    zza(14, localParcel);
  }

  public final void zza(zzyx paramzzyx)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzyx);
    zza(2, localParcel);
  }

  public final void zza(zzzw paramzzzw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzzw);
    zza(7, localParcel);
  }

  public final void zza(String paramString, zzafq paramzzafq, zzafn paramzzafn)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramzzafq);
    zzfo.zza(localParcel, paramzzafn);
    zza(5, localParcel);
  }

  public final zzza zzpk()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    IBinder localIBinder = localParcel.readStrongBinder();
    Object localObject;
    if (localIBinder == null)
      localObject = null;
    while (true)
    {
      localParcel.recycle();
      return localObject;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
      if ((localIInterface instanceof zzza))
        localObject = (zzza)localIInterface;
      else
        localObject = new zzzc(localIBinder);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzf
 * JD-Core Version:    0.6.2
 */