package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private c<K, V> a;
  private c<K, V> b;
  private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
  private int d = 0;

  public int a()
  {
    return this.d;
  }

  protected c<K, V> a(K paramK)
  {
    for (c localc = this.a; ; localc = localc.c)
      if ((localc == null) || (localc.a.equals(paramK)))
        return localc;
  }

  public V a(K paramK, V paramV)
  {
    c localc = a(paramK);
    if (localc != null)
      return localc.b;
    b(paramK, paramV);
    return null;
  }

  protected c<K, V> b(K paramK, V paramV)
  {
    c localc = new c(paramK, paramV);
    this.d = (1 + this.d);
    if (this.b == null)
    {
      this.a = localc;
      this.b = this.a;
      return localc;
    }
    this.b.c = localc;
    localc.d = this.b;
    this.b = localc;
    return localc;
  }

  public V b(K paramK)
  {
    c localc = a(paramK);
    if (localc == null)
      return null;
    this.d = (-1 + this.d);
    if (!this.c.isEmpty())
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
        ((f)localIterator.next()).a_(localc);
    }
    if (localc.d != null)
    {
      localc.d.c = localc.c;
      if (localc.c == null)
        break label134;
      localc.c.d = localc.d;
    }
    while (true)
    {
      localc.c = null;
      localc.d = null;
      return localc.b;
      this.a = localc.c;
      break;
      label134: this.b = localc.d;
    }
  }

  public Iterator<Map.Entry<K, V>> b()
  {
    b localb = new b(this.b, this.a);
    this.c.put(localb, Boolean.valueOf(false));
    return localb;
  }

  public b<K, V>.d c()
  {
    d locald = new d(null);
    this.c.put(locald, Boolean.valueOf(false));
    return locald;
  }

  public Map.Entry<K, V> d()
  {
    return this.a;
  }

  public Map.Entry<K, V> e()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this)
      bool2 = true;
    b localb;
    int i;
    int j;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof b;
        bool2 = false;
      }
      while (!bool1);
      localb = (b)paramObject;
      i = a();
      j = localb.a();
      bool2 = false;
    }
    while (i != j);
    Iterator localIterator1 = iterator();
    Iterator localIterator2 = localb.iterator();
    while (true)
      if ((localIterator1.hasNext()) && (localIterator2.hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Object localObject = localIterator2.next();
        if (localEntry == null)
        {
          bool2 = false;
          if (localObject != null)
            break;
        }
        if ((localEntry != null) && (!localEntry.equals(localObject)))
          return false;
      }
    if ((!localIterator1.hasNext()) && (!localIterator2.hasNext()));
    for (boolean bool3 = true; ; bool3 = false)
      return bool3;
  }

  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(this.a, this.b);
    this.c.put(locala, Boolean.valueOf(false));
    return locala;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext())
        localStringBuilder.append(", ");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  static class a<K, V> extends b.e<K, V>
  {
    a(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }

    b.c<K, V> a(b.c<K, V> paramc)
    {
      return paramc.c;
    }

    b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.d;
    }
  }

  private static class b<K, V> extends b.e<K, V>
  {
    b(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }

    b.c<K, V> a(b.c<K, V> paramc)
    {
      return paramc.d;
    }

    b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.c;
    }
  }

  static class c<K, V>
    implements Map.Entry<K, V>
  {
    final K a;
    final V b;
    c<K, V> c;
    c<K, V> d;

    c(K paramK, V paramV)
    {
      this.a = paramK;
      this.b = paramV;
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      c localc;
      do
      {
        return true;
        if (!(paramObject instanceof c))
          return false;
        localc = (c)paramObject;
      }
      while ((this.a.equals(localc.a)) && (this.b.equals(localc.b)));
      return false;
    }

    public K getKey()
    {
      return this.a;
    }

    public V getValue()
    {
      return this.b;
    }

    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public String toString()
    {
      return this.a + "=" + this.b;
    }
  }

  private class d
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private b.c<K, V> b;
    private boolean c = true;

    private d()
    {
    }

    public Map.Entry<K, V> a()
    {
      if (this.c)
      {
        this.c = false;
        this.b = b.a(b.this);
        return this.b;
      }
      if (this.b != null);
      for (b.c localc = this.b.c; ; localc = null)
      {
        this.b = localc;
        break;
      }
    }

    public void a_(b.c<K, V> paramc)
    {
      if (paramc == this.b)
      {
        this.b = this.b.d;
        if (this.b != null)
          break label34;
      }
      label34: for (boolean bool = true; ; bool = false)
      {
        this.c = bool;
        return;
      }
    }

    public boolean hasNext()
    {
      if (this.c)
        if (b.a(b.this) == null);
      while ((this.b != null) && (this.b.c != null))
      {
        return true;
        return false;
      }
      return false;
    }
  }

  private static abstract class e<K, V>
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    b.c<K, V> a;
    b.c<K, V> b;

    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.a = paramc2;
      this.b = paramc1;
    }

    private b.c<K, V> b()
    {
      if ((this.b == this.a) || (this.a == null))
        return null;
      return a(this.b);
    }

    abstract b.c<K, V> a(b.c<K, V> paramc);

    public Map.Entry<K, V> a()
    {
      b.c localc = this.b;
      this.b = b();
      return localc;
    }

    public void a_(b.c<K, V> paramc)
    {
      if ((this.a == paramc) && (paramc == this.b))
      {
        this.b = null;
        this.a = null;
      }
      if (this.a == paramc)
        this.a = b(this.a);
      if (this.b == paramc)
        this.b = b();
    }

    abstract b.c<K, V> b(b.c<K, V> paramc);

    public boolean hasNext()
    {
      return this.b != null;
    }
  }

  static abstract interface f<K, V>
  {
    public abstract void a_(b.c<K, V> paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.a.b.b
 * JD-Core Version:    0.6.2
 */