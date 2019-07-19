package com.google.a.a.f;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

final class j extends AbstractMap<String, Object>
{
  final Object a;
  final h b;

  j(Object paramObject, boolean paramBoolean)
  {
    this.a = paramObject;
    this.b = h.a(paramObject.getClass(), paramBoolean);
    if (!this.b.b());
    for (boolean bool = true; ; bool = false)
    {
      z.a(bool);
      return;
    }
  }

  public c a()
  {
    return new c();
  }

  public Object a(String paramString, Object paramObject)
  {
    m localm = this.b.a(paramString);
    String str1 = String.valueOf(paramString);
    if (str1.length() != 0);
    for (String str2 = "no field of key ".concat(str1); ; str2 = new String("no field of key "))
    {
      z.a(localm, str2);
      Object localObject = localm.a(this.a);
      localm.a(this.a, z.a(paramObject));
      return localObject;
    }
  }

  public boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }

  public Object get(Object paramObject)
  {
    if (!(paramObject instanceof String));
    m localm;
    do
    {
      return null;
      localm = this.b.a((String)paramObject);
    }
    while (localm == null);
    return localm.a(this.a);
  }

  final class a
    implements Map.Entry<String, Object>
  {
    private Object b;
    private final m c;

    a(m paramObject, Object arg3)
    {
      this.c = paramObject;
      Object localObject;
      this.b = z.a(localObject);
    }

    public String a()
    {
      String str = this.c.b();
      if (j.this.b.a())
        str = str.toLowerCase();
      return str;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Map.Entry localEntry;
      do
      {
        return true;
        if (!(paramObject instanceof Map.Entry))
          return false;
        localEntry = (Map.Entry)paramObject;
      }
      while ((a().equals(localEntry.getKey())) && (getValue().equals(localEntry.getValue())));
      return false;
    }

    public Object getValue()
    {
      return this.b;
    }

    public int hashCode()
    {
      return a().hashCode() ^ getValue().hashCode();
    }

    public Object setValue(Object paramObject)
    {
      Object localObject = this.b;
      this.b = z.a(paramObject);
      this.c.a(j.this.a, paramObject);
      return localObject;
    }
  }

  final class b
    implements Iterator<Map.Entry<String, Object>>
  {
    private int b = -1;
    private m c;
    private Object d;
    private boolean e;
    private boolean f;
    private m g;

    b()
    {
    }

    public Map.Entry<String, Object> a()
    {
      if (!hasNext())
        throw new NoSuchElementException();
      this.g = this.c;
      Object localObject = this.d;
      this.f = false;
      this.e = false;
      this.c = null;
      this.d = null;
      return new j.a(j.this, this.g, localObject);
    }

    public boolean hasNext()
    {
      if (!this.f)
      {
        this.f = true;
        for (this.d = null; this.d == null; this.d = this.c.a(j.this.a))
        {
          int i = 1 + this.b;
          this.b = i;
          if (i >= j.this.b.a.size())
            break;
          this.c = j.this.b.a((String)j.this.b.a.get(this.b));
        }
      }
      return this.d != null;
    }

    public void remove()
    {
      if ((this.g != null) && (!this.e));
      for (boolean bool = true; ; bool = false)
      {
        z.b(bool);
        this.e = true;
        this.g.a(j.this.a, null);
        return;
      }
    }
  }

  final class c extends AbstractSet<Map.Entry<String, Object>>
  {
    c()
    {
    }

    public j.b a()
    {
      return new j.b(j.this);
    }

    public void clear()
    {
      Iterator localIterator = j.this.b.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        j.this.b.a(str).a(j.this.a, null);
      }
    }

    public boolean isEmpty()
    {
      Iterator localIterator = j.this.b.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (j.this.b.a(str).a(j.this.a) != null)
          return false;
      }
      return true;
    }

    public int size()
    {
      Iterator localIterator = j.this.b.a.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (j.this.b.a(str).a(j.this.a) == null)
          break label74;
      }
      label74: for (int j = i + 1; ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.j
 * JD-Core Version:    0.6.2
 */