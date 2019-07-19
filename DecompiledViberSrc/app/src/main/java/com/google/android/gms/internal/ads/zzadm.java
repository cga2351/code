package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzadm extends zzfm
  implements zzadk
{
  zzadm(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
  }

  public final String getContent()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }

  public final void recordClick()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void recordImpression()
    throws RemoteException
  {
    zza(5, obtainAndWriteInterfaceToken());
  }

  public final void zzo(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(3, localParcel);
  }

  public final String zzqz()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadm
 * JD-Core Version:    0.6.2
 */