package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

final class f
  implements c.a
{
  private final long[] a;
  private final long[] b;
  private final long c;
  private final long d;

  private f(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2)
  {
    this.a = paramArrayOfLong1;
    this.b = paramArrayOfLong2;
    this.c = paramLong1;
    this.d = paramLong2;
  }

  public static f a(long paramLong1, long paramLong2, m paramm, r paramr)
  {
    paramr.d(10);
    int i = paramr.p();
    if (i <= 0)
      return null;
    int j = paramm.d;
    long l1 = i;
    if (j >= 32000);
    long l2;
    int n;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    int i2;
    long l4;
    for (int k = 1152; ; k = 576)
    {
      l2 = ag.d(l1, 1000000L * k, j);
      int m = paramr.i();
      n = paramr.i();
      int i1 = paramr.i();
      paramr.d(2);
      long l3 = paramLong2 + paramm.c;
      arrayOfLong1 = new long[m];
      arrayOfLong2 = new long[m];
      i2 = 0;
      l4 = paramLong2;
      if (i2 >= m)
        break;
      arrayOfLong1[i2] = (l2 * i2 / m);
      arrayOfLong2[i2] = Math.max(l4, l3);
      switch (i1)
      {
      default:
        return null;
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    int i3 = paramr.h();
    while (true)
    {
      l4 += i3 * n;
      i2++;
      break;
      i3 = paramr.i();
      continue;
      i3 = paramr.l();
      continue;
      i3 = paramr.v();
    }
    if ((paramLong1 != -1L) && (paramLong1 != l4))
      l.c("VbriSeeker", "VBRI data size mismatch: " + paramLong1 + ", " + l4);
    return new f(arrayOfLong1, arrayOfLong2, l2, l4);
  }

  public o.a a(long paramLong)
  {
    int i = ag.a(this.a, paramLong, true, true);
    p localp = new p(this.a[i], this.b[i]);
    if ((localp.b >= paramLong) || (i == -1 + this.a.length))
      return new o.a(localp);
    return new o.a(localp, new p(this.a[(i + 1)], this.b[(i + 1)]));
  }

  public boolean a()
  {
    return true;
  }

  public long b()
  {
    return this.c;
  }

  public long c()
  {
    return this.d;
  }

  public long c(long paramLong)
  {
    return this.a[ag.a(this.b, paramLong, true, true)];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.d.f
 * JD-Core Version:    0.6.2
 */