package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zze extends com.google.android.gms.internal.auth.zza
  implements zzc
{
  zze(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.account.IWorkAccountService");
  }

  public final void zza(zza paramzza, Account paramAccount)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.gms.internal.auth.zzc.zza(localParcel, paramzza);
    com.google.android.gms.internal.auth.zzc.zza(localParcel, paramAccount);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }

  public final void zza(zza paramzza, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.gms.internal.auth.zzc.zza(localParcel, paramzza);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }

  public final void zzb(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.gms.internal.auth.zzc.writeBoolean(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.account.zze
 * JD-Core Version:    0.6.2
 */