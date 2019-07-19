package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class zaam
  implements BaseGmsClient.ConnectionProgressReportCallbacks
{
  private final Api<?> mApi;
  private final boolean zaeb;
  private final WeakReference<zaak> zagj;

  public zaam(zaak paramzaak, Api<?> paramApi, boolean paramBoolean)
  {
    this.zagj = new WeakReference(paramzaak);
    this.mApi = paramApi;
    this.zaeb = paramBoolean;
  }

  public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
  {
    zaak localzaak = (zaak)this.zagj.get();
    if (localzaak == null)
      return;
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = zaak.zad(localzaak).zaed.getLooper();
    boolean bool1 = false;
    if (localLooper1 == localLooper2)
      bool1 = true;
    Preconditions.checkState(bool1, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zaak.zac(localzaak).lock();
    try
    {
      boolean bool2 = zaak.zaa(localzaak, 0);
      if (!bool2)
        return;
      if (!paramConnectionResult.isSuccess())
        zaak.zaa(localzaak, paramConnectionResult, this.mApi, this.zaeb);
      if (zaak.zak(localzaak))
        zaak.zaj(localzaak);
      return;
    }
    finally
    {
      zaak.zac(localzaak).unlock();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaam
 * JD-Core Version:    0.6.2
 */