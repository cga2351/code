package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.accounttransfer.zzn;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzu extends GmsClient<zzz>
{
  private final Bundle zzbv;

  public zzu(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, zzn paramzzn, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 128, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramzzn == null)
    {
      this.zzbv = new Bundle();
      return;
    }
    throw new NoSuchMethodError();
  }

  protected final Bundle getGetServiceRequestExtraArgs()
  {
    return this.zzbv;
  }

  public final int getMinApkVersion()
  {
    return 12451000;
  }

  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService";
  }

  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.accounttransfer.service.START";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzu
 * JD-Core Version:    0.6.2
 */