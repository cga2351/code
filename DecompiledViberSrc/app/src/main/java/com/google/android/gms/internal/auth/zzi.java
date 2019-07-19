package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

final class zzi extends BaseImplementation.ApiMethodImpl<Result, zzr>
{
  zzi(zzh paramzzh, Api paramApi, GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    super(paramApi, paramGoogleApiClient);
  }

  protected final Result createFailedResult(Status paramStatus)
  {
    return new zzp(paramStatus);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzi
 * JD-Core Version:    0.6.2
 */