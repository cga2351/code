package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.a.a.a;

public abstract class ak
{
  public static final ak a = new ak()
  {
    public int a(Object paramAnonymousObject)
    {
      return -1;
    }

    public ak.a a(int paramAnonymousInt, ak.a paramAnonymousa, boolean paramAnonymousBoolean)
    {
      throw new IndexOutOfBoundsException();
    }

    public ak.b a(int paramAnonymousInt, ak.b paramAnonymousb, boolean paramAnonymousBoolean, long paramAnonymousLong)
    {
      throw new IndexOutOfBoundsException();
    }

    public Object a(int paramAnonymousInt)
    {
      throw new IndexOutOfBoundsException();
    }

    public int b()
    {
      return 0;
    }

    public int c()
    {
      return 0;
    }
  };

  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    default:
      throw new IllegalStateException();
    case 0:
      if (paramInt1 == a(paramBoolean))
        return -1;
      return paramInt1 + 1;
    case 1:
      return paramInt1;
    case 2:
    }
    if (paramInt1 == a(paramBoolean))
      return b(paramBoolean);
    return paramInt1 + 1;
  }

  public final int a(int paramInt1, a parama, b paramb, int paramInt2, boolean paramBoolean)
  {
    int i = a(paramInt1, parama).c;
    if (a(i, paramb).g == paramInt1)
    {
      int j = a(i, paramInt2, paramBoolean);
      if (j == -1)
        return -1;
      return a(j, paramb).f;
    }
    return paramInt1 + 1;
  }

  public abstract int a(Object paramObject);

  public int a(boolean paramBoolean)
  {
    if (a())
      return -1;
    return -1 + b();
  }

  public final Pair<Object, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }

  public final Pair<Object, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    com.google.android.exoplayer2.g.a.a(paramInt, 0, b());
    a(paramInt, paramb, false, paramLong2);
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.b();
      if (paramLong1 == -9223372036854775807L)
        return null;
    }
    int i = paramb.f;
    long l1 = paramLong1 + paramb.d();
    for (long l2 = a(i, parama, true).a(); (l2 != -9223372036854775807L) && (l1 >= l2) && (i < paramb.g); l2 = a(i, parama, true).a())
    {
      l1 -= l2;
      i++;
    }
    return Pair.create(parama.b, Long.valueOf(l1));
  }

  public final a a(int paramInt, a parama)
  {
    return a(paramInt, parama, false);
  }

  public abstract a a(int paramInt, a parama, boolean paramBoolean);

  public a a(Object paramObject, a parama)
  {
    return a(a(paramObject), parama, true);
  }

  public final b a(int paramInt, b paramb)
  {
    return a(paramInt, paramb, false);
  }

  public final b a(int paramInt, b paramb, boolean paramBoolean)
  {
    return a(paramInt, paramb, paramBoolean, 0L);
  }

  public abstract b a(int paramInt, b paramb, boolean paramBoolean, long paramLong);

  public abstract Object a(int paramInt);

  public final boolean a()
  {
    return b() == 0;
  }

  public abstract int b();

  public int b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    default:
      throw new IllegalStateException();
    case 0:
      if (paramInt1 == b(paramBoolean))
        return -1;
      return paramInt1 - 1;
    case 1:
      return paramInt1;
    case 2:
    }
    if (paramInt1 == b(paramBoolean))
      return a(paramBoolean);
    return paramInt1 - 1;
  }

  public int b(boolean paramBoolean)
  {
    if (a())
      return -1;
    return 0;
  }

  public final boolean b(int paramInt1, a parama, b paramb, int paramInt2, boolean paramBoolean)
  {
    return a(paramInt1, parama, paramb, paramInt2, paramBoolean) == -1;
  }

  public abstract int c();

  public static final class a
  {
    public Object a;
    public Object b;
    public int c;
    public long d;
    private long e;
    private com.google.android.exoplayer2.source.a.a f;

    public int a(int paramInt1, int paramInt2)
    {
      return this.f.d[paramInt1].a(paramInt2);
    }

    public int a(long paramLong)
    {
      return this.f.a(paramLong);
    }

    public long a()
    {
      return this.d;
    }

    public long a(int paramInt)
    {
      return this.f.c[paramInt];
    }

    public a a(Object paramObject1, Object paramObject2, int paramInt, long paramLong1, long paramLong2)
    {
      return a(paramObject1, paramObject2, paramInt, paramLong1, paramLong2, com.google.android.exoplayer2.source.a.a.a);
    }

    public a a(Object paramObject1, Object paramObject2, int paramInt, long paramLong1, long paramLong2, com.google.android.exoplayer2.source.a.a parama)
    {
      this.a = paramObject1;
      this.b = paramObject2;
      this.c = paramInt;
      this.d = paramLong1;
      this.e = paramLong2;
      this.f = parama;
      return this;
    }

    public int b(int paramInt)
    {
      return this.f.d[paramInt].a();
    }

    public int b(long paramLong)
    {
      return this.f.b(paramLong);
    }

    public long b()
    {
      return c.a(this.e);
    }

    public boolean b(int paramInt1, int paramInt2)
    {
      a.a locala = this.f.d[paramInt1];
      return (locala.a != -1) && (locala.c[paramInt2] != 0);
    }

    public long c()
    {
      return this.e;
    }

    public long c(int paramInt1, int paramInt2)
    {
      a.a locala = this.f.d[paramInt1];
      if (locala.a != -1)
        return locala.d[paramInt2];
      return -9223372036854775807L;
    }

    public boolean c(int paramInt)
    {
      return !this.f.d[paramInt].b();
    }

    public int d()
    {
      return this.f.b;
    }

    public int d(int paramInt)
    {
      return this.f.d[paramInt].a;
    }

    public long e()
    {
      return this.f.e;
    }
  }

  public static final class b
  {
    public Object a;
    public long b;
    public long c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;

    public long a()
    {
      return c.a(this.h);
    }

    public b a(Object paramObject, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, long paramLong5)
    {
      this.a = paramObject;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.h = paramLong3;
      this.i = paramLong4;
      this.f = paramInt1;
      this.g = paramInt2;
      this.j = paramLong5;
      return this;
    }

    public long b()
    {
      return this.h;
    }

    public long c()
    {
      return c.a(this.i);
    }

    public long d()
    {
      return this.j;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ak
 * JD-Core Version:    0.6.2
 */