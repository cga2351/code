package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.c;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;

public final class d
  implements g
{
  public static final j a = e.a;
  private static final int b = ag.g("ID3");
  private final int c;
  private final f d;
  private final r e;
  private final r f;
  private final q g;
  private final long h;
  private i i;
  private long j;
  private long k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;

  public d()
  {
    this(0L);
  }

  public d(long paramLong)
  {
    this(paramLong, 0);
  }

  public d(long paramLong, int paramInt)
  {
    this.h = paramLong;
    this.j = paramLong;
    this.c = paramInt;
    this.d = new f(true);
    this.e = new r(2048);
    this.l = -1;
    this.k = -1L;
    this.f = new r(10);
    this.g = new q(this.f.a);
  }

  private static int a(int paramInt, long paramLong)
  {
    return (int)(1000000L * (paramInt * 8) / paramLong);
  }

  private o a(long paramLong)
  {
    int i1 = a(this.l, this.d.c());
    return new c(paramLong, this.k, i1, this.l);
  }

  private void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.o)
      return;
    int i1;
    label22: i locali;
    if ((paramBoolean1) && (this.l > 0))
    {
      i1 = 1;
      if ((i1 != 0) && (this.d.c() == -9223372036854775807L) && (!paramBoolean2))
        break label99;
      locali = (i)a.a(this.i);
      if ((i1 == 0) || (this.d.c() == -9223372036854775807L))
        break label101;
      locali.a(a(paramLong));
    }
    while (true)
    {
      this.o = true;
      return;
      i1 = 0;
      break label22;
      label99: break;
      label101: locali.a(new o.b(-9223372036854775807L));
    }
  }

  private int b(h paramh)
    throws IOException, InterruptedException
  {
    int i1 = 0;
    while (true)
    {
      paramh.c(this.f.a, 0, 10);
      this.f.c(0);
      if (this.f.l() != b)
      {
        paramh.a();
        paramh.c(i1);
        if (this.k == -1L)
          this.k = i1;
        return i1;
      }
      this.f.d(3);
      int i2 = this.f.u();
      i1 += i2 + 10;
      paramh.c(i2);
    }
  }

  private void c(h paramh)
    throws IOException, InterruptedException
  {
    long l1 = 0L;
    if (this.m)
      return;
    this.l = -1;
    paramh.a();
    if (paramh.c() == l1)
      b(paramh);
    int i1 = 0;
    if (paramh.b(this.f.a, 0, 2, true))
    {
      this.f.c(0);
      if (!f.a(this.f.i()))
        i1 = 0;
    }
    else
    {
      label84: paramh.a();
      if (i1 <= 0)
        break label207;
    }
    label207: for (this.l = ((int)(l1 / i1)); ; this.l = -1)
    {
      this.m = true;
      return;
      if (!paramh.b(this.f.a, 0, 4, true))
        break label84;
      this.g.a(14);
      int i2 = this.g.c(13);
      if (i2 <= 6)
      {
        this.m = true;
        throw new w("Malformed ADTS stream");
      }
      l1 += i2;
      i1++;
      if (i1 == 1000)
        break label84;
      if (paramh.b(i2 - 6, true))
        break;
      break label84;
    }
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    long l1 = paramh.d();
    boolean bool1;
    int i1;
    if (((0x1 & this.c) != 0) && (l1 != -1L))
    {
      bool1 = true;
      if (bool1)
        c(paramh);
      i1 = paramh.a(this.e.a, 0, 2048);
      if (i1 != -1)
        break label87;
    }
    label87: for (boolean bool2 = true; ; bool2 = false)
    {
      a(l1, bool1, bool2);
      if (!bool2)
        break label93;
      return -1;
      bool1 = false;
      break;
    }
    label93: this.e.c(0);
    this.e.b(i1);
    if (!this.n)
    {
      this.d.a(this.j, 4);
      this.n = true;
    }
    this.d.a(this.e);
    return 0;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.n = false;
    this.d.a();
    this.j = (paramLong2 + this.h);
  }

  public void a(i parami)
  {
    this.i = parami;
    this.d.a(parami, new ae.d(0, 1));
    parami.a();
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    int i1 = b(paramh);
    int i2 = 0;
    int i3 = 0;
    int i4 = i1;
    while (true)
    {
      paramh.c(this.f.a, 0, 2);
      this.f.c(0);
      if (!f.a(this.f.i()))
      {
        paramh.a();
        i4++;
        if (i4 - i1 < 8192);
      }
      int i5;
      do
      {
        return false;
        paramh.c(i4);
        i2 = 0;
        i3 = 0;
        break;
        i2++;
        if ((i2 >= 4) && (i3 > 188))
          return true;
        paramh.c(this.f.a, 0, 4);
        this.g.a(14);
        i5 = this.g.c(13);
      }
      while (i5 <= 6);
      paramh.c(i5 - 6);
      i3 += i5;
    }
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.d
 * JD-Core Version:    0.6.2
 */