package com.google.d.b.a;

import com.google.d.b.e;
import com.google.d.b.h;
import com.google.d.b.j;
import com.google.d.f;
import com.google.d.l;
import com.google.d.r;
import com.google.d.u;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
  implements x
{
  final boolean a;
  private final com.google.d.b.c b;

  public g(com.google.d.b.c paramc, boolean paramBoolean)
  {
    this.b = paramc;
    this.a = paramBoolean;
  }

  private w<?> a(f paramf, Type paramType)
  {
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class))
      return n.f;
    return paramf.a(com.google.d.c.a.get(paramType));
  }

  public <T> w<T> a(f paramf, com.google.d.c.a<T> parama)
  {
    Type localType = parama.getType();
    if (!Map.class.isAssignableFrom(parama.getRawType()))
      return null;
    Type[] arrayOfType = com.google.d.b.b.b(localType, com.google.d.b.b.e(localType));
    w localw1 = a(paramf, arrayOfType[0]);
    w localw2 = paramf.a(com.google.d.c.a.get(arrayOfType[1]));
    h localh = this.b.a(parama);
    return new a(paramf, arrayOfType[0], localw1, arrayOfType[1], localw2, localh);
  }

  private final class a<K, V> extends w<Map<K, V>>
  {
    private final w<K> b;
    private final w<V> c;
    private final h<? extends Map<K, V>> d;

    public a(Type paramw, w<K> paramType1, Type paramw1, w<V> paramh, h<? extends Map<K, V>> arg6)
    {
      this.b = new m(paramw, paramw1, paramType1);
      w localw;
      this.c = new m(paramw, localw, paramh);
      Object localObject;
      this.d = localObject;
    }

    private String a(l paraml)
    {
      if (paraml.i())
      {
        r localr = paraml.m();
        if (localr.p())
          return String.valueOf(localr.a());
        if (localr.o())
          return Boolean.toString(localr.f());
        if (localr.q())
          return localr.b();
        throw new AssertionError();
      }
      if (paraml.j())
        return "null";
      throw new AssertionError();
    }

    public Map<K, V> a(com.google.d.d.a parama)
      throws IOException
    {
      com.google.d.d.b localb = parama.f();
      if (localb == com.google.d.d.b.i)
      {
        parama.j();
        return null;
      }
      Map localMap = (Map)this.d.a();
      if (localb == com.google.d.d.b.a)
      {
        parama.a();
        while (parama.e())
        {
          parama.a();
          Object localObject2 = this.b.b(parama);
          if (localMap.put(localObject2, this.c.b(parama)) != null)
            throw new u("duplicate key: " + localObject2);
          parama.b();
        }
        parama.b();
        return localMap;
      }
      parama.c();
      while (parama.e())
      {
        e.a.a(parama);
        Object localObject1 = this.b.b(parama);
        if (localMap.put(localObject1, this.c.b(parama)) != null)
          throw new u("duplicate key: " + localObject1);
      }
      parama.d();
      return localMap;
    }

    public void a(com.google.d.d.c paramc, Map<K, V> paramMap)
      throws IOException
    {
      int i = 0;
      if (paramMap == null)
      {
        paramc.f();
        return;
      }
      if (!g.this.a)
      {
        paramc.d();
        Iterator localIterator2 = paramMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
          paramc.a(String.valueOf(localEntry2.getKey()));
          this.c.a(paramc, localEntry2.getValue());
        }
        paramc.e();
        return;
      }
      ArrayList localArrayList1 = new ArrayList(paramMap.size());
      ArrayList localArrayList2 = new ArrayList(paramMap.size());
      Iterator localIterator1 = paramMap.entrySet().iterator();
      int j = 0;
      if (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        l locall = this.b.a(localEntry1.getKey());
        localArrayList1.add(locall);
        localArrayList2.add(localEntry1.getValue());
        if ((locall.g()) || (locall.h()));
        for (int k = 1; ; k = 0)
        {
          j = k | j;
          break;
        }
      }
      if (j != 0)
      {
        paramc.b();
        while (i < localArrayList1.size())
        {
          paramc.b();
          j.a((l)localArrayList1.get(i), paramc);
          this.c.a(paramc, localArrayList2.get(i));
          paramc.c();
          i++;
        }
        paramc.c();
        return;
      }
      paramc.d();
      while (i < localArrayList1.size())
      {
        paramc.a(a((l)localArrayList1.get(i)));
        this.c.a(paramc, localArrayList2.get(i));
        i++;
      }
      paramc.e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.g
 * JD-Core Version:    0.6.2
 */