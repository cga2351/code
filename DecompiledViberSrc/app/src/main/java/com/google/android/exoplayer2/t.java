package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.g;

final class t
{
  public final m a;
  public final Object b;
  public final z[] c;
  public final boolean[] d;
  public boolean e;
  public boolean f;
  public u g;
  public t h;
  public TrackGroupArray i;
  public com.google.android.exoplayer2.trackselection.i j;
  private final af[] k;
  private final com.google.android.exoplayer2.trackselection.h l;
  private final n m;
  private long n;
  private com.google.android.exoplayer2.trackselection.i o;

  public t(af[] paramArrayOfaf, long paramLong, com.google.android.exoplayer2.trackselection.h paramh, b paramb, n paramn, u paramu)
  {
    this.k = paramArrayOfaf;
    this.n = (paramLong - paramu.b);
    this.l = paramh;
    this.m = paramn;
    this.b = a.a(paramu.a.a);
    this.g = paramu;
    this.c = new z[paramArrayOfaf.length];
    this.d = new boolean[paramArrayOfaf.length];
    m localm = paramn.a(paramu.a, paramb, paramu.b);
    if (paramu.a.e != -9223372036854775808L);
    for (Object localObject = new c(localm, true, 0L, paramu.a.e); ; localObject = localm)
    {
      this.a = ((m)localObject);
      return;
    }
  }

  private void a(com.google.android.exoplayer2.trackselection.i parami)
  {
    if (this.o != null)
      c(this.o);
    this.o = parami;
    if (this.o != null)
      b(this.o);
  }

  private void a(z[] paramArrayOfz)
  {
    for (int i1 = 0; i1 < this.k.length; i1++)
      if (this.k[i1].a() == 6)
        paramArrayOfz[i1] = null;
  }

  private void b(com.google.android.exoplayer2.trackselection.i parami)
  {
    for (int i1 = 0; i1 < parami.a; i1++)
    {
      boolean bool = parami.a(i1);
      e locale = parami.c.a(i1);
      if ((bool) && (locale != null))
        locale.d();
    }
  }

  private void b(z[] paramArrayOfz)
  {
    for (int i1 = 0; i1 < this.k.length; i1++)
      if ((this.k[i1].a() == 6) && (this.j.a(i1)))
        paramArrayOfz[i1] = new com.google.android.exoplayer2.source.h();
  }

  private void c(com.google.android.exoplayer2.trackselection.i parami)
  {
    for (int i1 = 0; i1 < parami.a; i1++)
    {
      boolean bool = parami.a(i1);
      e locale = parami.c.a(i1);
      if ((bool) && (locale != null))
        locale.e();
    }
  }

  public long a()
  {
    return this.n;
  }

  public long a(long paramLong)
  {
    return paramLong + a();
  }

  public long a(long paramLong, boolean paramBoolean)
  {
    return a(paramLong, paramBoolean, new boolean[this.k.length]);
  }

  public long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    int i1 = 0;
    if (i1 < this.j.a)
    {
      boolean[] arrayOfBoolean = this.d;
      if ((!paramBoolean) && (this.j.a(this.o, i1)));
      for (int i3 = 1; ; i3 = 0)
      {
        arrayOfBoolean[i1] = i3;
        i1++;
        break;
      }
    }
    a(this.c);
    a(this.j);
    g localg = this.j.c;
    long l1 = this.a.a(localg.a(), this.d, this.c, paramArrayOfBoolean, paramLong);
    b(this.c);
    this.f = false;
    int i2 = 0;
    while (i2 < this.c.length)
      if (this.c[i2] != null)
      {
        a.b(this.j.a(i2));
        if (this.k[i2].a() != 6)
          this.f = true;
        i2++;
      }
      else
      {
        if (localg.a(i2) == null);
        for (boolean bool = true; ; bool = false)
        {
          a.b(bool);
          break;
        }
      }
    return l1;
  }

  public void a(float paramFloat)
    throws i
  {
    this.e = true;
    this.i = this.a.b();
    b(paramFloat);
    long l1 = a(this.g.b, false);
    this.n += this.g.b - l1;
    this.g = this.g.a(l1);
  }

  public long b()
  {
    return this.g.b + this.n;
  }

  public long b(long paramLong)
  {
    return paramLong - a();
  }

  public boolean b(float paramFloat)
    throws i
  {
    int i1 = 0;
    com.google.android.exoplayer2.trackselection.i locali = this.l.a(this.k, this.i);
    if (locali.a(this.o))
      return false;
    this.j = locali;
    e[] arrayOfe = this.j.c.a();
    int i2 = arrayOfe.length;
    while (i1 < i2)
    {
      e locale = arrayOfe[i1];
      if (locale != null)
        locale.a(paramFloat);
      i1++;
    }
    return true;
  }

  public void c(long paramLong)
  {
    if (this.e)
      this.a.a(b(paramLong));
  }

  public boolean c()
  {
    return (this.e) && ((!this.f) || (this.a.d() == -9223372036854775808L));
  }

  public long d()
  {
    long l1;
    if (!this.e)
      l1 = this.g.b;
    while (true)
    {
      return l1;
      if (this.f);
      for (l1 = this.a.d(); l1 == -9223372036854775808L; l1 = -9223372036854775808L)
        return this.g.d;
    }
  }

  public void d(long paramLong)
  {
    long l1 = b(paramLong);
    this.a.c(l1);
  }

  public long e()
  {
    if (!this.e)
      return 0L;
    return this.a.e();
  }

  public void f()
  {
    a(null);
    try
    {
      if (this.g.a.e != -9223372036854775808L)
      {
        this.m.a(((c)this.a).a);
        return;
      }
      this.m.a(this.a);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      l.b("MediaPeriodHolder", "Period release failed.", localRuntimeException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.t
 * JD-Core Version:    0.6.2
 */