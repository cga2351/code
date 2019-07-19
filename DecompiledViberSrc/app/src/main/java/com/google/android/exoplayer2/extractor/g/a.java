package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.w;
import java.io.IOException;

public final class a
  implements g
{
  public static final j a = b.a;
  private i b;
  private q c;
  private c d;
  private int e;
  private int f;

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    if (this.d == null)
    {
      this.d = d.a(paramh);
      if (this.d == null)
        throw new w("Unsupported or unrecognized wav header.");
      Format localFormat = Format.createAudioSampleFormat(null, "audio/raw", null, this.d.f(), 32768, this.d.h(), this.d.g(), this.d.i(), null, null, 0, null);
      this.c.a(localFormat);
      this.e = this.d.e();
    }
    if (!this.d.d())
    {
      d.a(paramh, this.d);
      this.b.a(this.d);
    }
    long l1 = this.d.c();
    if (l1 != -1L);
    long l2;
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.b(bool);
      l2 = l1 - paramh.c();
      if (l2 > 0L)
        break;
      return -1;
    }
    int i = (int)Math.min(32768 - this.f, l2);
    int j = this.c.a(paramh, i, true);
    if (j != -1)
      this.f = (j + this.f);
    int k = this.f / this.e;
    if (k > 0)
    {
      long l3 = this.d.b(paramh.c() - this.f);
      int m = k * this.e;
      this.f -= m;
      this.c.a(l3, 1, m, this.f, null);
    }
    if (j == -1)
      return -1;
    return 0;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.f = 0;
  }

  public void a(i parami)
  {
    this.b = parami;
    this.c = parami.a(0, 1);
    this.d = null;
    parami.a();
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    return d.a(paramh) != null;
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.g.a
 * JD-Core Version:    0.6.2
 */