package com.google.android.gms.internal.auth-api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzr extends GmsClient<zzw>
{
  private final Auth.AuthCredentialsOptions zzaq;

  public zzr(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 68, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzaq = paramAuthCredentialsOptions;
  }

  protected final Bundle getGetServiceRequestExtraArgs()
  {
    if (this.zzaq == null)
      return new Bundle();
    return this.zzaq.toBundle();
  }

  public final int getMinApkVersion()
  {
    return 12800000;
  }

  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
  }

  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.credentials.service.START";
  }

  final Auth.AuthCredentialsOptions zzd()
  {
    return this.zzaq;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzr
 * JD-Core Version:    0.6.2
 */