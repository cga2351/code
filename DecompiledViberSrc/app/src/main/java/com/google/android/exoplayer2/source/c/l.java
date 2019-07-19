package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.f.z.a;
import com.google.android.exoplayer2.f.z.b;
import com.google.android.exoplayer2.f.z.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.aa;
import com.google.android.exoplayer2.source.aa.a;
import com.google.android.exoplayer2.source.c.a.d.a;
import com.google.android.exoplayer2.source.o.a;
import com.google.android.exoplayer2.source.y.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class l
  implements i, z.a<com.google.android.exoplayer2.source.b.b>, z.e, aa, y.b
{
  private Format A;
  private Format B;
  private boolean C;
  private TrackGroupArray D;
  private TrackGroupArray E;
  private int[] F;
  private int G;
  private boolean H;
  private boolean[] I;
  private boolean[] J;
  private long K;
  private long L;
  private boolean M;
  private boolean N;
  private boolean O;
  private boolean P;
  private long Q;
  private int R;
  private final int a;
  private final a b;
  private final d c;
  private final com.google.android.exoplayer2.f.b d;
  private final Format e;
  private final com.google.android.exoplayer2.f.y f;
  private final com.google.android.exoplayer2.f.z g;
  private final o.a h;
  private final d.b i;
  private final ArrayList<h> j;
  private final List<h> k;
  private final Runnable l;
  private final Runnable m;
  private final Handler n;
  private final ArrayList<k> o;
  private com.google.android.exoplayer2.source.y[] p;
  private int[] q;
  private boolean r;
  private int s;
  private boolean t;
  private int u;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private int z;

  public l(int paramInt, a parama, d paramd, com.google.android.exoplayer2.f.b paramb, long paramLong, Format paramFormat, com.google.android.exoplayer2.f.y paramy, o.a parama1)
  {
    this.a = paramInt;
    this.b = parama;
    this.c = paramd;
    this.d = paramb;
    this.e = paramFormat;
    this.f = paramy;
    this.h = parama1;
    this.g = new com.google.android.exoplayer2.f.z("Loader:HlsSampleStreamWrapper");
    this.i = new d.b();
    this.q = new int[0];
    this.s = -1;
    this.u = -1;
    this.p = new com.google.android.exoplayer2.source.y[0];
    this.J = new boolean[0];
    this.I = new boolean[0];
    this.j = new ArrayList();
    this.k = Collections.unmodifiableList(this.j);
    this.o = new ArrayList();
    this.l = new m(this);
    this.m = new n(this);
    this.n = new Handler();
    this.K = paramLong;
    this.L = paramLong;
  }

  private static Format a(Format paramFormat1, Format paramFormat2, boolean paramBoolean)
  {
    if (paramFormat1 == null)
      return paramFormat2;
    if (paramBoolean);
    for (int i1 = paramFormat1.bitrate; ; i1 = -1)
    {
      int i2 = com.google.android.exoplayer2.g.o.g(paramFormat2.sampleMimeType);
      String str1 = ag.a(paramFormat1.codecs, i2);
      String str2 = com.google.android.exoplayer2.g.o.f(str1);
      if (str2 == null)
        str2 = paramFormat2.sampleMimeType;
      return paramFormat2.copyWithContainerInfo(paramFormat1.id, paramFormat1.label, str2, str1, i1, paramFormat1.width, paramFormat1.height, paramFormat1.selectionFlags, paramFormat1.language);
    }
  }

  private void a(com.google.android.exoplayer2.source.z[] paramArrayOfz)
  {
    this.o.clear();
    int i1 = paramArrayOfz.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      com.google.android.exoplayer2.source.z localz = paramArrayOfz[i2];
      if (localz != null)
        this.o.add((k)localz);
    }
  }

  private static boolean a(Format paramFormat1, Format paramFormat2)
  {
    String str1 = paramFormat1.sampleMimeType;
    String str2 = paramFormat2.sampleMimeType;
    int i1 = com.google.android.exoplayer2.g.o.g(str1);
    if (i1 != 3)
      if (i1 != com.google.android.exoplayer2.g.o.g(str2));
    do
    {
      return true;
      return false;
      if (!ag.a(str1, str2))
        return false;
    }
    while (((!"application/cea-608".equals(str1)) && (!"application/cea-708".equals(str1))) || (paramFormat1.accessibilityChannel == paramFormat2.accessibilityChannel));
    return false;
  }

  private static boolean a(com.google.android.exoplayer2.source.b.b paramb)
  {
    return paramb instanceof h;
  }

  private boolean a(h paramh)
  {
    int i1 = paramh.j;
    int i2 = this.p.length;
    for (int i3 = 0; i3 < i2; i3++)
      if ((this.I[i3] != 0) && (this.p[i3].f() == i1))
        return false;
    return true;
  }

  private static f b(int paramInt1, int paramInt2)
  {
    com.google.android.exoplayer2.g.l.c("HlsSampleStreamWrapper", "Unmapped track with id " + paramInt1 + " of type " + paramInt2);
    return new f();
  }

  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 2:
      return 3;
    case 1:
      return 2;
    case 3:
    }
    return 1;
  }

  private boolean d(long paramLong)
  {
    int i1 = this.p.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      com.google.android.exoplayer2.source.y localy = this.p[i2];
      localy.j();
      if (localy.b(paramLong, true, false) != -1);
      for (int i3 = 1; (i3 == 0) && ((this.J[i2] != 0) || (!this.H)); i3 = 0)
        return false;
    }
    return true;
  }

  private void l()
  {
    com.google.android.exoplayer2.source.y[] arrayOfy = this.p;
    int i1 = arrayOfy.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfy[i2].a(this.M);
    this.M = false;
  }

  private void m()
  {
    this.x = true;
    n();
  }

  private void n()
  {
    if ((this.C) || (this.F != null) || (!this.x))
      return;
    com.google.android.exoplayer2.source.y[] arrayOfy = this.p;
    int i1 = arrayOfy.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        break label52;
      if (arrayOfy[i2].g() == null)
        break;
    }
    label52: if (this.D != null)
    {
      o();
      return;
    }
    p();
    this.y = true;
    this.b.g();
  }

  private void o()
  {
    int i1 = this.D.length;
    this.F = new int[i1];
    Arrays.fill(this.F, -1);
    int i2 = 0;
    if (i2 < i1)
      for (int i3 = 0; ; i3++)
        if (i3 < this.p.length)
        {
          if (a(this.p[i3].g(), this.D.get(i2).getFormat(0)))
            this.F[i2] = i3;
        }
        else
        {
          i2++;
          break;
        }
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((k)localIterator.next()).a();
  }

  private void p()
  {
    int i1 = 1;
    int i2 = this.p.length;
    int i3 = 0;
    int i4 = -1;
    int i5 = 6;
    String str;
    int i10;
    label47: int i12;
    int i11;
    if (i3 < i2)
    {
      str = this.p[i3].g().sampleMimeType;
      if (com.google.android.exoplayer2.g.o.b(str))
      {
        i10 = 2;
        if (d(i10) <= d(i5))
          break label116;
        i12 = i10;
        i11 = i3;
      }
    }
    while (true)
    {
      i3++;
      i5 = i12;
      i4 = i11;
      break;
      if (com.google.android.exoplayer2.g.o.a(str))
      {
        i10 = i1;
        break label47;
      }
      if (com.google.android.exoplayer2.g.o.c(str))
      {
        i10 = 3;
        break label47;
      }
      i10 = 6;
      break label47;
      label116: if ((i10 == i5) && (i4 != -1))
      {
        i11 = -1;
        i12 = i5;
        continue;
        TrackGroup localTrackGroup = this.c.b();
        int i6 = localTrackGroup.length;
        this.G = -1;
        this.F = new int[i2];
        for (int i7 = 0; i7 < i2; i7++)
          this.F[i7] = i7;
        TrackGroup[] arrayOfTrackGroup = new TrackGroup[i2];
        int i8 = 0;
        if (i8 < i2)
        {
          Format localFormat1 = this.p[i8].g();
          if (i8 == i4)
          {
            Format[] arrayOfFormat2 = new Format[i6];
            if (i6 == i1)
              arrayOfFormat2[0] = localFormat1.copyWithManifestFormatInfo(localTrackGroup.getFormat(0));
            while (true)
            {
              arrayOfTrackGroup[i8] = new TrackGroup(arrayOfFormat2);
              this.G = i8;
              i8++;
              break;
              for (int i9 = 0; i9 < i6; i9++)
                arrayOfFormat2[i9] = a(localTrackGroup.getFormat(i9), localFormat1, i1);
            }
          }
          if ((i5 == 2) && (com.google.android.exoplayer2.g.o.a(localFormat1.sampleMimeType)));
          for (Format localFormat2 = this.e; ; localFormat2 = null)
          {
            Format[] arrayOfFormat1 = new Format[i1];
            arrayOfFormat1[0] = a(localFormat2, localFormat1, false);
            arrayOfTrackGroup[i8] = new TrackGroup(arrayOfFormat1);
            break;
          }
        }
        this.D = new TrackGroupArray(arrayOfTrackGroup);
        if (this.E == null);
        while (true)
        {
          a.b(i1);
          this.E = TrackGroupArray.EMPTY;
          return;
          i1 = 0;
        }
      }
      else
      {
        i11 = i4;
        i12 = i5;
      }
    }
  }

  private h q()
  {
    return (h)this.j.get(-1 + this.j.size());
  }

  private boolean r()
  {
    return this.L != -9223372036854775807L;
  }

  public int a(int paramInt)
  {
    int i1 = this.F[paramInt];
    if (i1 == -1)
      if (this.E.indexOf(this.D.get(paramInt)) != -1);
    while (this.I[i1] != 0)
    {
      return -2;
      return -3;
    }
    this.I[i1] = true;
    return i1;
  }

  public int a(int paramInt, long paramLong)
  {
    if (r());
    int i1;
    do
    {
      return 0;
      com.google.android.exoplayer2.source.y localy = this.p[paramInt];
      if ((this.O) && (paramLong > localy.h()))
        return localy.l();
      i1 = localy.b(paramLong, true, true);
    }
    while (i1 == -1);
    return i1;
  }

  public int a(int paramInt, p paramp, com.google.android.exoplayer2.c.e parame, boolean paramBoolean)
  {
    int i1 = 0;
    if (r())
      return -3;
    if (!this.j.isEmpty())
    {
      for (int i4 = 0; (i4 < -1 + this.j.size()) && (a((h)this.j.get(i4))); i4++);
      ag.a(this.j, 0, i4);
      h localh = (h)this.j.get(0);
      Format localFormat2 = localh.c;
      if (!localFormat2.equals(this.B))
        this.h.a(this.a, localFormat2, localh.d, localh.e, localh.f);
      this.B = localFormat2;
    }
    int i2 = this.p[paramInt].a(paramp, parame, paramBoolean, this.O, this.K);
    if ((i2 == -5) && (paramInt == this.w))
    {
      int i3 = this.p[paramInt].f();
      while ((i1 < this.j.size()) && (((h)this.j.get(i1)).j != i3))
        i1++;
      if (i1 >= this.j.size())
        break label273;
    }
    label273: for (Format localFormat1 = ((h)this.j.get(i1)).c; ; localFormat1 = this.A)
    {
      paramp.a = paramp.a.copyWithManifestFormatInfo(localFormat1);
      return i2;
    }
  }

  public q a(int paramInt1, int paramInt2)
  {
    int i1 = this.p.length;
    if (paramInt2 == 1)
    {
      if (this.s != -1)
      {
        if (this.r)
        {
          if (this.q[this.s] == paramInt1)
            return this.p[this.s];
          return b(paramInt1, paramInt2);
        }
        this.r = true;
        this.q[this.s] = paramInt1;
        return this.p[this.s];
      }
      if (this.P)
        return b(paramInt1, paramInt2);
    }
    else if (paramInt2 == 2)
    {
      if (this.u != -1)
      {
        if (this.t)
        {
          if (this.q[this.u] == paramInt1)
            return this.p[this.u];
          return b(paramInt1, paramInt2);
        }
        this.t = true;
        this.q[this.u] = paramInt1;
        return this.p[this.u];
      }
      if (this.P)
        return b(paramInt1, paramInt2);
    }
    else
    {
      for (int i2 = 0; i2 < i1; i2++)
        if (this.q[i2] == paramInt1)
          return this.p[i2];
      if (this.P)
        return b(paramInt1, paramInt2);
    }
    b localb = new b(this.d);
    localb.a(this.Q);
    localb.a(this.R);
    localb.a(this);
    this.q = Arrays.copyOf(this.q, i1 + 1);
    this.q[i1] = paramInt1;
    this.p = ((com.google.android.exoplayer2.source.y[])Arrays.copyOf(this.p, i1 + 1));
    this.p[i1] = localb;
    this.J = Arrays.copyOf(this.J, i1 + 1);
    boolean[] arrayOfBoolean = this.J;
    int i3;
    if ((paramInt2 == 1) || (paramInt2 == 2))
    {
      i3 = 1;
      arrayOfBoolean[i1] = i3;
      this.H |= this.J[i1];
      if (paramInt2 != 1)
        break label426;
      this.r = true;
      this.s = i1;
    }
    while (true)
    {
      if (d(paramInt2) > d(this.v))
      {
        this.w = i1;
        this.v = paramInt2;
      }
      this.I = Arrays.copyOf(this.I, i1 + 1);
      return localb;
      i3 = 0;
      break;
      label426: if (paramInt2 == 2)
      {
        this.t = true;
        this.u = i1;
      }
    }
  }

  public z.b a(com.google.android.exoplayer2.source.b.b paramb, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    long l1 = paramb.d();
    boolean bool1 = a(paramb);
    long l2 = this.f.a(paramb.b, paramLong2, paramIOException, paramInt);
    if (l2 != -9223372036854775807L);
    for (boolean bool2 = this.c.a(paramb, l2); ; bool2 = false)
    {
      boolean bool4;
      z.b localb;
      label125: o.a locala;
      com.google.android.exoplayer2.f.l locall;
      Uri localUri;
      Map localMap;
      int i1;
      int i2;
      Format localFormat;
      int i3;
      Object localObject;
      long l4;
      long l5;
      if (bool2)
      {
        if ((bool1) && (l1 == 0L))
        {
          if ((h)this.j.remove(-1 + this.j.size()) != paramb)
            break label260;
          bool4 = true;
          a.b(bool4);
          if (this.j.isEmpty())
            this.L = this.K;
        }
        localb = com.google.android.exoplayer2.f.z.c;
        locala = this.h;
        locall = paramb.a;
        localUri = paramb.e();
        localMap = paramb.f();
        i1 = paramb.b;
        i2 = this.a;
        localFormat = paramb.c;
        i3 = paramb.d;
        localObject = paramb.e;
        l4 = paramb.f;
        l5 = paramb.g;
        if (localb.a())
          break label315;
      }
      label260: label315: for (boolean bool3 = true; ; bool3 = false)
      {
        locala.a(locall, localUri, localMap, i1, i2, localFormat, i3, localObject, l4, l5, paramLong1, paramLong2, l1, paramIOException, bool3);
        if (bool2)
        {
          if (this.y)
            break label321;
          c(this.K);
        }
        return localb;
        bool4 = false;
        break;
        long l3 = this.f.b(paramb.b, paramLong2, paramIOException, paramInt);
        if (l3 != -9223372036854775807L)
        {
          localb = com.google.android.exoplayer2.f.z.a(false, l3);
          break label125;
        }
        localb = com.google.android.exoplayer2.f.z.d;
        break label125;
      }
      label321: this.b.a(this);
      return localb;
    }
  }

  public void a()
  {
    this.P = true;
    this.n.post(this.m);
  }

  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (!paramBoolean2)
    {
      this.r = false;
      this.t = false;
    }
    this.R = paramInt;
    com.google.android.exoplayer2.source.y[] arrayOfy1 = this.p;
    int i2 = arrayOfy1.length;
    for (int i3 = 0; i3 < i2; i3++)
      arrayOfy1[i3].a(paramInt);
    if (paramBoolean1)
    {
      com.google.android.exoplayer2.source.y[] arrayOfy2 = this.p;
      int i4 = arrayOfy2.length;
      while (i1 < i4)
      {
        arrayOfy2[i1].b();
        i1++;
      }
    }
  }

  public void a(long paramLong)
  {
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    if ((!this.x) || (r()));
    while (true)
    {
      return;
      int i1 = this.p.length;
      for (int i2 = 0; i2 < i1; i2++)
        this.p[i2].a(paramLong, paramBoolean, this.I[i2]);
    }
  }

  public void a(Format paramFormat)
  {
    this.n.post(this.l);
  }

  public void a(com.google.android.exoplayer2.extractor.o paramo)
  {
  }

  public void a(TrackGroupArray paramTrackGroupArray1, int paramInt, TrackGroupArray paramTrackGroupArray2)
  {
    this.y = true;
    this.D = paramTrackGroupArray1;
    this.E = paramTrackGroupArray2;
    this.G = paramInt;
    this.b.g();
  }

  public void a(com.google.android.exoplayer2.source.b.b paramb, long paramLong1, long paramLong2)
  {
    this.c.a(paramb);
    this.h.a(paramb.a, paramb.e(), paramb.f(), paramb.b, this.a, paramb.c, paramb.d, paramb.e, paramb.f, paramb.g, paramLong1, paramLong2, paramb.d());
    if (!this.y)
    {
      c(this.K);
      return;
    }
    this.b.a(this);
  }

  public void a(com.google.android.exoplayer2.source.b.b paramb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.h.b(paramb.a, paramb.e(), paramb.f(), paramb.b, this.a, paramb.c, paramb.d, paramb.e, paramb.f, paramb.g, paramLong1, paramLong2, paramb.d());
    if (!paramBoolean)
    {
      l();
      if (this.z > 0)
        this.b.a(this);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public boolean a(d.a parama, long paramLong)
  {
    return this.c.a(parama, paramLong);
  }

  public boolean a(com.google.android.exoplayer2.trackselection.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, com.google.android.exoplayer2.source.z[] paramArrayOfz, boolean[] paramArrayOfBoolean2, long paramLong, boolean paramBoolean)
  {
    a.b(this.y);
    int i1 = this.z;
    for (int i2 = 0; i2 < paramArrayOfe.length; i2++)
      if ((paramArrayOfz[i2] != null) && ((paramArrayOfe[i2] == null) || (paramArrayOfBoolean1[i2] == 0)))
      {
        this.z = (-1 + this.z);
        ((k)paramArrayOfz[i2]).d();
        paramArrayOfz[i2] = null;
      }
    boolean bool1;
    label95: com.google.android.exoplayer2.trackselection.e locale1;
    int i3;
    boolean bool2;
    Object localObject;
    label115: boolean bool4;
    if (!paramBoolean)
    {
      if (this.N)
        if (i1 != 0)
          break label306;
    }
    else
    {
      bool1 = true;
      locale1 = this.c.c();
      i3 = 0;
      bool2 = bool1;
      localObject = locale1;
      if (i3 >= paramArrayOfe.length)
        break label318;
      if ((paramArrayOfz[i3] != null) || (paramArrayOfe[i3] == null))
        break label611;
      this.z = (1 + this.z);
      com.google.android.exoplayer2.trackselection.e locale2 = paramArrayOfe[i3];
      int i10 = this.D.indexOf(locale2.f());
      if (i10 == this.G)
      {
        this.c.a(locale2);
        localObject = locale2;
      }
      paramArrayOfz[i3] = new k(this, i10);
      paramArrayOfBoolean2[i3] = true;
      if (this.F != null)
        ((k)paramArrayOfz[i3]).a();
      if ((!this.x) || (bool2))
        break label611;
      com.google.android.exoplayer2.source.y localy = this.p[this.F[i10]];
      localy.j();
      if ((localy.b(paramLong, true, true) != -1) || (localy.e() == 0))
        break label312;
      bool4 = true;
    }
    label282: label306: label312: label318: label462: label599: label605: label611: for (boolean bool3 = bool4; ; bool3 = bool2)
    {
      i3++;
      bool2 = bool3;
      break label115;
      if (paramLong != this.K)
        break;
      bool1 = false;
      break label95;
      bool4 = false;
      break label282;
      if (this.z == 0)
      {
        this.c.d();
        this.B = null;
        this.j.clear();
        if (this.g.a())
        {
          if (this.x)
          {
            com.google.android.exoplayer2.source.y[] arrayOfy = this.p;
            int i8 = arrayOfy.length;
            for (int i9 = 0; i9 < i8; i9++)
              arrayOfy[i9].k();
          }
          this.g.b();
        }
        while (true)
        {
          a(paramArrayOfz);
          this.N = true;
          return bool2;
          l();
        }
      }
      long l1;
      if ((!this.j.isEmpty()) && (!ag.a(localObject, locale1)))
      {
        if (this.N)
          break label605;
        if (paramLong >= 0L)
          break label599;
        l1 = -paramLong;
        h localh = q();
        com.google.android.exoplayer2.source.b.e[] arrayOfe = this.c.a(localh, paramLong);
        ((com.google.android.exoplayer2.trackselection.e)localObject).a(paramLong, l1, -9223372036854775807L, this.k, arrayOfe);
        int i6 = this.c.b().indexOf(localh.c);
        int i7 = ((com.google.android.exoplayer2.trackselection.e)localObject).i();
        i5 = 0;
        if (i7 == i6);
      }
      for (int i5 = 1; ; i5 = 1)
      {
        if (i5 != 0)
        {
          paramBoolean = true;
          bool2 = true;
          this.M = true;
        }
        if (!bool2)
          break;
        b(paramLong, paramBoolean);
        for (int i4 = 0; i4 < paramArrayOfz.length; i4++)
          if (paramArrayOfz[i4] != null)
            paramArrayOfBoolean2[i4] = true;
        break;
        l1 = 0L;
        break label462;
      }
    }
  }

  public void b()
  {
    if (!this.y)
      c(this.K);
  }

  public void b(int paramInt)
  {
    int i1 = this.F[paramInt];
    a.b(this.I[i1]);
    this.I[i1] = false;
  }

  public void b(long paramLong)
  {
    this.Q = paramLong;
    com.google.android.exoplayer2.source.y[] arrayOfy = this.p;
    int i1 = arrayOfy.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfy[i2].a(paramLong);
  }

  public boolean b(long paramLong, boolean paramBoolean)
  {
    this.K = paramLong;
    if (r())
    {
      this.L = paramLong;
      return true;
    }
    if ((this.x) && (!paramBoolean) && (d(paramLong)))
      return false;
    this.L = paramLong;
    this.O = false;
    this.j.clear();
    if (this.g.a())
    {
      this.g.b();
      return true;
    }
    l();
    return true;
  }

  public void c()
    throws IOException
  {
    i();
  }

  public boolean c(int paramInt)
  {
    return (this.O) || ((!r()) && (this.p[paramInt].d()));
  }

  public boolean c(long paramLong)
  {
    if ((this.O) || (this.g.a()))
      return false;
    List localList;
    long l2;
    com.google.android.exoplayer2.source.b.b localb;
    d.a locala;
    if (r())
    {
      localList = Collections.emptyList();
      l2 = this.L;
      this.c.a(paramLong, l2, localList, this.i);
      boolean bool = this.i.b;
      localb = this.i.a;
      locala = this.i.c;
      this.i.a();
      if (bool)
      {
        this.L = -9223372036854775807L;
        this.O = true;
        return true;
      }
    }
    else
    {
      localList = this.k;
      h localh1 = q();
      if (localh1.h());
      for (long l1 = localh1.g; ; l1 = Math.max(this.K, localh1.f))
      {
        l2 = l1;
        break;
      }
    }
    if (localb == null)
    {
      if (locala != null)
        this.b.a(locala);
      return false;
    }
    if (a(localb))
    {
      this.L = -9223372036854775807L;
      h localh2 = (h)localb;
      localh2.a(this);
      this.j.add(localh2);
      this.A = localh2.c;
    }
    long l3 = this.g.a(localb, this, this.f.a(localb.b));
    this.h.a(localb.a, localb.b, this.a, localb.c, localb.d, localb.e, localb.f, localb.g, l3);
    return true;
  }

  public long d()
  {
    long l2;
    if (this.O)
      l2 = -9223372036854775808L;
    label151: label155: 
    while (true)
    {
      return l2;
      if (r())
        return this.L;
      long l1 = this.K;
      h localh = q();
      if (localh.h())
        label44: if (localh == null)
          break label151;
      for (l2 = Math.max(l1, localh.g); ; l2 = l1)
      {
        if (!this.x)
          break label155;
        com.google.android.exoplayer2.source.y[] arrayOfy = this.p;
        int i1 = arrayOfy.length;
        int i2 = 0;
        while (i2 < i1)
        {
          long l3 = Math.max(l2, arrayOfy[i2].h());
          i2++;
          l2 = l3;
        }
        break;
        if (this.j.size() > 1)
        {
          localh = (h)this.j.get(-2 + this.j.size());
          break label44;
        }
        localh = null;
        break label44;
      }
    }
  }

  public long e()
  {
    if (r())
      return this.L;
    if (this.O)
      return -9223372036854775808L;
    return q().g;
  }

  public TrackGroupArray f()
  {
    return this.D;
  }

  public void g()
  {
    l();
  }

  public void h()
  {
    if (this.y)
    {
      com.google.android.exoplayer2.source.y[] arrayOfy = this.p;
      int i1 = arrayOfy.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfy[i2].k();
    }
    this.g.a(this);
    this.n.removeCallbacksAndMessages(null);
    this.C = true;
    this.o.clear();
  }

  public void i()
    throws IOException
  {
    this.g.d();
    this.c.a();
  }

  public static abstract interface a extends aa.a<l>
  {
    public abstract void a(d.a parama);

    public abstract void g();
  }

  private static final class b extends com.google.android.exoplayer2.source.y
  {
    public b(com.google.android.exoplayer2.f.b paramb)
    {
      super();
    }

    private Metadata a(Metadata paramMetadata)
    {
      if (paramMetadata == null)
        paramMetadata = null;
      label141: 
      while (true)
      {
        return paramMetadata;
        int i = paramMetadata.length();
        int j = 0;
        if (j < i)
        {
          Metadata.Entry localEntry = paramMetadata.get(j);
          if ((!(localEntry instanceof PrivFrame)) || (!"com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)localEntry).owner)));
        }
        while (true)
        {
          if (j == -1)
            break label141;
          if (i == 1)
          {
            return null;
            j++;
            break;
          }
          Metadata.Entry[] arrayOfEntry = new Metadata.Entry[i - 1];
          int k = 0;
          if (k < i)
          {
            if (k != j)
              if (k >= j)
                break label119;
            label119: for (int m = k; ; m = k - 1)
            {
              arrayOfEntry[m] = paramMetadata.get(k);
              k++;
              break;
            }
          }
          return new Metadata(arrayOfEntry);
          j = -1;
        }
      }
    }

    public void a(Format paramFormat)
    {
      super.a(paramFormat.copyWithMetadata(a(paramFormat.metadata)));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.l
 * JD-Core Version:    0.6.2
 */