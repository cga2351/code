package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.trackselection.h;

final class v
{
  private final ak.a a = new ak.a();
  private final ak.b b = new ak.b();
  private long c;
  private ak d = ak.a;
  private int e;
  private boolean f;
  private t g;
  private t h;
  private t i;
  private int j;
  private Object k;
  private long l;

  private long a(Object paramObject)
  {
    int m = this.d.a(paramObject, this.a).c;
    if (this.k != null)
    {
      int i1 = this.d.a(this.k);
      if ((i1 != -1) && (this.d.a(i1, this.a).c == m))
        return this.l;
    }
    for (t localt1 = e(); localt1 != null; localt1 = localt1.h)
      if (localt1.b.equals(paramObject))
        return localt1.g.a.d;
    for (t localt2 = e(); localt2 != null; localt2 = localt2.h)
    {
      int n = this.d.a(localt2.b);
      if ((n != -1) && (this.d.a(n, this.a).c == m))
        return localt2.g.a.d;
    }
    long l1 = this.c;
    this.c = (1L + l1);
    return l1;
  }

  private n.a a(Object paramObject, long paramLong1, long paramLong2)
  {
    this.d.a(paramObject, this.a);
    int m = this.a.a(paramLong1);
    if (m == -1)
    {
      int n = this.a.b(paramLong1);
      if (n == -1);
      for (long l1 = -9223372036854775808L; ; l1 = this.a.a(n))
        return new n.a(paramObject, paramLong2, l1);
    }
    return new n.a(paramObject, m, this.a.b(m), paramLong2);
  }

  private u a(n.a parama, long paramLong1, long paramLong2)
  {
    this.d.a(parama.a, this.a);
    if (parama.a())
    {
      if (!this.a.b(parama.b, parama.c))
        return null;
      return a(parama.a, parama.b, parama.c, paramLong1, parama.d);
    }
    return b(parama.a, paramLong2, parama.d);
  }

  private u a(t paramt, long paramLong)
  {
    u localu = paramt.g;
    long l1 = paramt.a() + localu.d - paramLong;
    if (localu.e)
    {
      int i7 = this.d.a(localu.a.a);
      int i8 = this.d.a(i7, this.a, this.b, this.e, this.f);
      if (i8 == -1)
        return null;
      int i9 = this.d.a(i8, this.a, true).c;
      Object localObject1 = this.a.b;
      long l4 = localu.a.d;
      long l7;
      long l5;
      if (this.d.a(i9, this.b).f == i8)
      {
        Pair localPair2 = this.d.a(this.b, this.a, i9, -9223372036854775807L, Math.max(0L, l1));
        if (localPair2 == null)
          return null;
        Object localObject2 = localPair2.first;
        long l6 = ((Long)localPair2.second).longValue();
        if ((paramt.h != null) && (paramt.h.b.equals(localObject2)))
        {
          l7 = paramt.h.g.a.d;
          long l8 = l7;
          localObject1 = localObject2;
          l5 = l6;
          l4 = l8;
        }
      }
      while (true)
      {
        return a(a(localObject1, l5, l4), l5, l5);
        l7 = this.c;
        this.c = (1L + l7);
        break;
        l5 = 0L;
      }
    }
    n.a locala = localu.a;
    this.d.a(locala.a, this.a);
    if (locala.a())
    {
      int i4 = locala.b;
      int i5 = this.a.d(i4);
      if (i5 == -1)
        return null;
      int i6 = this.a.a(i4, locala.c);
      if (i6 < i5)
      {
        if (!this.a.b(i4, i6))
          return null;
        return a(locala.a, i4, i6, localu.c, locala.d);
      }
      long l3 = localu.c;
      if ((this.a.d() == 1) && (this.a.a(0) == 0L))
      {
        Pair localPair1 = this.d.a(this.b, this.a, this.a.c, -9223372036854775807L, Math.max(0L, l1));
        if (localPair1 == null)
          return null;
        l3 = ((Long)localPair1.second).longValue();
      }
      return b(locala.a, l3, locala.d);
    }
    if (localu.a.e != -9223372036854775808L)
    {
      int i2 = this.a.a(localu.a.e);
      if (i2 == -1)
        return b(locala.a, localu.a.e, locala.d);
      int i3 = this.a.b(i2);
      if (!this.a.b(i2, i3))
        return null;
      return a(locala.a, i2, i3, localu.a.e, locala.d);
    }
    int m = this.a.d();
    if (m == 0)
      return null;
    int n = m - 1;
    if ((this.a.a(n) != -9223372036854775808L) || (this.a.c(n)))
      return null;
    int i1 = this.a.b(n);
    if (!this.a.b(n, i1))
      return null;
    long l2 = this.a.a();
    return a(locala.a, n, i1, l2, locala.d);
  }

  private u a(x paramx)
  {
    return a(paramx.c, paramx.e, paramx.d);
  }

  private u a(Object paramObject, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    n.a locala = new n.a(paramObject, paramInt1, paramInt2, paramLong2);
    boolean bool1 = a(locala);
    boolean bool2 = a(locala, bool1);
    long l1 = this.d.a(locala.a, this.a).c(locala.b, locala.c);
    if (paramInt2 == this.a.b(paramInt1));
    for (long l2 = this.a.e(); ; l2 = 0L)
      return new u(locala, l2, paramLong1, l1, bool1, bool2);
  }

  private boolean a(n.a parama)
  {
    int m = this.d.a(parama.a, this.a).d();
    if (m == 0);
    int n;
    boolean bool1;
    do
    {
      return true;
      n = m - 1;
      bool1 = parama.a();
      if (this.a.a(n) == -9223372036854775808L)
        break;
    }
    while ((!bool1) && (parama.e == -9223372036854775808L));
    return false;
    int i1 = this.a.d(n);
    if (i1 == -1)
      return false;
    if ((bool1) && (parama.b == n) && (parama.c == i1 - 1));
    for (int i2 = 1; ; i2 = 0)
    {
      boolean bool2;
      if (i2 == 0)
      {
        bool2 = false;
        if (!bool1)
        {
          int i3 = this.a.b(n);
          bool2 = false;
          if (i3 != i1);
        }
      }
      else
      {
        bool2 = true;
      }
      return bool2;
    }
  }

  private boolean a(n.a parama, boolean paramBoolean)
  {
    int m = this.d.a(parama.a);
    int n = this.d.a(m, this.a).c;
    return (!this.d.a(n, this.b).e) && (this.d.b(m, this.a, this.b, this.e, this.f)) && (paramBoolean);
  }

  private boolean a(t paramt, u paramu)
  {
    u localu = paramt.g;
    return (localu.b == paramu.b) && (localu.a.equals(paramu.a));
  }

  private u b(Object paramObject, long paramLong1, long paramLong2)
  {
    int m = this.a.b(paramLong1);
    long l1;
    n.a locala;
    boolean bool1;
    boolean bool2;
    if (m == -1)
    {
      l1 = -9223372036854775808L;
      locala = new n.a(paramObject, paramLong2, l1);
      this.d.a(locala.a, this.a);
      bool1 = a(locala);
      bool2 = a(locala, bool1);
      if (l1 != -9223372036854775808L)
        break label122;
    }
    label122: for (long l2 = this.a.a(); ; l2 = l1)
    {
      return new u(locala, paramLong1, -9223372036854775807L, l2, bool1, bool2);
      l1 = this.a.a(m);
      break;
    }
  }

  private boolean i()
  {
    t localt1 = e();
    if (localt1 == null)
      return true;
    int m = this.d.a(localt1.b);
    t localt2 = localt1;
    m = this.d.a(m, this.a, this.b, this.e, this.f);
    while ((localt2.h != null) && (!localt2.g.e))
      localt2 = localt2.h;
    if ((m == -1) || (localt2.h == null))
    {
      label87: boolean bool1 = a(localt2);
      localt2.g = a(localt2.g);
      if ((bool1) && (f()))
        break label150;
    }
    label150: for (boolean bool2 = true; ; bool2 = false)
    {
      return bool2;
      if (this.d.a(localt2.h.b) != m)
        break label87;
      localt2 = localt2.h;
      break;
    }
  }

  public m a(af[] paramArrayOfaf, h paramh, b paramb, n paramn, u paramu)
  {
    if (this.i == null);
    for (long l1 = paramu.b; ; l1 = this.i.a() + this.i.g.d)
    {
      t localt = new t(paramArrayOfaf, l1, paramh, paramb, paramn, paramu);
      if (this.i != null)
      {
        a.b(f());
        this.i.h = localt;
      }
      this.k = null;
      this.i = localt;
      this.j = (1 + this.j);
      return localt.a;
    }
  }

  public n.a a(Object paramObject, long paramLong)
  {
    return a(paramObject, paramLong, a(paramObject));
  }

  public u a(long paramLong, x paramx)
  {
    if (this.i == null)
      return a(paramx);
    return a(this.i, paramLong);
  }

  public u a(u paramu)
  {
    boolean bool1 = a(paramu.a);
    boolean bool2 = a(paramu.a, bool1);
    this.d.a(paramu.a.a, this.a);
    long l1;
    if (paramu.a.a())
      l1 = this.a.c(paramu.a.b, paramu.a.c);
    while (true)
    {
      return new u(paramu.a, paramu.b, paramu.c, l1, bool1, bool2);
      if (paramu.a.e == -9223372036854775808L)
        l1 = this.a.a();
      else
        l1 = paramu.a.e;
    }
  }

  public void a(long paramLong)
  {
    if (this.i != null)
      this.i.c(paramLong);
  }

  public void a(ak paramak)
  {
    this.d = paramak;
  }

  public boolean a()
  {
    return (this.i == null) || ((!this.i.g.f) && (this.i.c()) && (this.i.g.d != -9223372036854775807L) && (this.j < 100));
  }

  public boolean a(int paramInt)
  {
    this.e = paramInt;
    return i();
  }

  public boolean a(m paramm)
  {
    return (this.i != null) && (this.i.a == paramm);
  }

  public boolean a(n.a parama, long paramLong)
  {
    boolean bool1 = true;
    int m = this.d.a(parama.a);
    t localt1 = e();
    Object localObject1 = null;
    Object localObject2 = localt1;
    boolean bool2;
    while (localObject2 != null)
      if (localObject1 == null)
      {
        ((t)localObject2).g = a(((t)localObject2).g);
        if (((t)localObject2).g.e)
          m = this.d.a(m, this.a, this.b, this.e, this.f);
        t localt2 = ((t)localObject2).h;
        localObject1 = localObject2;
        localObject2 = localt2;
      }
      else
      {
        if ((m != -1) && (((t)localObject2).b.equals(this.d.a(m))))
          break label161;
        if (a(localObject1))
          break label155;
        bool2 = bool1;
        bool1 = bool2;
      }
    label155: label161: label186: 
    do
    {
      u localu;
      do
      {
        return bool1;
        bool2 = false;
        break;
        localu = a(localObject1, paramLong);
        if (localu != null)
          break label186;
      }
      while (!a(localObject1));
      return false;
      ((t)localObject2).g = a(((t)localObject2).g);
      if (a((t)localObject2, localu))
        break;
    }
    while (!a(localObject1));
    return false;
  }

  public boolean a(t paramt)
  {
    boolean bool1 = false;
    if (paramt != null);
    for (boolean bool2 = true; ; bool2 = false)
    {
      a.b(bool2);
      this.i = paramt;
      while (paramt.h != null)
      {
        paramt = paramt.h;
        if (paramt == this.h)
        {
          this.h = this.g;
          bool1 = true;
        }
        paramt.f();
        this.j = (-1 + this.j);
      }
    }
    this.i.h = null;
    return bool1;
  }

  public boolean a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return i();
  }

  public t b()
  {
    return this.i;
  }

  public void b(boolean paramBoolean)
  {
    t localt = e();
    Object localObject;
    if (localt != null)
      if (paramBoolean)
      {
        localObject = localt.b;
        this.k = localObject;
        this.l = localt.g.a.d;
        localt.f();
        a(localt);
      }
    while (true)
    {
      this.g = null;
      this.i = null;
      this.h = null;
      this.j = 0;
      return;
      localObject = null;
      break;
      if (!paramBoolean)
        this.k = null;
    }
  }

  public t c()
  {
    return this.g;
  }

  public t d()
  {
    return this.h;
  }

  public t e()
  {
    if (f())
      return this.g;
    return this.i;
  }

  public boolean f()
  {
    return this.g != null;
  }

  public t g()
  {
    if ((this.h != null) && (this.h.h != null));
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h = this.h.h;
      return this.h;
    }
  }

  public t h()
  {
    if (this.g != null)
    {
      if (this.g == this.h)
        this.h = this.g.h;
      this.g.f();
      this.j = (-1 + this.j);
      if (this.j == 0)
      {
        this.i = null;
        this.k = this.g.b;
        this.l = this.g.g.a.d;
      }
      this.g = this.g.h;
    }
    while (true)
    {
      return this.g;
      this.g = this.i;
      this.h = this.i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.6.2
 */