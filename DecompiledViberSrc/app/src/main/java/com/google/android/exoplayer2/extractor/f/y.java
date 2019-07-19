package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.a.g;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.r;
import java.util.List;

final class y
{
  private final List<Format> a;
  private final q[] b;

  public y(List<Format> paramList)
  {
    this.a = paramList;
    this.b = new q[paramList.size()];
  }

  public void a(long paramLong, r paramr)
  {
    g.a(paramLong, paramr, this.b);
  }

  public void a(i parami, ae.d paramd)
  {
    int i = 0;
    if (i < this.b.length)
    {
      paramd.a();
      q localq = parami.a(paramd.b(), 3);
      Format localFormat = (Format)this.a.get(i);
      String str1 = localFormat.sampleMimeType;
      boolean bool;
      if (("application/cea-608".equals(str1)) || ("application/cea-708".equals(str1)))
      {
        bool = true;
        label73: a.a(bool, "Invalid closed caption mime type provided: " + str1);
        if (localFormat.id == null)
          break label173;
      }
      label173: for (String str2 = localFormat.id; ; str2 = paramd.c())
      {
        localq.a(Format.createTextSampleFormat(str2, str1, null, -1, localFormat.selectionFlags, localFormat.language, localFormat.accessibilityChannel, null, 9223372036854775807L, localFormat.initializationData));
        this.b[i] = localq;
        i++;
        break;
        bool = false;
        break label73;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.y
 * JD-Core Version:    0.6.2
 */