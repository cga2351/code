package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

abstract class i
{
  private final e a = new e();
  private q b;
  private com.google.android.exoplayer2.extractor.i c;
  private g d;
  private long e;
  private long f;
  private long g;
  private int h;
  private int i;
  private a j;
  private long k;
  private boolean l;
  private boolean m;

  private int a(h paramh)
    throws IOException, InterruptedException
  {
    boolean bool1 = true;
    boolean bool2 = bool1;
    while (bool2)
    {
      if (!this.a.a(paramh))
      {
        this.h = 3;
        return -1;
      }
      this.k = (paramh.c() - this.f);
      bool2 = a(this.a.c(), this.f, this.j);
      if (bool2)
        this.f = paramh.c();
    }
    this.i = this.j.a.sampleRate;
    if (!this.m)
    {
      this.b.a(this.j.a);
      this.m = bool1;
    }
    if (this.j.b != null);
    for (this.d = this.j.b; ; this.d = new b(null))
    {
      this.j = null;
      this.h = 2;
      this.a.d();
      return 0;
      if (paramh.d() != -1L)
        break;
    }
    f localf = this.a.b();
    if ((0x4 & localf.b) != 0);
    while (true)
    {
      this.d = new a(this.f, paramh.d(), this, localf.h + localf.i, localf.c, bool1);
      break;
      bool1 = false;
    }
  }

  private int b(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    long l1 = this.d.a(paramh);
    if (l1 >= 0L)
    {
      paramn.a = l1;
      return 1;
    }
    if (l1 < -1L)
      c(-(l1 + 2L));
    if (!this.l)
    {
      o localo = this.d.c();
      this.c.a(localo);
      this.l = true;
    }
    if ((this.k > 0L) || (this.a.a(paramh)))
    {
      this.k = 0L;
      r localr = this.a.c();
      long l2 = b(localr);
      if ((l2 >= 0L) && (l2 + this.g >= this.e))
      {
        long l3 = a(this.g);
        this.b.a(localr, localr.c());
        this.b.a(l3, 1, localr.c(), 0, null);
        this.e = -1L;
      }
      this.g = (l2 + this.g);
      return 0;
    }
    this.h = 3;
    return -1;
  }

  final int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    switch (this.h)
    {
    default:
      throw new IllegalStateException();
    case 0:
      return a(paramh);
    case 1:
      paramh.b((int)this.f);
      this.h = 2;
      return 0;
    case 2:
    }
    return b(paramh, paramn);
  }

  protected long a(long paramLong)
  {
    return 1000000L * paramLong / this.i;
  }

  final void a(long paramLong1, long paramLong2)
  {
    this.a.a();
    if (paramLong1 == 0L)
      if (!this.l)
      {
        bool = true;
        a(bool);
      }
    while (this.h == 0)
      while (true)
      {
        return;
        boolean bool = false;
      }
    this.e = this.d.a_(paramLong2);
    this.h = 2;
  }

  void a(com.google.android.exoplayer2.extractor.i parami, q paramq)
  {
    this.c = parami;
    this.b = paramq;
    a(true);
  }

  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j = new a();
      this.f = 0L;
    }
    for (this.h = 0; ; this.h = 1)
    {
      this.e = -1L;
      this.g = 0L;
      return;
    }
  }

  protected abstract boolean a(r paramr, long paramLong, a parama)
    throws IOException, InterruptedException;

  protected long b(long paramLong)
  {
    return paramLong * this.i / 1000000L;
  }

  protected abstract long b(r paramr);

  protected void c(long paramLong)
  {
    this.g = paramLong;
  }

  static class a
  {
    Format a;
    g b;
  }

  private static final class b
    implements g
  {
    public long a(h paramh)
      throws IOException, InterruptedException
    {
      return -1L;
    }

    public long a_(long paramLong)
    {
      return 0L;
    }

    public o c()
    {
      return new o.b(-9223372036854775807L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.i
 * JD-Core Version:    0.6.2
 */