package com.crashlytics.android.a;

import c.a.a.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class l
{
  final AtomicReference<ScheduledFuture<?>> a = new AtomicReference();
  boolean b = true;
  private final ScheduledExecutorService c;
  private final List<a> d = new ArrayList();
  private volatile boolean e = true;

  public l(ScheduledExecutorService paramScheduledExecutorService)
  {
    this.c = paramScheduledExecutorService;
  }

  private void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a();
  }

  public void a()
  {
    this.b = false;
    ScheduledFuture localScheduledFuture = (ScheduledFuture)this.a.getAndSet(null);
    if (localScheduledFuture != null)
      localScheduledFuture.cancel(false);
  }

  public void a(a parama)
  {
    this.d.add(parama);
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void b()
  {
    if ((this.e) && (!this.b))
      this.b = true;
    try
    {
      this.a.compareAndSet(null, this.c.schedule(new Runnable()
      {
        public void run()
        {
          l.this.a.set(null);
          l.a(l.this);
        }
      }
      , 5000L, TimeUnit.MILLISECONDS));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      c.g().a("Answers", "Failed to schedule background detector", localRejectedExecutionException);
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.l
 * JD-Core Version:    0.6.2
 */