package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool
{
  private static final Executor executor;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      long l1;
      do
      {
        l1 = ConnectionPool.this.cleanup(System.nanoTime());
        if (l1 == -1L)
          return;
      }
      while (l1 <= 0L);
      long l2 = l1 / 1000000L;
      long l3 = l1 - l2 * 1000000L;
      try
      {
        label61: synchronized (ConnectionPool.this)
        {
          ConnectionPool.this.wait(l2, (int)l3);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label61;
      }
    }
  };
  boolean cleanupRunning;
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();

  static
  {
    if (!ConnectionPool.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
      return;
    }
  }

  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }

  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L)
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
  }

  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.allocations;
    int i = 0;
    while (i < localList.size())
    {
      Reference localReference = (Reference)localList.get(i);
      if (localReference.get() != null)
      {
        i++;
      }
      else
      {
        StreamAllocation.StreamAllocationReference localStreamAllocationReference = (StreamAllocation.StreamAllocationReference)localReference;
        String str = "A connection to " + paramRealConnection.route().address().url() + " was leaked. Did you forget to close a response body?";
        Platform.get().logCloseableLeak(str, localStreamAllocationReference.callStackTrace);
        localList.remove(i);
        paramRealConnection.noNewStreams = true;
        if (localList.isEmpty())
        {
          paramRealConnection.idleAtNanos = (paramLong - this.keepAliveDurationNs);
          return 0;
        }
      }
    }
    return localList.size();
  }

  long cleanup(long paramLong)
  {
    Object localObject1 = null;
    long l1 = -9223372036854775808L;
    while (true)
    {
      int j;
      int k;
      try
      {
        Iterator localIterator = this.connections.iterator();
        i = 0;
        j = 0;
        if (localIterator.hasNext())
        {
          RealConnection localRealConnection = (RealConnection)localIterator.next();
          if (pruneAndGetAllocationCount(localRealConnection, paramLong) > 0)
          {
            j++;
            continue;
          }
          k = i + 1;
          long l4 = paramLong - localRealConnection.idleAtNanos;
          if (l4 <= l1)
            break label192;
          localObject3 = localRealConnection;
          l5 = l4;
          break label199;
        }
        if ((l1 >= this.keepAliveDurationNs) || (i > this.maxIdleConnections))
        {
          this.connections.remove(localObject1);
          Util.closeQuietly(localObject1.socket());
          return 0L;
        }
        if (i > 0)
        {
          long l3 = this.keepAliveDurationNs - l1;
          return l3;
        }
      }
      finally
      {
      }
      if (j > 0)
      {
        long l2 = this.keepAliveDurationNs;
        return l2;
      }
      this.cleanupRunning = false;
      return -1L;
      label192: Object localObject3 = localObject1;
      long l5 = l1;
      label199: l1 = l5;
      localObject1 = localObject3;
      int i = k;
    }
  }

  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if ((paramRealConnection.noNewStreams) || (this.maxIdleConnections == 0))
    {
      this.connections.remove(paramRealConnection);
      return true;
    }
    notifyAll();
    return false;
  }

  public int connectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  Socket deduplicate(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if ((localRealConnection.isEligible(paramAddress, null)) && (localRealConnection.isMultiplexed()) && (localRealConnection != paramStreamAllocation.connection()))
        return paramStreamAllocation.releaseAndAcquire(localRealConnection);
    }
    return null;
  }

  public void evictAll()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator1 = this.connections.iterator();
      while (localIterator1.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator1.next();
        if (localRealConnection.allocations.isEmpty())
        {
          localRealConnection.noNewStreams = true;
          localArrayList.add(localRealConnection);
          localIterator1.remove();
        }
      }
    }
    finally
    {
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
      Util.closeQuietly(((RealConnection)localIterator2.next()).socket());
  }

  @Nullable
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation, Route paramRoute)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if (localRealConnection.isEligible(paramAddress, paramRoute))
      {
        paramStreamAllocation.acquire(localRealConnection, true);
        return localRealConnection;
      }
    }
    return null;
  }

  public int idleConnectionCount()
  {
    int i = 0;
    while (true)
    {
      try
      {
        Iterator localIterator = this.connections.iterator();
        if (localIterator.hasNext())
        {
          boolean bool = ((RealConnection)localIterator.next()).allocations.isEmpty();
          if (!bool)
            break label67;
          j = i + 1;
          i = j;
          continue;
        }
        return i;
      }
      finally
      {
      }
      label67: int j = i;
    }
  }

  void put(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if (!this.cleanupRunning)
    {
      this.cleanupRunning = true;
      executor.execute(this.cleanupRunnable);
    }
    this.connections.add(paramRealConnection);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.ConnectionPool
 * JD-Core Version:    0.6.2
 */