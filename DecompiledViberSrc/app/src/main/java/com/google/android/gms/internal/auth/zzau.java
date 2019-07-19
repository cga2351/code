package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzau extends zzaq
{
  zzau(zzar paramzzar, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }

  protected final void zza(Context paramContext, zzan paramzzan)
    throws RemoteException
  {
    paramzzan.zza(new zzav(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzau
 * JD-Core Version:    0.6.2
 */