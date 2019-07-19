package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.p;
import java.io.EOFException;
import java.io.IOException;

final class a
  implements g
{
  private final f a = new f();
  private final long b;
  private final long c;
  private final i d;
  private int e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;

  public a(long paramLong1, long paramLong2, i parami, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    if ((paramLong1 >= 0L) && (paramLong2 > paramLong1));
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.a(bool);
      this.d = parami;
      this.b = paramLong1;
      this.c = paramLong2;
      if ((paramLong3 != paramLong2 - paramLong1) && (!paramBoolean))
        break;
      this.f = paramLong4;
      this.e = 3;
      return;
    }
    this.e = 0;
  }

  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong1 + (paramLong2 * (this.c - this.b) / this.f - paramLong3);
    if (l1 < this.b)
      l1 = this.b;
    if (l1 >= this.c)
      l1 = this.c - 1L;
    return l1;
  }

  public long a(long paramLong, h paramh)
    throws IOException, InterruptedException
  {
    if (this.i == this.j)
      return -(2L + this.k);
    long l1 = paramh.c();
    if (!a(paramh, this.j))
    {
      if (this.i == l1)
        throw new IOException("No ogg page can be found.");
      return this.i;
    }
    this.a.a(paramh, false);
    paramh.a();
    long l2 = paramLong - this.a.c;
    int m = this.a.h + this.a.i;
    if ((l2 < 0L) || (l2 > 72000L))
    {
      if (l2 < 0L)
      {
        this.j = l1;
        this.l = this.a.c;
      }
      while (this.j - this.i < 100000L)
      {
        this.j = this.i;
        return this.i;
        this.i = (paramh.c() + m);
        this.k = this.a.c;
        if (this.j - this.i + m < 100000L)
        {
          paramh.b(m);
          return -(2L + this.k);
        }
      }
      long l3 = m;
      if (l2 <= 0L);
      for (long l4 = 2L; ; l4 = 1L)
      {
        long l5 = l4 * l3;
        return Math.min(Math.max(paramh.c() - l5 + l2 * (this.j - this.i) / (this.l - this.k), this.i), this.j - 1L);
      }
    }
    paramh.b(m);
    return -(2L + this.a.c);
  }

  public long a(h paramh)
    throws IOException, InterruptedException
  {
    long l1 = 0L;
    long l3;
    switch (this.e)
    {
    default:
      throw new IllegalStateException();
    case 3:
      l3 = -1L;
    case 0:
      do
      {
        return l3;
        this.g = paramh.c();
        this.e = 1;
        l3 = this.c - 65307L;
      }
      while (l3 > this.g);
    case 1:
      this.f = c(paramh);
      this.e = 3;
      return this.g;
    case 2:
    }
    if (this.h == l1);
    while (true)
    {
      this.e = 3;
      return -(l1 + 2L);
      long l2 = a(this.h, paramh);
      if (l2 >= l1)
        return l2;
      l1 = a(paramh, this.h, -(l2 + 2L));
    }
  }

  long a(h paramh, long paramLong1, long paramLong2)
    throws IOException, InterruptedException
  {
    this.a.a(paramh, false);
    while (this.a.c < paramLong1)
    {
      paramh.b(this.a.h + this.a.i);
      paramLong2 = this.a.c;
      this.a.a(paramh, false);
    }
    paramh.a();
    return paramLong2;
  }

  public a a()
  {
    if (this.f != 0L)
      return new a(null);
    return null;
  }

  boolean a(h paramh, long paramLong)
    throws IOException, InterruptedException
  {
    long l1 = Math.min(3L + paramLong, this.c);
    byte[] arrayOfByte = new byte[2048];
    int m = arrayOfByte.length;
    while (true)
    {
      if (paramh.c() + m > l1)
      {
        m = (int)(l1 - paramh.c());
        if (m < 4)
          return false;
      }
      paramh.b(arrayOfByte, 0, m, false);
      for (int n = 0; n < m - 3; n++)
        if ((arrayOfByte[n] == 79) && (arrayOfByte[(n + 1)] == 103) && (arrayOfByte[(n + 2)] == 103) && (arrayOfByte[(n + 3)] == 83))
        {
          paramh.b(n);
          return true;
        }
      paramh.b(m - 3);
    }
  }

  public long a_(long paramLong)
  {
    boolean bool;
    if ((this.e == 3) || (this.e == 2))
    {
      bool = true;
      com.google.android.exoplayer2.g.a.a(bool);
      if (paramLong != 0L)
        break label56;
    }
    label56: for (long l1 = 0L; ; l1 = this.d.b(paramLong))
    {
      this.h = l1;
      this.e = 2;
      b();
      return this.h;
      bool = false;
      break;
    }
  }

  public void b()
  {
    this.i = this.b;
    this.j = this.c;
    this.k = 0L;
    this.l = this.f;
  }

  void b(h paramh)
    throws IOException, InterruptedException
  {
    if (!a(paramh, this.c))
      throw new EOFException();
  }

  long c(h paramh)
    throws IOException, InterruptedException
  {
    b(paramh);
    this.a.a();
    while (((0x4 & this.a.b) != 4) && (paramh.c() < this.c))
    {
      this.a.a(paramh, false);
      paramh.b(this.a.h + this.a.i);
    }
    return this.a.c;
  }

  private class a
    implements o
  {
    private a()
    {
    }

    public o.a a(long paramLong)
    {
      if (paramLong == 0L)
        return new o.a(new p(0L, a.a(a.this)));
      long l = a.b(a.this).b(paramLong);
      return new o.a(new p(paramLong, a.a(a.this, a.a(a.this), l, 30000L)));
    }

    public boolean a()
    {
      return true;
    }

    public long b()
    {
      return a.b(a.this).a(a.c(a.this));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.a
 * JD-Core Version:    0.6.2
 */