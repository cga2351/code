package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

final class zacn
  implements Runnable
{
  zacn(zacm paramzacm, Result paramResult)
  {
  }

  public final void run()
  {
    try
    {
      BasePendingResult.zadm.set(Boolean.valueOf(true));
      PendingResult localPendingResult = zacm.zac(this.zakv).onSuccess(this.zaku);
      zacm.zad(this.zakv).sendMessage(zacm.zad(this.zakv).obtainMessage(0, localPendingResult));
      GoogleApiClient localGoogleApiClient3;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zacm.zad(this.zakv).sendMessage(zacm.zad(this.zakv).obtainMessage(1, localRuntimeException));
      GoogleApiClient localGoogleApiClient2;
      return;
    }
    finally
    {
      BasePendingResult.zadm.set(Boolean.valueOf(false));
      zacm.zaa(this.zakv, this.zaku);
      GoogleApiClient localGoogleApiClient1 = (GoogleApiClient)zacm.zae(this.zakv).get();
      if (localGoogleApiClient1 != null)
        localGoogleApiClient1.zab(this.zakv);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zacn
 * JD-Core Version:    0.6.2
 */