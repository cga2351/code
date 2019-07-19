package com.google.a.a.f;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class n extends AbstractMap<String, Object>
  implements Cloneable
{
  Map<String, Object> a = a.a();
  final h b;

  public n()
  {
    this(EnumSet.noneOf(c.class));
  }

  public n(EnumSet<c> paramEnumSet)
  {
    this.b = h.a(getClass(), paramEnumSet.contains(c.a));
  }

  public n c()
  {
    try
    {
      n localn = (n)super.clone();
      i.a(this, localn);
      localn.a = ((Map)i.c(this.a));
      return localn;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException(localCloneNotSupportedException);
    }
  }

  public n c(String paramString, Object paramObject)
  {
    m localm = this.b.a(paramString);
    if (localm != null)
    {
      localm.a(this, paramObject);
      return this;
    }
    if (this.b.a())
      paramString = paramString.toLowerCase();
    this.a.put(paramString, paramObject);
    return this;
  }

  public final Object d(String paramString, Object paramObject)
  {
    m localm = this.b.a(paramString);
    if (localm != null)
    {
      Object localObject = localm.a(this);
      localm.a(this, paramObject);
      return localObject;
    }
    if (this.b.a())
      paramString = paramString.toLowerCase();
    return this.a.put(paramString, paramObject);
  }

  public Set<Map.Entry<String, Object>> entrySet()
  {
    return new b();
  }

  public final Object get(Object paramObject)
  {
    if (!(paramObject instanceof String))
      return null;
    String str = (String)paramObject;
    m localm = this.b.a(str);
    if (localm != null)
      return localm.a(this);
    if (this.b.a())
      str = str.toLowerCase();
    return this.a.get(str);
  }

  public final h k()
  {
    return this.b;
  }

  public final void putAll(Map<? extends String, ?> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      c((String)localEntry.getKey(), localEntry.getValue());
    }
  }

  public final Object remove(Object paramObject)
  {
    if (!(paramObject instanceof String))
      return null;
    String str = (String)paramObject;
    if (this.b.a(str) != null)
      throw new UnsupportedOperationException();
    if (this.b.a())
      str = str.toLowerCase();
    return this.a.remove(str);
  }

  final class a
    implements Iterator<Map.Entry<String, Object>>
  {
    private boolean b;
    private final Iterator<Map.Entry<String, Object>> c;
    private final Iterator<Map.Entry<String, Object>> d;

    a(j.c arg2)
    {
      Object localObject;
      this.c = localObject.a();
      this.d = n.this.a.entrySet().iterator();
    }

    public Map.Entry<String, Object> a()
    {
      if (!this.b)
      {
        if (this.c.hasNext())
          return (Map.Entry)this.c.next();
        this.b = true;
      }
      return (Map.Entry)this.d.next();
    }

    public boolean hasNext()
    {
      return (this.c.hasNext()) || (this.d.hasNext());
    }

    public void remove()
    {
      if (this.b)
        this.d.remove();
      this.c.remove();
    }
  }

  final class b extends AbstractSet<Map.Entry<String, Object>>
  {
    private final j.c b = new j(n.this, n.this.b.a()).a();

    b()
    {
    }

    public void clear()
    {
      n.this.a.clear();
      this.b.clear();
    }

    public Iterator<Map.Entry<String, Object>> iterator()
    {
      return new n.a(n.this, this.b);
    }

    public int size()
    {
      return n.this.a.size() + this.b.size();
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[1];
      arrayOfc[0] = a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.n
 * JD-Core Version:    0.6.2
 */