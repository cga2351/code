package com.google.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i extends l
  implements Iterable<l>
{
  private final List<l> a = new ArrayList();

  public Number a()
  {
    if (this.a.size() == 1)
      return ((l)this.a.get(0)).a();
    throw new IllegalStateException();
  }

  public void a(l paraml)
  {
    if (paraml == null)
      paraml = n.a;
    this.a.add(paraml);
  }

  public String b()
  {
    if (this.a.size() == 1)
      return ((l)this.a.get(0)).b();
    throw new IllegalStateException();
  }

  public double c()
  {
    if (this.a.size() == 1)
      return ((l)this.a.get(0)).c();
    throw new IllegalStateException();
  }

  public long d()
  {
    if (this.a.size() == 1)
      return ((l)this.a.get(0)).d();
    throw new IllegalStateException();
  }

  public int e()
  {
    if (this.a.size() == 1)
      return ((l)this.a.get(0)).e();
    throw new IllegalStateException();
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof i)) && (((i)paramObject).a.equals(this.a)));
  }

  public boolean f()
  {
    if (this.a.size() == 1)
      return ((l)this.a.get(0)).f();
    throw new IllegalStateException();
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public Iterator<l> iterator()
  {
    return this.a.iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.i
 * JD-Core Version:    0.6.2
 */