package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class h
  implements com.google.android.exoplayer2.extractor.g, com.google.android.exoplayer2.extractor.o
{
  public static final j a = i.a;
  private static final int b = ag.g("qt  ");
  private final int c;
  private final r d;
  private final r e;
  private final r f;
  private final ArrayDeque<a.a> g;
  private int h;
  private int i;
  private long j;
  private int k;
  private r l;
  private int m;
  private int n;
  private int o;
  private com.google.android.exoplayer2.extractor.i p;
  private a[] q;
  private long[][] r;
  private int s;
  private long t;
  private boolean u;

  public h()
  {
    this(0);
  }

  public h(int paramInt)
  {
    this.c = paramInt;
    this.f = new r(16);
    this.g = new ArrayDeque();
    this.d = new r(com.google.android.exoplayer2.g.p.a);
    this.e = new r(4);
    this.m = -1;
  }

  private static int a(o paramo, long paramLong)
  {
    int i1 = paramo.a(paramLong);
    if (i1 == -1)
      i1 = paramo.b(paramLong);
    return i1;
  }

  private static long a(o paramo, long paramLong1, long paramLong2)
  {
    int i1 = a(paramo, paramLong1);
    if (i1 == -1)
      return paramLong2;
    return Math.min(paramo.c[i1], paramLong2);
  }

  private ArrayList<o> a(a.a parama, com.google.android.exoplayer2.extractor.k paramk, boolean paramBoolean)
    throws w
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < parama.aZ.size())
    {
      a.a locala = (a.a)parama.aZ.get(i1);
      if (locala.aW != a.D);
      while (true)
      {
        i1++;
        break;
        l locall = b.a(locala, parama.d(a.C), -9223372036854775807L, null, paramBoolean, this.u);
        if (locall != null)
        {
          o localo = b.a(locall, locala.e(a.E).e(a.F).e(a.G), paramk);
          if (localo.b != 0)
            localArrayList.add(localo);
        }
      }
    }
    return localArrayList;
  }

  private void a(a.a parama)
    throws w
  {
    int i1 = -1;
    ArrayList localArrayList1 = new ArrayList();
    com.google.android.exoplayer2.extractor.k localk = new com.google.android.exoplayer2.extractor.k();
    a.b localb = parama.d(a.aA);
    Metadata localMetadata3;
    if (localb != null)
    {
      localMetadata3 = b.a(localb, this.u);
      if (localMetadata3 != null)
        localk.a(localMetadata3);
    }
    for (Metadata localMetadata1 = localMetadata3; ; localMetadata1 = null)
    {
      a.a locala = parama.e(a.aB);
      if (locala != null);
      for (Metadata localMetadata2 = b.a(locala); ; localMetadata2 = null)
      {
        boolean bool;
        int i3;
        long l1;
        label120: o localo;
        a locala1;
        long l2;
        label246: long l3;
        if ((0x1 & this.c) != 0)
        {
          bool = true;
          ArrayList localArrayList2 = a(parama, localk, bool);
          int i2 = localArrayList2.size();
          i3 = 0;
          l1 = -9223372036854775807L;
          if (i3 >= i2)
            break label315;
          localo = (o)localArrayList2.get(i3);
          l locall = localo.a;
          locala1 = new a(locall, localo, this.p.a(i3, locall.b));
          int i4 = 30 + localo.e;
          Format localFormat1 = locall.f.copyWithMaxInputSize(i4);
          Format localFormat2 = g.a(locall.b, localFormat1, localMetadata1, localMetadata2, localk);
          locala1.c.a(localFormat2);
          if (locall.e == -9223372036854775807L)
            break label305;
          l2 = locall.e;
          l3 = Math.max(l1, l2);
          if ((locall.b != 2) || (i1 != -1))
            break label379;
        }
        label305: label315: label379: for (int i5 = localArrayList1.size(); ; i5 = i1)
        {
          localArrayList1.add(locala1);
          i3++;
          l1 = l3;
          i1 = i5;
          break label120;
          bool = false;
          break;
          l2 = localo.h;
          break label246;
          this.s = i1;
          this.t = l1;
          this.q = ((a[])localArrayList1.toArray(new a[localArrayList1.size()]));
          this.r = a(this.q);
          this.p.a();
          this.p.a(this);
          return;
        }
      }
    }
  }

  private static boolean a(int paramInt)
  {
    return (paramInt == a.R) || (paramInt == a.C) || (paramInt == a.S) || (paramInt == a.T) || (paramInt == a.am) || (paramInt == a.an) || (paramInt == a.ao) || (paramInt == a.Q) || (paramInt == a.ap) || (paramInt == a.aq) || (paramInt == a.ar) || (paramInt == a.as) || (paramInt == a.at) || (paramInt == a.O) || (paramInt == a.a) || (paramInt == a.aA) || (paramInt == a.aC) || (paramInt == a.aD);
  }

  private static boolean a(r paramr)
  {
    paramr.c(8);
    if (paramr.p() == b)
      return true;
    paramr.d(4);
    while (paramr.b() > 0)
      if (paramr.p() == b)
        return true;
    return false;
  }

  private static long[][] a(a[] paramArrayOfa)
  {
    long[][] arrayOfLong = new long[paramArrayOfa.length][];
    int[] arrayOfInt = new int[paramArrayOfa.length];
    long[] arrayOfLong1 = new long[paramArrayOfa.length];
    boolean[] arrayOfBoolean = new boolean[paramArrayOfa.length];
    for (int i1 = 0; i1 < paramArrayOfa.length; i1++)
    {
      arrayOfLong[i1] = new long[paramArrayOfa[i1].b.b];
      arrayOfLong1[i1] = paramArrayOfa[i1].b.f[0];
    }
    long l1 = 0L;
    int i2 = 0;
    while (i2 < paramArrayOfa.length)
    {
      long l2 = 9223372036854775807L;
      int i3 = -1;
      for (int i4 = 0; i4 < paramArrayOfa.length; i4++)
        if ((arrayOfBoolean[i4] == 0) && (arrayOfLong1[i4] <= l2))
        {
          l2 = arrayOfLong1[i4];
          i3 = i4;
        }
      int i5 = arrayOfInt[i3];
      arrayOfLong[i3][i5] = l1;
      l1 += paramArrayOfa[i3].b.d[i5];
      int i6 = i5 + 1;
      arrayOfInt[i3] = i6;
      if (i6 < arrayOfLong[i3].length)
      {
        arrayOfLong1[i3] = paramArrayOfa[i3].b.f[i6];
      }
      else
      {
        arrayOfBoolean[i3] = true;
        i2++;
      }
    }
    return arrayOfLong;
  }

  private void b(long paramLong)
    throws w
  {
    while ((!this.g.isEmpty()) && (((a.a)this.g.peek()).aX == paramLong))
    {
      a.a locala = (a.a)this.g.pop();
      if (locala.aW == a.B)
      {
        a(locala);
        this.g.clear();
        this.h = 2;
      }
      else if (!this.g.isEmpty())
      {
        ((a.a)this.g.peek()).a(locala);
      }
    }
    if (this.h != 2)
      e();
  }

  private static boolean b(int paramInt)
  {
    return (paramInt == a.B) || (paramInt == a.D) || (paramInt == a.E) || (paramInt == a.F) || (paramInt == a.G) || (paramInt == a.P) || (paramInt == a.aB);
  }

  private boolean b(com.google.android.exoplayer2.extractor.h paramh)
    throws IOException, InterruptedException
  {
    if (this.k == 0)
    {
      if (!paramh.a(this.f.a, 0, 8, true))
        return false;
      this.k = 8;
      this.f.c(0);
      this.j = this.f.n();
      this.i = this.f.p();
    }
    if (this.j == 1L)
    {
      paramh.b(this.f.a, 8, 8);
      this.k = (8 + this.k);
      this.j = this.f.x();
    }
    while (this.j < this.k)
    {
      throw new w("Atom size less than header length (unsupported).");
      if (this.j == 0L)
      {
        long l1 = paramh.d();
        if ((l1 == -1L) && (!this.g.isEmpty()))
          l1 = ((a.a)this.g.peek()).aX;
        if (l1 != -1L)
          this.j = (l1 - paramh.c() + this.k);
      }
    }
    if (b(this.i))
    {
      long l2 = paramh.c() + this.j - this.k;
      this.g.push(new a.a(this.i, l2));
      if (this.j == this.k)
        b(l2);
    }
    while (true)
    {
      return true;
      e();
      continue;
      if (a(this.i))
      {
        boolean bool1;
        if (this.k == 8)
        {
          bool1 = true;
          label313: com.google.android.exoplayer2.g.a.b(bool1);
          if (this.j > 2147483647L)
            break label388;
        }
        label388: for (boolean bool2 = true; ; bool2 = false)
        {
          com.google.android.exoplayer2.g.a.b(bool2);
          this.l = new r((int)this.j);
          System.arraycopy(this.f.a, 0, this.l.a, 0, 8);
          this.h = 1;
          break;
          bool1 = false;
          break label313;
        }
      }
      this.l = null;
      this.h = 1;
    }
  }

  private boolean b(com.google.android.exoplayer2.extractor.h paramh, n paramn)
    throws IOException, InterruptedException
  {
    long l1 = this.j - this.k;
    long l2 = l1 + paramh.c();
    int i1;
    if (this.l != null)
    {
      paramh.b(this.l.a, this.k, (int)l1);
      if (this.i == a.a)
      {
        this.u = a(this.l);
        i1 = 0;
      }
    }
    while (true)
    {
      b(l2);
      if ((i1 != 0) && (this.h != 2))
      {
        return true;
        if (!this.g.isEmpty())
        {
          ((a.a)this.g.peek()).a(new a.b(this.i, this.l));
          i1 = 0;
          continue;
          if (l1 < 262144L)
          {
            paramh.b((int)l1);
            i1 = 0;
            continue;
          }
          paramn.a = (l1 + paramh.c());
          i1 = 1;
        }
      }
      else
      {
        return false;
        i1 = 0;
      }
    }
  }

  private int c(long paramLong)
  {
    long l1 = 9223372036854775807L;
    int i1 = 1;
    int i2 = -1;
    long l2 = 9223372036854775807L;
    long l3 = 9223372036854775807L;
    int i3 = 1;
    int i4 = -1;
    int i5 = 0;
    while (i5 < this.q.length)
    {
      a locala = this.q[i5];
      int i6 = locala.d;
      if (i6 == locala.b.b)
      {
        i5++;
      }
      else
      {
        long l4 = locala.b.c[i6];
        long l5 = this.r[i5][i6];
        long l6 = l4 - paramLong;
        if ((l6 < 0L) || (l6 >= 262144L));
        for (int i7 = 1; ; i7 = 0)
        {
          if (((i7 == 0) && (i1 != 0)) || ((i7 == i1) && (l6 < l1)))
          {
            l2 = l5;
            i2 = i5;
            i1 = i7;
            l1 = l6;
          }
          if (l5 >= l3)
            break;
          i4 = i5;
          i3 = i7;
          l3 = l5;
          break;
        }
      }
    }
    if ((l3 == 9223372036854775807L) || (i3 == 0) || (l2 < l3 + 10485760L))
      i4 = i2;
    return i4;
  }

  private int c(com.google.android.exoplayer2.extractor.h paramh, n paramn)
    throws IOException, InterruptedException
  {
    long l1 = paramh.c();
    if (this.m == -1)
    {
      this.m = c(l1);
      if (this.m == -1)
        return -1;
    }
    a locala = this.q[this.m];
    q localq = locala.c;
    int i1 = locala.d;
    long l2 = locala.b.c[i1];
    int i2 = locala.b.d[i1];
    long l3 = l2 - l1 + this.n;
    if ((l3 < 0L) || (l3 >= 262144L))
    {
      paramn.a = l2;
      return 1;
    }
    if (locala.a.g == 1)
    {
      l3 += 8L;
      i2 -= 8;
    }
    paramh.b((int)l3);
    if (locala.a.j != 0)
    {
      byte[] arrayOfByte = this.e.a;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      int i5 = locala.a.j;
      int i6 = 4 - locala.a.j;
      while (this.n < i2)
        if (this.o == 0)
        {
          paramh.b(this.e.a, i6, i5);
          this.e.c(0);
          this.o = this.e.v();
          this.d.c(0);
          localq.a(this.d, 4);
          this.n = (4 + this.n);
          i2 += i6;
        }
        else
        {
          int i7 = localq.a(paramh, this.o, false);
          this.n = (i7 + this.n);
          this.o -= i7;
        }
    }
    for (int i3 = i2; ; i3 = i2)
    {
      localq.a(locala.b.f[i1], locala.b.g[i1], i3, 0, null);
      locala.d = (1 + locala.d);
      this.m = -1;
      this.n = 0;
      this.o = 0;
      return 0;
      while (this.n < i2)
      {
        int i4 = localq.a(paramh, i2 - this.n, false);
        this.n = (i4 + this.n);
        this.o -= i4;
      }
    }
  }

  private void d(long paramLong)
  {
    for (a locala : this.q)
    {
      o localo = locala.b;
      int i3 = localo.a(paramLong);
      if (i3 == -1)
        i3 = localo.b(paramLong);
      locala.d = i3;
    }
  }

  private void e()
  {
    this.h = 0;
    this.k = 0;
  }

  public int a(com.google.android.exoplayer2.extractor.h paramh, n paramn)
    throws IOException, InterruptedException
  {
    do
    {
      do
        switch (this.h)
        {
        default:
          throw new IllegalStateException();
        case 0:
        case 1:
        case 2:
        }
      while (b(paramh));
      return -1;
    }
    while (!b(paramh, paramn));
    return 1;
    return c(paramh, paramn);
  }

  public o.a a(long paramLong)
  {
    if (this.q.length == 0)
      return new o.a(com.google.android.exoplayer2.extractor.p.a);
    long l1 = -9223372036854775807L;
    long l2 = -1L;
    long l3;
    if (this.s != -1)
    {
      o localo2 = this.q[this.s].b;
      int i2 = a(localo2, paramLong);
      if (i2 == -1)
        return new o.a(com.google.android.exoplayer2.extractor.p.a);
      long l6 = localo2.f[i2];
      l3 = localo2.c[i2];
      if ((l6 < paramLong) && (i2 < -1 + localo2.b))
      {
        int i3 = localo2.b(paramLong);
        if ((i3 != -1) && (i3 != i2))
        {
          l1 = localo2.f[i3];
          l2 = localo2.c[i3];
        }
      }
      paramLong = l6;
    }
    long l4;
    long l5;
    while (true)
    {
      l4 = l3;
      l5 = l2;
      for (int i1 = 0; i1 < this.q.length; i1++)
        if (i1 != this.s)
        {
          o localo1 = this.q[i1].b;
          l4 = a(localo1, paramLong, l4);
          if (l1 != -9223372036854775807L)
            l5 = a(localo1, l1, l5);
        }
      l3 = 9223372036854775807L;
    }
    com.google.android.exoplayer2.extractor.p localp = new com.google.android.exoplayer2.extractor.p(paramLong, l4);
    if (l1 == -9223372036854775807L)
      return new o.a(localp);
    return new o.a(localp, new com.google.android.exoplayer2.extractor.p(l1, l5));
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.g.clear();
    this.k = 0;
    this.m = -1;
    this.n = 0;
    this.o = 0;
    if (paramLong1 == 0L)
      e();
    while (this.q == null)
      return;
    d(paramLong2);
  }

  public void a(com.google.android.exoplayer2.extractor.i parami)
  {
    this.p = parami;
  }

  public boolean a()
  {
    return true;
  }

  public boolean a(com.google.android.exoplayer2.extractor.h paramh)
    throws IOException, InterruptedException
  {
    return k.b(paramh);
  }

  public long b()
  {
    return this.t;
  }

  public void c()
  {
  }

  private static final class a
  {
    public final l a;
    public final o b;
    public final q c;
    public int d;

    public a(l paraml, o paramo, q paramq)
    {
      this.a = paraml;
      this.b = paramo;
      this.c = paramq;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.h
 * JD-Core Version:    0.6.2
 */