package android.support.constraint.a.a;

import android.support.constraint.a.h;
import android.support.constraint.a.h.a;

public class c
{
  final d a;
  final c b;
  c c;
  public int d = 0;
  int e = -1;
  h f;
  private j g = new j(this);
  private b h = b.a;
  private a i = a.a;
  private int j = 0;

  public c(d paramd, c paramc)
  {
    this.a = paramd;
    this.b = paramc;
  }

  public j a()
  {
    return this.g;
  }

  public void a(int paramInt)
  {
    if (j())
      this.d = paramInt;
  }

  public void a(android.support.constraint.a.c paramc)
  {
    if (this.f == null)
    {
      this.f = new h(h.a.a, null);
      return;
    }
    this.f.b();
  }

  public boolean a(c paramc)
  {
    boolean bool1 = true;
    if (paramc == null);
    c localc;
    do
    {
      return false;
      localc = paramc.d();
      if (localc != this.b)
        break;
    }
    while ((this.b == c.f) && ((!paramc.c().B()) || (!c().B())));
    return bool1;
    boolean bool2;
    switch (1.a[this.b.ordinal()])
    {
    case 6:
    case 7:
    case 8:
    case 9:
    default:
      throw new AssertionError(this.b.name());
    case 1:
      if ((localc != c.f) && (localc != c.h) && (localc != c.i));
      while (true)
      {
        return bool1;
        bool1 = false;
      }
    case 2:
    case 3:
      if ((localc == c.b) || (localc == c.d))
        bool2 = bool1;
      break;
    case 4:
    case 5:
    }
    while (true)
      if ((paramc.c() instanceof f))
      {
        if ((!bool2) && (localc != c.h))
          break;
        return bool1;
        bool2 = false;
        continue;
        if ((localc == c.c) || (localc == c.e));
        for (bool2 = bool1; ; bool2 = false)
        {
          if (!(paramc.c() instanceof f))
            break label253;
          if ((!bool2) && (localc != c.i))
            break;
          return bool1;
        }
      }
    label253: return bool2;
  }

  public boolean a(c paramc, int paramInt1, int paramInt2)
  {
    return a(paramc, paramInt1, -1, b.b, paramInt2, false);
  }

  public boolean a(c paramc, int paramInt1, int paramInt2, b paramb, int paramInt3, boolean paramBoolean)
  {
    if (paramc == null)
    {
      this.c = null;
      this.d = 0;
      this.e = -1;
      this.h = b.a;
      this.j = 2;
      return true;
    }
    if ((!paramBoolean) && (!a(paramc)))
      return false;
    this.c = paramc;
    if (paramInt1 > 0);
    for (this.d = paramInt1; ; this.d = 0)
    {
      this.e = paramInt2;
      this.h = paramb;
      this.j = paramInt3;
      return true;
    }
  }

  public boolean a(c paramc, int paramInt1, b paramb, int paramInt2)
  {
    return a(paramc, paramInt1, -1, paramb, paramInt2, false);
  }

  public h b()
  {
    return this.f;
  }

  public d c()
  {
    return this.a;
  }

  public c d()
  {
    return this.b;
  }

  public int e()
  {
    if (this.a.k() == 8)
      return 0;
    if ((this.e > -1) && (this.c != null) && (this.c.a.k() == 8))
      return this.e;
    return this.d;
  }

  public b f()
  {
    return this.h;
  }

  public c g()
  {
    return this.c;
  }

  public int h()
  {
    return this.j;
  }

  public void i()
  {
    this.c = null;
    this.d = 0;
    this.e = -1;
    this.h = b.b;
    this.j = 0;
    this.i = a.a;
    this.g.b();
  }

  public boolean j()
  {
    return this.c != null;
  }

  public final c k()
  {
    switch (1.a[this.b.ordinal()])
    {
    default:
      throw new AssertionError(this.b.name());
    case 2:
      return this.a.s;
    case 3:
      return this.a.q;
    case 4:
      return this.a.t;
    case 5:
      return this.a.r;
    case 1:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    return null;
  }

  public String toString()
  {
    return this.a.l() + ":" + this.b.toString();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
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

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[9];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
      arrayOfc[4] = e;
      arrayOfc[5] = f;
      arrayOfc[6] = g;
      arrayOfc[7] = h;
      arrayOfc[8] = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.c
 * JD-Core Version:    0.6.2
 */