package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace extends zac
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static Api.AbstractClientBuilder<? extends zad, SignInOptions> zakh = zaa.zapg;
  private final Context mContext;
  private final Handler mHandler;
  private Set<Scope> mScopes;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zaau;
  private ClientSettings zaes;
  private zad zaga;
  private zach zaki;

  public zace(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings)
  {
    this(paramContext, paramHandler, paramClientSettings, zakh);
  }

  public zace(Context paramContext, Handler paramHandler, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.zaes = ((ClientSettings)Preconditions.checkNotNull(paramClientSettings, "ClientSettings must not be null"));
    this.mScopes = paramClientSettings.getRequiredScopes();
    this.zaau = paramAbstractClientBuilder;
  }

  private final void zac(zaj paramzaj)
  {
    ConnectionResult localConnectionResult1 = paramzaj.getConnectionResult();
    if (localConnectionResult1.isSuccess())
    {
      ResolveAccountResponse localResolveAccountResponse = paramzaj.zacw();
      ConnectionResult localConnectionResult2 = localResolveAccountResponse.getConnectionResult();
      if (!localConnectionResult2.isSuccess())
      {
        String str = String.valueOf(localConnectionResult2);
        Log.wtf("SignInCoordinator", 48 + String.valueOf(str).length() + "Sign-in succeeded with resolve account failure: " + str, new Exception());
        this.zaki.zag(localConnectionResult2);
        this.zaga.disconnect();
        return;
      }
      this.zaki.zaa(localResolveAccountResponse.getAccountAccessor(), this.mScopes);
    }
    while (true)
    {
      this.zaga.disconnect();
      return;
      this.zaki.zag(localConnectionResult1);
    }
  }

  public final void onConnected(Bundle paramBundle)
  {
    this.zaga.zaa(this);
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zaki.zag(paramConnectionResult);
  }

  public final void onConnectionSuspended(int paramInt)
  {
    this.zaga.disconnect();
  }

  public final void zaa(zach paramzach)
  {
    if (this.zaga != null)
      this.zaga.disconnect();
    this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
    this.zaga = ((zad)this.zaau.buildClient(this.mContext, this.mHandler.getLooper(), this.zaes, this.zaes.getSignInOptions(), this, this));
    this.zaki = paramzach;
    if ((this.mScopes == null) || (this.mScopes.isEmpty()))
    {
      this.mHandler.post(new zacf(this));
      return;
    }
    this.zaga.connect();
  }

  public final void zab(zaj paramzaj)
  {
    this.mHandler.post(new zacg(this, paramzaj));
  }

  public final zad zabq()
  {
    return this.zaga;
  }

  public final void zabs()
  {
    if (this.zaga != null)
      this.zaga.disconnect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zace
 * JD-Core Version:    0.6.2
 */