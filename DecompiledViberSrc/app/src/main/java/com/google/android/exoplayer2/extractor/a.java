package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.ag;
import java.io.IOException;

public abstract class a
{
  protected final a a;
  protected final g b;
  protected d c;
  private final int d;

  protected a(e parame, g paramg, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt)
  {
    this.b = paramg;
    this.d = paramInt;
    this.a = new a(parame, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
  }

  protected final int a(h paramh, long paramLong, n paramn)
  {
    if (paramLong == paramh.c())
      return 0;
    paramn.a = paramLong;
    return 1;
  }

  public int a(h paramh, n paramn, c paramc)
    throws InterruptedException, IOException
  {
    g localg = (g)com.google.android.exoplayer2.g.a.a(this.b);
    long l3;
    f localf;
    while (true)
    {
      d locald = (d)com.google.android.exoplayer2.g.a.a(this.c);
      long l1 = d.b(locald);
      long l2 = d.c(locald);
      l3 = d.d(locald);
      if (l2 - l1 <= this.d)
      {
        a(false, l1);
        return a(paramh, l1, paramn);
      }
      if (!a(paramh, l3))
        return a(paramh, l3, paramn);
      paramh.a();
      localf = localg.a(paramh, d.e(locald), paramc);
      switch (f.a(localf))
      {
      default:
        throw new IllegalStateException("Invalid case");
      case -1:
        d.a(locald, f.b(localf), f.c(localf));
        break;
      case -2:
        d.b(locald, f.b(localf), f.c(localf));
      case 0:
      case -3:
      }
    }
    a(true, f.c(localf));
    a(paramh, f.c(localf));
    return a(paramh, f.c(localf), paramn);
    a(false, l3);
    return a(paramh, l3, paramn);
  }

  public final o a()
  {
    return this.a;
  }

  public final void a(long paramLong)
  {
    if ((this.c != null) && (d.a(this.c) == paramLong))
      return;
    this.c = b(paramLong);
  }

  protected final void a(boolean paramBoolean, long paramLong)
  {
    this.c = null;
    this.b.a();
    b(paramBoolean, paramLong);
  }

  protected final boolean a(h paramh, long paramLong)
    throws IOException, InterruptedException
  {
    long l = paramLong - paramh.c();
    if ((l >= 0L) && (l <= 262144L))
    {
      paramh.b((int)l);
      return true;
    }
    return false;
  }

  protected d b(long paramLong)
  {
    return new d(paramLong, this.a.b(paramLong), a.a(this.a), a.b(this.a), a.c(this.a), a.d(this.a), a.e(this.a));
  }

  protected void b(boolean paramBoolean, long paramLong)
  {
  }

  public final boolean b()
  {
    return this.c != null;
  }

  public static class a
    implements o
  {
    private final a.e a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;

    public a(a.e parame, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
    {
      this.a = parame;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramLong3;
      this.e = paramLong4;
      this.f = paramLong5;
      this.g = paramLong6;
    }

    public o.a a(long paramLong)
    {
      return new o.a(new p(paramLong, a.d.a(this.a.a(paramLong), this.c, this.d, this.e, this.f, this.g)));
    }

    public boolean a()
    {
      return true;
    }

    public long b()
    {
      return this.b;
    }

    public long b(long paramLong)
    {
      return this.a.a(paramLong);
    }
  }

  public static final class b
    implements a.e
  {
    public long a(long paramLong)
    {
      return paramLong;
    }
  }

  public static final class c
  {
  }

  protected static class d
  {
    private final long a;
    private final long b;
    private final long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;

    protected d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.d = paramLong3;
      this.e = paramLong4;
      this.f = paramLong5;
      this.g = paramLong6;
      this.c = paramLong7;
      this.h = a(paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7);
    }

    private long a()
    {
      return this.f;
    }

    protected static long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
    {
      if ((1L + paramLong4 >= paramLong5) || (1L + paramLong2 >= paramLong3))
        return paramLong4;
      long l1 = paramLong1 - paramLong2;
      long l2 = ()((float)(paramLong5 - paramLong4) / (float)(paramLong3 - paramLong2) * (float)l1);
      long l3 = l2 / 20L;
      return ag.a(l2 + paramLong4 - paramLong6 - l3, paramLong4, paramLong5 - 1L);
    }

    private void a(long paramLong1, long paramLong2)
    {
      this.d = paramLong1;
      this.f = paramLong2;
      f();
    }

    private long b()
    {
      return this.g;
    }

    private void b(long paramLong1, long paramLong2)
    {
      this.e = paramLong1;
      this.g = paramLong2;
      f();
    }

    private long c()
    {
      return this.b;
    }

    private long d()
    {
      return this.a;
    }

    private long e()
    {
      return this.h;
    }

    private void f()
    {
      this.h = a(this.b, this.d, this.e, this.f, this.g, this.c);
    }
  }

  protected static abstract interface e
  {
    public abstract long a(long paramLong);
  }

  public static final class f
  {
    public static final f a = new f(-3, -9223372036854775807L, -1L);
    private final int b;
    private final long c;
    private final long d;

    private f(int paramInt, long paramLong1, long paramLong2)
    {
      this.b = paramInt;
      this.c = paramLong1;
      this.d = paramLong2;
    }

    public static f a(long paramLong)
    {
      return new f(0, -9223372036854775807L, paramLong);
    }

    public static f a(long paramLong1, long paramLong2)
    {
      return new f(-1, paramLong1, paramLong2);
    }

    public static f b(long paramLong1, long paramLong2)
    {
      return new f(-2, paramLong1, paramLong2);
    }
  }

  protected static abstract interface g
  {
    public abstract a.f a(h paramh, long paramLong, a.c paramc)
      throws IOException, InterruptedException;

    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.a
 * JD-Core Version:    0.6.2
 */