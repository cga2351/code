package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaep extends zzfm
  implements zzaeo
{
  zzaep(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
  }

  public final IBinder zza(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper1);
    zzfo.zza(localParcel1, paramIObjectWrapper2);
    zzfo.zza(localParcel1, paramIObjectWrapper3);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    localParcel2.recycle();
    return localIBinder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaep
 * JD-Core Version:    0.6.2
 */