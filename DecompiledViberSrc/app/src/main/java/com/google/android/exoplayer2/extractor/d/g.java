package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

final class g
  implements c.a
{
  private final long a;
  private final int b;
  private final long c;
  private final long d;
  private final long e;
  private final long[] f;

  private g(long paramLong1, int paramInt, long paramLong2)
  {
    this(paramLong1, paramInt, paramLong2, -1L, null);
  }

  private g(long paramLong1, int paramInt, long paramLong2, long paramLong3, long[] paramArrayOfLong)
  {
    this.a = paramLong1;
    this.b = paramInt;
    this.c = paramLong2;
    this.f = paramArrayOfLong;
    this.d = paramLong3;
    if (paramLong3 == l);
    while (true)
    {
      this.e = l;
      return;
      l = paramLong1 + paramLong3;
    }
  }

  private long a(int paramInt)
  {
    return this.c * paramInt / 100L;
  }

  public static g a(long paramLong1, long paramLong2, m paramm, r paramr)
  {
    int i = paramm.g;
    int j = paramm.d;
    int k = paramr.p();
    int m;
    if ((k & 0x1) == 1)
    {
      m = paramr.v();
      if (m != 0);
    }
    else
    {
      return null;
    }
    long l1 = ag.d(m, 1000000L * i, j);
    if ((k & 0x6) != 6)
      return new g(paramLong2, paramm.c, l1);
    long l2 = paramr.v();
    long[] arrayOfLong = new long[100];
    for (int n = 0; n < 100; n++)
      arrayOfLong[n] = paramr.h();
    if ((paramLong1 != -1L) && (paramLong1 != paramLong2 + l2))
      l.c("XingSeeker", "XING data size mismatch: " + paramLong1 + ", " + (paramLong2 + l2));
    return new g(paramLong2, paramm.c, l1, l2, arrayOfLong);
  }

  public o.a a(long paramLong)
  {
    if (!a())
      return new o.a(new p(0L, this.a + this.b));
    long l = ag.a(paramLong, 0L, this.c);
    double d1 = 100.0D * l / this.c;
    if (d1 <= 0.0D);
    for (double d4 = 0.0D; ; d4 = 256.0D)
    {
      return new o.a(new p(l, ag.a(Math.round(d4 / 256.0D * this.d), this.b, this.d - 1L) + this.a));
      if (d1 < 100.0D)
        break;
    }
    int i = (int)d1;
    long[] arrayOfLong = (long[])a.a(this.f);
    double d2 = arrayOfLong[i];
    if (i == 99);
    for (double d3 = 256.0D; ; d3 = arrayOfLong[(i + 1)])
    {
      d4 = d2 + (d1 - i) * (d3 - d2);
      break;
    }
  }

  public boolean a()
  {
    return this.f != null;
  }

  public long b()
  {
    return this.c;
  }

  public long c()
  {
    return this.e;
  }

  public long c(long paramLong)
  {
    long l1 = paramLong - this.a;
    if ((!a()) || (l1 <= this.b))
      return 0L;
    long[] arrayOfLong = (long[])a.a(this.f);
    double d1 = 256.0D * l1 / this.d;
    int i = ag.a(arrayOfLong, ()d1, true, true);
    long l2 = a(i);
    long l3 = arrayOfLong[i];
    long l4 = a(i + 1);
    long l5;
    if (i == 99)
    {
      l5 = 256L;
      if (l3 != l5)
        break label140;
    }
    label140: for (double d2 = 0.0D; ; d2 = (d1 - l3) / (l5 - l3))
    {
      return l2 + Math.round(d2 * (l4 - l2));
      l5 = arrayOfLong[(i + 1)];
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.d.g
 * JD-Core Version:    0.6.2
 */