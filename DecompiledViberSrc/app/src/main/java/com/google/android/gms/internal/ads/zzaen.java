package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzaen extends zzfm
  implements zzael
{
  zzaen(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
  }

  public final void destroy()
    throws RemoteException
  {
    zza(4, obtainAndWriteInterfaceToken());
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    localParcel.writeInt(paramInt);
    zza(5, localParcel);
  }

  public final void zzc(String paramString, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(1, localParcel);
  }

  public final IObjectWrapper zzcf(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(3, localParcel);
  }

  public final void zzi(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramIObjectWrapper);
    zza(6, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaen
 * JD-Core Version:    0.6.2
 */