package com.google.android.exoplayer2.source.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.c.a.d.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class h extends com.google.android.exoplayer2.source.b.d
{
  private static final AtomicInteger m = new AtomicInteger();
  private g A;
  private l B;
  private int C;
  private int D;
  private boolean E;
  private volatile boolean F;
  private boolean G;
  public final int j;
  public final int k;
  public final d.a l;
  private final com.google.android.exoplayer2.f.h n;
  private final com.google.android.exoplayer2.f.l o;
  private final boolean p;
  private final boolean q;
  private final boolean r;
  private final ad s;
  private final boolean t;
  private final f u;
  private final List<Format> v;
  private final DrmInitData w;
  private final g x;
  private final com.google.android.exoplayer2.metadata.id3.a y;
  private final r z;

  public h(f paramf, com.google.android.exoplayer2.f.h paramh, com.google.android.exoplayer2.f.l paraml1, com.google.android.exoplayer2.f.l paraml2, d.a parama, List<Format> paramList, int paramInt1, Object paramObject, long paramLong1, long paramLong2, long paramLong3, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, ad paramad, h paramh1, DrmInitData paramDrmInitData, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(a(paramh, paramArrayOfByte1, paramArrayOfByte2), paraml1, parama.b, paramInt1, paramObject, paramLong1, paramLong2, paramLong3);
    this.k = paramInt2;
    this.o = paraml2;
    this.l = parama;
    this.q = paramBoolean2;
    this.s = paramad;
    boolean bool1;
    boolean bool2;
    label139: g localg;
    if (paramArrayOfByte1 != null)
    {
      bool1 = true;
      this.p = bool1;
      this.r = paramBoolean1;
      this.u = paramf;
      this.v = paramList;
      this.w = paramDrmInitData;
      if (paramh1 == null)
        break label209;
      this.y = paramh1.y;
      this.z = paramh1.z;
      if ((paramh1.l == parama) && (paramh1.G))
        break label193;
      bool2 = true;
      this.t = bool2;
      if ((paramh1.k == paramInt2) && (!this.t))
        break label199;
      localg = null;
    }
    while (true)
    {
      this.x = localg;
      this.n = paramh;
      this.j = m.getAndIncrement();
      return;
      bool1 = false;
      break;
      label193: bool2 = false;
      break label139;
      label199: localg = paramh1.A;
      continue;
      label209: this.y = new com.google.android.exoplayer2.metadata.id3.a();
      this.z = new r(10);
      this.t = false;
      localg = null;
    }
  }

  private long a(com.google.android.exoplayer2.extractor.h paramh)
    throws IOException, InterruptedException
  {
    paramh.a();
    try
    {
      paramh.c(this.z.a, 0, 10);
      this.z.a(10);
      if (this.z.l() != com.google.android.exoplayer2.metadata.id3.a.b)
        return -9223372036854775807L;
    }
    catch (EOFException localEOFException)
    {
      return -9223372036854775807L;
    }
    this.z.d(3);
    int i = this.z.u();
    int i1 = i + 10;
    if (i1 > this.z.e())
    {
      byte[] arrayOfByte = this.z.a;
      this.z.a(i1);
      System.arraycopy(arrayOfByte, 0, this.z.a, 0, 10);
    }
    paramh.c(this.z.a, 10, i);
    Metadata localMetadata = this.y.a(this.z.a, i);
    if (localMetadata == null)
      return -9223372036854775807L;
    int i2 = localMetadata.length();
    for (int i3 = 0; i3 < i2; i3++)
    {
      Metadata.Entry localEntry = localMetadata.get(i3);
      if ((localEntry instanceof PrivFrame))
      {
        PrivFrame localPrivFrame = (PrivFrame)localEntry;
        if ("com.apple.streaming.transportStreamTimestamp".equals(localPrivFrame.owner))
        {
          System.arraycopy(localPrivFrame.privateData, 0, this.z.a, 0, 8);
          this.z.a(8);
          return 0xFFFFFFFF & this.z.r();
        }
      }
    }
    return -9223372036854775807L;
  }

  private com.google.android.exoplayer2.extractor.d a(com.google.android.exoplayer2.f.h paramh, com.google.android.exoplayer2.f.l paraml)
    throws IOException, InterruptedException
  {
    long l1 = paramh.a(paraml);
    com.google.android.exoplayer2.extractor.d locald = new com.google.android.exoplayer2.extractor.d(paramh, paraml.e, l1);
    boolean bool1;
    long l3;
    if (this.A == null)
    {
      long l2 = a(locald);
      locald.a();
      Pair localPair = this.u.a(this.x, paraml.a, this.c, this.v, this.w, this.s, paramh.b(), locald);
      this.A = ((g)localPair.first);
      if (this.A != this.x)
        break label218;
      bool1 = true;
      if (((Boolean)localPair.second).booleanValue())
      {
        l locall = this.B;
        if (l2 == -9223372036854775807L)
          break label224;
        l3 = this.s.b(l2);
        label152: locall.b(l3);
      }
      if ((!bool1) || (this.o == null))
        break label233;
    }
    label218: label224: label233: for (boolean bool2 = true; ; bool2 = false)
    {
      this.E = bool2;
      this.B.a(this.j, this.t, bool1);
      if (!bool1)
        this.A.a(this.B);
      return locald;
      bool1 = false;
      break;
      l3 = this.f;
      break label152;
    }
  }

  private static com.google.android.exoplayer2.f.h a(com.google.android.exoplayer2.f.h paramh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
      paramh = new a(paramh, paramArrayOfByte1, paramArrayOfByte2);
    return paramh;
  }

  private void i()
    throws IOException, InterruptedException
  {
    if ((this.E) || (this.o == null))
      return;
    com.google.android.exoplayer2.f.l locall = this.o.a(this.C);
    try
    {
      com.google.android.exoplayer2.extractor.d locald = a(this.n, locall);
      int i = 0;
      while (true)
      {
        if (i == 0);
        try
        {
          if (!this.F)
          {
            int i1 = this.A.a(locald, null);
            i = i1;
            continue;
          }
          this.C = ((int)(locald.c() - this.o.e));
          ag.a(this.n);
          this.E = true;
          return;
        }
        finally
        {
          this.C = ((int)(locald.c() - this.o.e));
        }
      }
    }
    finally
    {
      ag.a(this.n);
    }
  }

  private void j()
    throws IOException, InterruptedException
  {
    com.google.android.exoplayer2.f.l locall;
    int i;
    if (this.p)
    {
      locall = this.a;
      if (this.D != 0)
        i = 1;
    }
    while (true)
    {
      if (!this.q)
        this.s.e();
      try
      {
        label35: com.google.android.exoplayer2.extractor.d locald = a(this.h, locall);
        int i1 = 0;
        if (i != 0)
          locald.b(this.D);
        label64: if (i1 == 0);
        try
        {
          if (!this.F)
          {
            int i2 = this.A.a(locald, null);
            i1 = i2;
            break label64;
            i = 0;
            continue;
            locall = this.a.a(this.D);
            i = 0;
            continue;
            if (this.s.a() != 9223372036854775807L)
              break label35;
            this.s.a(this.f);
            break label35;
          }
          this.D = ((int)(locald.c() - this.a.e));
          return;
        }
        finally
        {
          this.D = ((int)(locald.c() - this.a.e));
        }
      }
      finally
      {
        ag.a(this.h);
      }
    }
  }

  public void a()
  {
    this.F = true;
  }

  public void a(l paraml)
  {
    this.B = paraml;
  }

  public void b()
    throws IOException, InterruptedException
  {
    i();
    if (!this.F)
    {
      if (!this.r)
        j();
      this.G = true;
    }
  }

  public boolean h()
  {
    return this.G;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.h
 * JD-Core Version:    0.6.2
 */