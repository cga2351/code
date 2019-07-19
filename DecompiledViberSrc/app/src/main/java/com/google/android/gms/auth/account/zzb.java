package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzc;

public abstract class zzb extends com.google.android.gms.internal.auth.zzb
  implements zza
{
  public zzb()
  {
    super("com.google.android.gms.auth.account.IWorkAccountCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzc((Account)zzc.zza(paramParcel1, Account.CREATOR));
    case 2:
    }
    while (true)
    {
      return true;
      zza(zzc.zza(paramParcel1));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.account.zzb
 * JD-Core Version:    0.6.2
 */