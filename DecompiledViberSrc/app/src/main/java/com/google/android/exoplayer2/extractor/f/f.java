package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.Arrays;
import java.util.Collections;

public final class f
  implements j
{
  private static final byte[] a = { 73, 68, 51 };
  private final boolean b;
  private final com.google.android.exoplayer2.g.q c = new com.google.android.exoplayer2.g.q(new byte[7]);
  private final r d = new r(Arrays.copyOf(a, 10));
  private final String e;
  private String f;
  private com.google.android.exoplayer2.extractor.q g;
  private com.google.android.exoplayer2.extractor.q h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private long r;
  private int s;
  private long t;
  private com.google.android.exoplayer2.extractor.q u;
  private long v;

  public f(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }

  public f(boolean paramBoolean, String paramString)
  {
    e();
    this.n = -1;
    this.o = -1;
    this.r = -9223372036854775807L;
    this.b = paramBoolean;
    this.e = paramString;
  }

  private void a(com.google.android.exoplayer2.extractor.q paramq, long paramLong, int paramInt1, int paramInt2)
  {
    this.i = 4;
    this.j = paramInt1;
    this.u = paramq;
    this.v = paramLong;
    this.s = paramInt2;
  }

  private boolean a(byte paramByte1, byte paramByte2)
  {
    return a((paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF);
  }

  public static boolean a(int paramInt)
  {
    return (0xFFF6 & paramInt) == 65520;
  }

  private boolean a(r paramr, int paramInt)
  {
    int i1 = 1;
    paramr.c(paramInt + 1);
    if (!b(paramr, this.c.a, i1));
    int i3;
    int i4;
    do
    {
      do
      {
        do
        {
          return false;
          this.c.a(4);
          i3 = this.c.c(i1);
        }
        while ((this.n != -1) && (i3 != this.n));
        if (this.o == -1)
          break;
        if (!b(paramr, this.c.a, i1))
          return i1;
        this.c.a(2);
      }
      while (this.c.c(4) != this.o);
      paramr.c(paramInt + 2);
      if (!b(paramr, this.c.a, 4))
        return i1;
      this.c.a(14);
      i4 = this.c.c(13);
    }
    while (i4 <= 6);
    int i5 = i4 + paramInt;
    if (i5 + 1 >= paramr.c())
      return i1;
    if ((a(paramr.a[i5], paramr.a[(i5 + 1)])) && ((this.n == -1) || ((0x8 & paramr.a[(i5 + 1)]) >> 3 == i3)));
    while (true)
    {
      return i1;
      int i2 = 0;
    }
  }

  private boolean a(r paramr, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = Math.min(paramr.b(), paramInt - this.j);
    paramr.a(paramArrayOfByte, this.j, i1);
    this.j = (i1 + this.j);
    return this.j == paramInt;
  }

  private void b(r paramr)
  {
    byte[] arrayOfByte = paramr.a;
    int i1 = paramr.d();
    int i2 = paramr.c();
    while (true)
    {
      int i3;
      if (i1 < i2)
      {
        i3 = i1 + 1;
        int i4 = 0xFF & arrayOfByte[i1];
        if ((this.k == 512) && (a((byte)-1, (byte)i4)) && ((this.m) || (a(paramr, i3 - 2))))
        {
          this.p = ((i4 & 0x8) >> 3);
          boolean bool;
          if ((i4 & 0x1) == 0)
          {
            bool = true;
            this.l = bool;
            if (this.m)
              break label127;
            h();
          }
          while (true)
          {
            paramr.c(i3);
            return;
            bool = false;
            break;
            label127: g();
          }
        }
        switch (i4 | this.k)
        {
        default:
          if (this.k == 256)
            break label265;
          this.k = 256;
          i1 = i3 - 1;
          break;
        case 511:
          this.k = 512;
          i1 = i3;
          break;
        case 329:
          this.k = 768;
          i1 = i3;
          break;
        case 836:
          this.k = 1024;
          i1 = i3;
          break;
        case 1075:
          f();
          paramr.c(i3);
          return;
        }
      }
      else
      {
        paramr.c(i1);
        return;
        label265: i1 = i3;
      }
    }
  }

  private boolean b(r paramr, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramr.b() < paramInt)
      return false;
    paramr.a(paramArrayOfByte, 0, paramInt);
    return true;
  }

  private void c(r paramr)
  {
    if (paramr.b() == 0)
      return;
    this.c.a[0] = paramr.a[paramr.d()];
    this.c.a(2);
    int i1 = this.c.c(4);
    if ((this.o != -1) && (i1 != this.o))
    {
      d();
      return;
    }
    if (!this.m)
    {
      this.m = true;
      this.n = this.p;
      this.o = i1;
    }
    g();
  }

  private void d()
  {
    this.m = false;
    e();
  }

  private void d(r paramr)
  {
    int i1 = Math.min(paramr.b(), this.s - this.j);
    this.u.a(paramr, i1);
    this.j = (i1 + this.j);
    if (this.j == this.s)
    {
      this.u.a(this.t, 1, this.s, 0, null);
      this.t += this.v;
      e();
    }
  }

  private void e()
  {
    this.i = 0;
    this.j = 0;
    this.k = 256;
  }

  private void f()
  {
    this.i = 2;
    this.j = a.length;
    this.s = 0;
    this.d.c(0);
  }

  private void g()
  {
    this.i = 3;
    this.j = 0;
  }

  private void h()
  {
    this.i = 1;
    this.j = 0;
  }

  private void i()
  {
    this.h.a(this.d, 10);
    this.d.c(6);
    a(this.h, 0L, 10, 10 + this.d.u());
  }

  private void j()
    throws w
  {
    int i1 = 2;
    this.c.a(0);
    int i3;
    if (!this.q)
    {
      i3 = 1 + this.c.c(i1);
      if (i3 == i1)
        break label237;
      l.c("AdtsReader", "Detected audio object type: " + i3 + ", but assuming AAC LC.");
    }
    while (true)
    {
      this.c.b(5);
      int i4 = this.c.c(3);
      byte[] arrayOfByte = c.a(i1, this.o, i4);
      Pair localPair = c.a(arrayOfByte);
      Format localFormat = Format.createAudioSampleFormat(this.f, "audio/mp4a-latm", null, -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(arrayOfByte), null, 0, this.e);
      this.r = (1024000000L / localFormat.sampleRate);
      this.g.a(localFormat);
      this.q = true;
      while (true)
      {
        this.c.b(4);
        int i2 = -5 + (-2 + this.c.c(13));
        if (this.l)
          i2 -= 2;
        a(this.g, this.r, 0, i2);
        return;
        this.c.b(10);
      }
      label237: i1 = i3;
    }
  }

  public void a()
  {
    d();
  }

  public void a(long paramLong, int paramInt)
  {
    this.t = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.f = paramd.c();
    this.g = parami.a(paramd.b(), 1);
    if (this.b)
    {
      paramd.a();
      this.h = parami.a(paramd.b(), 4);
      this.h.a(Format.createSampleFormat(paramd.c(), "application/id3", null, -1, null));
      return;
    }
    this.h = new com.google.android.exoplayer2.extractor.f();
  }

  public void a(r paramr)
    throws w
  {
    while (paramr.b() > 0)
    {
      switch (this.i)
      {
      default:
        throw new IllegalStateException();
      case 0:
        b(paramr);
        break;
      case 2:
        if (!a(paramr, this.d.a, 10))
          continue;
        i();
        break;
      case 1:
        c(paramr);
        break;
      case 3:
        if (this.l);
        for (int i1 = 7; a(paramr, this.c.a, i1); i1 = 5)
        {
          j();
          break;
        }
      case 4:
      }
      d(paramr);
    }
  }

  public void b()
  {
  }

  public long c()
  {
    return this.r;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.f
 * JD-Core Version:    0.6.2
 */