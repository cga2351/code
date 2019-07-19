package com.mopub.volley;

import android.os.Handler;
import android.os.Looper;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue
{
  private final AtomicInteger a = new AtomicInteger();
  private final Set<Request<?>> b = new HashSet();
  private final PriorityBlockingQueue<Request<?>> c = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<Request<?>> d = new PriorityBlockingQueue();
  private final Cache e;
  private final Network f;
  private final ResponseDelivery g;
  private final NetworkDispatcher[] h;
  private CacheDispatcher i;
  private final List<RequestFinishedListener> j = new ArrayList();
  private final List<RequestEventListener> k = new ArrayList();

  public RequestQueue(Cache paramCache, Network paramNetwork)
  {
    this(paramCache, paramNetwork, 4);
  }

  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt)
  {
    this(paramCache, paramNetwork, paramInt, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }

  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    this.e = paramCache;
    this.f = paramNetwork;
    this.h = new NetworkDispatcher[paramInt];
    this.g = paramResponseDelivery;
  }

  <T> void a(Request<T> paramRequest)
  {
    synchronized (this.b)
    {
      this.b.remove(paramRequest);
      synchronized (this.j)
      {
        Iterator localIterator = this.j.iterator();
        if (localIterator.hasNext())
          ((RequestFinishedListener)localIterator.next()).onRequestFinished(paramRequest);
      }
    }
    a(paramRequest, 5);
  }

  void a(Request<?> paramRequest, int paramInt)
  {
    synchronized (this.k)
    {
      Iterator localIterator = this.k.iterator();
      if (localIterator.hasNext())
        ((RequestEventListener)localIterator.next()).onRequestEvent(paramRequest, paramInt);
    }
  }

  public <T> Request<T> add(Request<T> paramRequest)
  {
    paramRequest.setRequestQueue(this);
    synchronized (this.b)
    {
      this.b.add(paramRequest);
      paramRequest.setSequence(getSequenceNumber());
      paramRequest.addMarker("add-to-queue");
      a(paramRequest, 0);
      if (!paramRequest.shouldCache())
      {
        this.d.add(paramRequest);
        return paramRequest;
      }
    }
    this.c.add(paramRequest);
    return paramRequest;
  }

  public void addRequestEventListener(RequestEventListener paramRequestEventListener)
  {
    synchronized (this.k)
    {
      this.k.add(paramRequestEventListener);
      return;
    }
  }

  @Deprecated
  public <T> void addRequestFinishedListener(RequestFinishedListener<T> paramRequestFinishedListener)
  {
    synchronized (this.j)
    {
      this.j.add(paramRequestFinishedListener);
      return;
    }
  }

  public void cancelAll(RequestFilter paramRequestFilter)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        if (paramRequestFilter.apply(localRequest))
          localRequest.cancel();
      }
    }
  }

  public void cancelAll(final Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    cancelAll(new RequestFilter()
    {
      public boolean apply(Request<?> paramAnonymousRequest)
      {
        return paramAnonymousRequest.getTag() == paramObject;
      }
    });
  }

  public Cache getCache()
  {
    return this.e;
  }

  public int getSequenceNumber()
  {
    return this.a.incrementAndGet();
  }

  public void removeRequestEventListener(RequestEventListener paramRequestEventListener)
  {
    synchronized (this.k)
    {
      this.k.remove(paramRequestEventListener);
      return;
    }
  }

  @Deprecated
  public <T> void removeRequestFinishedListener(RequestFinishedListener<T> paramRequestFinishedListener)
  {
    synchronized (this.j)
    {
      this.j.remove(paramRequestFinishedListener);
      return;
    }
  }

  public void start()
  {
    stop();
    this.i = new CacheDispatcher(this.c, this.d, this.e, this.g);
    this.i.start();
    for (int m = 0; m < this.h.length; m++)
    {
      NetworkDispatcher localNetworkDispatcher = new NetworkDispatcher(this.d, this.f, this.e, this.g);
      this.h[m] = localNetworkDispatcher;
      localNetworkDispatcher.start();
    }
  }

  public void stop()
  {
    if (this.i != null)
      this.i.quit();
    for (NetworkDispatcher localNetworkDispatcher : this.h)
      if (localNetworkDispatcher != null)
        localNetworkDispatcher.quit();
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface RequestEvent
  {
    public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
    public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
    public static final int REQUEST_FINISHED = 5;
    public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
    public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
    public static final int REQUEST_QUEUED;
  }

  public static abstract interface RequestEventListener
  {
    public abstract void onRequestEvent(Request<?> paramRequest, int paramInt);
  }

  public static abstract interface RequestFilter
  {
    public abstract boolean apply(Request<?> paramRequest);
  }

  @Deprecated
  public static abstract interface RequestFinishedListener<T>
  {
    public abstract void onRequestFinished(Request<T> paramRequest);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.RequestQueue
 * JD-Core Version:    0.6.2
 */