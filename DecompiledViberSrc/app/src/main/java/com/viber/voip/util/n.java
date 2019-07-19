package com.viber.voip.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static <T> void a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    T ? = paramArrayOfT[paramInt1];
    paramArrayOfT[paramInt1] = paramArrayOfT[paramInt2];
    paramArrayOfT[paramInt2] = ?;
  }

  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return false;
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        if (paramArrayOfInt[j] == paramInt)
          return true;
    }
  }

  public static boolean a(Object[] paramArrayOfObject)
  {
    return (paramArrayOfObject == null) || (paramArrayOfObject.length == 0);
  }

  public static <T> boolean a(T[] paramArrayOfT, T paramT)
  {
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      T ? = paramArrayOfT[j];
      if (? == null)
      {
        if (paramT != null);
      }
      else
        while ((paramT != null) && (?.equals(paramT)))
          return true;
    }
    return false;
  }

  public static long[] a(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return new long[0];
    long[] arrayOfLong = new long[paramList.size()];
    Iterator localIterator = paramList.iterator();
    for (int i = 0; i < arrayOfLong.length; i++)
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
    return arrayOfLong;
  }

  public static Integer[] a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return null;
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++)
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
    return arrayOfInteger;
  }

  public static <S, D> D[] a(Class<D> paramClass, Collection<S> paramCollection, u.b<S, D> paramb)
  {
    int i = 0;
    int j;
    Object[] arrayOfObject;
    if (paramCollection != null)
    {
      j = paramCollection.size();
      arrayOfObject = (Object[])Array.newInstance(paramClass, j);
      if (paramCollection != null)
        break label41;
    }
    while (true)
    {
      return arrayOfObject;
      j = 0;
      break;
      label41: Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        int k = i + 1;
        arrayOfObject[i] = paramb.transform(localObject);
        i = k;
      }
    }
  }

  public static <S, D> D[] a(Class<D> paramClass, S[] paramArrayOfS, u.b<S, D> paramb)
  {
    Object localObject;
    if (paramArrayOfS == null)
      localObject = null;
    while (true)
    {
      return localObject;
      localObject = (Object[])Array.newInstance(paramClass, paramArrayOfS.length);
      for (int i = 0; i < paramArrayOfS.length; i++)
        localObject[i] = paramb.transform(paramArrayOfS[i]);
    }
  }

  public static <T> T[] a(T[] paramArrayOfT, ci<T> paramci)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      T ? = paramArrayOfT[j];
      if (paramci.apply(?))
        localArrayList.add(?);
    }
    return localArrayList.toArray((Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), localArrayList.size()));
  }

  public static <T> T b(T[] paramArrayOfT, ci<T> paramci)
  {
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      T ? = paramArrayOfT[j];
      if (paramci.apply(?))
        return ?;
    }
    return null;
  }

  public static int[] b(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return new int[0];
    int[] arrayOfInt = new int[paramList.size()];
    Iterator localIterator = paramList.iterator();
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
    return arrayOfInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.n
 * JD-Core Version:    0.6.2
 */