package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;

public class c
  implements g
{
  public static final j a = d.a;
  private com.google.android.exoplayer2.extractor.i b;
  private i c;
  private boolean d;

  private static r a(r paramr)
  {
    paramr.c(0);
    return paramr;
  }

  private boolean b(com.google.android.exoplayer2.extractor.h paramh)
    throws IOException, InterruptedException
  {
    f localf = new f();
    if ((!localf.a(paramh, true)) || ((0x2 & localf.b) != 2))
      return false;
    int i = Math.min(localf.i, 8);
    r localr = new r(i);
    paramh.c(localr.a, 0, i);
    if (b.a(a(localr)))
      this.c = new b();
    while (true)
    {
      return true;
      if (k.a(a(localr)))
      {
        this.c = new k();
      }
      else
      {
        if (!h.a(a(localr)))
          break;
        this.c = new h();
      }
    }
  }

  public int a(com.google.android.exoplayer2.extractor.h paramh, n paramn)
    throws IOException, InterruptedException
  {
    if (this.c == null)
    {
      if (!b(paramh))
        throw new w("Failed to determine bitstream type");
      paramh.a();
    }
    if (!this.d)
    {
      q localq = this.b.a(0, 1);
      this.b.a();
      this.c.a(this.b, localq);
      this.d = true;
    }
    return this.c.a(paramh, paramn);
  }

  public void a(long paramLong1, long paramLong2)
  {
    if (this.c != null)
      this.c.a(paramLong1, paramLong2);
  }

  public void a(com.google.android.exoplayer2.extractor.i parami)
  {
    this.b = parami;
  }

  public boolean a(com.google.android.exoplayer2.extractor.h paramh)
    throws IOException, InterruptedException
  {
    try
    {
      boolean bool = b(paramh);
      return bool;
    }
    catch (w localw)
    {
    }
    return false;
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.c
 * JD-Core Version:    0.6.2
 */