package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

public class AccountAccessor extends IAccountAccessor.Stub
{
  @KeepForSdk
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor)
  {
    Object localObject1 = null;
    long l;
    if (paramIAccountAccessor != null)
      l = Binder.clearCallingIdentity();
    try
    {
      Account localAccount = paramIAccountAccessor.getAccount();
      localObject1 = localAccount;
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }

  public boolean equals(Object paramObject)
  {
    throw new NoSuchMethodError();
  }

  public final Account getAccount()
  {
    throw new NoSuchMethodError();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.AccountAccessor
 * JD-Core Version:    0.6.2
 */