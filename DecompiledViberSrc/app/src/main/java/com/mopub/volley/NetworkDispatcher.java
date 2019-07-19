package com.mopub.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread
{
  private final BlockingQueue<Request<?>> a;
  private final Network b;
  private final Cache c;
  private final ResponseDelivery d;
  private volatile boolean e = false;

  public NetworkDispatcher(BlockingQueue<Request<?>> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.a = paramBlockingQueue;
    this.b = paramNetwork;
    this.c = paramCache;
    this.d = paramResponseDelivery;
  }

  private void a()
    throws InterruptedException
  {
    a((Request)this.a.take());
  }

  private void a(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    VolleyError localVolleyError = paramRequest.a(paramVolleyError);
    this.d.postError(paramRequest, localVolleyError);
  }

  @TargetApi(14)
  private void b(Request<?> paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14)
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
  }

  void a(Request<?> paramRequest)
  {
    long l = SystemClock.elapsedRealtime();
    paramRequest.a(3);
    try
    {
      paramRequest.addMarker("network-queue-take");
      if (paramRequest.isCanceled())
      {
        paramRequest.b("network-discard-cancelled");
        paramRequest.e();
        return;
      }
      b(paramRequest);
      NetworkResponse localNetworkResponse = this.b.performRequest(paramRequest);
      paramRequest.addMarker("network-http-complete");
      if ((localNetworkResponse.notModified) && (paramRequest.hasHadResponseDelivered()))
      {
        paramRequest.b("not-modified");
        paramRequest.e();
        return;
      }
      Response localResponse = paramRequest.a(localNetworkResponse);
      paramRequest.addMarker("network-parse-complete");
      if ((paramRequest.shouldCache()) && (localResponse.cacheEntry != null))
      {
        this.c.put(paramRequest.getCacheKey(), localResponse.cacheEntry);
        paramRequest.addMarker("network-cache-written");
      }
      paramRequest.markDelivered();
      this.d.postResponse(paramRequest, localResponse);
      paramRequest.a(localResponse);
      return;
    }
    catch (VolleyError localVolleyError2)
    {
      localVolleyError2.a(SystemClock.elapsedRealtime() - l);
      a(paramRequest, localVolleyError2);
      paramRequest.e();
      return;
    }
    catch (Exception localException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localException.toString();
      VolleyLog.e(localException, "Unhandled exception %s", arrayOfObject);
      VolleyError localVolleyError1 = new VolleyError(localException);
      localVolleyError1.a(SystemClock.elapsedRealtime() - l);
      this.d.postError(paramRequest, localVolleyError1);
      paramRequest.e();
      return;
    }
    finally
    {
      paramRequest.a(4);
    }
  }

  public void quit()
  {
    this.e = true;
    interrupt();
  }

  public void run()
  {
    Process.setThreadPriority(10);
    while (true)
      try
      {
        a();
      }
      catch (InterruptedException localInterruptedException)
      {
        if (this.e)
        {
          Thread.currentThread().interrupt();
          return;
        }
        VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.NetworkDispatcher
 * JD-Core Version:    0.6.2
 */