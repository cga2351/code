package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzj extends zzp<CredentialRequestResult>
{
  zzj(zzi paramzzi, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }

  protected final void zzc(Context paramContext, zzw paramzzw)
    throws RemoteException
  {
    paramzzw.zzc(new zzk(this), this.zzam);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzj
 * JD-Core Version:    0.6.2
 */