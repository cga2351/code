package com.viber.voip.ads.b.b.b;

import com.viber.voip.i.c.b;
import com.viber.voip.i.f;

public enum c
{
  private final String k;

  static
  {
    c[] arrayOfc = new c[10];
    arrayOfc[0] = a;
    arrayOfc[1] = b;
    arrayOfc[2] = c;
    arrayOfc[3] = d;
    arrayOfc[4] = e;
    arrayOfc[5] = f;
    arrayOfc[6] = g;
    arrayOfc[7] = h;
    arrayOfc[8] = i;
    arrayOfc[9] = j;
  }

  private c(String paramString)
  {
    this.k = paramString;
  }

  public String a()
  {
    return this.k;
  }

  public String toString()
  {
    return this.k;
  }

  public static class a
  {
    private final f a;
    private final f b;
    private final f c;
    private final f d;
    private final f e;

    public a(f paramf1, f paramf2, f paramf3, f paramf4, f paramf5)
    {
      this.a = paramf1;
      this.b = paramf2;
      this.c = paramf3;
      this.d = paramf4;
      this.e = paramf5;
    }

    public static a a()
    {
      return new a(c.b.h, c.b.i, c.b.j, c.b.k, c.b.l);
    }

    private int b()
    {
      if (this.a.e())
        return 3;
      if (this.b.e())
        return 2;
      if (this.c.e())
        return 1;
      return 0;
    }

    private int c()
    {
      return 1;
    }

    private int d()
    {
      if (this.b.e())
        return 2;
      if (this.c.e())
        return 1;
      return 0;
    }

    private int e()
    {
      return 1;
    }

    private int f()
    {
      return 3;
    }

    private int g()
    {
      if (this.e.e())
        return 2;
      return 5;
    }

    private int h()
    {
      if (this.e.e())
        return 2;
      return 5;
    }

    private int i()
    {
      if (this.e.e())
        return 2;
      return 5;
    }

    public int a(c paramc)
    {
      if (paramc == null)
        return 0;
      switch (c.2.a[paramc.ordinal()])
      {
      default:
        return 0;
      case 1:
      case 2:
      case 3:
        return b();
      case 4:
        return c();
      case 5:
        return d();
      case 6:
        return e();
      case 7:
        return f();
      case 8:
        return g();
      case 9:
        return h();
      case 10:
      }
      return i();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.b.b.c
 * JD-Core Version:    0.6.2
 */