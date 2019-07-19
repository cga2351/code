package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import java.util.Iterator;
import java.util.Set;

public final class zzg extends GmsClient<zzu>
{
  private final GoogleSignInOptions zzbi;

  public zzg(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInOptions != null);
    while (!paramClientSettings.getAllRequestedScopes().isEmpty())
    {
      GoogleSignInOptions.Builder localBuilder = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
      Iterator localIterator = paramClientSettings.getAllRequestedScopes().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          localBuilder.requestScopes((Scope)localIterator.next(), new Scope[0]);
          continue;
          paramGoogleSignInOptions = new GoogleSignInOptions.Builder().build();
          break;
        }
      paramGoogleSignInOptions = localBuilder.build();
    }
    this.zzbi = paramGoogleSignInOptions;
  }

  public final int getMinApkVersion()
  {
    return 12451000;
  }

  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }

  public final Intent getSignInIntent()
  {
    return zzh.zzc(getContext(), this.zzbi);
  }

  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }

  public final boolean providesSignIn()
  {
    return true;
  }

  public final GoogleSignInOptions zzg()
  {
    return this.zzbi;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg
 * JD-Core Version:    0.6.2
 */