package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zacm<R extends Result> extends TransformedResult<R>
  implements ResultCallback<R>
{
  private final Object zadn = new Object();
  private final WeakReference<GoogleApiClient> zadp;
  private ResultTransform<? super R, ? extends Result> zakn = null;
  private zacm<? extends Result> zako = null;
  private volatile ResultCallbacks<? super R> zakp = null;
  private PendingResult<R> zakq = null;
  private Status zakr = null;
  private final zaco zaks;
  private boolean zakt = false;

  public zacm(WeakReference<GoogleApiClient> paramWeakReference)
  {
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zadp = paramWeakReference;
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zadp.get();
    if (localGoogleApiClient != null);
    for (Looper localLooper = localGoogleApiClient.getLooper(); ; localLooper = Looper.getMainLooper())
    {
      this.zaks = new zaco(this, localLooper);
      return;
    }
  }

  private static void zab(Result paramResult)
  {
    if ((paramResult instanceof Releasable));
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str = String.valueOf(paramResult);
      Log.w("TransformedResultImpl", 18 + String.valueOf(str).length() + "Unable to release " + str, localRuntimeException);
    }
  }

  @GuardedBy("mSyncToken")
  private final void zabu()
  {
    if ((this.zakn == null) && (this.zakp == null));
    do
    {
      return;
      GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zadp.get();
      if ((!this.zakt) && (this.zakn != null) && (localGoogleApiClient != null))
      {
        localGoogleApiClient.zaa(this);
        this.zakt = true;
      }
      if (this.zakr != null)
      {
        zae(this.zakr);
        return;
      }
    }
    while (this.zakq == null);
    this.zakq.setResultCallback(this);
  }

  @GuardedBy("mSyncToken")
  private final boolean zabw()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)this.zadp.get();
    return (this.zakp != null) && (localGoogleApiClient != null);
  }

  private final void zad(Status paramStatus)
  {
    synchronized (this.zadn)
    {
      this.zakr = paramStatus;
      zae(this.zakr);
      return;
    }
  }

  private final void zae(Status paramStatus)
  {
    synchronized (this.zadn)
    {
      if (this.zakn != null)
      {
        localStatus = this.zakn.onFailure(paramStatus);
        Preconditions.checkNotNull(localStatus, "onFailure must not return null");
        this.zako.zad(localStatus);
      }
      while (!zabw())
      {
        Status localStatus;
        return;
      }
      this.zakp.onFailure(paramStatus);
    }
  }

  public final void andFinally(ResultCallbacks<? super R> paramResultCallbacks)
  {
    boolean bool1 = true;
    while (true)
    {
      synchronized (this.zadn)
      {
        if (this.zakp == null)
        {
          bool2 = bool1;
          Preconditions.checkState(bool2, "Cannot call andFinally() twice.");
          if (this.zakn != null)
            break label64;
          Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zakp = paramResultCallbacks;
          zabu();
          return;
        }
      }
      boolean bool2 = false;
      continue;
      label64: bool1 = false;
    }
  }

  public final void onResult(R paramR)
  {
    while (true)
    {
      synchronized (this.zadn)
      {
        if (paramR.getStatus().isSuccess())
        {
          if (this.zakn != null)
          {
            zacc.zabb().submit(new zacn(this, paramR));
            return;
          }
          if (!zabw())
            continue;
          this.zakp.onSuccess(paramR);
        }
      }
      zad(paramR.getStatus());
      zab(paramR);
    }
  }

  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool1 = true;
    while (true)
    {
      synchronized (this.zadn)
      {
        if (this.zakn == null)
        {
          bool2 = bool1;
          Preconditions.checkState(bool2, "Cannot call then() twice.");
          if (this.zakp != null)
            break label85;
          Preconditions.checkState(bool1, "Cannot call then() and andFinally() on the same TransformedResult.");
          this.zakn = paramResultTransform;
          zacm localzacm = new zacm(this.zadp);
          this.zako = localzacm;
          zabu();
          return localzacm;
        }
      }
      boolean bool2 = false;
      continue;
      label85: bool1 = false;
    }
  }

  public final void zaa(PendingResult<?> paramPendingResult)
  {
    synchronized (this.zadn)
    {
      this.zakq = paramPendingResult;
      zabu();
      return;
    }
  }

  final void zabv()
  {
    this.zakp = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zacm
 * JD-Core Version:    0.6.2
 */