package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Dispatcher
{

  @Nullable
  private ExecutorService executorService;

  @Nullable
  private Runnable idleCallback;
  private int maxRequests = 64;
  private int maxRequestsPerHost = 5;
  private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
  private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
  private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

  public Dispatcher()
  {
  }

  public Dispatcher(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
  }

  private <T> void finished(Deque<T> paramDeque, T paramT, boolean paramBoolean)
  {
    try
    {
      if (!paramDeque.remove(paramT))
        throw new AssertionError("Call wasn't in-flight!");
    }
    finally
    {
    }
    if (paramBoolean)
      promoteCalls();
    int i = runningCallsCount();
    Runnable localRunnable = this.idleCallback;
    if ((i == 0) && (localRunnable != null))
      localRunnable.run();
  }

  private void promoteCalls()
  {
    if (this.runningAsyncCalls.size() >= this.maxRequests);
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (this.readyAsyncCalls.isEmpty());
        localIterator = this.readyAsyncCalls.iterator();
      }
      while (!localIterator.hasNext());
      RealCall.AsyncCall localAsyncCall = (RealCall.AsyncCall)localIterator.next();
      if (runningCallsForHost(localAsyncCall) < this.maxRequestsPerHost)
      {
        localIterator.remove();
        this.runningAsyncCalls.add(localAsyncCall);
        executorService().execute(localAsyncCall);
      }
    }
    while (this.runningAsyncCalls.size() < this.maxRequests);
  }

  private int runningCallsForHost(RealCall.AsyncCall paramAsyncCall)
  {
    Iterator localIterator = this.runningAsyncCalls.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      RealCall.AsyncCall localAsyncCall = (RealCall.AsyncCall)localIterator.next();
      if (!localAsyncCall.get().forWebSocket)
        if (!localAsyncCall.host().equals(paramAsyncCall.host()))
          break label71;
    }
    label71: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public void cancelAll()
  {
    try
    {
      Iterator localIterator1 = this.readyAsyncCalls.iterator();
      while (localIterator1.hasNext())
        ((RealCall.AsyncCall)localIterator1.next()).get().cancel();
    }
    finally
    {
    }
    Iterator localIterator2 = this.runningAsyncCalls.iterator();
    while (localIterator2.hasNext())
      ((RealCall.AsyncCall)localIterator2.next()).get().cancel();
    Iterator localIterator3 = this.runningSyncCalls.iterator();
    while (localIterator3.hasNext())
      ((RealCall)localIterator3.next()).cancel();
  }

  void enqueue(RealCall.AsyncCall paramAsyncCall)
  {
    try
    {
      if ((this.runningAsyncCalls.size() < this.maxRequests) && (runningCallsForHost(paramAsyncCall) < this.maxRequestsPerHost))
      {
        this.runningAsyncCalls.add(paramAsyncCall);
        executorService().execute(paramAsyncCall);
      }
      while (true)
      {
        return;
        this.readyAsyncCalls.add(paramAsyncCall);
      }
    }
    finally
    {
    }
  }

  void executed(RealCall paramRealCall)
  {
    try
    {
      this.runningSyncCalls.add(paramRealCall);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ExecutorService executorService()
  {
    try
    {
      if (this.executorService == null)
        this.executorService = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
      ExecutorService localExecutorService = this.executorService;
      return localExecutorService;
    }
    finally
    {
    }
  }

  void finished(RealCall.AsyncCall paramAsyncCall)
  {
    finished(this.runningAsyncCalls, paramAsyncCall, true);
  }

  void finished(RealCall paramRealCall)
  {
    finished(this.runningSyncCalls, paramRealCall, false);
  }

  public int getMaxRequests()
  {
    try
    {
      int i = this.maxRequests;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getMaxRequestsPerHost()
  {
    try
    {
      int i = this.maxRequestsPerHost;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<Call> queuedCalls()
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.readyAsyncCalls.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((RealCall.AsyncCall)localIterator.next()).get());
    }
    finally
    {
    }
    List localList = Collections.unmodifiableList(localArrayList);
    return localList;
  }

  public int queuedCallsCount()
  {
    try
    {
      int i = this.readyAsyncCalls.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<Call> runningCalls()
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(this.runningSyncCalls);
      Iterator localIterator = this.runningAsyncCalls.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((RealCall.AsyncCall)localIterator.next()).get());
    }
    finally
    {
    }
    List localList = Collections.unmodifiableList(localArrayList);
    return localList;
  }

  public int runningCallsCount()
  {
    try
    {
      int i = this.runningAsyncCalls.size();
      int j = this.runningSyncCalls.size();
      int k = i + j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setIdleCallback(@Nullable Runnable paramRunnable)
  {
    try
    {
      this.idleCallback = paramRunnable;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setMaxRequests(int paramInt)
  {
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
      }
    this.maxRequests = paramInt;
    promoteCalls();
  }

  public void setMaxRequestsPerHost(int paramInt)
  {
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
      }
    this.maxRequestsPerHost = paramInt;
    promoteCalls();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Dispatcher
 * JD-Core Version:    0.6.2
 */