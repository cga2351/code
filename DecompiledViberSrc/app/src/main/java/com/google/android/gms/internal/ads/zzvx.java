package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzvx extends zzfm
  implements zzvw
{
  zzvx(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
  }

  public final zzvq zza(zzvt paramzzvt)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramzzvt);
    Parcel localParcel2 = transactAndReadException(1, localParcel1);
    zzvq localzzvq = (zzvq)zzfo.zza(localParcel2, zzvq.CREATOR);
    localParcel2.recycle();
    return localzzvq;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvx
 * JD-Core Version:    0.6.2
 */