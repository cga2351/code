package twitter4j.internal.async;

import java.util.LinkedList;
import java.util.List;
import twitter4j.conf.Configuration;

final class DispatcherImpl
  implements Dispatcher
{
  private boolean active = true;
  private final List<Runnable> q = new LinkedList();
  private ExecuteThread[] threads;
  final Object ticket = new Object();

  public DispatcherImpl(Configuration paramConfiguration)
  {
    this.threads = new ExecuteThread[paramConfiguration.getAsyncNumThreads()];
    for (int i = 0; i < this.threads.length; i++)
    {
      this.threads[i] = new ExecuteThread("Twitter4J Async Dispatcher", this, i);
      this.threads[i].setDaemon(true);
      this.threads[i].start();
    }
    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run()
      {
        if (DispatcherImpl.this.active)
          DispatcherImpl.this.shutdown();
      }
    });
  }

  // ERROR //
  public void invokeLater(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	twitter4j/internal/async/DispatcherImpl:q	Ljava/util/List;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 25	twitter4j/internal/async/DispatcherImpl:q	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 76 2 0
    //   19: pop
    //   20: aload_3
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 27	twitter4j/internal/async/DispatcherImpl:ticket	Ljava/lang/Object;
    //   26: astore 6
    //   28: aload 6
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 27	twitter4j/internal/async/DispatcherImpl:ticket	Ljava/lang/Object;
    //   35: invokevirtual 79	java/lang/Object:notify	()V
    //   38: aload 6
    //   40: monitorexit
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore 4
    //   46: aload_3
    //   47: monitorexit
    //   48: aload 4
    //   50: athrow
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    //   56: astore 7
    //   58: aload 6
    //   60: monitorexit
    //   61: aload 7
    //   63: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	22	44	finally
    //   46	48	44	finally
    //   2	9	51	finally
    //   22	31	51	finally
    //   48	51	51	finally
    //   61	64	51	finally
    //   31	41	56	finally
    //   58	61	56	finally
  }

  public Runnable poll()
  {
    if (this.active)
      synchronized (this.q)
      {
        if (this.q.size() > 0)
        {
          Runnable localRunnable = (Runnable)this.q.remove(0);
          if (localRunnable != null)
            return localRunnable;
        }
      }
    try
    {
      label67: synchronized (this.ticket)
      {
        this.ticket.wait();
      }
      localObject1 = finally;
      throw localObject1;
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label67;
    }
  }

  public void shutdown()
  {
    int i = 0;
    try
    {
      if (this.active)
      {
        this.active = false;
        ExecuteThread[] arrayOfExecuteThread = this.threads;
        int j = arrayOfExecuteThread.length;
        while (i < j)
        {
          arrayOfExecuteThread[i].shutdown();
          i++;
        }
      }
      synchronized (this.ticket)
      {
        this.ticket.notify();
        return;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.async.DispatcherImpl
 * JD-Core Version:    0.6.2
 */