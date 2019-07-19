package android.support.constraint.a;

import android.support.constraint.a.a.c.c;
import java.util.Arrays;
import java.util.HashMap;

public class e
{
  public static f g;
  private static int h = 1000;
  int a = 0;
  b[] b = null;
  public boolean c = false;
  int d = 1;
  int e = 0;
  final c f;
  private HashMap<String, h> i = null;
  private a j;
  private int k = 32;
  private int l = this.k;
  private boolean[] m = new boolean[this.k];
  private int n = this.k;
  private h[] o = new h[h];
  private int p = 0;
  private b[] q = new b[this.k];
  private final a r;

  public e()
  {
    i();
    this.f = new c();
    this.j = new d(this.f);
    this.r = new b(this.f);
  }

  private final int a(a parama, boolean paramBoolean)
  {
    if (g != null)
    {
      f localf3 = g;
      localf3.h = (1L + localf3.h);
    }
    int i1 = 0;
    int i6;
    h localh;
    int i3;
    int i5;
    label124: int i4;
    int i2;
    while (true)
      if (i1 < this.d)
      {
        this.m[i1] = false;
        i1++;
        continue;
        if (i6 > -1)
        {
          b localb2 = this.b[i6];
          localb2.a.b = -1;
          if (g != null)
          {
            f localf1 = g;
            localf1.j = (1L + localf1.j);
          }
          localb2.c(localh);
          localb2.a.b = i6;
          localb2.a.c(localb2);
          i5 = i3;
          i3 = i5;
          i2 = i4;
        }
      }
    while (true)
    {
      if (i3 == 0)
      {
        if (g != null)
        {
          f localf2 = g;
          localf2.i = (1L + localf2.i);
        }
        i4 = i2 + 1;
        if (i4 >= 2 * this.d)
          i2 = i4;
      }
      else
      {
        return i2;
      }
      if (parama.g() != null)
        this.m[parama.g().a] = true;
      localh = parama.a(this, this.m);
      if (localh != null)
      {
        if (this.m[localh.a] != 0)
          return i4;
        this.m[localh.a] = true;
      }
      if (localh != null)
      {
        float f1 = 3.4028235E+38F;
        i6 = -1;
        int i7 = 0;
        label268: b localb1;
        if (i7 < this.e)
        {
          localb1 = this.b[i7];
          if (localb1.a.f != h.a.a)
            break label306;
        }
        while (true)
        {
          i7++;
          break label268;
          break;
          label306: if ((!localb1.e) && (localb1.a(localh)))
          {
            float f2 = localb1.d.b(localh);
            if (f2 < 0.0F)
            {
              float f3 = -localb1.b / f2;
              if (f3 < f1)
              {
                i6 = i7;
                f1 = f3;
              }
            }
          }
        }
        i5 = 1;
        break label124;
      }
      i5 = 1;
      break label124;
      i2 = 0;
      i3 = 0;
    }
  }

  public static b a(e parame, h paramh1, h paramh2, h paramh3, float paramFloat, boolean paramBoolean)
  {
    b localb = parame.c();
    if (paramBoolean)
      parame.b(localb);
    return localb.a(paramh1, paramh2, paramh3, paramFloat);
  }

  public static f a()
  {
    return g;
  }

  private h a(h.a parama, String paramString)
  {
    h localh1 = (h)this.f.b.a();
    h localh2;
    if (localh1 == null)
    {
      localh2 = new h(parama, paramString);
      localh2.a(parama, paramString);
    }
    for (h localh3 = localh2; ; localh3 = localh1)
    {
      if (this.p >= h)
      {
        h = 2 * h;
        this.o = ((h[])Arrays.copyOf(this.o, h));
      }
      h[] arrayOfh = this.o;
      int i1 = this.p;
      this.p = (i1 + 1);
      arrayOfh[i1] = localh3;
      return localh3;
      localh1.b();
      localh1.a(parama, paramString);
    }
  }

  private int b(a parama)
    throws Exception
  {
    int i1 = 0;
    if (i1 < this.e)
    {
      if (this.b[i1].a.f == h.a.a);
      while (this.b[i1].b >= 0.0F)
      {
        i1++;
        break;
      }
    }
    for (int i2 = 1; ; i2 = 0)
    {
      int i4;
      int i3;
      int i5;
      float f1;
      int i6;
      int i7;
      int i8;
      int i9;
      label110: b localb2;
      if (i2 != 0)
      {
        i4 = 0;
        i3 = 0;
        if (i4 != 0)
          break label408;
        if (g != null)
        {
          f localf2 = g;
          localf2.k = (1L + localf2.k);
        }
        i5 = i3 + 1;
        f1 = 3.4028235E+38F;
        i6 = 0;
        i7 = -1;
        i8 = -1;
        i9 = 0;
        if (i9 < this.e)
        {
          localb2 = this.b[i9];
          if (localb2.a.f != h.a.a);
        }
      }
      while (true)
      {
        i9++;
        break label110;
        if ((!localb2.e) && (localb2.b < 0.0F))
        {
          float f2 = f1;
          int i11 = i6;
          int i12 = i7;
          int i13 = i8;
          int i14 = 1;
          label185: if (i14 < this.d)
          {
            h localh = this.f.c[i14];
            float f3 = localb2.d.b(localh);
            if (f3 <= 0.0F);
            while (true)
            {
              i14++;
              break label185;
              float f4 = f2;
              int i15 = 0;
              label238: if (i15 < 7)
              {
                float f5 = localh.e[i15] / f3;
                if (((f5 < f4) && (i15 == i11)) || (i15 > i11))
                {
                  i13 = i14;
                  i12 = i9;
                  i11 = i15;
                }
                while (true)
                {
                  i15++;
                  f4 = f5;
                  break label238;
                  if (i7 != -1)
                  {
                    b localb1 = this.b[i7];
                    localb1.a.b = -1;
                    if (g != null)
                    {
                      f localf1 = g;
                      localf1.j = (1L + localf1.j);
                    }
                    localb1.c(this.f.c[i8]);
                    localb1.a.b = i7;
                    localb1.a.c(localb1);
                  }
                  for (int i10 = i4; ; i10 = 1)
                  {
                    i4 = i10;
                    i3 = i5;
                    break;
                  }
                  i3 = 0;
                  return i3;
                  f5 = f4;
                }
              }
              f2 = f4;
            }
          }
          label408: i8 = i13;
          i7 = i12;
          i6 = i11;
          f1 = f2;
        }
      }
    }
  }

  private void b(b paramb)
  {
    paramb.a(this, 0);
  }

  private final void c(b paramb)
  {
    if (this.e > 0)
    {
      paramb.d.a(paramb, this.b);
      if (paramb.d.a == 0)
        paramb.e = true;
    }
  }

  private final void d(b paramb)
  {
    if (this.b[this.e] != null)
      this.f.a.a(this.b[this.e]);
    this.b[this.e] = paramb;
    paramb.a.b = this.e;
    this.e = (1 + this.e);
    paramb.a.c(paramb);
  }

  private void h()
  {
    this.k = (2 * this.k);
    this.b = ((b[])Arrays.copyOf(this.b, this.k));
    this.f.c = ((h[])Arrays.copyOf(this.f.c, this.k));
    this.m = new boolean[this.k];
    this.l = this.k;
    this.n = this.k;
    if (g != null)
    {
      f localf = g;
      localf.d = (1L + localf.d);
      g.p = Math.max(g.p, this.k);
      g.D = g.p;
    }
  }

  private void i()
  {
    for (int i1 = 0; i1 < this.b.length; i1++)
    {
      b localb = this.b[i1];
      if (localb != null)
        this.f.a.a(localb);
      this.b[i1] = null;
    }
  }

  private void j()
  {
    for (int i1 = 0; i1 < this.e; i1++)
    {
      b localb = this.b[i1];
      localb.a.d = localb.b;
    }
  }

  public h a(int paramInt, String paramString)
  {
    if (g != null)
    {
      f localf = g;
      localf.m = (1L + localf.m);
    }
    if (1 + this.d >= this.l)
      h();
    h localh = a(h.a.d, paramString);
    this.a = (1 + this.a);
    this.d = (1 + this.d);
    localh.a = this.a;
    localh.c = paramInt;
    this.f.c[this.a] = localh;
    this.j.d(localh);
    return localh;
  }

  public h a(Object paramObject)
  {
    h localh = null;
    if (paramObject == null);
    do
    {
      boolean bool;
      do
      {
        return localh;
        if (1 + this.d >= this.l)
          h();
        bool = paramObject instanceof android.support.constraint.a.a.c;
        localh = null;
      }
      while (!bool);
      localh = ((android.support.constraint.a.a.c)paramObject).b();
      if (localh == null)
      {
        ((android.support.constraint.a.a.c)paramObject).a(this.f);
        localh = ((android.support.constraint.a.a.c)paramObject).b();
      }
    }
    while ((localh.a != -1) && (localh.a <= this.a) && (this.f.c[localh.a] != null));
    if (localh.a != -1)
      localh.b();
    this.a = (1 + this.a);
    this.d = (1 + this.d);
    localh.a = this.a;
    localh.f = h.a.a;
    this.f.c[this.a] = localh;
    return localh;
  }

  public void a(android.support.constraint.a.a.d paramd1, android.support.constraint.a.a.d paramd2, float paramFloat, int paramInt)
  {
    h localh1 = a(paramd1.a(c.c.b));
    h localh2 = a(paramd1.a(c.c.c));
    h localh3 = a(paramd1.a(c.c.d));
    h localh4 = a(paramd1.a(c.c.e));
    h localh5 = a(paramd2.a(c.c.b));
    h localh6 = a(paramd2.a(c.c.c));
    h localh7 = a(paramd2.a(c.c.d));
    h localh8 = a(paramd2.a(c.c.e));
    b localb1 = c();
    localb1.b(localh2, localh4, localh6, localh8, (float)(Math.sin(paramFloat) * paramInt));
    a(localb1);
    b localb2 = c();
    localb2.b(localh1, localh3, localh5, localh7, (float)(Math.cos(paramFloat) * paramInt));
    a(localb2);
  }

  public void a(b paramb)
  {
    boolean bool = true;
    if (paramb == null);
    label257: 
    while (true)
    {
      return;
      if (g != null)
      {
        f localf2 = g;
        localf2.f = (1L + localf2.f);
        if (paramb.e)
        {
          f localf3 = g;
          localf3.g = (1L + localf3.g);
        }
      }
      if ((1 + this.e >= this.n) || (1 + this.d >= this.l))
        h();
      if (!paramb.e)
      {
        c(paramb);
        if (!paramb.e())
        {
          paramb.d();
          if (paramb.a(this))
          {
            h localh1 = e();
            paramb.a = localh1;
            d(paramb);
            this.r.a(paramb);
            a(this.r, bool);
            if (localh1.b == -1)
            {
              if (paramb.a == localh1)
              {
                h localh2 = paramb.b(localh1);
                if (localh2 != null)
                {
                  if (g != null)
                  {
                    f localf1 = g;
                    localf1.j = (1L + localf1.j);
                  }
                  paramb.c(localh2);
                }
              }
              if (!paramb.e)
                paramb.a.c(paramb);
              this.e = (-1 + this.e);
            }
            label232: if (!paramb.a())
              break label252;
          }
        }
      }
      else
      {
        while (true)
        {
          if (bool)
            break label257;
          d(paramb);
          return;
          bool = false;
          break label232;
          label252: break;
          bool = false;
        }
      }
    }
  }

  void a(b paramb, int paramInt1, int paramInt2)
  {
    paramb.c(a(paramInt2, null), paramInt1);
  }

  void a(a parama)
    throws Exception
  {
    if (g != null)
    {
      f localf = g;
      localf.t = (1L + localf.t);
      g.u = Math.max(g.u, this.d);
      g.v = Math.max(g.v, this.e);
    }
    c((b)parama);
    b(parama);
    a(parama, false);
    j();
  }

  public void a(h paramh, int paramInt)
  {
    int i1 = paramh.b;
    if (paramh.b != -1)
    {
      b localb2 = this.b[i1];
      if (localb2.e)
      {
        localb2.b = paramInt;
        return;
      }
      if (localb2.d.a == 0)
      {
        localb2.e = true;
        localb2.b = paramInt;
        return;
      }
      b localb3 = c();
      localb3.b(paramh, paramInt);
      a(localb3);
      return;
    }
    b localb1 = c();
    localb1.a(paramh, paramInt);
    a(localb1);
  }

  public void a(h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2, int paramInt3)
  {
    b localb = c();
    localb.a(paramh1, paramh2, paramInt1, paramFloat, paramh3, paramh4, paramInt2);
    if (paramInt3 != 6)
      localb.a(this, paramInt3);
    a(localb);
  }

  public void a(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    b localb = c();
    h localh = d();
    localh.c = 0;
    localb.a(paramh1, paramh2, localh, paramInt1);
    if (paramInt2 != 6)
      a(localb, (int)(-1.0F * localb.d.b(localh)), paramInt2);
    a(localb);
  }

  public void a(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat, int paramInt)
  {
    b localb = c();
    localb.a(paramh1, paramh2, paramh3, paramh4, paramFloat);
    if (paramInt != 6)
      localb.a(this, paramInt);
    a(localb);
  }

  public void a(h paramh1, h paramh2, boolean paramBoolean)
  {
    b localb = c();
    h localh = d();
    localh.c = 0;
    localb.a(paramh1, paramh2, localh, 0);
    if (paramBoolean)
      a(localb, (int)(-1.0F * localb.d.b(localh)), 1);
    a(localb);
  }

  public int b(Object paramObject)
  {
    h localh = ((android.support.constraint.a.a.c)paramObject).b();
    if (localh != null)
      return (int)(0.5F + localh.d);
    return 0;
  }

  public void b()
  {
    for (int i1 = 0; i1 < this.f.c.length; i1++)
    {
      h localh = this.f.c[i1];
      if (localh != null)
        localh.b();
    }
    this.f.b.a(this.o, this.p);
    this.p = 0;
    Arrays.fill(this.f.c, null);
    if (this.i != null)
      this.i.clear();
    this.a = 0;
    this.j.f();
    this.d = 1;
    for (int i2 = 0; i2 < this.e; i2++)
      this.b[i2].c = false;
    i();
    this.e = 0;
  }

  public void b(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    b localb = c();
    h localh = d();
    localh.c = 0;
    localb.b(paramh1, paramh2, localh, paramInt1);
    if (paramInt2 != 6)
      a(localb, (int)(-1.0F * localb.d.b(localh)), paramInt2);
    a(localb);
  }

  public void b(h paramh1, h paramh2, boolean paramBoolean)
  {
    b localb = c();
    h localh = d();
    localh.c = 0;
    localb.b(paramh1, paramh2, localh, 0);
    if (paramBoolean)
      a(localb, (int)(-1.0F * localb.d.b(localh)), 1);
    a(localb);
  }

  public b c()
  {
    b localb = (b)this.f.a.a();
    if (localb == null)
      localb = new b(this.f);
    while (true)
    {
      h.a();
      return localb;
      localb.c();
    }
  }

  public b c(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    b localb = c();
    localb.a(paramh1, paramh2, paramInt1);
    if (paramInt2 != 6)
      localb.a(this, paramInt2);
    a(localb);
    return localb;
  }

  public h d()
  {
    if (g != null)
    {
      f localf = g;
      localf.n = (1L + localf.n);
    }
    if (1 + this.d >= this.l)
      h();
    h localh = a(h.a.c, null);
    this.a = (1 + this.a);
    this.d = (1 + this.d);
    localh.a = this.a;
    this.f.c[this.a] = localh;
    return localh;
  }

  public h e()
  {
    if (g != null)
    {
      f localf = g;
      localf.o = (1L + localf.o);
    }
    if (1 + this.d >= this.l)
      h();
    h localh = a(h.a.c, null);
    this.a = (1 + this.a);
    this.d = (1 + this.d);
    localh.a = this.a;
    this.f.c[this.a] = localh;
    return localh;
  }

  public void f()
    throws Exception
  {
    if (g != null)
    {
      f localf3 = g;
      localf3.e = (1L + localf3.e);
    }
    int i1;
    int i2;
    if (this.c)
    {
      if (g != null)
      {
        f localf2 = g;
        localf2.r = (1L + localf2.r);
      }
      i1 = 0;
      if (i1 >= this.e)
        break label134;
      boolean bool = this.b[i1].e;
      i2 = 0;
      if (bool);
    }
    while (true)
    {
      if (i2 == 0)
      {
        a(this.j);
        return;
        i1++;
        break;
      }
      if (g != null)
      {
        f localf1 = g;
        localf1.q = (1L + localf1.q);
      }
      j();
      return;
      a(this.j);
      return;
      label134: i2 = 1;
    }
  }

  public c g()
  {
    return this.f;
  }

  static abstract interface a
  {
    public abstract h a(e parame, boolean[] paramArrayOfBoolean);

    public abstract void a(a parama);

    public abstract void d(h paramh);

    public abstract void f();

    public abstract h g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.e
 * JD-Core Version:    0.6.2
 */