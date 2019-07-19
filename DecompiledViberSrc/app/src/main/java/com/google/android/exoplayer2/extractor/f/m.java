package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.g.s;
import java.util.Collections;

public final class m
  implements j
{
  private final y a;
  private String b;
  private com.google.android.exoplayer2.extractor.q c;
  private a d;
  private boolean e;
  private final boolean[] f;
  private final q g;
  private final q h;
  private final q i;
  private final q j;
  private final q k;
  private long l;
  private long m;
  private final r n;

  public m(y paramy)
  {
    this.a = paramy;
    this.f = new boolean[3];
    this.g = new q(32, 128);
    this.h = new q(33, 128);
    this.i = new q(34, 128);
    this.j = new q(39, 128);
    this.k = new q(40, 128);
    this.n = new r();
  }

  private static Format a(String paramString, q paramq1, q paramq2, q paramq3)
  {
    byte[] arrayOfByte = new byte[paramq1.b + paramq2.b + paramq3.b];
    System.arraycopy(paramq1.a, 0, arrayOfByte, 0, paramq1.b);
    System.arraycopy(paramq2.a, 0, arrayOfByte, paramq1.b, paramq2.b);
    System.arraycopy(paramq3.a, 0, arrayOfByte, paramq1.b + paramq2.b, paramq3.b);
    s locals = new s(paramq2.a, 0, paramq2.b);
    locals.a(44);
    int i1 = locals.c(3);
    locals.a();
    locals.a(88);
    locals.a(8);
    int i2 = 0;
    for (int i3 = 0; i3 < i1; i3++)
    {
      if (locals.b())
        i2 += 89;
      if (locals.b())
        i2 += 8;
    }
    locals.a(i2);
    if (i1 > 0)
      locals.a(2 * (8 - i1));
    locals.d();
    int i4 = locals.d();
    if (i4 == 3)
      locals.a();
    int i5 = locals.d();
    int i6 = locals.d();
    int i17;
    int i18;
    label289: int i7;
    int i8;
    if (locals.b())
    {
      int i13 = locals.d();
      int i14 = locals.d();
      int i15 = locals.d();
      int i16 = locals.d();
      if ((i4 == 1) || (i4 == 2))
      {
        i17 = 2;
        if (i4 != 1)
          break label382;
        i18 = 2;
        i5 -= i17 * (i13 + i14);
        i6 -= i18 * (i15 + i16);
      }
    }
    else
    {
      locals.d();
      locals.d();
      i7 = locals.d();
      if (!locals.b())
        break label388;
      i8 = 0;
    }
    while (true)
    {
      if (i8 > i1)
        break label395;
      locals.d();
      locals.d();
      locals.d();
      i8++;
      continue;
      i17 = 1;
      break;
      label382: i18 = 1;
      break label289;
      label388: i8 = i1;
    }
    label395: locals.d();
    locals.d();
    locals.d();
    locals.d();
    locals.d();
    locals.d();
    if ((locals.b()) && (locals.b()))
      a(locals);
    locals.a(2);
    if (locals.b())
    {
      locals.a(8);
      locals.d();
      locals.d();
      locals.a();
    }
    b(locals);
    if (locals.b())
      for (int i12 = 0; i12 < locals.d(); i12++)
        locals.a(1 + (i7 + 4));
    locals.a(2);
    float f1 = 1.0F;
    int i9;
    float f2;
    if ((locals.b()) && (locals.b()))
    {
      i9 = locals.c(8);
      if (i9 == 255)
      {
        int i10 = locals.c(16);
        int i11 = locals.c(16);
        if ((i10 != 0) && (i11 != 0))
          f1 = i10 / i11;
        f2 = f1;
      }
    }
    while (true)
    {
      return Format.createVideoSampleFormat(paramString, "video/hevc", null, -1, -1, i5, i6, -1.0F, Collections.singletonList(arrayOfByte), -1, f2, null);
      if (i9 < p.b.length)
      {
        f2 = p.b[i9];
      }
      else
      {
        l.c("H265Reader", "Unexpected aspect_ratio_idc value: " + i9);
        f2 = f1;
      }
    }
  }

  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if (this.e)
      this.d.a(paramLong1, paramInt1, paramInt2, paramLong2);
    while (true)
    {
      this.j.a(paramInt2);
      this.k.a(paramInt2);
      return;
      this.g.a(paramInt2);
      this.h.a(paramInt2);
      this.i.a(paramInt2);
    }
  }

  private static void a(s params)
  {
    for (int i1 = 0; i1 < 4; i1++)
    {
      int i2 = 0;
      if (i2 < 6)
      {
        if (!params.b())
        {
          params.d();
          label27: if (i1 != 3)
            break label86;
        }
        label86: for (int i5 = 3; ; i5 = 1)
        {
          i2 = i5 + i2;
          break;
          int i3 = Math.min(64, 1 << 4 + (i1 << 1));
          if (i1 > 1)
            params.e();
          for (int i4 = 0; i4 < i3; i4++)
            params.e();
          break label27;
        }
      }
    }
  }

  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.e)
      this.d.a(paramArrayOfByte, paramInt1, paramInt2);
    while (true)
    {
      this.j.a(paramArrayOfByte, paramInt1, paramInt2);
      this.k.a(paramArrayOfByte, paramInt1, paramInt2);
      return;
      this.g.a(paramArrayOfByte, paramInt1, paramInt2);
      this.h.a(paramArrayOfByte, paramInt1, paramInt2);
      this.i.a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  private void b(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    if (this.e)
      this.d.a(paramLong1, paramInt1);
    while (true)
    {
      if (this.j.b(paramInt2))
      {
        int i2 = p.a(this.j.a, this.j.b);
        this.n.a(this.j.a, i2);
        this.n.d(5);
        this.a.a(paramLong2, this.n);
      }
      if (this.k.b(paramInt2))
      {
        int i1 = p.a(this.k.a, this.k.b);
        this.n.a(this.k.a, i1);
        this.n.d(5);
        this.a.a(paramLong2, this.n);
      }
      return;
      this.g.b(paramInt2);
      this.h.b(paramInt2);
      this.i.b(paramInt2);
      if ((this.g.b()) && (this.h.b()) && (this.i.b()))
      {
        this.c.a(a(this.b, this.g, this.h, this.i));
        this.e = true;
      }
    }
  }

  private static void b(s params)
  {
    int i1 = params.d();
    int i2 = 0;
    int i3 = 0;
    boolean bool1 = false;
    if (i2 < i1)
      if (i2 == 0)
        break label146;
    label146: for (boolean bool2 = params.b(); ; bool2 = bool1)
    {
      if (bool2)
      {
        params.a();
        params.d();
        for (int i8 = 0; i8 <= i3; i8++)
          if (params.b())
            params.a();
      }
      int i4 = params.d();
      int i5 = params.d();
      i3 = i4 + i5;
      for (int i6 = 0; i6 < i4; i6++)
      {
        params.d();
        params.a();
      }
      for (int i7 = 0; i7 < i5; i7++)
      {
        params.d();
        params.a();
      }
      i2++;
      bool1 = bool2;
      break;
      return;
    }
  }

  public void a()
  {
    p.a(this.f);
    this.g.a();
    this.h.a();
    this.i.a();
    this.j.a();
    this.k.a();
    this.d.a();
    this.l = 0L;
  }

  public void a(long paramLong, int paramInt)
  {
    this.m = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.b = paramd.c();
    this.c = parami.a(paramd.b(), 2);
    this.d = new a(this.c);
    this.a.a(parami, paramd);
  }

  public void a(r paramr)
  {
    int i1;
    int i2;
    byte[] arrayOfByte;
    int i3;
    while (paramr.b() > 0)
    {
      i1 = paramr.d();
      i2 = paramr.c();
      arrayOfByte = paramr.a;
      this.l += paramr.b();
      this.c.a(paramr, paramr.b());
      if (i1 < i2)
      {
        i3 = p.a(arrayOfByte, i1, i2, this.f);
        if (i3 != i2)
          break label84;
        a(arrayOfByte, i1, i2);
      }
    }
    return;
    label84: int i4 = p.c(arrayOfByte, i3);
    int i5 = i3 - i1;
    if (i5 > 0)
      a(arrayOfByte, i1, i3);
    int i6 = i2 - i3;
    long l1 = this.l - i6;
    if (i5 < 0);
    for (int i7 = -i5; ; i7 = 0)
    {
      b(l1, i6, i7, this.m);
      a(l1, i6, i4, this.m);
      i1 = i3 + 3;
      break;
    }
  }

  public void b()
  {
  }

  private static final class a
  {
    private final com.google.android.exoplayer2.extractor.q a;
    private long b;
    private boolean c;
    private int d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private boolean m;

    public a(com.google.android.exoplayer2.extractor.q paramq)
    {
      this.a = paramq;
    }

    private void a(int paramInt)
    {
      if (this.m);
      for (int n = 1; ; n = 0)
      {
        int i1 = (int)(this.b - this.k);
        this.a.a(this.l, n, i1, paramInt, null);
        return;
      }
    }

    public void a()
    {
      this.f = false;
      this.g = false;
      this.h = false;
      this.i = false;
      this.j = false;
    }

    public void a(long paramLong, int paramInt)
    {
      if ((this.j) && (this.g))
      {
        this.m = this.c;
        this.j = false;
      }
      while ((!this.h) && (!this.g))
        return;
      if (this.i)
        a(paramInt + (int)(paramLong - this.b));
      this.k = this.b;
      this.l = this.e;
      this.i = true;
      this.m = this.c;
    }

    public void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
    {
      this.g = false;
      this.h = false;
      this.e = paramLong2;
      this.d = 0;
      this.b = paramLong1;
      boolean bool3;
      if (paramInt2 >= 32)
      {
        if ((!this.j) && (this.i))
        {
          a(paramInt1);
          this.i = false;
        }
        if (paramInt2 <= 34)
        {
          if (this.j)
            break label135;
          bool3 = true;
          this.h = bool3;
          this.j = true;
        }
      }
      if ((paramInt2 >= 16) && (paramInt2 <= 21));
      for (boolean bool1 = true; ; bool1 = false)
      {
        this.c = bool1;
        boolean bool2;
        if (!this.c)
        {
          bool2 = false;
          if (paramInt2 > 9);
        }
        else
        {
          bool2 = true;
        }
        this.f = bool2;
        return;
        label135: bool3 = false;
        break;
      }
    }

    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.f)
      {
        int n = paramInt1 + 2 - this.d;
        if (n >= paramInt2)
          break label55;
        if ((0x80 & paramArrayOfByte[n]) == 0)
          break label49;
      }
      label49: for (boolean bool = true; ; bool = false)
      {
        this.g = bool;
        this.f = false;
        return;
      }
      label55: this.d += paramInt2 - paramInt1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.m
 * JD-Core Version:    0.6.2
 */