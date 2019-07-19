package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.a.a;
import com.google.firebase.a.b;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class q
  implements c, d
{
  private final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> a = new HashMap();
  private Queue<a<?>> b = new ArrayDeque();
  private final Executor c;

  q(Executor paramExecutor)
  {
    this.c = paramExecutor;
  }

  private Set<Map.Entry<b<Object>, Executor>> b(a<?> parama)
  {
    try
    {
      Map localMap = (Map)this.a.get(parama.a());
      Set localSet1;
      if (localMap == null)
        localSet1 = Collections.emptySet();
      Set localSet2;
      for (Object localObject2 = localSet1; ; localObject2 = localSet2)
      {
        return localObject2;
        localSet2 = localMap.entrySet();
      }
    }
    finally
    {
    }
  }

  void a()
  {
    try
    {
      Queue localQueue1 = this.b;
      Queue localQueue2 = null;
      if (localQueue1 != null)
      {
        localQueue2 = this.b;
        this.b = null;
      }
      if (localQueue2 != null)
      {
        Iterator localIterator = localQueue2.iterator();
        while (localIterator.hasNext())
          a((a)localIterator.next());
      }
    }
    finally
    {
    }
  }

  public void a(a<?> parama)
  {
    Preconditions.checkNotNull(parama);
    try
    {
      if (this.b != null)
      {
        this.b.add(parama);
        return;
      }
      Iterator localIterator = b(parama).iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Executor)localEntry.getValue()).execute(r.a(localEntry, parama));
      }
    }
    finally
    {
    }
  }

  public <T> void a(Class<T> paramClass, b<? super T> paramb)
  {
    a(paramClass, this.c, paramb);
  }

  public <T> void a(Class<T> paramClass, Executor paramExecutor, b<? super T> paramb)
  {
    try
    {
      Preconditions.checkNotNull(paramClass);
      Preconditions.checkNotNull(paramb);
      Preconditions.checkNotNull(paramExecutor);
      if (!this.a.containsKey(paramClass))
        this.a.put(paramClass, new ConcurrentHashMap());
      ((ConcurrentHashMap)this.a.get(paramClass)).put(paramb, paramExecutor);
      return;
    }
    finally
    {
    }
  }

  public <T> void b(Class<T> paramClass, b<? super T> paramb)
  {
    try
    {
      Preconditions.checkNotNull(paramClass);
      Preconditions.checkNotNull(paramb);
      boolean bool = this.a.containsKey(paramClass);
      if (!bool);
      while (true)
      {
        return;
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.a.get(paramClass);
        localConcurrentHashMap.remove(paramb);
        if (localConcurrentHashMap.isEmpty())
          this.a.remove(paramClass);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.q
 * JD-Core Version:    0.6.2
 */