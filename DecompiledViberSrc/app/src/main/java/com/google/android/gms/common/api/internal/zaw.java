package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

public final class zaw<O extends Api.ApiOptions> extends GoogleApi<O>
{
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
  private final Api.Client zaeq;
  private final zaq zaer;
  private final ClientSettings zaes;

  public zaw(Context paramContext, Api<O> paramApi, Looper paramLooper, Api.Client paramClient, zaq paramzaq, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder)
  {
    super(paramContext, paramApi, paramLooper);
    this.zaeq = paramClient;
    this.zaer = paramzaq;
    this.zaes = paramClientSettings;
    this.zacd = paramAbstractClientBuilder;
    this.zabm.zaa(this);
  }

  public final Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa)
  {
    this.zaer.zaa(paramzaa);
    return this.zaeq;
  }

  public final zace zaa(Context paramContext, Handler paramHandler)
  {
    return new zace(paramContext, paramHandler, this.zaes, this.zacd);
  }

  public final Api.Client zaab()
  {
    return this.zaeq;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaw
 * JD-Core Version:    0.6.2
 */