package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;

public final class zaq
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> mApi;
  private final boolean zaeb;
  private zar zaec;

  public zaq(Api<?> paramApi, boolean paramBoolean)
  {
    this.mApi = paramApi;
    this.zaeb = paramBoolean;
  }

  private final void zav()
  {
    Preconditions.checkNotNull(this.zaec, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }

  public final void onConnected(Bundle paramBundle)
  {
    zav();
    this.zaec.onConnected(paramBundle);
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zav();
    this.zaec.zaa(paramConnectionResult, this.mApi, this.zaeb);
  }

  public final void onConnectionSuspended(int paramInt)
  {
    zav();
    this.zaec.onConnectionSuspended(paramInt);
  }

  public final void zaa(zar paramzar)
  {
    this.zaec = paramzar;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaq
 * JD-Core Version:    0.6.2
 */