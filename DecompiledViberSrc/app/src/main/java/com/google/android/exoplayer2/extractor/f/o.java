package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.Collections;

public final class o
  implements j
{
  private final String a;
  private final r b;
  private final com.google.android.exoplayer2.g.q c;
  private com.google.android.exoplayer2.extractor.q d;
  private Format e;
  private String f;
  private int g;
  private int h;
  private int i;
  private int j;
  private long k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private boolean p;
  private long q;
  private int r;
  private long s;
  private int t;

  public o(String paramString)
  {
    this.a = paramString;
    this.b = new r(1024);
    this.c = new com.google.android.exoplayer2.g.q(this.b.a);
  }

  private void a(int paramInt)
  {
    this.b.a(paramInt);
    this.c.a(this.b.a);
  }

  private void a(com.google.android.exoplayer2.g.q paramq)
    throws w
  {
    if (!paramq.e())
    {
      this.l = true;
      b(paramq);
    }
    while (this.m == 0)
      if (this.n != 0)
      {
        throw new w();
        if (this.l)
          break;
      }
      else
      {
        do
        {
          return;
          a(paramq, e(paramq));
        }
        while (!this.p);
        paramq.b((int)this.q);
        return;
      }
    throw new w();
  }

  private void a(com.google.android.exoplayer2.g.q paramq, int paramInt)
  {
    int i1 = paramq.b();
    if ((i1 & 0x7) == 0)
      this.b.c(i1 >> 3);
    while (true)
    {
      this.d.a(this.b, paramInt);
      this.d.a(this.k, 1, paramInt, 0, null);
      this.k += this.s;
      return;
      paramq.a(this.b.a, 0, paramInt * 8);
      this.b.c(0);
    }
  }

  private void b(com.google.android.exoplayer2.g.q paramq)
    throws w
  {
    int i1 = paramq.c(1);
    if (i1 == 1);
    for (int i2 = paramq.c(1); ; i2 = 0)
    {
      this.m = i2;
      if (this.m != 0)
        break label324;
      if (i1 == 1)
        f(paramq);
      if (paramq.e())
        break;
      throw new w();
    }
    this.n = paramq.c(6);
    int i3 = paramq.c(4);
    int i4 = paramq.c(3);
    if ((i3 != 0) || (i4 != 0))
      throw new w();
    if (i1 == 0)
    {
      int i5 = paramq.b();
      int i6 = d(paramq);
      paramq.a(i5);
      byte[] arrayOfByte = new byte[(i6 + 7) / 8];
      paramq.a(arrayOfByte, 0, i6);
      Format localFormat = Format.createAudioSampleFormat(this.f, "audio/mp4a-latm", null, -1, -1, this.t, this.r, Collections.singletonList(arrayOfByte), null, 0, this.a);
      if (!localFormat.equals(this.e))
      {
        this.e = localFormat;
        this.s = (1024000000L / localFormat.sampleRate);
        this.d.a(localFormat);
      }
      c(paramq);
      this.p = paramq.e();
      this.q = 0L;
      if (this.p)
      {
        if (i1 != 1)
          break label291;
        this.q = f(paramq);
      }
    }
    while (true)
    {
      if (paramq.e())
        paramq.b(8);
      return;
      paramq.b((int)f(paramq) - d(paramq));
      break;
      label291: boolean bool;
      do
      {
        bool = paramq.e();
        this.q = ((this.q << 8) + paramq.c(8));
      }
      while (bool);
    }
    label324: throw new w();
  }

  private void c(com.google.android.exoplayer2.g.q paramq)
  {
    this.o = paramq.c(3);
    switch (this.o)
    {
    case 2:
    default:
      throw new IllegalStateException();
    case 0:
      paramq.b(8);
      return;
    case 1:
      paramq.b(9);
      return;
    case 3:
    case 4:
    case 5:
      paramq.b(6);
      return;
    case 6:
    case 7:
    }
    paramq.b(1);
  }

  private int d(com.google.android.exoplayer2.g.q paramq)
    throws w
  {
    int i1 = paramq.a();
    Pair localPair = c.a(paramq, true);
    this.r = ((Integer)localPair.first).intValue();
    this.t = ((Integer)localPair.second).intValue();
    return i1 - paramq.a();
  }

  private int e(com.google.android.exoplayer2.g.q paramq)
    throws w
  {
    int i1 = this.o;
    int i2 = 0;
    if (i1 == 0)
    {
      int i3;
      do
      {
        i3 = paramq.c(8);
        i2 += i3;
      }
      while (i3 == 255);
      return i2;
    }
    throw new w();
  }

  private static long f(com.google.android.exoplayer2.g.q paramq)
  {
    return paramq.c(8 * (1 + paramq.c(2)));
  }

  public void a()
  {
    this.g = 0;
    this.l = false;
  }

  public void a(long paramLong, int paramInt)
  {
    this.k = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.d = parami.a(paramd.b(), 1);
    this.f = paramd.c();
  }

  public void a(r paramr)
    throws w
  {
    while (paramr.b() > 0)
    {
      switch (this.g)
      {
      default:
        throw new IllegalStateException();
      case 0:
        if (paramr.h() != 86)
          continue;
        this.g = 1;
        break;
      case 1:
        int i2 = paramr.h();
        if ((i2 & 0xE0) == 224)
        {
          this.j = i2;
          this.g = 2;
          continue;
        }
        if (i2 == 86)
          continue;
        this.g = 0;
        break;
      case 2:
        this.i = ((0xFFFFFF1F & this.j) << 8 | paramr.h());
        if (this.i > this.b.a.length)
          a(this.i);
        this.h = 0;
        this.g = 3;
        break;
      case 3:
      }
      int i1 = Math.min(paramr.b(), this.i - this.h);
      paramr.a(this.c.a, this.h, i1);
      this.h = (i1 + this.h);
      if (this.h == this.i)
      {
        this.c.a(0);
        a(this.c);
        this.g = 0;
      }
    }
  }

  public void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.o
 * JD-Core Version:    0.6.2
 */