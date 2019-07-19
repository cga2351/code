package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class aw
{
  private final Object a = new Object();
  private final bb b;
  private final HashMap<av, ax> c = new HashMap();
  private final or<a, av> d = new or();
  private final Context e;
  private volatile int f = 0;

  public aw(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    this.b = new bb(paramContext);
  }

  public int a()
  {
    return this.f;
  }

  public ax a(av paramav, t paramt)
  {
    synchronized (this.a)
    {
      ax localax = (ax)this.c.get(paramav);
      if (localax == null)
      {
        localax = paramav.a().a(this.e, this.b, paramav, paramt);
        this.c.put(paramav, localax);
        this.d.a(new a(paramav), paramav);
        this.f = (1 + this.f);
      }
      return localax;
    }
  }

  public void a(String paramString1, int paramInt, String paramString2)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    ArrayList localArrayList;
    synchronized (this.a)
    {
      Collection localCollection = this.d.b(new a(paramString1, localInteger, paramString2));
      if (bw.a(localCollection))
        break label167;
      this.f -= localCollection.size();
      localArrayList = new ArrayList(localCollection.size());
      Iterator localIterator1 = localCollection.iterator();
      if (localIterator1.hasNext())
      {
        av localav = (av)localIterator1.next();
        localArrayList.add(this.c.remove(localav));
      }
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
      ((ax)localIterator2.next()).a();
    label167:
  }

  private static final class a
  {
    private final String a;
    private final Integer b;
    private final String c;

    a(av paramav)
    {
      this(paramav.c(), paramav.d(), paramav.e());
    }

    a(String paramString1, Integer paramInteger, String paramString2)
    {
      this.a = paramString1;
      this.b = paramInteger;
      this.c = paramString2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
        if (!this.a.equals(locala.a))
          return false;
        if (this.b != null)
        {
          if (this.b.equals(locala.b));
        }
        else
          while (locala.b != null)
            return false;
        if (this.c != null)
          return this.c.equals(locala.c);
      }
      while (locala.c == null);
      return false;
    }

    public int hashCode()
    {
      int i = 31 * this.a.hashCode();
      if (this.b != null);
      for (int j = this.b.hashCode(); ; j = 0)
      {
        int k = 31 * (j + i);
        String str = this.c;
        int m = 0;
        if (str != null)
          m = this.c.hashCode();
        return k + m;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.aw
 * JD-Core Version:    0.6.2
 */