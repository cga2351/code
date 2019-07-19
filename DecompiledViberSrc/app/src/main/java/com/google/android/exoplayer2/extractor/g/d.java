package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.b.ab;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;

final class d
{
  public static c a(h paramh)
    throws IOException, InterruptedException
  {
    a.a(paramh);
    r localr = new r(16);
    if (a.a(paramh, localr).a != ab.a)
      return null;
    paramh.c(localr.a, 0, 4);
    localr.c(0);
    int i = localr.p();
    if (i != ab.b)
    {
      l.d("WavHeaderReader", "Unsupported RIFF format: " + i);
      return null;
    }
    for (a locala = a.a(paramh, localr); locala.a != ab.c; locala = a.a(paramh, localr))
      paramh.c((int)locala.b);
    if (locala.b >= 16L);
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      paramh.c(localr.a, 0, 16);
      localr.c(0);
      j = localr.j();
      k = localr.j();
      m = localr.w();
      n = localr.w();
      i1 = localr.j();
      i2 = localr.j();
      int i3 = k * i2 / 8;
      if (i1 == i3)
        break;
      throw new w("Expected block alignment: " + i3 + "; got: " + i1);
    }
    int i4 = ab.a(j, i2);
    if (i4 == 0)
    {
      l.d("WavHeaderReader", "Unsupported WAV format: " + i2 + " bit/sample, type " + j);
      return null;
    }
    paramh.c(-16 + (int)locala.b);
    return new c(k, m, n, i1, i2, i4);
  }

  public static void a(h paramh, c paramc)
    throws IOException, InterruptedException
  {
    a.a(paramh);
    a.a(paramc);
    paramh.a();
    r localr = new r(8);
    for (a locala = a.a(paramh, localr); locala.a != ag.g("data"); locala = a.a(paramh, localr))
    {
      l.c("WavHeaderReader", "Ignoring unknown WAV chunk: " + locala.a);
      long l = 8L + locala.b;
      if (locala.a == ag.g("RIFF"))
        l = 12L;
      if (l > 2147483647L)
        throw new w("Chunk is too large (~2GB+) to skip; id: " + locala.a);
      paramh.b((int)l);
    }
    paramh.b(8);
    paramc.a(paramh.c(), locala.b);
  }

  private static final class a
  {
    public final int a;
    public final long b;

    private a(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }

    public static a a(h paramh, r paramr)
      throws IOException, InterruptedException
    {
      paramh.c(paramr.a, 0, 8);
      paramr.c(0);
      return new a(paramr.p(), paramr.o());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.g.d
 * JD-Core Version:    0.6.2
 */