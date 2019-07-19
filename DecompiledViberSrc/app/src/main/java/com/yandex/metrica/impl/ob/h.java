package com.yandex.metrica.impl.ob;

import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class h
{
  private final Thread a = od.a("YMM-BD", new Runnable()
  {
    public void run()
    {
      while (h.a(h.this))
        try
        {
          ((h.a)h.b(h.this).take()).a();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
    }
  });
  private volatile boolean b = true;
  private final BlockingQueue<a> c = new LinkedBlockingQueue();
  private ConcurrentHashMap<Class, CopyOnWriteArrayList<l<? extends j>>> d = new ConcurrentHashMap();
  private WeakHashMap<Object, CopyOnWriteArrayList<c>> e = new WeakHashMap();
  private ConcurrentHashMap<Class, j> f = new ConcurrentHashMap();

  h()
  {
    this.a.start();
  }

  public static final h a()
  {
    return b.a();
  }

  public void a(j paramj)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.d.get(paramj.getClass());
      if (localCopyOnWriteArrayList != null)
      {
        Iterator localIterator = localCopyOnWriteArrayList.iterator();
        while (localIterator.hasNext())
          a(paramj, (l)localIterator.next());
      }
    }
    finally
    {
    }
  }

  void a(j paramj, l<? extends j> paraml)
  {
    this.c.add(new a(paramj, paraml, (byte)0));
  }

  public void a(Class<? extends j> paramClass)
  {
    try
    {
      this.f.remove(paramClass);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Object paramObject)
  {
    try
    {
      List localList = (List)this.e.remove(paramObject);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
          ((c)localIterator.next()).a();
      }
    }
    finally
    {
    }
  }

  public void a(Object paramObject, Class paramClass, l<? extends j> paraml)
  {
    while (true)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList1;
      try
      {
        localCopyOnWriteArrayList1 = (CopyOnWriteArrayList)this.d.get(paramClass);
        if (localCopyOnWriteArrayList1 == null)
        {
          CopyOnWriteArrayList localCopyOnWriteArrayList2 = new CopyOnWriteArrayList();
          this.d.put(paramClass, localCopyOnWriteArrayList2);
          localCopyOnWriteArrayList3 = localCopyOnWriteArrayList2;
          localCopyOnWriteArrayList3.add(paraml);
          CopyOnWriteArrayList localCopyOnWriteArrayList4 = (CopyOnWriteArrayList)this.e.get(paramObject);
          if (localCopyOnWriteArrayList4 == null)
          {
            localCopyOnWriteArrayList4 = new CopyOnWriteArrayList();
            this.e.put(paramObject, localCopyOnWriteArrayList4);
          }
          localCopyOnWriteArrayList4.add(new c(localCopyOnWriteArrayList3, paraml, (byte)0));
          j localj = (j)this.f.get(paramClass);
          if (localj != null)
            a(localj, paraml);
          return;
        }
      }
      finally
      {
      }
      CopyOnWriteArrayList localCopyOnWriteArrayList3 = localCopyOnWriteArrayList1;
    }
  }

  public void b(j paramj)
  {
    try
    {
      a(paramj);
      this.f.put(paramj.getClass(), paramj);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class a
  {
    private final j a;
    private final l<? extends j> b;

    private a(j paramj, l<? extends j> paraml)
    {
      this.a = paramj;
      this.b = paraml;
    }

    void a()
    {
      try
      {
        if (!this.b.b(this.a))
          this.b.a(this.a);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  private static final class b
  {
    private static final h a = new h();
  }

  private static class c
  {
    final CopyOnWriteArrayList<l<? extends j>> a;
    final l<? extends j> b;

    private c(CopyOnWriteArrayList<l<? extends j>> paramCopyOnWriteArrayList, l<? extends j> paraml)
    {
      this.a = paramCopyOnWriteArrayList;
      this.b = paraml;
    }

    protected void a()
    {
      this.a.remove(this.b);
    }

    protected void finalize()
      throws Throwable
    {
      super.finalize();
      a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.h
 * JD-Core Version:    0.6.2
 */