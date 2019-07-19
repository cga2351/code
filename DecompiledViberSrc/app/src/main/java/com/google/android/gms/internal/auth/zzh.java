package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzh
  implements WorkAccountApi
{
  private static final Status zzad = new Status(13);

  public final PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzj(this, WorkAccount.API, paramGoogleApiClient, paramString));
  }

  public final PendingResult<Result> removeWorkAccount(GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    return paramGoogleApiClient.execute(new zzl(this, WorkAccount.API, paramGoogleApiClient, paramAccount));
  }

  public final void setWorkAuthenticatorEnabled(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    setWorkAuthenticatorEnabledWithResult(paramGoogleApiClient, paramBoolean);
  }

  public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return paramGoogleApiClient.execute(new zzi(this, WorkAccount.API, paramGoogleApiClient, paramBoolean));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzh
 * JD-Core Version:    0.6.2
 */