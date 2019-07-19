package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

public class i extends a
{
  private static final com.google.firebase.b.a<Set<Object>> a = l.b();
  private final Map<b<?>, s<?>> b = new HashMap();
  private final Map<Class<?>, s<?>> c = new HashMap();
  private final Map<Class<?>, s<Set<?>>> d = new HashMap();
  private final q e;

  public i(Executor paramExecutor, Iterable<h> paramIterable, b<?>[] paramArrayOfb)
  {
    this.e = new q(paramExecutor);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b.a(this.e, q.class, new Class[] { d.class, c.class }));
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
      localArrayList.addAll(((h)localIterator1.next()).getComponents());
    Collections.addAll(localArrayList, paramArrayOfb);
    m.a(localArrayList);
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      b localb = (b)localIterator2.next();
      s locals = new s(j.a(this, localb));
      this.b.put(localb, locals);
    }
    a();
    b();
  }

  private void a()
  {
    Iterator localIterator1 = this.b.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      b localb = (b)localEntry.getKey();
      if (localb.g())
      {
        s locals = (s)localEntry.getValue();
        Iterator localIterator2 = localb.a().iterator();
        while (localIterator2.hasNext())
        {
          Class localClass = (Class)localIterator2.next();
          this.c.put(localClass, locals);
        }
      }
    }
    c();
  }

  private void b()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.b.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      b localb = (b)localEntry2.getKey();
      if (!localb.g())
      {
        s locals = (s)localEntry2.getValue();
        Iterator localIterator3 = localb.a().iterator();
        while (localIterator3.hasNext())
        {
          Class localClass = (Class)localIterator3.next();
          if (!localHashMap.containsKey(localClass))
            localHashMap.put(localClass, new HashSet());
          ((Set)localHashMap.get(localClass)).add(locals);
        }
      }
    }
    Iterator localIterator2 = localHashMap.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      Set localSet = (Set)localEntry1.getValue();
      this.d.put((Class)localEntry1.getKey(), new s(k.a(localSet)));
    }
  }

  private void c()
  {
    b localb;
    n localn;
    do
    {
      Iterator localIterator1 = this.b.keySet().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext())
          break;
        localb = (b)localIterator1.next();
        localIterator2 = localb.b().iterator();
      }
      localn = (n)localIterator2.next();
    }
    while ((!localn.b()) || (this.c.containsKey(localn.a())));
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localb;
    arrayOfObject[1] = localn.a();
    throw new t(String.format("Unsatisfied dependency for component %s: %s", arrayOfObject));
  }

  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      b localb = (b)localEntry.getKey();
      s locals = (s)localEntry.getValue();
      if ((localb.e()) || ((localb.f()) && (paramBoolean)))
        locals.a();
    }
    this.e.a();
  }

  public <T> com.google.firebase.b.a<T> c(Class<T> paramClass)
  {
    Preconditions.checkNotNull(paramClass, "Null interface requested.");
    return (com.google.firebase.b.a)this.c.get(paramClass);
  }

  public <T> com.google.firebase.b.a<Set<T>> d(Class<T> paramClass)
  {
    s locals = (s)this.d.get(paramClass);
    if (locals != null)
      return locals;
    return a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.i
 * JD-Core Version:    0.6.2
 */