package a.a;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public class c
  implements d
{
  private static final String a = com.appboy.f.c.a(c.class);
  private final ConcurrentMap<Class, CopyOnWriteArraySet<com.appboy.c.c>> b = new ConcurrentHashMap();
  private final ConcurrentMap<Class, CopyOnWriteArraySet<com.appboy.c.c>> c = new ConcurrentHashMap();
  private final ConcurrentMap<Class, Object> d = new ConcurrentHashMap();
  private final Executor e;
  private final dc f;
  private final Object g = new Object();
  private final Object h = new Object();
  private final Object i = new Object();

  public c(Executor paramExecutor, dc paramdc)
  {
    this.e = paramExecutor;
    this.f = paramdc;
  }

  private <T> CopyOnWriteArraySet<com.appboy.c.c<T>> a(Class<T> paramClass, CopyOnWriteArraySet<com.appboy.c.c> paramCopyOnWriteArraySet)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)paramCopyOnWriteArraySet;
    com.appboy.f.c.a(a, "Triggering " + paramClass.getName() + " on " + paramCopyOnWriteArraySet.size() + " subscribers.", false);
    return localCopyOnWriteArraySet;
  }

  private <T> void a(Class<T> paramClass)
  {
    synchronized (this.i)
    {
      if (this.d.containsKey(paramClass))
      {
        com.appboy.f.c.a(a, "Publishing cached event for class: " + paramClass);
        Object localObject3 = this.d.remove(paramClass);
        if (localObject3 != null)
          a(localObject3, paramClass);
      }
      return;
    }
  }

  private <T> boolean a(com.appboy.c.c<T> paramc, Class<T> paramClass, ConcurrentMap<Class, CopyOnWriteArraySet<com.appboy.c.c>> paramConcurrentMap)
  {
    if (paramc == null)
    {
      if (paramClass == null);
      for (String str = "null eventClass"; ; str = paramClass.getName())
      {
        com.appboy.f.c.e(a, "Error: Attempted to add a null subscriber for eventClass " + str + ". This subscriber is being ignored. Please check your calling code to ensure that all potential subscriptions are valid.");
        return false;
      }
    }
    Object localObject = (CopyOnWriteArraySet)paramConcurrentMap.get(paramClass);
    if (localObject == null)
    {
      CopyOnWriteArraySet localCopyOnWriteArraySet = new CopyOnWriteArraySet();
      localObject = (CopyOnWriteArraySet)paramConcurrentMap.putIfAbsent(paramClass, localCopyOnWriteArraySet);
      if (localObject == null)
        localObject = localCopyOnWriteArraySet;
    }
    boolean bool = ((CopyOnWriteArraySet)localObject).add(paramc);
    a(paramClass);
    return bool;
  }

  private <T> boolean a(CopyOnWriteArraySet<com.appboy.c.c> paramCopyOnWriteArraySet, com.appboy.c.c<T> paramc)
  {
    return (paramCopyOnWriteArraySet != null) && (paramc != null) && (paramCopyOnWriteArraySet.remove(paramc));
  }

  public void a()
  {
    synchronized (this.g)
    {
      this.b.clear();
    }
    synchronized (this.h)
    {
      this.c.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  public <T> void a(final T paramT, Class<T> paramClass)
  {
    if (this.f.a())
      com.appboy.f.c.b(a, "SDK is disabled. Not publishing event class: " + paramClass.getName() + " and message: " + paramT.toString());
    int j;
    do
    {
      return;
      com.appboy.f.c.a(a, paramClass.getName() + " fired: " + paramT.toString(), false);
      CopyOnWriteArraySet localCopyOnWriteArraySet1 = (CopyOnWriteArraySet)this.b.get(paramClass);
      j = 0;
      if (localCopyOnWriteArraySet1 != null)
      {
        Iterator localIterator2 = a(paramClass, localCopyOnWriteArraySet1).iterator();
        while (localIterator2.hasNext())
        {
          final com.appboy.c.c localc = (com.appboy.c.c)localIterator2.next();
          this.e.execute(new Runnable()
          {
            public void run()
            {
              localc.trigger(paramT);
            }
          });
        }
        boolean bool = localCopyOnWriteArraySet1.isEmpty();
        j = 0;
        if (!bool)
          j = 1;
      }
      CopyOnWriteArraySet localCopyOnWriteArraySet2 = (CopyOnWriteArraySet)this.c.get(paramClass);
      if (localCopyOnWriteArraySet2 != null)
      {
        Iterator localIterator1 = a(paramClass, localCopyOnWriteArraySet2).iterator();
        while (localIterator1.hasNext())
          ((com.appboy.c.c)localIterator1.next()).trigger(paramT);
        if (!localCopyOnWriteArraySet2.isEmpty())
          j = 1;
      }
    }
    while ((j != 0) || (paramT == null));
    com.appboy.f.c.c(a, "Event was published, but no subscribers were found. Saving event for later publishing to a matching subscriber. Event class: " + paramClass);
    synchronized (this.d)
    {
      this.d.put(paramClass, paramT);
      return;
    }
  }

  public <T> boolean a(com.appboy.c.c<T> paramc, Class<T> paramClass)
  {
    synchronized (this.g)
    {
      boolean bool = a(paramc, paramClass, this.b);
      return bool;
    }
  }

  public <T> boolean b(com.appboy.c.c<T> paramc, Class<T> paramClass)
  {
    synchronized (this.h)
    {
      boolean bool = a(paramc, paramClass, this.c);
      return bool;
    }
  }

  public <T> boolean c(com.appboy.c.c<T> paramc, Class<T> paramClass)
  {
    synchronized (this.g)
    {
      boolean bool = a((CopyOnWriteArraySet)this.b.get(paramClass), paramc);
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.c
 * JD-Core Version:    0.6.2
 */