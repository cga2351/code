package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

public final class n
  implements j
{
  private final r a = new r(10);
  private q b;
  private boolean c;
  private long d;
  private int e;
  private int f;

  public void a()
  {
    this.c = false;
  }

  public void a(long paramLong, int paramInt)
  {
    if ((paramInt & 0x4) == 0)
      return;
    this.c = true;
    this.d = paramLong;
    this.e = 0;
    this.f = 0;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.b = parami.a(paramd.b(), 4);
    this.b.a(Format.createSampleFormat(paramd.c(), "application/id3", null, -1, null));
  }

  public void a(r paramr)
  {
    if (!this.c)
      return;
    int i = paramr.b();
    if (this.f < 10)
    {
      int k = Math.min(i, 10 - this.f);
      System.arraycopy(paramr.a, paramr.d(), this.a.a, this.f, k);
      if (k + this.f == 10)
      {
        this.a.c(0);
        if ((73 != this.a.h()) || (68 != this.a.h()) || (51 != this.a.h()))
        {
          l.c("Id3Reader", "Discarding invalid ID3 tag");
          this.c = false;
          return;
        }
        this.a.d(3);
        this.e = (10 + this.a.u());
      }
    }
    int j = Math.min(i, this.e - this.f);
    this.b.a(paramr, j);
    this.f = (j + this.f);
  }

  public void b()
  {
    if ((!this.c) || (this.e == 0) || (this.f != this.e))
      return;
    this.b.a(this.d, 1, this.e, 0, null);
    this.c = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.n
 * JD-Core Version:    0.6.2
 */