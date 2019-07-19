package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ai;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.f.ac;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.f.z.a;
import com.google.android.exoplayer2.f.z.b;
import com.google.android.exoplayer2.f.z.d;
import com.google.android.exoplayer2.f.z.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

final class i
  implements com.google.android.exoplayer2.extractor.i, z.a<a>, z.e, m, y.b
{
  private int A;
  private long B;
  private long C;
  private long D;
  private long E;
  private boolean F;
  private int G;
  private boolean H;
  private boolean I;
  private final Uri a;
  private final h b;
  private final com.google.android.exoplayer2.f.y c;
  private final o.a d;
  private final c e;
  private final b f;
  private final String g;
  private final long h;
  private final com.google.android.exoplayer2.f.z i;
  private final b j;
  private final com.google.android.exoplayer2.g.e k;
  private final Runnable l;
  private final Runnable m;
  private final Handler n;
  private m.a o;
  private com.google.android.exoplayer2.extractor.o p;
  private y[] q;
  private int[] r;
  private boolean s;
  private boolean t;
  private d u;
  private boolean v;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;

  public i(Uri paramUri, h paramh, g[] paramArrayOfg, com.google.android.exoplayer2.f.y paramy, o.a parama, c paramc, b paramb, String paramString, int paramInt)
  {
    this.a = paramUri;
    this.b = paramh;
    this.c = paramy;
    this.d = parama;
    this.e = paramc;
    this.f = paramb;
    this.g = paramString;
    this.h = paramInt;
    this.i = new com.google.android.exoplayer2.f.z("Loader:ExtractorMediaPeriod");
    this.j = new b(paramArrayOfg);
    this.k = new com.google.android.exoplayer2.g.e();
    this.l = new j(this);
    this.m = new k(this);
    this.n = new Handler();
    this.r = new int[0];
    this.q = new y[0];
    this.E = -9223372036854775807L;
    this.C = -1L;
    this.B = -9223372036854775807L;
    this.w = 1;
    parama.a();
  }

  private void a(a parama)
  {
    if (this.C == -1L)
      this.C = a.d(parama);
  }

  private boolean a(a parama, int paramInt)
  {
    int i1 = 0;
    if ((this.C != -1L) || ((this.p != null) && (this.p.b() != -9223372036854775807L)))
    {
      this.G = paramInt;
      return true;
    }
    if ((this.t) && (!k()))
    {
      this.F = true;
      return false;
    }
    this.y = this.t;
    this.D = 0L;
    this.G = 0;
    y[] arrayOfy = this.q;
    int i2 = arrayOfy.length;
    while (i1 < i2)
    {
      arrayOfy[i1].a();
      i1++;
    }
    a.a(parama, 0L, 0L);
    return true;
  }

  private boolean a(boolean[] paramArrayOfBoolean, long paramLong)
  {
    int i1 = this.q.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      y localy = this.q[i2];
      localy.j();
      if (localy.b(paramLong, true, false) != -1);
      for (int i3 = 1; (i3 == 0) && ((paramArrayOfBoolean[i2] != 0) || (!this.v)); i3 = 0)
        return false;
    }
    return true;
  }

  private void b(int paramInt)
  {
    d locald = m();
    boolean[] arrayOfBoolean = locald.e;
    if (arrayOfBoolean[paramInt] == 0)
    {
      Format localFormat = locald.b.get(paramInt).getFormat(0);
      this.d.a(com.google.android.exoplayer2.g.o.g(localFormat.sampleMimeType), localFormat, 0, null, this.D);
      arrayOfBoolean[paramInt] = true;
    }
  }

  private void c(int paramInt)
  {
    int i1 = 0;
    boolean[] arrayOfBoolean = m().c;
    if ((!this.F) || (arrayOfBoolean[paramInt] == 0) || (this.q[paramInt].d()))
      return;
    this.E = 0L;
    this.F = false;
    this.y = true;
    this.D = 0L;
    this.G = 0;
    y[] arrayOfy = this.q;
    int i2 = arrayOfy.length;
    while (i1 < i2)
    {
      arrayOfy[i1].a();
      i1++;
    }
    ((m.a)a.a(this.o)).a(this);
  }

  private boolean k()
  {
    return (this.y) || (q());
  }

  private void l()
  {
    com.google.android.exoplayer2.extractor.o localo = this.p;
    if ((this.I) || (this.t) || (!this.s) || (localo == null))
      return;
    y[] arrayOfy = this.q;
    int i1 = arrayOfy.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        break label64;
      if (arrayOfy[i2].g() == null)
        break;
    }
    label64: this.k.b();
    int i3 = this.q.length;
    TrackGroup[] arrayOfTrackGroup = new TrackGroup[i3];
    boolean[] arrayOfBoolean = new boolean[i3];
    this.B = localo.b();
    int i4 = 0;
    if (i4 < i3)
    {
      Format localFormat = this.q[i4].g();
      arrayOfTrackGroup[i4] = new TrackGroup(new Format[] { localFormat });
      String str = localFormat.sampleMimeType;
      if ((com.google.android.exoplayer2.g.o.b(str)) || (com.google.android.exoplayer2.g.o.a(str)));
      for (int i6 = 1; ; i6 = 0)
      {
        arrayOfBoolean[i4] = i6;
        this.v = (i6 | this.v);
        i4++;
        break;
      }
    }
    if ((this.C == -1L) && (localo.b() == -9223372036854775807L));
    for (int i5 = 7; ; i5 = 1)
    {
      this.w = i5;
      this.u = new d(localo, new TrackGroupArray(arrayOfTrackGroup), arrayOfBoolean);
      this.t = true;
      this.e.a(this.B, localo.a());
      ((m.a)a.a(this.o)).a(this);
      return;
    }
  }

  private d m()
  {
    return (d)a.a(this.u);
  }

  private void n()
  {
    a locala = new a(this.a, this.b, this.j, this, this.k);
    if (this.t)
    {
      com.google.android.exoplayer2.extractor.o localo = m().a;
      a.b(q());
      if ((this.B != -9223372036854775807L) && (this.E >= this.B))
      {
        this.H = true;
        this.E = -9223372036854775807L;
        return;
      }
      a.a(locala, localo.a(this.E).a.c, this.E);
      this.E = -9223372036854775807L;
    }
    this.G = o();
    long l1 = this.i.a(locala, this, this.c.a(this.w));
    this.d.a(a.a(locala), 1, -1, null, 0, null, a.c(locala), this.B, l1);
  }

  private int o()
  {
    int i1 = 0;
    y[] arrayOfy = this.q;
    int i2 = arrayOfy.length;
    int i3 = 0;
    while (i1 < i2)
    {
      i3 += arrayOfy[i1].c();
      i1++;
    }
    return i3;
  }

  private long p()
  {
    long l1 = -9223372036854775808L;
    y[] arrayOfy = this.q;
    int i1 = arrayOfy.length;
    for (int i2 = 0; i2 < i1; i2++)
      l1 = Math.max(l1, arrayOfy[i2].h());
    return l1;
  }

  private boolean q()
  {
    return this.E != -9223372036854775807L;
  }

  int a(int paramInt, long paramLong)
  {
    boolean bool = k();
    int i1 = 0;
    if (bool);
    while (true)
    {
      return i1;
      b(paramInt);
      y localy = this.q[paramInt];
      if ((this.H) && (paramLong > localy.h()))
        i1 = localy.l();
      while (i1 == 0)
      {
        c(paramInt);
        return i1;
        int i2 = localy.b(paramLong, true, true);
        i1 = 0;
        if (i2 != -1)
          i1 = i2;
      }
    }
  }

  int a(int paramInt, com.google.android.exoplayer2.p paramp, com.google.android.exoplayer2.c.e parame, boolean paramBoolean)
  {
    if (k())
      return -3;
    b(paramInt);
    int i1 = this.q[paramInt].a(paramp, parame, paramBoolean, this.H, this.D);
    if (i1 == -3)
      c(paramInt);
    return i1;
  }

  public long a(long paramLong, ai paramai)
  {
    com.google.android.exoplayer2.extractor.o localo = m().a;
    if (!localo.a())
      return 0L;
    com.google.android.exoplayer2.extractor.o.a locala = localo.a(paramLong);
    return ag.a(paramLong, paramai, locala.a.b, locala.b.b);
  }

  public long a(com.google.android.exoplayer2.trackselection.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, z[] paramArrayOfz, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int i1 = 0;
    d locald = m();
    TrackGroupArray localTrackGroupArray = locald.b;
    boolean[] arrayOfBoolean = locald.d;
    int i2 = this.A;
    for (int i3 = 0; i3 < paramArrayOfe.length; i3++)
      if ((paramArrayOfz[i3] != null) && ((paramArrayOfe[i3] == null) || (paramArrayOfBoolean1[i3] == 0)))
      {
        int i10 = e.a((e)paramArrayOfz[i3]);
        a.b(arrayOfBoolean[i10]);
        this.A = (-1 + this.A);
        arrayOfBoolean[i10] = false;
        paramArrayOfz[i3] = null;
      }
    int i4;
    int i6;
    label129: boolean bool1;
    label170: boolean bool2;
    label189: boolean bool3;
    if (this.x)
      if (i2 == 0)
      {
        i4 = 1;
        i5 = i4;
        i6 = 0;
        if (i6 >= paramArrayOfe.length)
          break label358;
        if ((paramArrayOfz[i6] == null) && (paramArrayOfe[i6] != null))
        {
          com.google.android.exoplayer2.trackselection.e locale = paramArrayOfe[i6];
          if (locale.g() != 1)
            break label334;
          bool1 = true;
          a.b(bool1);
          if (locale.b(0) != 0)
            break label340;
          bool2 = true;
          a.b(bool2);
          int i9 = localTrackGroupArray.indexOf(locale.f());
          if (arrayOfBoolean[i9] != 0)
            break label346;
          bool3 = true;
          label219: a.b(bool3);
          this.A = (1 + this.A);
          arrayOfBoolean[i9] = true;
          paramArrayOfz[i6] = new e(i9);
          paramArrayOfBoolean2[i6] = true;
          if (i5 == 0)
          {
            y localy = this.q[i9];
            localy.j();
            if ((localy.b(paramLong, true, true) != -1) || (localy.e() == 0))
              break label352;
          }
        }
      }
    label334: label340: label346: label352: for (int i5 = 1; ; i5 = 0)
    {
      i6++;
      break label129;
      i4 = 0;
      break;
      if (paramLong != 0L)
      {
        i4 = 1;
        break;
      }
      i4 = 0;
      break;
      bool1 = false;
      break label170;
      bool2 = false;
      break label189;
      bool3 = false;
      break label219;
    }
    label358: if (this.A == 0)
    {
      this.F = false;
      this.y = false;
      if (this.i.a())
      {
        y[] arrayOfy2 = this.q;
        int i8 = arrayOfy2.length;
        while (i1 < i8)
        {
          arrayOfy2[i1].k();
          i1++;
        }
        this.i.b();
      }
    }
    while (true)
    {
      this.x = true;
      return paramLong;
      y[] arrayOfy1 = this.q;
      int i7 = arrayOfy1.length;
      while (i1 < i7)
      {
        arrayOfy1[i1].a();
        i1++;
      }
      continue;
      if (i5 != 0)
      {
        paramLong = b(paramLong);
        while (i1 < paramArrayOfz.length)
        {
          if (paramArrayOfz[i1] != null)
            paramArrayOfBoolean2[i1] = true;
          i1++;
        }
      }
    }
  }

  public q a(int paramInt1, int paramInt2)
  {
    int i1 = this.q.length;
    for (int i2 = 0; i2 < i1; i2++)
      if (this.r[i2] == paramInt1)
        return this.q[i2];
    y localy = new y(this.f);
    localy.a(this);
    this.r = Arrays.copyOf(this.r, i1 + 1);
    this.r[i1] = paramInt1;
    y[] arrayOfy = (y[])Arrays.copyOf(this.q, i1 + 1);
    arrayOfy[i1] = localy;
    this.q = ((y[])ag.a(arrayOfy));
    return localy;
  }

  public z.b a(a parama, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    a(parama);
    long l1 = this.c.b(this.w, this.B, paramIOException, paramInt);
    z.b localb;
    o.a locala;
    l locall;
    Uri localUri;
    Map localMap;
    long l2;
    long l3;
    long l4;
    if (l1 == -9223372036854775807L)
    {
      localb = com.google.android.exoplayer2.f.z.d;
      locala = this.d;
      locall = a.a(parama);
      localUri = a.b(parama).f();
      localMap = a.b(parama).g();
      l2 = a.c(parama);
      l3 = this.B;
      l4 = a.b(parama).e();
      if (localb.a())
        break label190;
    }
    label182: label190: for (boolean bool2 = true; ; bool2 = false)
    {
      locala.a(locall, localUri, localMap, 1, -1, null, 0, null, l2, l3, paramLong1, paramLong2, l4, paramIOException, bool2);
      return localb;
      int i1 = o();
      if (i1 > this.G);
      for (boolean bool1 = true; ; bool1 = false)
      {
        if (!a(parama, i1))
          break label182;
        localb = com.google.android.exoplayer2.f.z.a(bool1, l1);
        break;
      }
      localb = com.google.android.exoplayer2.f.z.c;
      break;
    }
  }

  public void a()
  {
    this.s = true;
    this.n.post(this.l);
  }

  public void a(long paramLong)
  {
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    if (q());
    while (true)
    {
      return;
      boolean[] arrayOfBoolean = m().d;
      int i1 = this.q.length;
      for (int i2 = 0; i2 < i1; i2++)
        this.q[i2].a(paramLong, paramBoolean, arrayOfBoolean[i2]);
    }
  }

  public void a(Format paramFormat)
  {
    this.n.post(this.l);
  }

  public void a(com.google.android.exoplayer2.extractor.o paramo)
  {
    this.p = paramo;
    this.n.post(this.l);
  }

  public void a(a parama, long paramLong1, long paramLong2)
  {
    com.google.android.exoplayer2.extractor.o localo;
    long l1;
    if (this.B == -9223372036854775807L)
    {
      localo = (com.google.android.exoplayer2.extractor.o)a.a(this.p);
      l1 = p();
      if (l1 != -9223372036854775808L)
        break label142;
    }
    label142: for (long l2 = 0L; ; l2 = l1 + 10000L)
    {
      this.B = l2;
      this.e.a(this.B, localo.a());
      this.d.a(a.a(parama), a.b(parama).f(), a.b(parama).g(), 1, -1, null, 0, null, a.c(parama), this.B, paramLong1, paramLong2, a.b(parama).e());
      a(parama);
      this.H = true;
      ((m.a)a.a(this.o)).a(this);
      return;
    }
  }

  public void a(a parama, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.d.b(a.a(parama), a.b(parama).f(), a.b(parama).g(), 1, -1, null, 0, null, a.c(parama), this.B, paramLong1, paramLong2, a.b(parama).e());
    if (!paramBoolean)
    {
      a(parama);
      y[] arrayOfy = this.q;
      int i1 = arrayOfy.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfy[i2].a();
      if (this.A > 0)
        ((m.a)a.a(this.o)).a(this);
    }
  }

  public void a(m.a parama, long paramLong)
  {
    this.o = parama;
    this.k.a();
    n();
  }

  boolean a(int paramInt)
  {
    return (!k()) && ((this.H) || (this.q[paramInt].d()));
  }

  public long b(long paramLong)
  {
    int i1 = 0;
    d locald = m();
    com.google.android.exoplayer2.extractor.o localo = locald.a;
    boolean[] arrayOfBoolean = locald.c;
    if (localo.a())
    {
      this.y = false;
      this.D = paramLong;
      if (!q())
        break label61;
      this.E = paramLong;
    }
    while (true)
    {
      return paramLong;
      paramLong = 0L;
      break;
      label61: if ((this.w == 7) || (!a(arrayOfBoolean, paramLong)))
      {
        this.F = false;
        this.E = paramLong;
        this.H = false;
        if (this.i.a())
        {
          this.i.b();
          return paramLong;
        }
        y[] arrayOfy = this.q;
        int i2 = arrayOfy.length;
        while (i1 < i2)
        {
          arrayOfy[i1].a();
          i1++;
        }
      }
    }
  }

  public TrackGroupArray b()
  {
    return m().b;
  }

  public long c()
  {
    if (!this.z)
    {
      this.d.c();
      this.z = true;
    }
    if ((this.y) && ((this.H) || (o() > this.G)))
    {
      this.y = false;
      return this.D;
    }
    return -9223372036854775807L;
  }

  public boolean c(long paramLong)
  {
    boolean bool;
    if ((this.H) || (this.F) || ((this.t) && (this.A == 0)))
      bool = false;
    do
    {
      return bool;
      bool = this.k.a();
    }
    while (this.i.a());
    n();
    return true;
  }

  public long d()
  {
    boolean[] arrayOfBoolean = m().c;
    long l1;
    if (this.H)
      l1 = -9223372036854775808L;
    do
    {
      return l1;
      if (q())
        return this.E;
      if (this.v)
      {
        int i1 = this.q.length;
        l1 = 9223372036854775807L;
        for (int i2 = 0; i2 < i1; i2++)
          if ((arrayOfBoolean[i2] != 0) && (!this.q[i2].i()))
            l1 = Math.min(l1, this.q[i2].h());
      }
      l1 = -9223372036854775807L;
      if (l1 == -9223372036854775807L)
        l1 = p();
    }
    while (l1 != -9223372036854775808L);
    return this.D;
  }

  public long e()
  {
    if (this.A == 0)
      return -9223372036854775808L;
    return d();
  }

  public void f()
  {
    if (this.t)
    {
      y[] arrayOfy = this.q;
      int i1 = arrayOfy.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfy[i2].k();
    }
    this.i.a(this);
    this.n.removeCallbacksAndMessages(null);
    this.o = null;
    this.I = true;
    this.d.b();
  }

  public void g()
  {
    y[] arrayOfy = this.q;
    int i1 = arrayOfy.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfy[i2].a();
    this.j.a();
  }

  void h()
    throws IOException
  {
    this.i.a(this.c.a(this.w));
  }

  public void i_()
    throws IOException
  {
    h();
  }

  final class a
    implements z.d
  {
    private final Uri b;
    private final ac c;
    private final i.b d;
    private final com.google.android.exoplayer2.extractor.i e;
    private final com.google.android.exoplayer2.g.e f;
    private final n g;
    private volatile boolean h;
    private boolean i;
    private long j;
    private l k;
    private long l;

    public a(Uri paramh, h paramb, i.b parami, com.google.android.exoplayer2.extractor.i parame, com.google.android.exoplayer2.g.e arg6)
    {
      this.b = paramh;
      this.c = new ac(paramb);
      this.d = parami;
      this.e = parame;
      Object localObject;
      this.f = localObject;
      this.g = new n();
      this.i = true;
      this.l = -1L;
      this.k = new l(paramh, this.g.a, -1L, i.a(i.this));
    }

    private void a(long paramLong1, long paramLong2)
    {
      this.g.a = paramLong1;
      this.j = paramLong2;
      this.i = true;
    }

    public void a()
    {
      this.h = true;
    }

    // ERROR //
    public void b()
      throws IOException, java.lang.InterruptedException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: iload_1
      //   3: ifne +356 -> 359
      //   6: aload_0
      //   7: getfield 86	com/google/android/exoplayer2/source/i$a:h	Z
      //   10: ifne +349 -> 359
      //   13: aload_0
      //   14: getfield 55	com/google/android/exoplayer2/source/i$a:g	Lcom/google/android/exoplayer2/extractor/n;
      //   17: getfield 65	com/google/android/exoplayer2/extractor/n:a	J
      //   20: lstore 5
      //   22: aload_0
      //   23: new 63	com/google/android/exoplayer2/f/l
      //   26: dup
      //   27: aload_0
      //   28: getfield 37	com/google/android/exoplayer2/source/i$a:b	Landroid/net/Uri;
      //   31: lload 5
      //   33: ldc2_w 58
      //   36: aload_0
      //   37: getfield 32	com/google/android/exoplayer2/source/i$a:a	Lcom/google/android/exoplayer2/source/i;
      //   40: invokestatic 70	com/google/android/exoplayer2/source/i:a	(Lcom/google/android/exoplayer2/source/i;)Ljava/lang/String;
      //   43: invokespecial 73	com/google/android/exoplayer2/f/l:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
      //   46: putfield 75	com/google/android/exoplayer2/source/i$a:k	Lcom/google/android/exoplayer2/f/l;
      //   49: aload_0
      //   50: aload_0
      //   51: getfield 44	com/google/android/exoplayer2/source/i$a:c	Lcom/google/android/exoplayer2/f/ac;
      //   54: aload_0
      //   55: getfield 75	com/google/android/exoplayer2/source/i$a:k	Lcom/google/android/exoplayer2/f/l;
      //   58: invokevirtual 93	com/google/android/exoplayer2/f/ac:a	(Lcom/google/android/exoplayer2/f/l;)J
      //   61: putfield 61	com/google/android/exoplayer2/source/i$a:l	J
      //   64: aload_0
      //   65: getfield 61	com/google/android/exoplayer2/source/i$a:l	J
      //   68: ldc2_w 58
      //   71: lcmp
      //   72: ifeq +14 -> 86
      //   75: aload_0
      //   76: lload 5
      //   78: aload_0
      //   79: getfield 61	com/google/android/exoplayer2/source/i$a:l	J
      //   82: ladd
      //   83: putfield 61	com/google/android/exoplayer2/source/i$a:l	J
      //   86: aload_0
      //   87: getfield 44	com/google/android/exoplayer2/source/i$a:c	Lcom/google/android/exoplayer2/f/ac;
      //   90: invokevirtual 96	com/google/android/exoplayer2/f/ac:a	()Landroid/net/Uri;
      //   93: invokestatic 101	com/google/android/exoplayer2/g/a:a	(Ljava/lang/Object;)Ljava/lang/Object;
      //   96: checkcast 103	android/net/Uri
      //   99: astore 7
      //   101: new 105	com/google/android/exoplayer2/extractor/d
      //   104: dup
      //   105: aload_0
      //   106: getfield 44	com/google/android/exoplayer2/source/i$a:c	Lcom/google/android/exoplayer2/f/ac;
      //   109: lload 5
      //   111: aload_0
      //   112: getfield 61	com/google/android/exoplayer2/source/i$a:l	J
      //   115: invokespecial 108	com/google/android/exoplayer2/extractor/d:<init>	(Lcom/google/android/exoplayer2/f/h;JJ)V
      //   118: astore 8
      //   120: aload_0
      //   121: getfield 46	com/google/android/exoplayer2/source/i$a:d	Lcom/google/android/exoplayer2/source/i$b;
      //   124: aload 8
      //   126: aload_0
      //   127: getfield 48	com/google/android/exoplayer2/source/i$a:e	Lcom/google/android/exoplayer2/extractor/i;
      //   130: aload 7
      //   132: invokevirtual 113	com/google/android/exoplayer2/source/i$b:a	(Lcom/google/android/exoplayer2/extractor/h;Lcom/google/android/exoplayer2/extractor/i;Landroid/net/Uri;)Lcom/google/android/exoplayer2/extractor/g;
      //   135: astore 10
      //   137: aload_0
      //   138: getfield 57	com/google/android/exoplayer2/source/i$a:i	Z
      //   141: ifeq +21 -> 162
      //   144: aload 10
      //   146: lload 5
      //   148: aload_0
      //   149: getfield 79	com/google/android/exoplayer2/source/i$a:j	J
      //   152: invokeinterface 116 5 0
      //   157: aload_0
      //   158: iconst_0
      //   159: putfield 57	com/google/android/exoplayer2/source/i$a:i	Z
      //   162: lload 5
      //   164: lstore 11
      //   166: iload_1
      //   167: istore 13
      //   169: iload 13
      //   171: ifne +99 -> 270
      //   174: aload_0
      //   175: getfield 86	com/google/android/exoplayer2/source/i$a:h	Z
      //   178: ifne +92 -> 270
      //   181: aload_0
      //   182: getfield 50	com/google/android/exoplayer2/source/i$a:f	Lcom/google/android/exoplayer2/g/e;
      //   185: invokevirtual 120	com/google/android/exoplayer2/g/e:c	()V
      //   188: aload 10
      //   190: aload 8
      //   192: aload_0
      //   193: getfield 55	com/google/android/exoplayer2/source/i$a:g	Lcom/google/android/exoplayer2/extractor/n;
      //   196: invokeinterface 123 3 0
      //   201: istore 16
      //   203: iload 16
      //   205: istore 4
      //   207: aload 8
      //   209: invokeinterface 128 1 0
      //   214: lload 11
      //   216: aload_0
      //   217: getfield 32	com/google/android/exoplayer2/source/i$a:a	Lcom/google/android/exoplayer2/source/i;
      //   220: invokestatic 131	com/google/android/exoplayer2/source/i:b	(Lcom/google/android/exoplayer2/source/i;)J
      //   223: ladd
      //   224: lcmp
      //   225: ifle +175 -> 400
      //   228: aload 8
      //   230: invokeinterface 128 1 0
      //   235: lstore 11
      //   237: aload_0
      //   238: getfield 50	com/google/android/exoplayer2/source/i$a:f	Lcom/google/android/exoplayer2/g/e;
      //   241: invokevirtual 134	com/google/android/exoplayer2/g/e:b	()Z
      //   244: pop
      //   245: aload_0
      //   246: getfield 32	com/google/android/exoplayer2/source/i$a:a	Lcom/google/android/exoplayer2/source/i;
      //   249: invokestatic 137	com/google/android/exoplayer2/source/i:d	(Lcom/google/android/exoplayer2/source/i;)Landroid/os/Handler;
      //   252: aload_0
      //   253: getfield 32	com/google/android/exoplayer2/source/i$a:a	Lcom/google/android/exoplayer2/source/i;
      //   256: invokestatic 140	com/google/android/exoplayer2/source/i:c	(Lcom/google/android/exoplayer2/source/i;)Ljava/lang/Runnable;
      //   259: invokevirtual 146	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   262: pop
      //   263: iload 4
      //   265: istore 13
      //   267: goto -98 -> 169
      //   270: iload 13
      //   272: iconst_1
      //   273: if_icmpne +19 -> 292
      //   276: iconst_0
      //   277: istore 14
      //   279: aload_0
      //   280: getfield 44	com/google/android/exoplayer2/source/i$a:c	Lcom/google/android/exoplayer2/f/ac;
      //   283: invokestatic 150	com/google/android/exoplayer2/g/ag:a	(Lcom/google/android/exoplayer2/f/h;)V
      //   286: iload 14
      //   288: istore_1
      //   289: goto -287 -> 2
      //   292: aload 8
      //   294: ifnull +17 -> 311
      //   297: aload_0
      //   298: getfield 55	com/google/android/exoplayer2/source/i$a:g	Lcom/google/android/exoplayer2/extractor/n;
      //   301: aload 8
      //   303: invokeinterface 128 1 0
      //   308: putfield 65	com/google/android/exoplayer2/extractor/n:a	J
      //   311: iload 13
      //   313: istore 14
      //   315: goto -36 -> 279
      //   318: astore_2
      //   319: aconst_null
      //   320: astore_3
      //   321: iload_1
      //   322: istore 4
      //   324: iload 4
      //   326: iconst_1
      //   327: if_icmpne +12 -> 339
      //   330: aload_0
      //   331: getfield 44	com/google/android/exoplayer2/source/i$a:c	Lcom/google/android/exoplayer2/f/ac;
      //   334: invokestatic 150	com/google/android/exoplayer2/g/ag:a	(Lcom/google/android/exoplayer2/f/h;)V
      //   337: aload_2
      //   338: athrow
      //   339: aload_3
      //   340: ifnull -10 -> 330
      //   343: aload_0
      //   344: getfield 55	com/google/android/exoplayer2/source/i$a:g	Lcom/google/android/exoplayer2/extractor/n;
      //   347: aload_3
      //   348: invokeinterface 128 1 0
      //   353: putfield 65	com/google/android/exoplayer2/extractor/n:a	J
      //   356: goto -26 -> 330
      //   359: return
      //   360: astore 9
      //   362: iload_1
      //   363: istore 4
      //   365: aload 9
      //   367: astore_2
      //   368: aload 8
      //   370: astore_3
      //   371: goto -47 -> 324
      //   374: astore 15
      //   376: iload 13
      //   378: istore 4
      //   380: aload 8
      //   382: astore_3
      //   383: aload 15
      //   385: astore_2
      //   386: goto -62 -> 324
      //   389: astore 17
      //   391: aload 8
      //   393: astore_3
      //   394: aload 17
      //   396: astore_2
      //   397: goto -73 -> 324
      //   400: iload 4
      //   402: istore 13
      //   404: goto -235 -> 169
      //
      // Exception table:
      //   from	to	target	type
      //   13	86	318	finally
      //   86	120	318	finally
      //   120	162	360	finally
      //   174	203	374	finally
      //   207	263	389	finally
    }
  }

  private static final class b
  {
    private final g[] a;
    private g b;

    public b(g[] paramArrayOfg)
    {
      this.a = paramArrayOfg;
    }

    // ERROR //
    public g a(com.google.android.exoplayer2.extractor.h paramh, com.google.android.exoplayer2.extractor.i parami, Uri paramUri)
      throws IOException, java.lang.InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/google/android/exoplayer2/source/i$b:b	Lcom/google/android/exoplayer2/extractor/g;
      //   4: ifnull +8 -> 12
      //   7: aload_0
      //   8: getfield 24	com/google/android/exoplayer2/source/i$b:b	Lcom/google/android/exoplayer2/extractor/g;
      //   11: areturn
      //   12: aload_0
      //   13: getfield 15	com/google/android/exoplayer2/source/i$b:a	[Lcom/google/android/exoplayer2/extractor/g;
      //   16: astore 4
      //   18: aload 4
      //   20: arraylength
      //   21: istore 5
      //   23: iconst_0
      //   24: istore 6
      //   26: iload 6
      //   28: iload 5
      //   30: if_icmpge +33 -> 63
      //   33: aload 4
      //   35: iload 6
      //   37: aaload
      //   38: astore 7
      //   40: aload 7
      //   42: aload_1
      //   43: invokeinterface 29 2 0
      //   48: ifeq +61 -> 109
      //   51: aload_0
      //   52: aload 7
      //   54: putfield 24	com/google/android/exoplayer2/source/i$b:b	Lcom/google/android/exoplayer2/extractor/g;
      //   57: aload_1
      //   58: invokeinterface 33 1 0
      //   63: aload_0
      //   64: getfield 24	com/google/android/exoplayer2/source/i$b:b	Lcom/google/android/exoplayer2/extractor/g;
      //   67: ifnonnull +76 -> 143
      //   70: new 35	com/google/android/exoplayer2/source/ac
      //   73: dup
      //   74: new 37	java/lang/StringBuilder
      //   77: dup
      //   78: invokespecial 38	java/lang/StringBuilder:<init>	()V
      //   81: ldc 40
      //   83: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: aload_0
      //   87: getfield 15	com/google/android/exoplayer2/source/i$b:a	[Lcom/google/android/exoplayer2/extractor/g;
      //   90: invokestatic 49	com/google/android/exoplayer2/g/ag:b	([Ljava/lang/Object;)Ljava/lang/String;
      //   93: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   96: ldc 51
      //   98: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   101: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   104: aload_3
      //   105: invokespecial 58	com/google/android/exoplayer2/source/ac:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
      //   108: athrow
      //   109: aload_1
      //   110: invokeinterface 33 1 0
      //   115: iinc 6 1
      //   118: goto -92 -> 26
      //   121: astore 9
      //   123: aload_1
      //   124: invokeinterface 33 1 0
      //   129: goto -14 -> 115
      //   132: astore 8
      //   134: aload_1
      //   135: invokeinterface 33 1 0
      //   140: aload 8
      //   142: athrow
      //   143: aload_0
      //   144: getfield 24	com/google/android/exoplayer2/source/i$b:b	Lcom/google/android/exoplayer2/extractor/g;
      //   147: aload_2
      //   148: invokeinterface 61 2 0
      //   153: aload_0
      //   154: getfield 24	com/google/android/exoplayer2/source/i$b:b	Lcom/google/android/exoplayer2/extractor/g;
      //   157: areturn
      //
      // Exception table:
      //   from	to	target	type
      //   40	57	121	java/io/EOFException
      //   40	57	132	finally
    }

    public void a()
    {
      if (this.b != null)
      {
        this.b.c();
        this.b = null;
      }
    }
  }

  static abstract interface c
  {
    public abstract void a(long paramLong, boolean paramBoolean);
  }

  private static final class d
  {
    public final com.google.android.exoplayer2.extractor.o a;
    public final TrackGroupArray b;
    public final boolean[] c;
    public final boolean[] d;
    public final boolean[] e;

    public d(com.google.android.exoplayer2.extractor.o paramo, TrackGroupArray paramTrackGroupArray, boolean[] paramArrayOfBoolean)
    {
      this.a = paramo;
      this.b = paramTrackGroupArray;
      this.c = paramArrayOfBoolean;
      this.d = new boolean[paramTrackGroupArray.length];
      this.e = new boolean[paramTrackGroupArray.length];
    }
  }

  private final class e
    implements z
  {
    private final int b;

    public e(int arg2)
    {
      int i;
      this.b = i;
    }

    public int a(long paramLong)
    {
      return i.this.a(this.b, paramLong);
    }

    public int a(com.google.android.exoplayer2.p paramp, com.google.android.exoplayer2.c.e parame, boolean paramBoolean)
    {
      return i.this.a(this.b, paramp, parame, paramBoolean);
    }

    public boolean b()
    {
      return i.this.a(this.b);
    }

    public void c()
      throws IOException
    {
      i.this.h();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i
 * JD-Core Version:    0.6.2
 */