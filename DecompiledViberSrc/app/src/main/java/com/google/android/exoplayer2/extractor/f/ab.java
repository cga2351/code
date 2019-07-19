package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class ab
{
  private final ad a = new ad(0L);
  private final r b = new r();
  private boolean c;
  private boolean d;
  private boolean e;
  private long f = -9223372036854775807L;
  private long g = -9223372036854775807L;
  private long h = -9223372036854775807L;

  private int a(h paramh)
  {
    this.b.a(ag.f);
    this.c = true;
    paramh.a();
    return 0;
  }

  private long a(r paramr, int paramInt)
  {
    int i = paramr.d();
    int j = paramr.c();
    int k = i;
    if (k < j)
    {
      if (paramr.a[k] != 71);
      long l;
      do
      {
        k++;
        break;
        l = af.a(paramr, k, paramInt);
      }
      while (l == -9223372036854775807L);
      return l;
    }
    return -9223372036854775807L;
  }

  private int b(h paramh, n paramn, int paramInt)
    throws IOException, InterruptedException
  {
    int i = (int)Math.min(112800L, paramh.d());
    if (paramh.c() != 0)
    {
      paramn.a = 0;
      return 1;
    }
    this.b.a(i);
    paramh.a();
    paramh.c(this.b.a, 0, i);
    this.f = a(this.b, paramInt);
    this.d = true;
    return 0;
  }

  private long b(r paramr, int paramInt)
  {
    int i = paramr.d();
    int j = -1 + paramr.c();
    if (j >= i)
    {
      if (paramr.a[j] != 71);
      long l;
      do
      {
        j--;
        break;
        l = af.a(paramr, j, paramInt);
      }
      while (l == -9223372036854775807L);
      return l;
    }
    return -9223372036854775807L;
  }

  private int c(h paramh, n paramn, int paramInt)
    throws IOException, InterruptedException
  {
    long l1 = paramh.d();
    int i = (int)Math.min(112800L, l1);
    long l2 = l1 - i;
    if (paramh.c() != l2)
    {
      paramn.a = l2;
      return 1;
    }
    this.b.a(i);
    paramh.a();
    paramh.c(this.b.a, 0, i);
    this.g = b(this.b, paramInt);
    this.e = true;
    return 0;
  }

  public int a(h paramh, n paramn, int paramInt)
    throws IOException, InterruptedException
  {
    if (paramInt <= 0)
      return a(paramh);
    if (!this.e)
      return c(paramh, paramn, paramInt);
    if (this.g == -9223372036854775807L)
      return a(paramh);
    if (!this.d)
      return b(paramh, paramn, paramInt);
    if (this.f == -9223372036854775807L)
      return a(paramh);
    long l = this.a.b(this.f);
    this.h = (this.a.b(this.g) - l);
    return a(paramh);
  }

  public boolean a()
  {
    return this.c;
  }

  public long b()
  {
    return this.h;
  }

  public ad c()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.ab
 * JD-Core Version:    0.6.2
 */