package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

final class zzl extends BaseImplementation.ApiMethodImpl<Result, zzr>
{
  zzl(zzh paramzzh, Api paramApi, GoogleApiClient paramGoogleApiClient, Account paramAccount)
  {
    super(paramApi, paramGoogleApiClient);
  }

  protected final Result createFailedResult(Status paramStatus)
  {
    return new zzq(paramStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzl
 * JD-Core Version:    0.6.2
 */