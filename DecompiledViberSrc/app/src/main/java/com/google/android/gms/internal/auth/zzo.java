package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Status;

final class zzo
  implements WorkAccountApi.AddAccountResult
{
  private final Status mStatus;
  private final Account zzk;

  public zzo(Status paramStatus, Account paramAccount)
  {
    this.mStatus = paramStatus;
    this.zzk = paramAccount;
  }

  public final Account getAccount()
  {
    return this.zzk;
  }

  public final Status getStatus()
  {
    return this.mStatus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzo
 * JD-Core Version:    0.6.2
 */