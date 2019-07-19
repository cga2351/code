package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;

public final class u
  implements g
{
  public static final com.google.android.exoplayer2.extractor.j a = v.a;
  private final ad b;
  private final SparseArray<a> c;
  private final r d;
  private final t e;
  private boolean f;
  private boolean g;
  private boolean h;
  private long i;
  private s j;
  private i k;
  private boolean l;

  public u()
  {
    this(new ad(0L));
  }

  public u(ad paramad)
  {
    this.b = paramad;
    this.d = new r(4096);
    this.c = new SparseArray();
    this.e = new t();
  }

  private void a(long paramLong)
  {
    if (!this.l)
    {
      this.l = true;
      if (this.e.c() != -9223372036854775807L)
      {
        this.j = new s(this.e.b(), this.e.c(), paramLong);
        this.k.a(this.j.a());
      }
    }
    else
    {
      return;
    }
    this.k.a(new o.b(this.e.c()));
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    int m = -1;
    long l1 = paramh.d();
    int n;
    if (l1 != -1L)
    {
      n = 1;
      if ((n == 0) || (this.e.a()))
        break label55;
      m = this.e.a(paramh, paramn);
    }
    label55: int i1;
    label237: 
    while (true)
    {
      return m;
      n = 0;
      break;
      a(l1);
      if ((this.j != null) && (this.j.b()))
        return this.j.a(paramh, paramn, null);
      paramh.a();
      if (l1 != -1L);
      for (long l2 = l1 - paramh.b(); ; l2 = -1L)
      {
        if (((l2 != -1L) && (l2 < 4L)) || (!paramh.b(this.d.a, 0, 4, true)))
          break label237;
        this.d.c(0);
        i1 = this.d.p();
        if (i1 == 441)
          break;
        if (i1 != 442)
          break label239;
        paramh.c(this.d.a, 0, 10);
        this.d.c(9);
        paramh.b(14 + (0x7 & this.d.h()));
        return 0;
      }
    }
    label239: if (i1 == 443)
    {
      paramh.c(this.d.a, 0, 2);
      this.d.c(0);
      paramh.b(6 + this.d.i());
      return 0;
    }
    if ((i1 & 0xFFFFFF00) >> 8 != 1)
    {
      paramh.b(1);
      return 0;
    }
    int i2 = i1 & 0xFF;
    a locala = (a)this.c.get(i2);
    Object localObject;
    long l3;
    if (!this.f)
    {
      if (locala == null)
      {
        if (i2 != 189)
          break label534;
        localObject = new c();
        this.g = true;
        this.i = paramh.c();
        if (localObject != null)
        {
          ae.d locald = new ae.d(i2, 256);
          ((j)localObject).a(this.k, locald);
          locala = new a((j)localObject, this.b);
          this.c.put(i2, locala);
        }
      }
      if ((!this.g) || (!this.h))
        break label619;
      l3 = 8192L + this.i;
      label458: if (paramh.c() > l3)
      {
        this.f = true;
        this.k.a();
      }
    }
    paramh.c(this.d.a, 0, 2);
    this.d.c(0);
    int i3 = 6 + this.d.i();
    if (locala == null)
      paramh.b(i3);
    while (true)
    {
      return 0;
      label534: if ((i2 & 0xE0) == 192)
      {
        localObject = new p();
        this.g = true;
        this.i = paramh.c();
        break;
      }
      int i4 = i2 & 0xF0;
      localObject = null;
      if (i4 != 224)
        break;
      localObject = new k();
      this.h = true;
      this.i = paramh.c();
      break;
      label619: l3 = 1048576L;
      break label458;
      this.d.a(i3);
      paramh.b(this.d.a, 0, i3);
      this.d.c(6);
      locala.a(this.d);
      this.d.b(this.d.e());
    }
  }

  public void a(long paramLong1, long paramLong2)
  {
    if (this.b.c() == -9223372036854775807L);
    for (int m = 1; ; m = 0)
    {
      if ((m != 0) || ((this.b.a() != 0L) && (this.b.a() != paramLong2)))
      {
        this.b.d();
        this.b.a(paramLong2);
      }
      if (this.j != null)
        this.j.a(paramLong2);
      for (int n = 0; n < this.c.size(); n++)
        ((a)this.c.valueAt(n)).a();
    }
  }

  public void a(i parami)
  {
    this.k = parami;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    int m = 1;
    byte[] arrayOfByte = new byte[14];
    paramh.c(arrayOfByte, 0, 14);
    if (442 != ((0xFF & arrayOfByte[0]) << 24 | (0xFF & arrayOfByte[m]) << 16 | (0xFF & arrayOfByte[2]) << 8 | 0xFF & arrayOfByte[3]));
    while (((0xC4 & arrayOfByte[4]) != 68) || ((0x4 & arrayOfByte[6]) != 4) || ((0x4 & arrayOfByte[8]) != 4) || ((0x1 & arrayOfByte[9]) != m) || ((0x3 & arrayOfByte[12]) != 3))
      return false;
    paramh.c(0x7 & arrayOfByte[13]);
    paramh.c(arrayOfByte, 0, 3);
    if (m == ((0xFF & arrayOfByte[0]) << 16 | (0xFF & arrayOfByte[m]) << 8 | 0xFF & arrayOfByte[2]));
    while (true)
    {
      return m;
      int n = 0;
    }
  }

  public void c()
  {
  }

  private static final class a
  {
    private final j a;
    private final ad b;
    private final q c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private long h;

    public a(j paramj, ad paramad)
    {
      this.a = paramj;
      this.b = paramad;
      this.c = new q(new byte[64]);
    }

    private void b()
    {
      this.c.b(8);
      this.d = this.c.e();
      this.e = this.c.e();
      this.c.b(6);
      this.g = this.c.c(8);
    }

    private void c()
    {
      this.h = 0L;
      if (this.d)
      {
        this.c.b(4);
        long l1 = this.c.c(3) << 30;
        this.c.b(1);
        long l2 = l1 | this.c.c(15) << 15;
        this.c.b(1);
        long l3 = l2 | this.c.c(15);
        this.c.b(1);
        if ((!this.f) && (this.e))
        {
          this.c.b(4);
          long l4 = this.c.c(3) << 30;
          this.c.b(1);
          long l5 = l4 | this.c.c(15) << 15;
          this.c.b(1);
          long l6 = l5 | this.c.c(15);
          this.c.b(1);
          this.b.b(l6);
          this.f = true;
        }
        this.h = this.b.b(l3);
      }
    }

    public void a()
    {
      this.f = false;
      this.a.a();
    }

    public void a(r paramr)
      throws w
    {
      paramr.a(this.c.a, 0, 3);
      this.c.a(0);
      b();
      paramr.a(this.c.a, 0, this.g);
      this.c.a(0);
      c();
      this.a.a(this.h, 4);
      this.a.a(paramr);
      this.a.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.u
 * JD-Core Version:    0.6.2
 */