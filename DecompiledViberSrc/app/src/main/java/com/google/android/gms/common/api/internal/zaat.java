package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.signin.zad;
import java.util.concurrent.locks.Lock;

final class zaat
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zaat(zaak paramzaak)
  {
  }

  public final void onConnected(Bundle paramBundle)
  {
    zaak.zaf(this.zagi).zaa(new zaar(this.zagi));
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zaak.zac(this.zagi).lock();
    try
    {
      if (zaak.zab(this.zagi, paramConnectionResult))
      {
        zaak.zai(this.zagi);
        zaak.zaj(this.zagi);
      }
      while (true)
      {
        return;
        zaak.zaa(this.zagi, paramConnectionResult);
      }
    }
    finally
    {
      zaak.zac(this.zagi).unlock();
    }
  }

  public final void onConnectionSuspended(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaat
 * JD-Core Version:    0.6.2
 */