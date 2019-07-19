package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public final class zzao extends zza
  implements zzan
{
  zzao(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.internal.IAuthService");
  }

  public final void zza(zzal paramzzal)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzal);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }

  public final void zza(zzal paramzzal, ProxyRequest paramProxyRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzal);
    zzc.zza(localParcel, paramProxyRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzao
 * JD-Core Version:    0.6.2
 */