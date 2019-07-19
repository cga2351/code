package d.d.b;

import d.f.d;

public class g extends a
  implements f, d
{
  private final int a;

  public g(int paramInt)
  {
    this.a = paramInt;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof g))
        break;
      g localg = (g)paramObject;
      if (c() == null)
        if (localg.c() != null);
      while ((!d().equals(localg.d())) || (!e().equals(localg.e())) || (!h.a(g(), localg.g())))
        do
          return false;
        while (!c().equals(localg.c()));
    }
    if ((paramObject instanceof d))
      return paramObject.equals(h());
    return false;
  }

  protected d.f.a f()
  {
    return m.a(this);
  }

  public int hashCode()
  {
    if (c() == null);
    for (int i = 0; ; i = 31 * c().hashCode())
      return 31 * (i + d().hashCode()) + e().hashCode();
  }

  protected d j()
  {
    return (d)super.i();
  }

  public String toString()
  {
    d.f.a locala = h();
    if (locala != this)
      return locala.toString();
    if ("<init>".equals(d()))
      return "constructor (Kotlin reflection is not available)";
    return "function " + d() + " (Kotlin reflection is not available)";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.g
 * JD-Core Version:    0.6.2
 */