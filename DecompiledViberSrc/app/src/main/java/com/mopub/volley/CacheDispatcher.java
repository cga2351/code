package com.mopub.volley;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread
{
  private static final boolean a = VolleyLog.DEBUG;
  private final BlockingQueue<Request<?>> b;
  private final BlockingQueue<Request<?>> c;
  private final Cache d;
  private final ResponseDelivery e;
  private volatile boolean f = false;
  private final a g;

  public CacheDispatcher(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramCache;
    this.e = paramResponseDelivery;
    this.g = new a(this);
  }

  private void a()
    throws InterruptedException
  {
    a((Request)this.b.take());
  }

  void a(final Request<?> paramRequest)
    throws InterruptedException
  {
    paramRequest.addMarker("cache-queue-take");
    paramRequest.a(1);
    while (true)
    {
      Response localResponse;
      try
      {
        if (paramRequest.isCanceled())
        {
          paramRequest.b("cache-discard-canceled");
          return;
        }
        Cache.Entry localEntry = this.d.get(paramRequest.getCacheKey());
        if (localEntry == null)
        {
          paramRequest.addMarker("cache-miss");
          if (!a.a(this.g, paramRequest))
            this.c.put(paramRequest);
          return;
        }
        if (localEntry.isExpired())
        {
          paramRequest.addMarker("cache-hit-expired");
          paramRequest.setCacheEntry(localEntry);
          if (!a.a(this.g, paramRequest))
            this.c.put(paramRequest);
          return;
        }
        paramRequest.addMarker("cache-hit");
        localResponse = paramRequest.a(new NetworkResponse(localEntry.data, localEntry.responseHeaders));
        paramRequest.addMarker("cache-hit-parsed");
        if (!localEntry.refreshNeeded())
        {
          this.e.postResponse(paramRequest, localResponse);
          return;
        }
        paramRequest.addMarker("cache-hit-refresh-needed");
        paramRequest.setCacheEntry(localEntry);
        localResponse.intermediate = true;
        if (!a.a(this.g, paramRequest))
        {
          this.e.postResponse(paramRequest, localResponse, new Runnable()
          {
            public void run()
            {
              try
              {
                CacheDispatcher.a(CacheDispatcher.this).put(paramRequest);
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          });
          continue;
        }
      }
      finally
      {
        paramRequest.a(2);
      }
      this.e.postResponse(paramRequest, localResponse);
    }
  }

  public void quit()
  {
    this.f = true;
    interrupt();
  }

  public void run()
  {
    if (a)
      VolleyLog.v("start new dispatcher", new Object[0]);
    Process.setThreadPriority(10);
    this.d.initialize();
    while (true)
      try
      {
        a();
      }
      catch (InterruptedException localInterruptedException)
      {
        if (this.f)
        {
          Thread.currentThread().interrupt();
          return;
        }
        VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
      }
  }

  private static class a
    implements Request.a
  {
    private final Map<String, List<Request<?>>> a = new HashMap();
    private final CacheDispatcher b;

    a(CacheDispatcher paramCacheDispatcher)
    {
      this.b = paramCacheDispatcher;
    }

    private boolean a(Request<?> paramRequest)
    {
      try
      {
        String str = paramRequest.getCacheKey();
        boolean bool2;
        if (this.a.containsKey(str))
        {
          Object localObject2 = (List)this.a.get(str);
          if (localObject2 == null)
            localObject2 = new ArrayList();
          paramRequest.addMarker("waiting-for-response");
          ((List)localObject2).add(paramRequest);
          this.a.put(str, localObject2);
          if (VolleyLog.DEBUG)
            VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          bool2 = true;
        }
        while (true)
        {
          return bool2;
          this.a.put(str, null);
          paramRequest.a(this);
          boolean bool1 = VolleyLog.DEBUG;
          bool2 = false;
          if (bool1)
          {
            VolleyLog.d("new request, sending to network %s", new Object[] { str });
            bool2 = false;
          }
        }
      }
      finally
      {
      }
    }

    public void onNoUsableResponseReceived(Request<?> paramRequest)
    {
      try
      {
        String str = paramRequest.getCacheKey();
        List localList = (List)this.a.remove(str);
        Request localRequest;
        if ((localList != null) && (!localList.isEmpty()))
        {
          if (VolleyLog.DEBUG)
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = Integer.valueOf(localList.size());
            arrayOfObject2[1] = str;
            VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", arrayOfObject2);
          }
          localRequest = (Request)localList.remove(0);
          this.a.put(str, localList);
          localRequest.a(this);
        }
        try
        {
          CacheDispatcher.a(this.b).put(localRequest);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
          {
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = localInterruptedException.toString();
            VolleyLog.e("Couldn't add request to queue. %s", arrayOfObject1);
            Thread.currentThread().interrupt();
            this.b.quit();
          }
        }
      }
      finally
      {
      }
    }

    public void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse)
    {
      if ((paramResponse.cacheEntry == null) || (paramResponse.cacheEntry.isExpired()))
        onNoUsableResponseReceived(paramRequest);
      while (true)
      {
        return;
        String str = paramRequest.getCacheKey();
        try
        {
          List localList = (List)this.a.remove(str);
          if (localList == null)
            continue;
          if (VolleyLog.DEBUG)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Integer.valueOf(localList.size());
            arrayOfObject[1] = str;
            VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", arrayOfObject);
          }
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            Request localRequest = (Request)localIterator.next();
            CacheDispatcher.b(this.b).postResponse(localRequest, paramResponse);
          }
        }
        finally
        {
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.CacheDispatcher
 * JD-Core Version:    0.6.2
 */