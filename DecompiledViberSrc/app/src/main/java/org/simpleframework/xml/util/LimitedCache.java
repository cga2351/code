package org.simpleframework.xml.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LimitedCache<T> extends LinkedHashMap<Object, T>
  implements Cache<T>
{
  private final int capacity;

  public LimitedCache()
  {
    this(50000);
  }

  public LimitedCache(int paramInt)
  {
    this.capacity = paramInt;
  }

  public void cache(Object paramObject, T paramT)
  {
    put(paramObject, paramT);
  }

  public boolean contains(Object paramObject)
  {
    return containsKey(paramObject);
  }

  public T fetch(Object paramObject)
  {
    return get(paramObject);
  }

  protected boolean removeEldestEntry(Map.Entry<Object, T> paramEntry)
  {
    return size() > this.capacity;
  }

  public T take(Object paramObject)
  {
    return remove(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.LimitedCache
 * JD-Core Version:    0.6.2
 */