package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

public final class b
  implements g
{
  public static final j a = c.a;
  private static final int b = ag.g("FLV");
  private final r c = new r(4);
  private final r d = new r(9);
  private final r e = new r(11);
  private final r f = new r();
  private final d g = new d();
  private i h;
  private int i = 1;
  private long j = -9223372036854775807L;
  private int k;
  private int l;
  private int m;
  private long n;
  private boolean o;
  private a p;
  private f q;

  private void b()
  {
    if (!this.o)
    {
      this.h.a(new o.b(-9223372036854775807L));
      this.o = true;
    }
    if (this.j == -9223372036854775807L)
      if (this.g.a() != -9223372036854775807L)
        break label68;
    label68: for (long l1 = -this.n; ; l1 = 0L)
    {
      this.j = l1;
      return;
    }
  }

  private boolean b(h paramh)
    throws IOException, InterruptedException
  {
    if (!paramh.a(this.d.a, 0, 9, true))
      return false;
    this.d.c(0);
    this.d.d(4);
    int i1 = this.d.h();
    if ((i1 & 0x4) != 0);
    for (int i2 = 1; ; i2 = 0)
    {
      int i3 = i1 & 0x1;
      int i4 = 0;
      if (i3 != 0)
        i4 = 1;
      if ((i2 != 0) && (this.p == null))
        this.p = new a(this.h.a(8, 1));
      if ((i4 != 0) && (this.q == null))
        this.q = new f(this.h.a(9, 2));
      this.h.a();
      this.k = (4 + (-9 + this.d.p()));
      this.i = 2;
      return true;
    }
  }

  private void c(h paramh)
    throws IOException, InterruptedException
  {
    paramh.b(this.k);
    this.k = 0;
    this.i = 3;
  }

  private boolean d(h paramh)
    throws IOException, InterruptedException
  {
    if (!paramh.a(this.e.a, 0, 11, true))
      return false;
    this.e.c(0);
    this.l = this.e.h();
    this.m = this.e.l();
    this.n = this.e.l();
    this.n = (1000L * (this.e.h() << 24 | this.n));
    this.e.d(3);
    this.i = 4;
    return true;
  }

  private boolean e(h paramh)
    throws IOException, InterruptedException
  {
    boolean bool = true;
    if ((this.l == 8) && (this.p != null))
    {
      b();
      this.p.b(f(paramh), this.j + this.n);
    }
    while (true)
    {
      this.k = 4;
      this.i = 2;
      return bool;
      if ((this.l == 9) && (this.q != null))
      {
        b();
        this.q.b(f(paramh), this.j + this.n);
      }
      else if ((this.l == 18) && (!this.o))
      {
        this.g.b(f(paramh), this.n);
        long l1 = this.g.a();
        if (l1 != -9223372036854775807L)
        {
          this.h.a(new o.b(l1));
          this.o = bool;
        }
      }
      else
      {
        paramh.b(this.m);
        bool = false;
      }
    }
  }

  private r f(h paramh)
    throws IOException, InterruptedException
  {
    if (this.m > this.f.e())
      this.f.a(new byte[Math.max(2 * this.f.e(), this.m)], 0);
    while (true)
    {
      this.f.b(this.m);
      paramh.b(this.f.a, 0, this.m);
      return this.f;
      this.f.c(0);
    }
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    do
    {
      do
        while (true)
          switch (this.i)
          {
          default:
            throw new IllegalStateException();
          case 1:
            if (!b(paramh))
              return -1;
            break;
          case 2:
            c(paramh);
          case 3:
          case 4:
          }
      while (d(paramh));
      return -1;
    }
    while (!e(paramh));
    return 0;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.i = 1;
    this.j = -9223372036854775807L;
    this.k = 0;
  }

  public void a(i parami)
  {
    this.h = parami;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    paramh.c(this.c.a, 0, 3);
    this.c.c(0);
    if (this.c.l() != b);
    do
    {
      do
      {
        return false;
        paramh.c(this.c.a, 0, 2);
        this.c.c(0);
      }
      while ((0xFA & this.c.i()) != 0);
      paramh.c(this.c.a, 0, 4);
      this.c.c(0);
      int i1 = this.c.p();
      paramh.a();
      paramh.c(i1);
      paramh.c(this.c.a, 0, 4);
      this.c.c(0);
    }
    while (this.c.p() != 0);
    return true;
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.b.b
 * JD-Core Version:    0.6.2
 */