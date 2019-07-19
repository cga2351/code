package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;

public final class p
  implements j
{
  private final r a = new r(4);
  private final m b;
  private final String c;
  private String d;
  private q e;
  private int f = 0;
  private int g;
  private boolean h;
  private boolean i;
  private long j;
  private int k;
  private long l;

  public p()
  {
    this(null);
  }

  public p(String paramString)
  {
    this.a.a[0] = -1;
    this.b = new m();
    this.c = paramString;
  }

  private void b(r paramr)
  {
    byte[] arrayOfByte = paramr.a;
    int m = paramr.d();
    int n = paramr.c();
    label121: label127: for (int i1 = m; i1 < n; i1++)
    {
      boolean bool;
      if ((0xFF & arrayOfByte[i1]) == 255)
      {
        bool = true;
        if ((!this.i) || ((0xE0 & arrayOfByte[i1]) != 224))
          break label121;
      }
      for (int i2 = 1; ; i2 = 0)
      {
        this.i = bool;
        if (i2 == 0)
          break label127;
        paramr.c(i1 + 1);
        this.i = false;
        this.a.a[1] = arrayOfByte[i1];
        this.g = 2;
        this.f = 1;
        return;
        bool = false;
        break;
      }
    }
    paramr.c(n);
  }

  private void c(r paramr)
  {
    int m = Math.min(paramr.b(), 4 - this.g);
    paramr.a(this.a.a, this.g, m);
    this.g = (m + this.g);
    if (this.g < 4)
      return;
    this.a.c(0);
    if (!m.a(this.a.p(), this.b))
    {
      this.g = 0;
      this.f = 1;
      return;
    }
    this.k = this.b.c;
    if (!this.h)
    {
      this.j = (1000000L * this.b.g / this.b.d);
      Format localFormat = Format.createAudioSampleFormat(this.d, this.b.b, null, -1, 4096, this.b.e, this.b.d, null, null, 0, this.c);
      this.e.a(localFormat);
      this.h = true;
    }
    this.a.c(0);
    this.e.a(this.a, 4);
    this.f = 2;
  }

  private void d(r paramr)
  {
    int m = Math.min(paramr.b(), this.k - this.g);
    this.e.a(paramr, m);
    this.g = (m + this.g);
    if (this.g < this.k)
      return;
    this.e.a(this.l, 1, this.k, 0, null);
    this.l += this.j;
    this.g = 0;
    this.f = 0;
  }

  public void a()
  {
    this.f = 0;
    this.g = 0;
    this.i = false;
  }

  public void a(long paramLong, int paramInt)
  {
    this.l = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.d = paramd.c();
    this.e = parami.a(paramd.b(), 1);
  }

  public void a(r paramr)
  {
    while (paramr.b() > 0)
    {
      switch (this.f)
      {
      default:
        throw new IllegalStateException();
      case 0:
        b(paramr);
        break;
      case 1:
        c(paramr);
        break;
      case 2:
      }
      d(paramr);
    }
  }

  public void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.p
 * JD-Core Version:    0.6.2
 */