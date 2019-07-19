package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ag;

final class c
  implements o
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private long g;
  private long h;

  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }

  public o.a a(long paramLong)
  {
    long l1 = ag.a(paramLong * this.c / 1000000L / this.d * this.d, 0L, this.h - this.d);
    long l2 = l1 + this.g;
    long l3 = b(l2);
    p localp = new p(l3, l2);
    if ((l3 >= paramLong) || (l1 == this.h - this.d))
      return new o.a(localp);
    long l4 = l2 + this.d;
    return new o.a(localp, new p(b(l4), l4));
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.g = paramLong1;
    this.h = paramLong2;
  }

  public boolean a()
  {
    return true;
  }

  public long b()
  {
    return 1000000L * (this.h / this.d) / this.b;
  }

  public long b(long paramLong)
  {
    return 1000000L * Math.max(0L, paramLong - this.g) / this.c;
  }

  public long c()
  {
    if (d())
      return this.g + this.h;
    return -1L;
  }

  public boolean d()
  {
    return (this.g != 0L) && (this.h != 0L);
  }

  public int e()
  {
    return this.d;
  }

  public int f()
  {
    return this.b * this.e * this.a;
  }

  public int g()
  {
    return this.b;
  }

  public int h()
  {
    return this.a;
  }

  public int i()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.g.c
 * JD-Core Version:    0.6.2
 */