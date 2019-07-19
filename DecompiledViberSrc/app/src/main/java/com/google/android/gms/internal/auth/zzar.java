package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;

public final class zzar
  implements ProxyApi
{
  public final PendingResult<ProxyApi.SpatulaHeaderResult> getSpatulaHeader(GoogleApiClient paramGoogleApiClient)
  {
    Preconditions.checkNotNull(paramGoogleApiClient);
    return paramGoogleApiClient.execute(new zzau(this, paramGoogleApiClient));
  }

  public final PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    Preconditions.checkNotNull(paramGoogleApiClient);
    Preconditions.checkNotNull(paramProxyRequest);
    return paramGoogleApiClient.execute(new zzas(this, paramGoogleApiClient, paramProxyRequest));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzar
 * JD-Core Version:    0.6.2
 */