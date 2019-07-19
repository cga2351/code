package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.volley.Request;

public abstract class RequestManager<T extends RequestFactory>
{
  protected Request<?> a;
  protected T b;
  protected BackoffPolicy c;
  protected Handler d;

  public RequestManager(Looper paramLooper)
  {
    this.d = new Handler(paramLooper);
  }

  abstract Request<?> a();

  @VisibleForTesting
  void b()
  {
    this.a = a();
    MoPubRequestQueue localMoPubRequestQueue = Networking.getRequestQueue();
    if (localMoPubRequestQueue == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MoPubRequest queue is null. Clearing request." });
      c();
      return;
    }
    if (this.c.getRetryCount() == 0)
    {
      localMoPubRequestQueue.add(this.a);
      return;
    }
    localMoPubRequestQueue.addDelayedRequest(this.a, this.c.getBackoffMs());
  }

  @VisibleForTesting
  void c()
  {
    this.a = null;
    this.b = null;
    this.c = null;
  }

  public void cancelRequest()
  {
    MoPubRequestQueue localMoPubRequestQueue = Networking.getRequestQueue();
    if ((localMoPubRequestQueue != null) && (this.a != null))
      localMoPubRequestQueue.cancel(this.a);
    c();
  }

  public boolean isAtCapacity()
  {
    return this.a != null;
  }

  public void makeRequest(T paramT, BackoffPolicy paramBackoffPolicy)
  {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramBackoffPolicy);
    cancelRequest();
    this.b = paramT;
    this.c = paramBackoffPolicy;
    b();
  }

  public static abstract interface RequestFactory
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.RequestManager
 * JD-Core Version:    0.6.2
 */