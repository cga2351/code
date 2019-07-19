package com.google.android.gms.internal.auth-api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public final class zzx extends zzc
  implements zzw
{
  zzx(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
  }

  public final void zzc(zzu paramzzu)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zze.zzc(localParcel, paramzzu);
    transactAndReadExceptionReturnVoid(4, localParcel);
  }

  public final void zzc(zzu paramzzu, CredentialRequest paramCredentialRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zze.zzc(localParcel, paramzzu);
    zze.zzc(localParcel, paramCredentialRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }

  public final void zzc(zzu paramzzu, zzs paramzzs)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zze.zzc(localParcel, paramzzu);
    zze.zzc(localParcel, paramzzs);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }

  public final void zzc(zzu paramzzu, zzy paramzzy)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zze.zzc(localParcel, paramzzu);
    zze.zzc(localParcel, paramzzy);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzx
 * JD-Core Version:    0.6.2
 */