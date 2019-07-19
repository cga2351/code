package com.google.d;

import com.google.d.b.g;
import java.util.Map.Entry;
import java.util.Set;

public final class o extends l
{
  private final g<String, l> a = new g();

  private l a(Object paramObject)
  {
    if (paramObject == null)
      return n.a;
    return new r(paramObject);
  }

  public l a(String paramString)
  {
    return (l)this.a.remove(paramString);
  }

  public void a(String paramString, l paraml)
  {
    if (paraml == null)
      paraml = n.a;
    this.a.put(paramString, paraml);
  }

  public void a(String paramString, Boolean paramBoolean)
  {
    a(paramString, a(paramBoolean));
  }

  public void a(String paramString, Number paramNumber)
  {
    a(paramString, a(paramNumber));
  }

  public boolean b(String paramString)
  {
    return this.a.containsKey(paramString);
  }

  public l c(String paramString)
  {
    return (l)this.a.get(paramString);
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof o)) && (((o)paramObject).a.equals(this.a)));
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public Set<Map.Entry<String, l>> o()
  {
    return this.a.entrySet();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.o
 * JD-Core Version:    0.6.2
 */