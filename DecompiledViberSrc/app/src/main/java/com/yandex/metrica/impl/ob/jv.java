package com.yandex.metrica.impl.ob;

public abstract class jv<T> extends ka
{
  private final T a;

  jv(int paramInt, String paramString, T paramT, px<String> parampx, js paramjs)
  {
    super(paramInt, paramString, parampx, paramjs);
    this.a = paramT;
  }

  public void a(ki paramki)
  {
    if (f())
    {
      ko.a.a locala = e().a(paramki, paramki.a(d(), c()), this);
      if (locala != null)
        a(locala);
    }
  }

  protected abstract void a(ko.a.a parama);

  public T b()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jv
 * JD-Core Version:    0.6.2
 */