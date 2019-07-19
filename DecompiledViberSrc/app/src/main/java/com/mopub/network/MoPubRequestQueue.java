package com.mopub.network;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.RequestQueue.RequestFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MoPubRequestQueue extends RequestQueue
{
  private final Map<Request<?>, a> a = new HashMap(10);

  MoPubRequestQueue(Cache paramCache, Network paramNetwork)
  {
    super(paramCache, paramNetwork);
  }

  @VisibleForTesting
  void a(Request<?> paramRequest, a parama)
  {
    Preconditions.checkNotNull(parama);
    if (this.a.containsKey(paramRequest))
      cancel(paramRequest);
    parama.a();
    this.a.put(paramRequest, parama);
  }

  public void addDelayedRequest(Request<?> paramRequest, int paramInt)
  {
    Preconditions.checkNotNull(paramRequest);
    a(paramRequest, new a(paramRequest, paramInt));
  }

  public void cancel(final Request<?> paramRequest)
  {
    Preconditions.checkNotNull(paramRequest);
    cancelAll(new RequestQueue.RequestFilter()
    {
      public boolean apply(Request<?> paramAnonymousRequest)
      {
        return paramRequest == paramAnonymousRequest;
      }
    });
  }

  public void cancelAll(RequestQueue.RequestFilter paramRequestFilter)
  {
    Preconditions.checkNotNull(paramRequestFilter);
    super.cancelAll(paramRequestFilter);
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramRequestFilter.apply((Request)localEntry.getKey()))
      {
        ((Request)localEntry.getKey()).cancel();
        ((a)localEntry.getValue()).b();
        localIterator.remove();
      }
    }
  }

  public void cancelAll(final Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    super.cancelAll(paramObject);
    cancelAll(new RequestQueue.RequestFilter()
    {
      public boolean apply(Request<?> paramAnonymousRequest)
      {
        return paramAnonymousRequest.getTag() == paramObject;
      }
    });
  }

  class a
  {
    final int a;
    final Handler b;
    final Runnable c;

    a(int arg2)
    {
      this(localRequest, i, new Handler());
    }

    @VisibleForTesting
    a(final int paramHandler, Handler arg3)
    {
      int i;
      this.a = i;
      Object localObject;
      this.b = localObject;
      this.c = new Runnable()
      {
        public void run()
        {
          MoPubRequestQueue.a(MoPubRequestQueue.this).remove(paramHandler);
          MoPubRequestQueue.this.add(paramHandler);
        }
      };
    }

    void a()
    {
      this.b.postDelayed(this.c, this.a);
    }

    void b()
    {
      this.b.removeCallbacks(this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MoPubRequestQueue
 * JD-Core Version:    0.6.2
 */