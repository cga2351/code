package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.a.g;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.r;
import java.util.List;

final class ag
{
  private final List<Format> a;
  private final q[] b;

  public ag(List<Format> paramList)
  {
    this.a = paramList;
    this.b = new q[paramList.size()];
  }

  public void a(long paramLong, r paramr)
  {
    if (paramr.b() < 9);
    int i;
    int j;
    int k;
    do
    {
      return;
      i = paramr.p();
      j = paramr.p();
      k = paramr.h();
    }
    while ((i != 434) || (j != g.a) || (k != 3));
    g.b(paramLong, paramr, this.b);
  }

  public void a(i parami, ae.d paramd)
  {
    int i = 0;
    if (i < this.b.length)
    {
      paramd.a();
      q localq = parami.a(paramd.b(), 3);
      Format localFormat = (Format)this.a.get(i);
      String str = localFormat.sampleMimeType;
      if (("application/cea-608".equals(str)) || ("application/cea-708".equals(str)));
      for (boolean bool = true; ; bool = false)
      {
        a.a(bool, "Invalid closed caption mime type provided: " + str);
        localq.a(Format.createTextSampleFormat(paramd.c(), str, null, -1, localFormat.selectionFlags, localFormat.language, localFormat.accessibilityChannel, null, 9223372036854775807L, localFormat.initializationData));
        this.b[i] = localq;
        i++;
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.ag
 * JD-Core Version:    0.6.2
 */