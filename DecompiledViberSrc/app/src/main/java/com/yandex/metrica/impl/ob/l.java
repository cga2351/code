package com.yandex.metrica.impl.ob;

public class l<T extends j>
{
  private final k<T> a;
  private final i<T> b;

  private l(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
  }

  public static <T extends j> a<T> a(k<T> paramk)
  {
    return new a(paramk);
  }

  public void a(j paramj)
  {
    this.a.a(paramj);
  }

  final boolean b(j paramj)
  {
    if (this.b == null)
      return false;
    return this.b.a(paramj);
  }

  public static final class a<T extends j>
  {
    final k<T> a;
    i<T> b;

    a(k<T> paramk)
    {
      this.a = paramk;
    }

    public a<T> a(i<T> parami)
    {
      this.b = parami;
      return this;
    }

    public l<T> a()
    {
      return new l(this, (byte)0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.l
 * JD-Core Version:    0.6.2
 */