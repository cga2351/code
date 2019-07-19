package org.simpleframework.xml.util;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache<T> extends ConcurrentHashMap<Object, T>
  implements Cache<T>
{
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

  public T take(Object paramObject)
  {
    return remove(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.ConcurrentCache
 * JD-Core Version:    0.6.2
 */