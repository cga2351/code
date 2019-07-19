package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;

public class eg
{
  private final ab a;
  private final a b;
  private final ea<ec> c;
  private final ea<ec> d;
  private eb e;
  private b f = null;

  public eg(ab paramab, a parama)
  {
    this(paramab, parama, new dz(paramab), new dy(paramab));
  }

  public eg(ab paramab, a parama, ea<ec> paramea1, ea<ec> paramea2)
  {
    this.a = paramab;
    this.b = parama;
    this.c = paramea1;
    this.d = paramea2;
  }

  private static eh a(eb parameb, long paramLong)
  {
    return new eh().a(parameb.c()).b(parameb.f()).c(parameb.c(paramLong)).a(parameb.a());
  }

  private boolean a(eb parameb, i parami)
  {
    if (parameb == null)
      return false;
    if (parameb.a(parami.v()))
      return true;
    b(parameb, parami);
    return false;
  }

  private void b(eb parameb, i parami)
  {
    if (parameb.g())
    {
      this.b.a(i.a(parami, s.a.f), a(parameb));
      parameb.a(false);
    }
    parameb.e();
  }

  private void f(i parami)
  {
    if (this.f == null)
    {
      eb localeb1 = this.c.a();
      if (a(localeb1, parami))
      {
        this.e = localeb1;
        this.f = b.c;
      }
    }
    else
    {
      return;
    }
    eb localeb2 = this.d.a();
    if (a(localeb2, parami))
    {
      this.e = localeb2;
      this.f = b.b;
      return;
    }
    this.e = null;
    this.f = b.a;
  }

  public eb a()
  {
    return this.e;
  }

  eh a(eb parameb)
  {
    return new eh().a(parameb.c()).a(parameb.a()).b(parameb.f()).c(parameb.d());
  }

  public void a(i parami)
  {
    f(parami);
    switch (1.a[this.f.ordinal()])
    {
    default:
      return;
    case 1:
      if (a(this.e, parami))
      {
        this.e.b(parami.v());
        return;
      }
      this.e = e(parami);
      return;
    case 2:
      b(this.e, parami);
      this.e = e(parami);
      return;
    case 3:
    }
    this.e = e(parami);
  }

  public void a(i parami, boolean paramBoolean)
  {
    c(parami).a(paramBoolean);
  }

  public eh b()
  {
    long l = System.currentTimeMillis() / 1000L;
    this.a.m().a(l, ek.b, l);
    return new eh().a(l).a(ek.b).b(0L).c(0L);
  }

  public void b(i parami)
  {
    f(parami);
    if (this.f != b.a)
      b(this.e, parami);
    this.f = b.a;
  }

  public eb c(i parami)
  {
    f(parami);
    if ((this.f != b.a) && (!a(this.e, parami)))
    {
      this.f = b.a;
      this.e = null;
    }
    long l;
    eb localeb;
    switch (1.a[this.f.ordinal()])
    {
    default:
      this.f = b.b;
      l = parami.v();
      localeb = this.d.a(new ec(l, parami.w()));
      if (this.a.B().d())
        this.b.a(i.a(parami, s.a.C), a(localeb, parami.v()));
      break;
    case 1:
    case 2:
    }
    while (true)
    {
      this.e = localeb;
      return this.e;
      return this.e;
      this.e.b(parami.v());
      return this.e;
      if (parami.e() == s.a.B.a())
      {
        this.b.a(parami, a(localeb, l));
        this.b.a(i.a(parami, s.a.C), a(localeb, l));
      }
    }
  }

  public eh d(i parami)
  {
    return a(c(parami), parami.v());
  }

  eb e(i parami)
  {
    long l = parami.v();
    eb localeb = this.c.a(new ec(l, parami.w()));
    this.f = b.c;
    this.a.a(true);
    this.b.a(i.a(parami, s.a.C), a(localeb, l));
    return localeb;
  }

  public static abstract interface a
  {
    public abstract void a(i parami, eh parameh);
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.eg
 * JD-Core Version:    0.6.2
 */