package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class n
{
  public c a;
  public long b;
  public long c;
  public long d;
  public int e;
  public int f;
  public long[] g;
  public int[] h;
  public int[] i;
  public int[] j;
  public long[] k;
  public boolean[] l;
  public boolean m;
  public boolean[] n;
  public m o;
  public int p;
  public r q;
  public boolean r;
  public long s;

  public void a()
  {
    this.e = 0;
    this.s = 0L;
    this.m = false;
    this.r = false;
    this.o = null;
  }

  public void a(int paramInt)
  {
    if ((this.q == null) || (this.q.c() < paramInt))
      this.q = new r(paramInt);
    this.p = paramInt;
    this.m = true;
    this.r = true;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if ((this.h == null) || (this.h.length < paramInt1))
    {
      this.g = new long[paramInt1];
      this.h = new int[paramInt1];
    }
    if ((this.i == null) || (this.i.length < paramInt2))
    {
      int i1 = paramInt2 * 125 / 100;
      this.i = new int[i1];
      this.j = new int[i1];
      this.k = new long[i1];
      this.l = new boolean[i1];
      this.n = new boolean[i1];
    }
  }

  public void a(h paramh)
    throws IOException, InterruptedException
  {
    paramh.b(this.q.a, 0, this.p);
    this.q.c(0);
    this.r = false;
  }

  public void a(r paramr)
  {
    paramr.a(this.q.a, 0, this.p);
    this.q.c(0);
    this.r = false;
  }

  public long b(int paramInt)
  {
    return this.k[paramInt] + this.j[paramInt];
  }

  public boolean c(int paramInt)
  {
    return (this.m) && (this.n[paramInt] != 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.n
 * JD-Core Version:    0.6.2
 */