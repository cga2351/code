package com.yandex.metrica.impl.ob;

public abstract class ka
  implements jq, kj
{
  private final String a;
  private final int b;
  private final px<String> c;
  private final js d;
  private of e;

  ka(int paramInt, String paramString, px<String> parampx, js paramjs)
  {
    this.b = paramInt;
    this.a = paramString;
    this.c = parampx;
    this.d = paramjs;
    this.e = og.a();
  }

  public final ko.a.a a()
  {
    ko.a.a locala = new ko.a.a();
    locala.c = d();
    locala.b = c().getBytes();
    locala.e = new ko.a.c();
    locala.d = new ko.a.b();
    return locala;
  }

  public void a(of paramof)
  {
    this.e = paramof;
  }

  public String c()
  {
    return this.a;
  }

  public int d()
  {
    return this.b;
  }

  public js e()
  {
    return this.d;
  }

  protected boolean f()
  {
    pv localpv = this.c.a(c());
    if (localpv.a())
      return true;
    if (this.e.c())
      this.e.b("Attribute " + c() + " of type " + kh.a(d()) + " is skipped because " + localpv.b());
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ka
 * JD-Core Version:    0.6.2
 */