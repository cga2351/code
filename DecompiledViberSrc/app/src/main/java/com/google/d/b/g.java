package com.google.d.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class g<K, V> extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> g;
  Comparator<? super K> a;
  d<K, V> b;
  int c = 0;
  int d = 0;
  final d<K, V> e = new d();
  private g<K, V>.a h;
  private g<K, V>.b i;

  static
  {
    if (!g.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      f = bool;
      g = new Comparator()
      {
        public int a(Comparable paramAnonymousComparable1, Comparable paramAnonymousComparable2)
        {
          return paramAnonymousComparable1.compareTo(paramAnonymousComparable2);
        }
      };
      return;
    }
  }

  public g()
  {
    this(g);
  }

  public g(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null);
    while (true)
    {
      this.a = paramComparator;
      return;
      paramComparator = g;
    }
  }

  private void a(d<K, V> paramd)
  {
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    d locald3 = locald2.b;
    d locald4 = locald2.c;
    paramd.c = locald3;
    if (locald3 != null)
      locald3.a = paramd;
    a(paramd, locald2);
    locald2.b = paramd;
    paramd.a = locald2;
    int j;
    if (locald1 != null)
    {
      j = locald1.h;
      if (locald3 == null)
        break label131;
    }
    label131: for (int k = locald3.h; ; k = 0)
    {
      paramd.h = (1 + Math.max(j, k));
      int m = paramd.h;
      int n = 0;
      if (locald4 != null)
        n = locald4.h;
      locald2.h = (1 + Math.max(m, n));
      return;
      j = 0;
      break;
    }
  }

  private void a(d<K, V> paramd1, d<K, V> paramd2)
  {
    d locald = paramd1.a;
    paramd1.a = null;
    if (paramd2 != null)
      paramd2.a = locald;
    if (locald != null)
    {
      if (locald.b == paramd1)
      {
        locald.b = paramd2;
        return;
      }
      if ((!f) && (locald.c != paramd1))
        throw new AssertionError();
      locald.c = paramd2;
      return;
    }
    this.b = paramd2;
  }

  private boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  private void b(d<K, V> paramd)
  {
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    d locald3 = locald1.b;
    d locald4 = locald1.c;
    paramd.b = locald4;
    if (locald4 != null)
      locald4.a = paramd;
    a(paramd, locald1);
    locald1.c = paramd;
    paramd.a = locald1;
    int j;
    if (locald2 != null)
    {
      j = locald2.h;
      if (locald4 == null)
        break label131;
    }
    label131: for (int k = locald4.h; ; k = 0)
    {
      paramd.h = (1 + Math.max(j, k));
      int m = paramd.h;
      int n = 0;
      if (locald3 != null)
        n = locald3.h;
      locald1.h = (1 + Math.max(m, n));
      return;
      j = 0;
      break;
    }
  }

  private void b(d<K, V> paramd, boolean paramBoolean)
  {
    d locald1;
    d locald2;
    int j;
    int k;
    label37: int m;
    int i3;
    label77: int i4;
    label89: int i5;
    if (paramd != null)
    {
      locald1 = paramd.b;
      locald2 = paramd.c;
      if (locald1 == null)
        break label121;
      j = locald1.h;
      if (locald2 == null)
        break label127;
      k = locald2.h;
      m = j - k;
      if (m != -2)
        break label179;
      d locald5 = locald2.b;
      d locald6 = locald2.c;
      if (locald6 == null)
        break label133;
      i3 = locald6.h;
      if (locald5 == null)
        break label139;
      i4 = locald5.h;
      i5 = i4 - i3;
      if ((i5 != -1) && ((i5 != 0) || (paramBoolean)))
        break label145;
      a(paramd);
    }
    while (true)
    {
      if (!paramBoolean)
        break label252;
      label120: return;
      label121: j = 0;
      break;
      label127: k = 0;
      break label37;
      label133: i3 = 0;
      break label77;
      label139: i4 = 0;
      break label89;
      label145: if ((!f) && (i5 != 1))
        throw new AssertionError();
      b(locald2);
      a(paramd);
    }
    label179: int n;
    label209: int i1;
    label221: int i2;
    if (m == 2)
    {
      d locald3 = locald1.b;
      d locald4 = locald1.c;
      if (locald4 != null)
      {
        n = locald4.h;
        if (locald3 == null)
          break label266;
        i1 = locald3.h;
        i2 = i1 - n;
        if ((i2 != 1) && ((i2 != 0) || (paramBoolean)))
          break label272;
        b(paramd);
        label248: if (paramBoolean)
          break label303;
      }
    }
    label252: 
    do
    {
      do
      {
        paramd = paramd.a;
        break;
        n = 0;
        break label209;
        i1 = 0;
        break label221;
        if ((!f) && (i2 != -1))
          throw new AssertionError();
        a(locald1);
        b(paramd);
        break label248;
        break label120;
        if (m != 0)
          break label323;
        paramd.h = (j + 1);
      }
      while (!paramBoolean);
      return;
      if ((!f) && (m != -1) && (m != 1))
        throw new AssertionError();
      paramd.h = (1 + Math.max(j, k));
    }
    while (paramBoolean);
    label266: label272: label303: label323: return;
  }

  d<K, V> a(Object paramObject)
  {
    Object localObject = null;
    if (paramObject != null);
    try
    {
      d locald = a(paramObject, false);
      localObject = locald;
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    return null;
  }

  d<K, V> a(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.a;
    Object localObject1 = this.b;
    Object localObject3;
    label57: label66: label83: d locald3;
    label95: int m;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == g)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null)
          break label66;
      }
      for (int k = localComparable.compareTo(((d)localObject1).f); ; k = localComparator.compare(paramK, ((d)localObject1).f))
      {
        if (k != 0)
          break label83;
        localObject3 = localObject1;
        return localObject3;
        localComparable = null;
        break;
      }
      if (k < 0)
      {
        locald3 = ((d)localObject1).b;
        if (locald3 != null)
          break label187;
        m = k;
        localObject2 = localObject1;
      }
    }
    for (int j = m; ; j = 0)
    {
      localObject3 = null;
      if (!paramBoolean)
        break label57;
      d locald1 = this.e;
      if (localObject2 == null)
      {
        if ((localComparator == g) && (!(paramK instanceof Comparable)))
        {
          throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
          locald3 = ((d)localObject1).c;
          break label95;
          label187: localObject1 = locald3;
          break;
        }
        locald2 = new d(localObject2, paramK, locald1, locald1.e);
        this.b = locald2;
        this.c = (1 + this.c);
        this.d = (1 + this.d);
        return locald2;
      }
      d locald2 = new d(localObject2, paramK, locald1, locald1.e);
      if (j < 0)
        localObject2.b = locald2;
      while (true)
      {
        b(localObject2, true);
        break;
        localObject2.c = locald2;
      }
      localObject2 = localObject1;
    }
  }

  d<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    d locald = a(paramEntry.getKey());
    if ((locald != null) && (a(locald.g, paramEntry.getValue())));
    for (int j = 1; j != 0; j = 0)
      return locald;
    return null;
  }

  void a(d<K, V> paramd, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramd.e.d = paramd.d;
      paramd.d.e = paramd.e;
    }
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    d locald3 = paramd.a;
    d locald4;
    int j;
    if ((locald1 != null) && (locald2 != null))
      if (locald1.h > locald2.h)
      {
        locald4 = locald1.b();
        a(locald4, false);
        d locald5 = paramd.b;
        if (locald5 == null)
          break label258;
        j = locald5.h;
        locald4.b = locald5;
        locald5.a = locald4;
        paramd.b = null;
      }
    while (true)
    {
      d locald6 = paramd.c;
      int k = 0;
      if (locald6 != null)
      {
        k = locald6.h;
        locald4.c = locald6;
        locald6.a = locald4;
        paramd.c = null;
      }
      locald4.h = (1 + Math.max(j, k));
      a(paramd, locald4);
      return;
      locald4 = locald2.a();
      break;
      if (locald1 != null)
      {
        a(paramd, locald1);
        paramd.b = null;
      }
      while (true)
      {
        b(locald3, false);
        this.c = (-1 + this.c);
        this.d = (1 + this.d);
        return;
        if (locald2 != null)
        {
          a(paramd, locald2);
          paramd.c = null;
        }
        else
        {
          a(paramd, null);
        }
      }
      label258: j = 0;
    }
  }

  d<K, V> b(Object paramObject)
  {
    d locald = a(paramObject);
    if (locald != null)
      a(locald, true);
    return locald;
  }

  public void clear()
  {
    this.b = null;
    this.c = 0;
    this.d = (1 + this.d);
    d locald = this.e;
    locald.e = locald;
    locald.d = locald;
  }

  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    a locala1 = this.h;
    if (locala1 != null)
      return locala1;
    a locala2 = new a();
    this.h = locala2;
    return locala2;
  }

  public V get(Object paramObject)
  {
    d locald = a(paramObject);
    if (locald != null)
      return locald.g;
    return null;
  }

  public Set<K> keySet()
  {
    b localb1 = this.i;
    if (localb1 != null)
      return localb1;
    b localb2 = new b();
    this.i = localb2;
    return localb2;
  }

  public V put(K paramK, V paramV)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    d locald = a(paramK, true);
    Object localObject = locald.g;
    locald.g = paramV;
    return localObject;
  }

  public V remove(Object paramObject)
  {
    d locald = b(paramObject);
    if (locald != null)
      return locald.g;
    return null;
  }

  public int size()
  {
    return this.c;
  }

  class a extends AbstractSet<Map.Entry<K, V>>
  {
    a()
    {
    }

    public void clear()
    {
      g.this.clear();
    }

    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (g.this.a((Map.Entry)paramObject) != null);
    }

    public Iterator<Map.Entry<K, V>> iterator()
    {
      // Byte code:
      //   0: new 30	com/google/d/b/g$a$1
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 33	com/google/d/b/g$a$1:<init>	(Lcom/google/d/b/g$a;)V
      //   8: areturn
    }

    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry));
      g.d locald;
      do
      {
        return false;
        locald = g.this.a((Map.Entry)paramObject);
      }
      while (locald == null);
      g.this.a(locald, true);
      return true;
    }

    public int size()
    {
      return g.this.c;
    }
  }

  final class b extends AbstractSet<K>
  {
    b()
    {
    }

    public void clear()
    {
      g.this.clear();
    }

    public boolean contains(Object paramObject)
    {
      return g.this.containsKey(paramObject);
    }

    public Iterator<K> iterator()
    {
      // Byte code:
      //   0: new 28	com/google/d/b/g$b$1
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 31	com/google/d/b/g$b$1:<init>	(Lcom/google/d/b/g$b;)V
      //   8: areturn
    }

    public boolean remove(Object paramObject)
    {
      return g.this.b(paramObject) != null;
    }

    public int size()
    {
      return g.this.c;
    }
  }

  private abstract class c<T>
    implements Iterator<T>
  {
    g.d<K, V> b = g.this.e.d;
    g.d<K, V> c = null;
    int d = g.this.d;

    c()
    {
    }

    final g.d<K, V> b()
    {
      g.d locald = this.b;
      if (locald == g.this.e)
        throw new NoSuchElementException();
      if (g.this.d != this.d)
        throw new ConcurrentModificationException();
      this.b = locald.d;
      this.c = locald;
      return locald;
    }

    public final boolean hasNext()
    {
      return this.b != g.this.e;
    }

    public final void remove()
    {
      if (this.c == null)
        throw new IllegalStateException();
      g.this.a(this.c, true);
      this.c = null;
      this.d = g.this.d;
    }
  }

  static final class d<K, V>
    implements Map.Entry<K, V>
  {
    d<K, V> a;
    d<K, V> b;
    d<K, V> c;
    d<K, V> d;
    d<K, V> e;
    final K f;
    V g;
    int h;

    d()
    {
      this.f = null;
      this.e = this;
      this.d = this;
    }

    d(d<K, V> paramd1, K paramK, d<K, V> paramd2, d<K, V> paramd3)
    {
      this.a = paramd1;
      this.f = paramK;
      this.h = 1;
      this.d = paramd2;
      this.e = paramd3;
      paramd3.d = this;
      paramd2.e = this;
    }

    public d<K, V> a()
    {
      d locald;
      for (Object localObject = this.b; localObject != null; localObject = locald)
      {
        locald = ((d)localObject).b;
        this = (d)localObject;
      }
      return this;
    }

    public d<K, V> b()
    {
      d locald;
      for (Object localObject = this.c; localObject != null; localObject = locald)
      {
        locald = ((d)localObject).c;
        this = (d)localObject;
      }
      return this;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      Map.Entry localEntry;
      if (bool1)
      {
        localEntry = (Map.Entry)paramObject;
        if (this.f != null)
          break label67;
        Object localObject2 = localEntry.getKey();
        bool2 = false;
        if (localObject2 == null)
        {
          if (this.g != null)
            break label93;
          Object localObject1 = localEntry.getValue();
          bool2 = false;
          if (localObject1 != null);
        }
      }
      while (true)
      {
        bool2 = true;
        label67: label93: boolean bool4;
        do
        {
          boolean bool3;
          do
          {
            return bool2;
            bool3 = this.f.equals(localEntry.getKey());
            bool2 = false;
          }
          while (!bool3);
          break;
          bool4 = this.g.equals(localEntry.getValue());
          bool2 = false;
        }
        while (!bool4);
      }
    }

    public K getKey()
    {
      return this.f;
    }

    public V getValue()
    {
      return this.g;
    }

    public int hashCode()
    {
      int i;
      int j;
      if (this.f == null)
      {
        i = 0;
        Object localObject = this.g;
        j = 0;
        if (localObject != null)
          break label35;
      }
      while (true)
      {
        return i ^ j;
        i = this.f.hashCode();
        break;
        label35: j = this.g.hashCode();
      }
    }

    public V setValue(V paramV)
    {
      Object localObject = this.g;
      this.g = paramV;
      return localObject;
    }

    public String toString()
    {
      return this.f + "=" + this.g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.g
 * JD-Core Version:    0.6.2
 */