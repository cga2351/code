package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zad
  implements zac
{
  public final PendingResult<Status> zaa(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new zae(this, paramGoogleApiClient));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.zad
 * JD-Core Version:    0.6.2
 */