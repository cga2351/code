package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzn extends zzp<Status>
{
  zzn(zzi paramzzi, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }

  protected final void zzc(Context paramContext, zzw paramzzw)
    throws RemoteException
  {
    paramzzw.zzc(new zzo(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzn
 * JD-Core Version:    0.6.2
 */