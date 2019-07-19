package com.viber.voip.util;

import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class u
{
  static
  {
    if (!u.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  private u()
  {
    if (!a)
      throw new AssertionError();
  }

  public static <T> List<T> a(Collection<T> paramCollection, ci<T> paramci)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramci.apply(localObject))
        localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public static <S, D> List<D> a(Collection<S> paramCollection, b<S, D> paramb)
  {
    if (paramCollection == null)
      throw new IllegalArgumentException("Source parameter is required");
    if (paramb == null)
      throw new IllegalArgumentException("Transformer parameter is required");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localArrayList.add(paramb.transform(localIterator.next()));
    return localArrayList;
  }

  public static <K, V> Map<K, V> a(K[] paramArrayOfK, b<K, V> paramb)
  {
    Object localObject;
    if ((paramArrayOfK == null) || (paramArrayOfK.length == 0))
      localObject = Collections.emptyMap();
    while (true)
    {
      return localObject;
      localObject = new HashMap(paramArrayOfK.length);
      int i = paramArrayOfK.length;
      for (int j = 0; j < i; j++)
      {
        K ? = paramArrayOfK[j];
        ((Map)localObject).put(?, paramb.transform(?));
      }
    }
  }

  @SafeVarargs
  public static <T> Set<T> a(Collection<T>[] paramArrayOfCollection)
  {
    Object localObject;
    if (paramArrayOfCollection.length == 0)
      localObject = Collections.emptySet();
    while (true)
    {
      return localObject;
      localObject = new HashSet(paramArrayOfCollection[0]);
      int i = 1;
      int j = paramArrayOfCollection.length;
      while (i < j)
      {
        if (paramArrayOfCollection[i] != null)
          ((Set)localObject).addAll(paramArrayOfCollection[i]);
        i++;
      }
    }
  }

  public static boolean a(LongSparseArray paramLongSparseArray)
  {
    return (paramLongSparseArray == null) || (paramLongSparseArray.size() == 0);
  }

  public static boolean a(LongSparseSet paramLongSparseSet)
  {
    return (paramLongSparseSet == null) || (paramLongSparseSet.isEmpty());
  }

  public static boolean a(LongSparseSet paramLongSparseSet1, LongSparseSet paramLongSparseSet2)
  {
    if (paramLongSparseSet1 == paramLongSparseSet2);
    while (true)
    {
      return true;
      if ((paramLongSparseSet1 == null) || (paramLongSparseSet2 == null))
        return false;
      if (paramLongSparseSet1.size() != paramLongSparseSet2.size())
        return false;
      int i = paramLongSparseSet1.size();
      for (int j = 0; j < i; j++)
        if (paramLongSparseSet1.get(j) != paramLongSparseSet2.get(j))
          return false;
    }
  }

  public static <T> boolean a(Collection<T> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }

  public static <T> boolean a(Collection<T> paramCollection, T paramT)
  {
    return (!a(paramCollection)) && (paramCollection.contains(paramT));
  }

  public static <K, V> boolean a(Map<K, V> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }

  public static <K, V> void b(Map<K, V> paramMap)
  {
    if (!a(paramMap))
      paramMap.clear();
  }

  public static <T> boolean b(Collection<T> paramCollection)
  {
    return (paramCollection != null) && (1 == paramCollection.size());
  }

  public static final class a
  {
    public static <T, E> T a(Map<T, E> paramMap, E paramE)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (a(paramE, localEntry.getValue()))
          return localEntry.getKey();
      }
      return null;
    }

    private static boolean a(Object paramObject1, Object paramObject2)
    {
      return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    }
  }

  public static abstract interface b<S, D>
  {
    public abstract D transform(S paramS);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.u
 * JD-Core Version:    0.6.2
 */