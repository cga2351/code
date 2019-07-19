package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.yandex.metrica.impl.br.a;
import com.yandex.metrica.impl.br.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class gw
  implements gr<br.a, kt.a.e>
{
  private static final Map<Integer, br.a.a> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private static final Map<br.a.a, Integer> b = Collections.unmodifiableMap(new HashMap()
  {
  });

  private static List<br.a.a> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      localArrayList.add(a.get(Integer.valueOf(k)));
    }
    return localArrayList;
  }

  private static List<Pair<String, String>> a(kt.a.e.a[] paramArrayOfa)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfa.length);
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
    {
      kt.a.e.a locala = paramArrayOfa[j];
      localArrayList.add(new Pair(locala.b, locala.c));
    }
    return localArrayList;
  }

  public br.a a(kt.a.e parame)
  {
    return new br.a(parame.b, parame.c, parame.d, a(parame.e), Long.valueOf(parame.f), a(parame.g));
  }

  public kt.a.e a(br.a parama)
  {
    int i = 0;
    kt.a.e locale = new kt.a.e();
    locale.b = parama.a;
    locale.c = parama.b;
    locale.d = parama.c;
    List localList1 = parama.d;
    kt.a.e.a[] arrayOfa = new kt.a.e.a[localList1.size()];
    Iterator localIterator = localList1.iterator();
    for (int j = 0; localIterator.hasNext(); j++)
    {
      Pair localPair = (Pair)localIterator.next();
      kt.a.e.a locala = new kt.a.e.a();
      locala.b = ((String)localPair.first);
      locala.c = ((String)localPair.second);
      arrayOfa[j] = locala;
    }
    locale.e = arrayOfa;
    if (parama.e == null);
    int[] arrayOfInt;
    for (long l = 0L; ; l = parama.e.longValue())
    {
      locale.f = l;
      List localList2 = parama.f;
      arrayOfInt = new int[localList2.size()];
      while (i < localList2.size())
      {
        arrayOfInt[i] = ((Integer)b.get(localList2.get(i))).intValue();
        i++;
      }
    }
    locale.g = arrayOfInt;
    return locale;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gw
 * JD-Core Version:    0.6.2
 */