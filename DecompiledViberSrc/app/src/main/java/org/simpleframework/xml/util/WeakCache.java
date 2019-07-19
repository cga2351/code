package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class WeakCache<T>
  implements Cache<T>
{
  private WeakCache<T>.SegmentList list;

  public WeakCache()
  {
    this(10);
  }

  public WeakCache(int paramInt)
  {
    this.list = new SegmentList(paramInt);
  }

  private WeakCache<T>.Segment map(Object paramObject)
  {
    return this.list.get(paramObject);
  }

  public void cache(Object paramObject, T paramT)
  {
    map(paramObject).cache(paramObject, paramT);
  }

  public boolean contains(Object paramObject)
  {
    return map(paramObject).contains(paramObject);
  }

  public T fetch(Object paramObject)
  {
    return map(paramObject).fetch(paramObject);
  }

  public boolean isEmpty()
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext())
      if (!((Segment)localIterator.next()).isEmpty())
        return false;
    return true;
  }

  public T take(Object paramObject)
  {
    return map(paramObject).take(paramObject);
  }

  private class Segment extends WeakHashMap<Object, T>
  {
    private Segment()
    {
    }

    public void cache(Object paramObject, T paramT)
    {
      try
      {
        put(paramObject, paramT);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public boolean contains(Object paramObject)
    {
      try
      {
        boolean bool = containsKey(paramObject);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public T fetch(Object paramObject)
    {
      try
      {
        Object localObject2 = get(paramObject);
        return localObject2;
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
    }

    public T take(Object paramObject)
    {
      try
      {
        Object localObject2 = remove(paramObject);
        return localObject2;
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
    }
  }

  private class SegmentList
    implements Iterable<WeakCache<T>.Segment>
  {
    private List<WeakCache<T>.Segment> list = new ArrayList();
    private int size;

    public SegmentList(int arg2)
    {
      int i;
      this.size = i;
      create(i);
    }

    private void create(int paramInt)
    {
      while (true)
      {
        int i = paramInt - 1;
        if (paramInt <= 0)
          break;
        this.list.add(new WeakCache.Segment(WeakCache.this, null));
        paramInt = i;
      }
    }

    private int segment(Object paramObject)
    {
      return Math.abs(paramObject.hashCode() % this.size);
    }

    public WeakCache<T>.Segment get(Object paramObject)
    {
      int i = segment(paramObject);
      if (i < this.size)
        return (WeakCache.Segment)this.list.get(i);
      return null;
    }

    public Iterator<WeakCache<T>.Segment> iterator()
    {
      return this.list.iterator();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.WeakCache
 * JD-Core Version:    0.6.2
 */