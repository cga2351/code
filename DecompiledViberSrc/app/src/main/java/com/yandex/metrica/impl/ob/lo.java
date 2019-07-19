package com.yandex.metrica.impl.ob;

public abstract class lo<T extends lm, A, L extends lm.d<T, lm.c<A>>>
{
  private T a;
  private L b;
  private lm.c<A> c;
  private a<A> d;

  public lo(L paramL, a<A> parama, mw parammw, t paramt)
  {
    this.b = paramL;
    this.d = parama;
    h.a().a(this, p.class, l.a(new k()
    {
      public void a()
      {
        lo.this.b();
      }
    }).a());
    a(new lm.c(parammw, this.d.a(null, paramt)));
  }

  protected void a(lm.c<A> paramc)
  {
    try
    {
      this.c = paramc;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(mw parammw)
  {
    try
    {
      a(new lm.c(parammw, d()));
      b();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final A b(t paramt)
  {
    return this.d.a(this.c.b, paramt);
  }

  public void b()
  {
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public mw c()
  {
    try
    {
      mw localmw = this.c.a;
      return localmw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public A d()
  {
    try
    {
      Object localObject2 = this.c.b;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public T e()
  {
    try
    {
      if (this.a == null)
        this.a = this.b.a(this.c);
      lm locallm = this.a;
      return locallm;
    }
    finally
    {
    }
  }

  public static abstract interface a<A>
  {
    public abstract A a(A paramA, t paramt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lo
 * JD-Core Version:    0.6.2
 */