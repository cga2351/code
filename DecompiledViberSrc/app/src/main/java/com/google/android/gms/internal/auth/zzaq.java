package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzaq extends BaseImplementation.ApiMethodImpl<ProxyApi.SpatulaHeaderResult, zzak>
{
  public zzaq(GoogleApiClient paramGoogleApiClient)
  {
    super(AuthProxy.API, paramGoogleApiClient);
  }

  protected static ProxyApi.SpatulaHeaderResult zzc(Status paramStatus)
  {
    return new zzax(paramStatus);
  }

  protected abstract void zza(Context paramContext, zzan paramzzan)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzaq
 * JD-Core Version:    0.6.2
 */