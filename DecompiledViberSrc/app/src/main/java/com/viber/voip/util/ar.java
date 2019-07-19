package com.viber.voip.util;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ar<K, V>
  implements Map<K, V>
{
  public static final int a = (int)TimeUnit.MINUTES.toMillis(1L);
  private final Map<K, ar<K, V>.a> b;
  private long c;

  public ar()
  {
    this(a);
  }

  public ar(long paramLong)
  {
    this.c = paramLong;
    this.b = new ConcurrentHashMap();
  }

  public void clear()
  {
    this.b.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    return this.b.containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.b.containsValue(paramObject);
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    throw new UnsupportedOperationException();
  }

  public boolean equals(Object paramObject)
  {
    return this.b.equals(paramObject);
  }

  public V get(Object paramObject)
  {
    if ((this.b != null) && (paramObject != null))
    {
      a locala = (a)this.b.get(paramObject);
      if (locala != null)
      {
        if (SystemClock.elapsedRealtime() - locala.a() >= this.c)
        {
          this.b.remove(locala.b());
          return null;
        }
        return locala.c();
      }
    }
    return null;
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }

  public Set<K> keySet()
  {
    return this.b.keySet();
  }

  public V put(K paramK, V paramV)
  {
    a locala = (a)this.b.put(paramK, new a(paramK, paramV, SystemClock.elapsedRealtime()));
    if (locala == null)
      return null;
    return locala.c();
  }

  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }

  public V remove(Object paramObject)
  {
    a locala = (a)this.b.remove(paramObject);
    if (locala == null)
      return null;
    return locala.c();
  }

  public int size()
  {
    return this.b.size();
  }

  public Collection<V> values()
  {
    Collection localCollection = this.b.values();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localCollection.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((a)localIterator.next()).c());
    return localArrayList;
  }

  private class a
  {
    private K b;
    private V c;
    private long d;
    private final ReadWriteLock e = new ReentrantReadWriteLock();

    a(V paramLong, long arg3)
    {
      Object localObject1;
      if (localObject1 == null)
        throw new IllegalArgumentException("An expiring object cannot be null.");
      this.b = paramLong;
      this.c = localObject1;
      Object localObject2;
      this.d = localObject2;
    }

    public long a()
    {
      this.e.readLock().lock();
      try
      {
        long l = this.d;
        return l;
      }
      finally
      {
        this.e.readLock().unlock();
      }
    }

    public K b()
    {
      return this.b;
    }

    public V c()
    {
      return this.c;
    }

    public boolean equals(Object paramObject)
    {
      return this.c.equals(paramObject);
    }

    public int hashCode()
    {
      return this.c.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ar
 * JD-Core Version:    0.6.2
 */