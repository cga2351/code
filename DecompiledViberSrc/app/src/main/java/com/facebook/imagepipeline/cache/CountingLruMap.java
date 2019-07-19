package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingLruMap<K, V>
{

  @GuardedBy("this")
  private final LinkedHashMap<K, V> mMap = new LinkedHashMap();

  @GuardedBy("this")
  private int mSizeInBytes = 0;
  private final ValueDescriptor<V> mValueDescriptor;

  public CountingLruMap(ValueDescriptor<V> paramValueDescriptor)
  {
    this.mValueDescriptor = paramValueDescriptor;
  }

  private int getValueSizeInBytes(V paramV)
  {
    if (paramV == null)
      return 0;
    return this.mValueDescriptor.getSizeInBytes(paramV);
  }

  public ArrayList<V> clear()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      this.mSizeInBytes = 0;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean contains(K paramK)
  {
    try
    {
      boolean bool = this.mMap.containsKey(paramK);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public V get(K paramK)
  {
    try
    {
      Object localObject2 = this.mMap.get(paramK);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public int getCount()
  {
    try
    {
      int i = this.mMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public K getFirstKey()
  {
    try
    {
      boolean bool = this.mMap.isEmpty();
      if (bool);
      Object localObject2;
      for (Object localObject3 = null; ; localObject3 = localObject2)
      {
        return localObject3;
        localObject2 = this.mMap.keySet().iterator().next();
      }
    }
    finally
    {
    }
  }

  @VisibleForTesting
  ArrayList<K> getKeys()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.keySet());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> paramPredicate)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList(this.mMap.entrySet().size());
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey())))
          localArrayList.add(localEntry);
      }
    }
    finally
    {
    }
    return localArrayList;
  }

  public int getSizeInBytes()
  {
    try
    {
      int i = this.mSizeInBytes;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @VisibleForTesting
  ArrayList<V> getValues()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public V put(K paramK, V paramV)
  {
    try
    {
      Object localObject2 = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(localObject2);
      this.mMap.put(paramK, paramV);
      this.mSizeInBytes += getValueSizeInBytes(paramV);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  @Nullable
  public V remove(K paramK)
  {
    try
    {
      Object localObject2 = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(localObject2);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public ArrayList<V> removeAll(@Nullable Predicate<K> paramPredicate)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate == null) || (paramPredicate.apply(localEntry.getKey())))
        {
          localArrayList.add(localEntry.getValue());
          this.mSizeInBytes -= getValueSizeInBytes(localEntry.getValue());
          localIterator.remove();
        }
      }
    }
    finally
    {
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.CountingLruMap
 * JD-Core Version:    0.6.2
 */