package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class or<K, V>
{
  private final HashMap<K, Collection<V>> a = new HashMap();

  private static Collection<V> a(Collection<V> paramCollection)
  {
    return new ArrayList(paramCollection);
  }

  public int a()
  {
    Iterator localIterator = this.a.values().iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((Collection)localIterator.next()).size();
    return i;
  }

  public Collection<V> a(K paramK)
  {
    return (Collection)this.a.get(paramK);
  }

  public Collection<V> a(K paramK, V paramV)
  {
    Collection localCollection = (Collection)this.a.get(paramK);
    if (localCollection == null);
    for (Object localObject = new ArrayList(); ; localObject = a(localCollection))
    {
      ((Collection)localObject).add(paramV);
      return (Collection)this.a.put(paramK, localObject);
    }
  }

  public Collection<V> b(K paramK)
  {
    return (Collection)this.a.remove(paramK);
  }

  public Collection<V> b(K paramK, V paramV)
  {
    Collection localCollection = (Collection)this.a.get(paramK);
    if ((localCollection != null) && (localCollection.remove(paramV)))
      return a(localCollection);
    return null;
  }

  public Set<? extends Map.Entry<K, ? extends Collection<V>>> b()
  {
    return this.a.entrySet();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.or
 * JD-Core Version:    0.6.2
 */