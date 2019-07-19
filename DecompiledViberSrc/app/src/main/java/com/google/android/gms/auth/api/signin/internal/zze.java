package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zze extends AsyncTaskLoader<Void>
  implements SignInConnectionListener
{
  private Semaphore zzbg = new Semaphore(0);
  private Set<GoogleApiClient> zzbh;

  public zze(Context paramContext, Set<GoogleApiClient> paramSet)
  {
    super(paramContext);
    this.zzbh = paramSet;
  }

  private final Void zzf()
  {
    Iterator localIterator = this.zzbh.iterator();
    int i = 0;
    if (localIterator.hasNext())
      if (!((GoogleApiClient)localIterator.next()).maybeSignIn(this))
        break label84;
    label84: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      try
      {
        this.zzbg.tryAcquire(i, 5L, TimeUnit.SECONDS);
        return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
        {
          Log.i("GACSignInLoader", "Unexpected InterruptedException", localInterruptedException);
          Thread.currentThread().interrupt();
        }
      }
    }
  }

  public final void onComplete()
  {
    this.zzbg.release();
  }

  protected final void onStartLoading()
  {
    this.zzbg.drainPermits();
    forceLoad();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zze
 * JD-Core Version:    0.6.2
 */