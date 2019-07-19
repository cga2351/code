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

final class s extends a
{
  public s(ad paramad, long paramLong1, long paramLong2)
  {
    super(new a.b(), new a(paramad, null), paramLong1, 0L, paramLong1 + 1L, 0L, paramLong2, 188L, 1000);
  }

  private static int b(byte[] paramArrayOfByte, int paramInt)
  {
    return (0xFF & paramArrayOfByte[paramInt]) << 24 | (0xFF & paramArrayOfByte[(paramInt + 1)]) << 16 | (0xFF & paramArrayOfByte[(paramInt + 2)]) << 8 | 0xFF & paramArrayOfByte[(paramInt + 3)];
  }

  private static final class a
    implements a.g
  {
    private final ad a;
    private final r b;

    private a(ad paramad)
    {
      this.a = paramad;
      this.b = new r();
    }

    private a.f a(r paramr, long paramLong1, long paramLong2)
    {
      int i = -1;
      int j = -1;
      long l1 = -9223372036854775807L;
      while (paramr.b() >= 4)
        if (s.a(paramr.a, paramr.d()) != 442)
        {
          paramr.d(1);
        }
        else
        {
          paramr.d(4);
          long l2 = t.a(paramr);
          if (l2 != -9223372036854775807L)
          {
            long l3 = this.a.b(l2);
            if (l3 > paramLong1)
            {
              if (l1 == -9223372036854775807L)
                return a.f.a(l3, paramLong2);
              return a.f.a(paramLong2 + j);
            }
            if (100000L + l3 > paramLong1)
              return a.f.a(paramLong2 + paramr.d());
            j = paramr.d();
            l1 = l3;
          }
          a(paramr);
          i = paramr.d();
        }
      if (l1 != -9223372036854775807L)
        return a.f.b(l1, paramLong2 + i);
      return a.f.a;
    }

    private static void a(r paramr)
    {
      int i = paramr.c();
      if (paramr.b() < 10)
        paramr.c(i);
      label202: 
      while (true)
      {
        return;
        paramr.d(9);
        int j = 0x7 & paramr.h();
        if (paramr.b() < j)
        {
          paramr.c(i);
          return;
        }
        paramr.d(j);
        if (paramr.b() < 4)
        {
          paramr.c(i);
          return;
        }
        if (s.a(paramr.a, paramr.d()) == 443)
        {
          paramr.d(4);
          int n = paramr.i();
          if (paramr.b() < n)
          {
            paramr.c(i);
            return;
          }
          paramr.d(n);
        }
        while (true)
        {
          if (paramr.b() < 4)
            break label202;
          int k = s.a(paramr.a, paramr.d());
          if ((k == 442) || (k == 441) || (k >>> 8 != 1))
            break;
          paramr.d(4);
          if (paramr.b() < 2)
          {
            paramr.c(i);
            return;
          }
          int m = paramr.i();
          paramr.c(Math.min(paramr.c(), m + paramr.d()));
        }
      }
    }

    public a.f a(h paramh, long paramLong, a.c paramc)
      throws IOException, InterruptedException
    {
      long l = paramh.c();
      int i = (int)Math.min(20000L, paramh.d() - l);
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
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.s
 * JD-Core Version:    0.6.2
 */