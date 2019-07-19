package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.a;
import com.google.android.exoplayer2.extractor.a.b;
import com.google.android.exoplayer2.extractor.a.c;
import com.google.android.exoplayer2.extractor.a.f;
import com.google.android.exoplayer2.extractor.a.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class aa extends a
{
  public aa(ad paramad, long paramLong1, long paramLong2, int paramInt)
  {
    super(new a.b(), new a(paramInt, paramad), paramLong1, 0L, paramLong1 + 1L, 0L, paramLong2, 188L, 940);
  }

  private static final class a
    implements a.g
  {
    private final ad a;
    private final r b;
    private final int c;

    public a(int paramInt, ad paramad)
    {
      this.c = paramInt;
      this.a = paramad;
      this.b = new r();
    }

    private a.f a(r paramr, long paramLong1, long paramLong2)
    {
      int i = paramr.c();
      long l1 = -1L;
      long l2 = -1L;
      long l3 = -9223372036854775807L;
      while (true)
      {
        int j;
        int k;
        if (paramr.b() >= 188)
        {
          j = af.a(paramr.a, paramr.d(), i);
          k = j + 188;
          if (k <= i);
        }
        else
        {
          if (l3 == -9223372036854775807L)
            break;
          return a.f.b(l3, l2 + paramLong2);
        }
        long l4 = af.a(paramr, j, this.c);
        if (l4 != -9223372036854775807L)
        {
          long l5 = this.a.b(l4);
          if (l5 > paramLong1)
          {
            if (l3 == -9223372036854775807L)
              return a.f.a(l5, paramLong2);
            return a.f.a(paramLong2 + l1);
          }
          if (100000L + l5 > paramLong1)
            return a.f.a(paramLong2 + j);
          l1 = j;
          l3 = l5;
        }
        paramr.c(k);
        l2 = k;
      }
      return a.f.a;
    }

    public a.f a(h paramh, long paramLong, a.c paramc)
      throws IOException, InterruptedException
    {
      long l = paramh.c();
      int i = (int)Math.min(112800L, paramh.d() - l);
      this.b.a(i);
      paramh.c(this.b.a, 0, i);
      return a(this.b, paramLong, l);
    }

    public void a()
    {
      this.b.a(ag.f);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.aa
 * JD-Core Version:    0.6.2
 */