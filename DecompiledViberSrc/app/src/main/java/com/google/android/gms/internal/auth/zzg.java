package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public final class zzg extends zza
  implements zze
{
  zzg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.auth.IAuthManagerService");
  }

  public final Bundle zza(Account paramAccount)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel1, paramAccount);
    Parcel localParcel2 = transactAndReadException(7, localParcel1);
    Bundle localBundle = (Bundle)zzc.zza(localParcel2, Bundle.CREATOR);
    localParcel2.recycle();
    return localBundle;
  }

  public final Bundle zza(Account paramAccount, String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel1, paramAccount);
    localParcel1.writeString(paramString);
    zzc.zza(localParcel1, paramBundle);
    Parcel localParcel2 = transactAndReadException(5, localParcel1);
    Bundle localBundle = (Bundle)zzc.zza(localParcel2, Bundle.CREATOR);
    localParcel2.recycle();
    return localBundle;
  }

  public final Bundle zza(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    Parcel localParcel2 = transactAndReadException(8, localParcel1);
    Bundle localBundle = (Bundle)zzc.zza(localParcel2, Bundle.CREATOR);
    localParcel2.recycle();
    return localBundle;
  }

  public final Bundle zza(String paramString, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    localParcel1.writeString(paramString);
    zzc.zza(localParcel1, paramBundle);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    Bundle localBundle = (Bundle)zzc.zza(localParcel2, Bundle.CREATOR);
    localParcel2.recycle();
    return localBundle;
  }

  public final AccountChangeEventsResponse zza(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel1, paramAccountChangeEventsRequest);
    Parcel localParcel2 = transactAndReadException(3, localParcel1);
    AccountChangeEventsResponse localAccountChangeEventsResponse = (AccountChangeEventsResponse)zzc.zza(localParcel2, AccountChangeEventsResponse.CREATOR);
    localParcel2.recycle();
    return localAccountChangeEventsResponse;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzg
 * JD-Core Version:    0.6.2
 */