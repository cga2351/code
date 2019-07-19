package androidx.work.impl.background.systemalarm;

import androidx.work.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class g
{
  private static final String d = i.a("WorkTimer");
  final Map<String, b> a = new HashMap();
  final Map<String, a> b = new HashMap();
  final Object c = new Object();
  private final ThreadFactory e = new ThreadFactory()
  {
    private int b = 0;

    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      Thread localThread = Executors.defaultThreadFactory().newThread(paramAnonymousRunnable);
      localThread.setName("WorkManager-WorkTimer-thread-" + this.b);
      this.b = (1 + this.b);
      return localThread;
    }
  };
  private final ScheduledExecutorService f = Executors.newSingleThreadScheduledExecutor(this.e);

  void a(String paramString)
  {
    synchronized (this.c)
    {
      if ((b)this.a.remove(paramString) != null)
      {
        i.a().b(d, String.format("Stopping timer for %s", new Object[] { paramString }), new Throwable[0]);
        this.b.remove(paramString);
      }
      return;
    }
  }

  void a(String paramString, long paramLong, a parama)
  {
    synchronized (this.c)
    {
      i.a().b(d, String.format("Starting timer for %s", new Object[] { paramString }), new Throwable[0]);
      a(paramString);
      b localb = new b(this, paramString);
      this.a.put(paramString, localb);
      this.b.put(paramString, parama);
      this.f.schedule(localb, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
  }

  static abstract interface a
  {
    public abstract void a(String paramString);
  }

  static class b
    implements Runnable
  {
    private final g a;
    private final String b;

    b(g paramg, String paramString)
    {
      this.a = paramg;
      this.b = paramString;
    }

    public void run()
    {
      synchronized (this.a.c)
      {
        if ((b)this.a.a.remove(this.b) != null)
        {
          g.a locala = (g.a)this.a.b.remove(this.b);
          if (locala != null)
            locala.a(this.b);
          return;
        }
        i locali = i.a();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.b;
        locali.b("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", arrayOfObject), new Throwable[0]);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.g
 * JD-Core Version:    0.6.2
 */