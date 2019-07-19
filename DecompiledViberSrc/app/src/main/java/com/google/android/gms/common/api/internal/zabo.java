package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import java.util.Collections;
import java.util.Map;

final class zabo
  implements Runnable
{
  zabo(GoogleApiManager.zac paramzac, ConnectionResult paramConnectionResult)
  {
  }

  public final void run()
  {
    if (this.zaiy.isSuccess())
    {
      GoogleApiManager.zac.zaa(this.zajf, true);
      if (GoogleApiManager.zac.zaa(this.zajf).requiresSignIn())
      {
        GoogleApiManager.zac.zab(this.zajf);
        return;
      }
      try
      {
        GoogleApiManager.zac.zaa(this.zajf).getRemoteService(null, Collections.emptySet());
        return;
      }
      catch (SecurityException localSecurityException)
      {
        ((GoogleApiManager.zaa)GoogleApiManager.zaj(this.zajf.zail).get(GoogleApiManager.zac.zac(this.zajf))).onConnectionFailed(new ConnectionResult(10));
        return;
      }
    }
    ((GoogleApiManager.zaa)GoogleApiManager.zaj(this.zajf.zail).get(GoogleApiManager.zac.zac(this.zajf))).onConnectionFailed(this.zaiy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabo
 * JD-Core Version:    0.6.2
 */