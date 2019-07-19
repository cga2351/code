package com.yandex.metrica.impl.ob;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ki
{
  private static final int[] a = { 0, 1, 2, 3 };
  private final SparseArray<HashMap<String, ko.a.a>> b = new SparseArray();
  private int c = 0;

  public ki()
  {
    this(a);
  }

  ki(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.b.put(k, new HashMap());
      i++;
    }
  }

  public int a()
  {
    return this.c;
  }

  public ko.a.a a(int paramInt, String paramString)
  {
    return (ko.a.a)((HashMap)this.b.get(paramInt)).get(paramString);
  }

  void a(ko.a.a parama)
  {
    ((HashMap)this.b.get(parama.c)).put(new String(parama.b), parama);
  }

  public void b()
  {
    this.c = (1 + this.c);
  }

  public ko.a c()
  {
    ko.a locala = new ko.a();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < this.b.size(); i++)
    {
      Iterator localIterator = ((HashMap)this.b.get(this.b.keyAt(i))).values().iterator();
      while (localIterator.hasNext())
        localArrayList.add((ko.a.a)localIterator.next());
    }
    locala.b = ((ko.a.a[])localArrayList.toArray(new ko.a.a[localArrayList.size()]));
    return locala;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ki
 * JD-Core Version:    0.6.2
 */