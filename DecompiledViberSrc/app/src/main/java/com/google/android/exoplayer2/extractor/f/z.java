package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.r;

public final class z
  implements w
{
  private ad a;
  private q b;
  private boolean c;

  public void a(ad paramad, i parami, ae.d paramd)
  {
    this.a = paramad;
    paramd.a();
    this.b = parami.a(paramd.b(), 4);
    this.b.a(Format.createSampleFormat(paramd.c(), "application/x-scte35", null, -1, null));
  }

  public void a(r paramr)
  {
    if (!this.c)
    {
      if (this.a.c() == -9223372036854775807L)
        return;
      this.b.a(Format.createSampleFormat(null, "application/x-scte35", this.a.c()));
      this.c = true;
    }
    int i = paramr.b();
    this.b.a(paramr, i);
    this.b.a(this.a.b(), 1, i, 0, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.z
 * JD-Core Version:    0.6.2
 */