package d.d.b;

import d.f.e;

public abstract class j extends a
  implements e
{
  protected e a()
  {
    return (e)super.i();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    j localj;
    do
    {
      return true;
      if (!(paramObject instanceof j))
        break;
      localj = (j)paramObject;
    }
    while ((c().equals(localj.c())) && (d().equals(localj.d())) && (e().equals(localj.e())) && (h.a(g(), localj.g())));
    return false;
    if ((paramObject instanceof e))
      return paramObject.equals(h());
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * c().hashCode() + d().hashCode()) + e().hashCode();
  }

  public String toString()
  {
    d.f.a locala = h();
    if (locala != this)
      return locala.toString();
    return "property " + d() + " (Kotlin reflection is not available)";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.j
 * JD-Core Version:    0.6.2
 */