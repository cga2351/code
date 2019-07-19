package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.video.a;
import com.google.android.exoplayer2.w;

final class f extends e
{
  private final r b = new r(p.a);
  private final r c = new r(4);
  private int d;
  private boolean e;
  private int f;

  public f(q paramq)
  {
    super(paramq);
  }

  protected void a(r paramr, long paramLong)
    throws w
  {
    int i = paramr.h();
    long l = paramLong + 1000L * paramr.m();
    if ((i == 0) && (!this.e))
    {
      localr = new r(new byte[paramr.b()]);
      paramr.a(localr.a, 0, paramr.b());
      locala = a.a(localr);
      this.d = locala.b;
      localFormat = Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, locala.c, locala.d, -1.0F, locala.a, -1, locala.e, null);
      this.a.a(localFormat);
      this.e = true;
    }
    while ((i != 1) || (!this.e))
    {
      r localr;
      a locala;
      Format localFormat;
      return;
    }
    byte[] arrayOfByte = this.c.a;
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    arrayOfByte[2] = 0;
    int j = 4 - this.d;
    int n;
    int i1;
    for (int k = 0; paramr.b() > 0; k = i1 + n)
    {
      paramr.a(this.c.a, j, this.d);
      this.c.c(0);
      n = this.c.v();
      this.b.c(0);
      this.a.a(this.b, 4);
      i1 = k + 4;
      this.a.a(paramr, n);
    }
    q localq = this.a;
    if (this.f == 1);
    for (int m = 1; ; m = 0)
    {
      localq.a(l, m, k, 0, null);
      return;
    }
  }

  protected boolean a(r paramr)
    throws e.a
  {
    int i = paramr.h();
    int j = 0xF & i >> 4;
    int k = i & 0xF;
    if (k != 7)
      throw new e.a("Video format not supported: " + k);
    this.f = j;
    return j != 5;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.b.f
 * JD-Core Version:    0.6.2
 */