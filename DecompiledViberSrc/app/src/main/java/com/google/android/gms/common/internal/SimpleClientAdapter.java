package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.SimpleClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class SimpleClientAdapter<T extends IInterface> extends GmsClient<T>
{
  private final Api.SimpleClient<T> zapf;

  public SimpleClientAdapter(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings, Api.SimpleClient<T> paramSimpleClient)
  {
    super(paramContext, paramLooper, paramInt, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zapf = paramSimpleClient;
  }

  protected T createServiceInterface(IBinder paramIBinder)
  {
    return this.zapf.createServiceInterface(paramIBinder);
  }

  public Api.SimpleClient<T> getClient()
  {
    return this.zapf;
  }

  public int getMinApkVersion()
  {
    return super.getMinApkVersion();
  }

  protected String getServiceDescriptor()
  {
    return this.zapf.getServiceDescriptor();
  }

  protected String getStartServiceAction()
  {
    return this.zapf.getStartServiceAction();
  }

  protected void onSetConnectState(int paramInt, T paramT)
  {
    this.zapf.setState(paramInt, paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.SimpleClientAdapter
 * JD-Core Version:    0.6.2
 */