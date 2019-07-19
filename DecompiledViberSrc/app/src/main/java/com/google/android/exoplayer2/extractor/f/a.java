package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

public final class a
  implements g
{
  public static final j a = b.a;
  private static final int b = ag.g("ID3");
  private final long c;
  private final c d;
  private final r e;
  private boolean f;

  public a()
  {
    this(0L);
  }

  public a(long paramLong)
  {
    this.c = paramLong;
    this.d = new c();
    this.e = new r(2786);
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    int i = paramh.a(this.e.a, 0, 2786);
    if (i == -1)
      return -1;
    this.e.c(0);
    this.e.b(i);
    if (!this.f)
    {
      this.d.a(this.c, 4);
      this.f = true;
    }
    this.d.a(this.e);
    return 0;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.f = false;
    this.d.a();
  }

  public void a(i parami)
  {
    this.d.a(parami, new ae.d(0, 1));
    parami.a();
    parami.a(new o.b(-9223372036854775807L));
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    r localr = new r(10);
    int i = 0;
    paramh.c(localr.a, 0, 10);
    localr.c(0);
    int k;
    int m;
    if (localr.l() != b)
    {
      paramh.a();
      paramh.c(i);
      k = 0;
      m = i;
    }
    while (true)
    {
      label59: paramh.c(localr.a, 0, 6);
      localr.c(0);
      if (localr.i() != 2935)
      {
        paramh.a();
        m++;
        if (m - i < 8192);
      }
      int n;
      do
      {
        return false;
        localr.d(3);
        int j = localr.u();
        i += j + 10;
        paramh.c(j);
        break;
        paramh.c(m);
        k = 0;
        break label59;
        k++;
        if (k >= 4)
          return true;
        n = com.google.android.exoplayer2.b.a.a(localr.a);
      }
      while (n == -1);
      paramh.c(n - 6);
    }
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.a
 * JD-Core Version:    0.6.2
 */