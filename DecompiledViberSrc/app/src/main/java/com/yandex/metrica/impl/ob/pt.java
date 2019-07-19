package com.yandex.metrica.impl.ob;

public class pt<T>
  implements px<T>
{
  private final px<T> a;

  public pt(px<T> parampx)
  {
    this.a = parampx;
  }

  public pv a(T paramT)
  {
    pv localpv = this.a.a(paramT);
    if (localpv.a())
      return localpv;
    throw new pu(localpv.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pt
 * JD-Core Version:    0.6.2
 */