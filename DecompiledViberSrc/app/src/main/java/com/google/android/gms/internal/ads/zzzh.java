package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzzh extends zzfm
  implements zzzg
{
  zzzh(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
  }

  public final IBinder zzc(IObjectWrapper paramIObjectWrapper, String paramString, zzamq paramzzamq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    localParcel2.recycle();
    return localIBinder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzh
 * JD-Core Version:    0.6.2
 */