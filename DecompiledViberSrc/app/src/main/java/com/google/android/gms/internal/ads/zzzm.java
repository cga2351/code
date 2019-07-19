package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzzm extends zzfm
  implements zzzl
{
  zzzm(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
  }

  public final IBinder zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, String paramString, zzamq paramzzamq, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    zzfo.zza(localParcel1, paramzzyb);
    localParcel1.writeString(paramString);
    zzfo.zza(localParcel1, paramzzamq);
    localParcel1.writeInt(paramInt1);
    localParcel1.writeInt(paramInt2);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    IBinder localIBinder = localParcel2.readStrongBinder();
    localParcel2.recycle();
    return localIBinder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzm
 * JD-Core Version:    0.6.2
 */