package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.EOFException;
import java.io.IOException;

final class f
{
  private static final int k = ag.g("OggS");
  public int a;
  public int b;
  public long c;
  public long d;
  public long e;
  public long f;
  public int g;
  public int h;
  public int i;
  public final int[] j = new int['ÿ'];
  private final r l = new r(255);

  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = 0;
    this.i = 0;
  }

  public boolean a(h paramh, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int m = 0;
    this.l.a();
    a();
    int n;
    if ((paramh.d() == -1L) || (paramh.d() - paramh.b() >= 27L))
    {
      n = 1;
      if ((n != 0) && (paramh.b(this.l.a, 0, 27, true)))
        break label94;
      if (!paramBoolean)
        break label86;
    }
    label86: label94: label123: 
    do
    {
      do
      {
        return false;
        n = 0;
        break;
        throw new EOFException();
        if (this.l.n() == k)
          break label123;
      }
      while (paramBoolean);
      throw new w("expected OggS capture pattern at begin of page");
      this.a = this.l.h();
      if (this.a == 0)
        break label155;
    }
    while (paramBoolean);
    throw new w("unsupported bit stream revision");
    label155: this.b = this.l.h();
    this.c = this.l.s();
    this.d = this.l.o();
    this.e = this.l.o();
    this.f = this.l.o();
    this.g = this.l.h();
    this.h = (27 + this.g);
    this.l.a();
    paramh.c(this.l.a, 0, this.g);
    while (m < this.g)
    {
      this.j[m] = this.l.h();
      this.i += this.j[m];
      m++;
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.f
 * JD-Core Version:    0.6.2
 */