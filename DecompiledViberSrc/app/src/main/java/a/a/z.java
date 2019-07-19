package a.a;

import com.appboy.f.c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class z extends ThreadPoolExecutor
{
  private static final String a = c.a(z.class);
  private au b;
  private List<Runnable> c = new CopyOnWriteArrayList();
  private Map<Runnable, Thread> d = new HashMap();
  private String e;

  public z(String paramString, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    this.e = paramString;
    setRejectedExecutionHandler(new a(null));
  }

  private static String a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement.length == 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[j];
      localStringBuilder.append("\nat ");
      localStringBuilder.append(localStackTraceElement);
    }
    return localStringBuilder.toString();
  }

  private void a(Exception paramException)
  {
    c.d(a, "Attempting to publish exception. ID: " + this.e, paramException);
    if (this.b != null)
      this.b.b(paramException);
  }

  private String b()
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.c.size() != getActiveCount())
      {
        c.b(a, "Running task count does not match ThreadPoolExecutor active count. Returning null description.  runningTasks.size(): " + this.c.size() + " getActiveCount(): " + getActiveCount() + " ID: " + this.e);
        return null;
      }
      localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("There are ").append(this.c.size()).append(" known running tasks. Active thread dumps: [\n");
      Iterator localIterator = this.d.values().iterator();
      while (localIterator.hasNext())
      {
        Thread localThread = (Thread)localIterator.next();
        try
        {
          localStringBuilder.append(a(localThread.getStackTrace()));
          localStringBuilder.append("\n,");
        }
        catch (Exception localException2)
        {
          c.d(a, "Failed to create description for active thread: " + localThread + " ID: " + this.e, localException2);
        }
      }
    }
    catch (Exception localException1)
    {
      c.d(a, "Failed to create running tasks description. ID: " + this.e, localException1);
      return null;
    }
    localStringBuilder.append("]\nExecutor ID: ").append(this.e).append(" state: ").append(toString());
    String str = localStringBuilder.toString();
    return str;
  }

  public void a(au paramau)
  {
    this.b = paramau;
  }

  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    this.c.remove(paramRunnable);
    this.d.remove(paramRunnable);
    super.afterExecute(paramRunnable, paramThrowable);
  }

  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    this.c.add(paramRunnable);
    this.d.put(paramRunnable, paramThread);
    super.beforeExecute(paramThread, paramRunnable);
  }

  class a
    implements RejectedExecutionHandler
  {
    private a()
    {
    }

    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      c.b(z.a(), "Rejected execution on runnable: " + paramRunnable + " . ID: " + z.a(z.this));
      if ((paramThreadPoolExecutor.isShutdown()) || (paramThreadPoolExecutor.isTerminating()))
        c.c(z.a(), "ThreadPoolExecutor is shutdown. Dropping rejected task. ID: " + z.a(z.this));
      while (true)
      {
        return;
        String str = z.b(z.this);
        try
        {
          Runnable localRunnable2;
          if (!z.c(z.this).isEmpty())
          {
            localRunnable2 = (Runnable)z.c(z.this).get(0);
            if (!(localRunnable2 instanceof Future))
              break label350;
            ((Future)localRunnable2).cancel(true);
          }
          while (true)
          {
            z.c(z.this).remove(localRunnable2);
            z.d(z.this).remove(localRunnable2);
            Runnable localRunnable1 = (Runnable)paramThreadPoolExecutor.getQueue().poll();
            if (localRunnable1 != null)
            {
              c.a(z.a(), "Running head of queue on caller thread: " + localRunnable1 + " . ID: " + z.a(z.this));
              Executors.newSingleThreadExecutor().invokeAll(Collections.singletonList(Executors.callable(localRunnable1)), 200L, TimeUnit.MILLISECONDS);
            }
            c.a(z.a(), "Re-adding rejected task to queue: " + paramRunnable + " . ID: " + z.a(z.this));
            paramThreadPoolExecutor.execute(paramRunnable);
            if (str == null)
              break;
            z.a(z.this, new Exception("Handled rejected execution on incoming task: " + str));
            return;
            label350: Thread localThread = (Thread)z.d(z.this).get(localRunnable2);
            if (localThread != null)
              localThread.interrupt();
          }
        }
        catch (Exception localException)
        {
          while (true)
            c.a(z.a(), "Caught exception in rejected execution handler for incoming task: " + paramRunnable + " . Running tasks description: " + str, localException);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.z
 * JD-Core Version:    0.6.2
 */