package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@KeepForSdk
public abstract interface ProxyApi
{
  @KeepForSdk
  public abstract PendingResult<SpatulaHeaderResult> getSpatulaHeader(GoogleApiClient paramGoogleApiClient);

  @KeepForSdk
  public abstract PendingResult<ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest);

  @KeepForSdk
  public static abstract interface ProxyResult extends Result
  {
    @KeepForSdk
    public abstract ProxyResponse getResponse();
  }

  @KeepForSdk
  public static abstract interface SpatulaHeaderResult extends Result
  {
    @KeepForSdk
    public abstract String getSpatulaHeader();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyApi
 * JD-Core Version:    0.6.2
 */