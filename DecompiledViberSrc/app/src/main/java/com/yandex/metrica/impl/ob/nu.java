package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class nu
{
  public static List<Integer> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(Integer.valueOf(paramArrayOfInt[j]));
    return localArrayList;
  }

  public static boolean a(Collection<?> paramCollection1, Collection<?> paramCollection2)
  {
    if ((paramCollection1 == null) && (paramCollection2 == null))
      return true;
    if ((paramCollection1 == null) || (paramCollection2 == null))
      return false;
    if (paramCollection1.size() == paramCollection2.size())
    {
      HashSet localHashSet;
      if ((paramCollection1 instanceof HashSet))
        localHashSet = (HashSet)paramCollection1;
      while (true)
      {
        Iterator localIterator = paramCollection2.iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (localHashSet.contains(localIterator.next()));
        return false;
        if ((paramCollection2 instanceof HashSet))
        {
          localHashSet = (HashSet)paramCollection2;
          paramCollection2 = paramCollection1;
        }
        else
        {
          localHashSet = new HashSet(paramCollection1);
        }
      }
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nu
 * JD-Core Version:    0.6.2
 */