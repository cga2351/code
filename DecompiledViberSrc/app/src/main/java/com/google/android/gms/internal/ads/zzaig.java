package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaig extends zzfm
  implements zzaif
{
  zzaig(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
  }

  public final void zza(zzahz paramzzahz, zzaid paramzzaid)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel, paramzzahz);
    zzfo.zza(localParcel, paramzzaid);
    zzb(2, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaig
 * JD-Core Version:    0.6.2
 */