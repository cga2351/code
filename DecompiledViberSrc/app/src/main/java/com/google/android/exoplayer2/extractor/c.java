package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.ag;

public class c
  implements o
{
  private final long a;
  private final long b;
  private final int c;
  private final long d;
  private final int e;
  private final long f;

  public c(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    if (paramInt2 == -1)
      paramInt2 = 1;
    this.c = paramInt2;
    this.e = paramInt1;
    if (paramLong1 == -1L)
    {
      this.d = -1L;
      this.f = -9223372036854775807L;
      return;
    }
    this.d = (paramLong1 - paramLong2);
    this.f = a(paramLong1, paramLong2, paramInt1);
  }

  private static long a(long paramLong1, long paramLong2, int paramInt)
  {
    return 1000000L * (8L * Math.max(0L, paramLong1 - paramLong2)) / paramInt;
  }

  private long c(long paramLong)
  {
    return ag.a(paramLong * this.e / 8000000L / this.c * this.c, 0L, this.d - this.c) + this.b;
  }

  public o.a a(long paramLong)
  {
    if (this.d == -1L)
      return new o.a(new p(0L, this.b));
    long l1 = c(paramLong);
    long l2 = b(l1);
    p localp = new p(l2, l1);
    if ((l2 >= paramLong) || (l1 + this.c >= this.a))
      return new o.a(localp);
    long l3 = l1 + this.c;
    return new o.a(localp, new p(b(l3), l3));
  }

  public boolean a()
  {
    return this.d != -1L;
  }

  public long b()
  {
    return this.f;
  }

  public long b(long paramLong)
  {
    return a(paramLong, this.b, this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.c
 * JD-Core Version:    0.6.2
 */