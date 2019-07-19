package com.google.e.g.a;

import com.google.e.c.b;
import com.google.e.j;
import com.google.e.p;

final class c
{
  private b a;
  private p b;
  private p c;
  private p d;
  private p e;
  private int f;
  private int g;
  private int h;
  private int i;

  c(b paramb, p paramp1, p paramp2, p paramp3, p paramp4)
    throws j
  {
    if (((paramp1 == null) && (paramp3 == null)) || ((paramp2 == null) && (paramp4 == null)) || ((paramp1 != null) && (paramp2 == null)) || ((paramp3 != null) && (paramp4 == null)))
      throw j.a();
    a(paramb, paramp1, paramp2, paramp3, paramp4);
  }

  c(c paramc)
  {
    a(paramc.a, paramc.b, paramc.c, paramc.d, paramc.e);
  }

  static c a(c paramc1, c paramc2)
    throws j
  {
    if (paramc1 == null)
      return paramc2;
    if (paramc2 == null)
      return paramc1;
    return new c(paramc1.a, paramc1.b, paramc1.c, paramc2.d, paramc2.e);
  }

  private void a(b paramb, p paramp1, p paramp2, p paramp3, p paramp4)
  {
    this.a = paramb;
    this.b = paramp1;
    this.c = paramp2;
    this.d = paramp3;
    this.e = paramp4;
    i();
  }

  private void i()
  {
    if (this.b == null)
    {
      this.b = new p(0.0F, this.d.b());
      this.c = new p(0.0F, this.e.b());
    }
    while (true)
    {
      this.f = ((int)Math.min(this.b.a(), this.c.a()));
      this.g = ((int)Math.max(this.d.a(), this.e.a()));
      this.h = ((int)Math.min(this.b.b(), this.d.b()));
      this.i = ((int)Math.max(this.c.b(), this.e.b()));
      return;
      if (this.d == null)
      {
        this.d = new p(-1 + this.a.e(), this.b.b());
        this.e = new p(-1 + this.a.e(), this.c.b());
      }
    }
  }

  int a()
  {
    return this.f;
  }

  c a(int paramInt1, int paramInt2, boolean paramBoolean)
    throws j
  {
    p localp1 = this.b;
    p localp2 = this.c;
    Object localObject1 = this.d;
    Object localObject2 = this.e;
    p localp6;
    p localp3;
    if (paramInt1 > 0)
      if (paramBoolean)
      {
        localp6 = this.b;
        int k = (int)localp6.b() - paramInt1;
        if (k < 0)
          k = 0;
        localp3 = new p(localp6.a(), k);
        if (!paramBoolean)
          break label178;
      }
    while (true)
    {
      label77: p localp5;
      label91: p localp4;
      if (paramInt2 > 0)
        if (paramBoolean)
        {
          localp5 = this.c;
          int j = paramInt2 + (int)localp5.b();
          if (j >= this.a.f())
            j = -1 + this.a.f();
          localp4 = new p(localp5.a(), j);
          if (!paramBoolean)
            break label198;
        }
      while (true)
      {
        i();
        return new c(this.a, localp3, localp4, (p)localObject1, (p)localObject2);
        localp6 = this.d;
        break;
        label178: localObject1 = localp3;
        localp3 = localp1;
        break label77;
        localp5 = this.e;
        break label91;
        label198: localObject2 = localp4;
        localp4 = localp2;
        continue;
        localp4 = localp2;
      }
      localp3 = localp1;
    }
  }

  int b()
  {
    return this.g;
  }

  int c()
  {
    return this.h;
  }

  int d()
  {
    return this.i;
  }

  p e()
  {
    return this.b;
  }

  p f()
  {
    return this.d;
  }

  p g()
  {
    return this.c;
  }

  p h()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.c
 * JD-Core Version:    0.6.2
 */