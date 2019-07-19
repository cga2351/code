package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.google.android.exoplayer2.w;
import java.io.EOFException;
import java.io.IOException;

public final class c
  implements com.google.android.exoplayer2.extractor.g
{
  public static final j a = d.a;
  private static final a.a b = e.a;
  private static final int c = ag.g("Xing");
  private static final int d = ag.g("Info");
  private static final int e = ag.g("VBRI");
  private final int f;
  private final long g;
  private final r h;
  private final m i;
  private final k j;
  private final l k;
  private i l;
  private q m;
  private int n;
  private Metadata o;
  private a p;
  private long q;
  private long r;
  private int s;

  public c()
  {
    this(0);
  }

  public c(int paramInt)
  {
    this(paramInt, -9223372036854775807L);
  }

  public c(int paramInt, long paramLong)
  {
    this.f = paramInt;
    this.g = paramLong;
    this.h = new r(10);
    this.i = new m();
    this.j = new k();
    this.q = -9223372036854775807L;
    this.k = new l();
  }

  private static int a(r paramr, int paramInt)
  {
    if (paramr.c() >= paramInt + 4)
    {
      paramr.c(paramInt);
      int i1 = paramr.p();
      if ((i1 == c) || (i1 == d))
        return i1;
    }
    if (paramr.c() >= 40)
    {
      paramr.c(36);
      if (paramr.p() == e)
        return e;
    }
    return 0;
  }

  private static b a(Metadata paramMetadata, long paramLong)
  {
    if (paramMetadata != null)
    {
      int i1 = paramMetadata.length();
      for (int i2 = 0; i2 < i1; i2++)
      {
        Metadata.Entry localEntry = paramMetadata.get(i2);
        if ((localEntry instanceof MlltFrame))
          return b.a(paramLong, (MlltFrame)localEntry);
      }
    }
    return null;
  }

  private static boolean a(int paramInt, long paramLong)
  {
    return (0xFFFE0C00 & paramInt) == (0xFFFE0C00 & paramLong);
  }

  private boolean a(h paramh, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int i1;
    int i9;
    label37: a.a locala;
    label45: int i3;
    int i4;
    int i5;
    int i2;
    if (paramBoolean)
    {
      i1 = 16384;
      paramh.a();
      if (paramh.c() != 0L)
        break label363;
      if ((0x2 & this.f) != 0)
        break label158;
      i9 = 1;
      if (i9 == 0)
        break label164;
      locala = null;
      this.o = this.k.a(paramh, locala);
      if (this.o != null)
        this.j.a(this.o);
      int i10 = (int)paramh.b();
      if (!paramBoolean)
        paramh.b(i10);
      i3 = i10;
      i4 = 0;
      i5 = 0;
      i2 = 0;
    }
    while (true)
    {
      label112: if (c(paramh))
        if (i5 > 0)
        {
          label125: if (!paramBoolean)
            break label354;
          paramh.b(i3 + i2);
        }
      while (true)
      {
        this.n = i4;
        boolean bool = true;
        label158: label164: int i6;
        int i7;
        int i8;
        do
        {
          return bool;
          i1 = 131072;
          break;
          i9 = 0;
          break label37;
          locala = b;
          break label45;
          throw new EOFException();
          this.h.c(0);
          i6 = this.h.p();
          if ((i4 == 0) || (a(i6, i4)))
          {
            i7 = m.a(i6);
            if (i7 != -1)
              break label309;
          }
          i8 = i2 + 1;
          if (i2 != i1)
            break label255;
          bool = false;
        }
        while (paramBoolean);
        throw new w("Searched too many bytes.");
        label255: if (paramBoolean)
        {
          paramh.a();
          paramh.c(i3 + i8);
          i2 = i8;
          i4 = 0;
          i5 = 0;
          break label112;
        }
        paramh.b(1);
        i2 = i8;
        i4 = 0;
        i5 = 0;
        break label112;
        label309: i5++;
        if (i5 == 1)
        {
          m.a(i6, this.i);
          i4 = i6;
        }
        while (i5 != 4)
        {
          paramh.c(i7 - 4);
          break;
        }
        break label125;
        label354: paramh.a();
      }
      label363: i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
    }
  }

  private int b(h paramh)
    throws IOException, InterruptedException
  {
    int i3;
    if (this.s == 0)
    {
      paramh.a();
      if (c(paramh))
        i3 = -1;
    }
    int i2;
    do
    {
      return i3;
      this.h.c(0);
      int i4 = this.h.p();
      if ((!a(i4, this.n)) || (m.a(i4) == -1))
      {
        paramh.b(1);
        this.n = 0;
        return 0;
      }
      m.a(i4, this.i);
      if (this.q == -9223372036854775807L)
      {
        this.q = this.p.c(paramh.c());
        if (this.g != -9223372036854775807L)
        {
          long l2 = this.p.c(0L);
          this.q += this.g - l2;
        }
      }
      this.s = this.i.c;
      int i1 = this.m.a(paramh, this.s, true);
      if (i1 == -1)
        return -1;
      this.s -= i1;
      i2 = this.s;
      i3 = 0;
    }
    while (i2 > 0);
    long l1 = this.q + 1000000L * this.r / this.i.d;
    this.m.a(l1, 1, this.i.c, 0, null);
    this.r += this.i.g;
    this.s = 0;
    return 0;
  }

  private boolean c(h paramh)
    throws IOException, InterruptedException
  {
    boolean bool2;
    if ((this.p == null) || (paramh.b() != this.p.c()))
    {
      boolean bool1 = paramh.b(this.h.a, 0, 4, true);
      bool2 = false;
      if (bool1);
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }

  private a d(h paramh)
    throws IOException, InterruptedException
  {
    r localr = new r(this.i.c);
    paramh.c(localr.a, 0, this.i.c);
    int i1;
    if ((0x1 & this.i.a) != 0)
      if (this.i.e != 1)
        i1 = 36;
    int i2;
    while (true)
    {
      i2 = a(localr, i1);
      if ((i2 != c) && (i2 != d))
        break;
      Object localObject = g.a(paramh.d(), paramh.c(), this.i, localr);
      if ((localObject != null) && (!this.j.a()))
      {
        paramh.a();
        paramh.c(i1 + 141);
        paramh.c(this.h.a, 0, 3);
        this.h.c(0);
        this.j.a(this.h.l());
      }
      paramh.b(this.i.c);
      if ((localObject != null) && (!((a)localObject).a()) && (i2 == d))
        localObject = e(paramh);
      return localObject;
      i1 = 21;
      continue;
      if (this.i.e != 1)
        i1 = 21;
      else
        i1 = 13;
    }
    if (i2 == e)
    {
      f localf = f.a(paramh.d(), paramh.c(), this.i, localr);
      paramh.b(this.i.c);
      return localf;
    }
    paramh.a();
    return null;
  }

  private a e(h paramh)
    throws IOException, InterruptedException
  {
    paramh.c(this.h.a, 0, 4);
    this.h.c(0);
    m.a(this.h.p(), this.i);
    return new a(paramh.d(), paramh.c(), this.i);
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    if (this.n == 0);
    while (true)
    {
      a locala;
      Metadata localMetadata;
      try
      {
        a(paramh, false);
        if (this.p == null)
        {
          locala = d(paramh);
          b localb = a(this.o, paramh.c());
          if (localb != null)
          {
            this.p = localb;
            if ((this.p == null) || ((!this.p.a()) && ((0x1 & this.f) != 0)))
              this.p = e(paramh);
            this.l.a(this.p);
            q localq = this.m;
            String str = this.i.b;
            int i1 = this.i.e;
            int i2 = this.i.d;
            int i3 = this.j.a;
            int i4 = this.j.b;
            if ((0x2 & this.f) == 0)
              break label221;
            localMetadata = null;
            localq.a(Format.createAudioSampleFormat(null, str, null, -1, 4096, i1, i2, -1, i3, i4, null, null, 0, null, localMetadata));
          }
        }
        else
        {
          return b(paramh);
        }
      }
      catch (EOFException localEOFException)
      {
        return -1;
      }
      if (locala != null)
      {
        this.p = locala;
        continue;
        label221: localMetadata = this.o;
      }
    }
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.n = 0;
    this.q = -9223372036854775807L;
    this.r = 0L;
    this.s = 0;
  }

  public void a(i parami)
  {
    this.l = parami;
    this.m = this.l.a(0, 1);
    this.l.a();
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    return a(paramh, true);
  }

  public void c()
  {
  }

  static abstract interface a extends o
  {
    public abstract long c();

    public abstract long c(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.d.c
 * JD-Core Version:    0.6.2
 */