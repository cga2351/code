package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class oj
{
  private AtomicInteger a = new AtomicInteger();
  private final Map<String, Queue<oi<?>>> b = new HashMap();
  private final Set<oi<?>> c = new HashSet();
  private final PriorityBlockingQueue<oi<?>> d = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<oi<?>> e = new PriorityBlockingQueue();
  private final ob f;
  private final of g;
  private final ol h;
  private og[] i;
  private oc j;
  private List<Object> k = new ArrayList();

  public oj(ob paramob, of paramof)
  {
    this(paramob, paramof, new oe(new Handler(Looper.getMainLooper())));
  }

  private oj(ob paramob, of paramof, ol paramol)
  {
    this.f = paramob;
    this.g = paramof;
    this.i = new og[1];
    this.h = paramol;
  }

  public final <T> oi<T> a(oi<T> paramoi)
  {
    paramoi.a(this);
    synchronized (this.c)
    {
      this.c.add(paramoi);
      paramoi.c(this.a.incrementAndGet());
      if (!paramoi.m())
      {
        this.e.add(paramoi);
        return paramoi;
      }
    }
    while (true)
    {
      String str;
      synchronized (this.b)
      {
        str = paramoi.b();
        if (this.b.containsKey(str))
        {
          Object localObject3 = (Queue)this.b.get(str);
          if (localObject3 == null)
            localObject3 = new LinkedList();
          ((Queue)localObject3).add(paramoi);
          this.b.put(str, localObject3);
          if (on.b)
            on.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          return paramoi;
        }
      }
      this.b.put(str, null);
      this.d.add(paramoi);
    }
  }

  public final void a()
  {
    int m = 0;
    if (this.j != null)
      this.j.a();
    for (int n = 0; n < this.i.length; n++)
      if (this.i[n] != null)
        this.i[n].a();
    this.j = new oc(this.d, this.e, this.f, this.h);
    this.j.start();
    while (m < this.i.length)
    {
      og localog = new og(this.e, this.g, this.f, this.h);
      this.i[m] = localog;
      localog.start();
      m++;
    }
  }

  public final void a(a parama)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        oi localoi = (oi)localIterator.next();
        if (parama.a(localoi))
          localoi.i();
      }
    }
  }

  final <T> void b(oi<T> paramoi)
  {
    synchronized (this.c)
    {
      this.c.remove(paramoi);
      synchronized (this.k)
      {
        Iterator localIterator = this.k.iterator();
        if (localIterator.hasNext())
          localIterator.next();
      }
    }
    if (paramoi.m())
      synchronized (this.b)
      {
        String str = paramoi.b();
        Queue localQueue = (Queue)this.b.remove(str);
        if (localQueue != null)
        {
          if (on.b)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Integer.valueOf(localQueue.size());
            arrayOfObject[1] = str;
            on.a("Releasing %d waiting requests for cacheKey=%s.", arrayOfObject);
          }
          this.d.addAll(localQueue);
        }
        return;
      }
  }

  public static abstract interface a
  {
    public abstract boolean a(oi<?> paramoi);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oj
 * JD-Core Version:    0.6.2
 */