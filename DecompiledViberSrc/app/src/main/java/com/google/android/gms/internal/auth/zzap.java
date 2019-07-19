package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzap extends BaseImplementation.ApiMethodImpl<ProxyApi.ProxyResult, zzak>
{
  public zzap(GoogleApiClient paramGoogleApiClient)
  {
    super(AuthProxy.API, paramGoogleApiClient);
  }

  protected abstract void zza(Context paramContext, zzan paramzzan)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzap
 * JD-Core Version:    0.6.2
 */