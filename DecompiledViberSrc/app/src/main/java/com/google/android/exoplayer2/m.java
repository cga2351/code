package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.g.k;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.n.b;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.trackselection.h.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

final class m
  implements Handler.Callback, ac.a, g.a, com.google.android.exoplayer2.source.m.a, n.b, h.a
{
  private int A;
  private boolean B;
  private int C;
  private d D;
  private long E;
  private int F;
  private final ad[] a;
  private final af[] b;
  private final h c;
  private final com.google.android.exoplayer2.trackselection.i d;
  private final s e;
  private final d f;
  private final k g;
  private final HandlerThread h;
  private final Handler i;
  private final j j;
  private final ak.b k;
  private final ak.a l;
  private final long m;
  private final boolean n;
  private final g o;
  private final c p;
  private final ArrayList<b> q;
  private final b r;
  private final v s;
  private ai t;
  private x u;
  private com.google.android.exoplayer2.source.n v;
  private ad[] w;
  private boolean x;
  private boolean y;
  private boolean z;

  public m(ad[] paramArrayOfad, h paramh, com.google.android.exoplayer2.trackselection.i parami, s params, d paramd, boolean paramBoolean1, int paramInt, boolean paramBoolean2, Handler paramHandler, j paramj, b paramb)
  {
    this.a = paramArrayOfad;
    this.c = paramh;
    this.d = parami;
    this.e = params;
    this.f = paramd;
    this.y = paramBoolean1;
    this.A = paramInt;
    this.B = paramBoolean2;
    this.i = paramHandler;
    this.j = paramj;
    this.r = paramb;
    this.s = new v();
    this.m = params.e();
    this.n = params.f();
    this.t = ai.e;
    this.u = x.a(-9223372036854775807L, parami);
    this.p = new c(null);
    this.b = new af[paramArrayOfad.length];
    for (int i1 = 0; i1 < paramArrayOfad.length; i1++)
    {
      paramArrayOfad[i1].a(i1);
      this.b[i1] = paramArrayOfad[i1].b();
    }
    this.o = new g(this, paramb);
    this.q = new ArrayList();
    this.w = new ad[0];
    this.k = new ak.b();
    this.l = new ak.a();
    paramh.a(this, paramd);
    this.h = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.h.start();
    this.g = paramb.a(this.h.getLooper(), this);
  }

  private long a(n.a parama, long paramLong)
    throws i
  {
    if (this.s.c() != this.s.d());
    for (boolean bool = true; ; bool = false)
      return a(parama, paramLong, bool);
  }

  private long a(n.a parama, long paramLong, boolean paramBoolean)
    throws i
  {
    e();
    this.z = false;
    b(2);
    t localt1 = this.s.c();
    for (t localt2 = localt1; ; localt2 = this.s.h())
      if (localt2 != null)
      {
        if ((parama.equals(localt2.g.a)) && (localt2.e))
          this.s.a(localt2);
      }
      else
      {
        if ((localt1 == localt2) && (!paramBoolean))
          break label136;
        ad[] arrayOfad = this.w;
        int i1 = arrayOfad.length;
        for (int i2 = 0; i2 < i1; i2++)
          b(arrayOfad[i2]);
      }
    this.w = new ad[0];
    localt1 = null;
    label136: if (localt2 != null)
    {
      a(localt1);
      if (localt2.f)
      {
        paramLong = localt2.a.b(paramLong);
        localt2.a.a(paramLong - this.m, this.n);
      }
      a(paramLong);
      q();
    }
    while (true)
    {
      i(false);
      this.g.a(2);
      return paramLong;
      this.s.b(true);
      this.u = this.u.a(TrackGroupArray.EMPTY, this.d);
      a(paramLong);
    }
  }

  private Pair<Object, Long> a(d paramd, boolean paramBoolean)
  {
    ak localak1 = this.u.a;
    ak localak2 = paramd.a;
    if (localak1.a())
      return null;
    if (localak2.a())
      localak2 = localak1;
    Pair localPair;
    try
    {
      localPair = localak2.a(this.k, this.l, paramd.b, paramd.c);
      if (localak1 == localak2)
        return localPair;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new q(localak1, paramd.b, paramd.c);
    }
    int i1 = localak1.a(localPair.first);
    if (i1 != -1)
      return localPair;
    if ((paramBoolean) && (a(localPair.first, localak2, localak1) != null))
      return b(localak1, localak1.a(i1, this.l).c, -9223372036854775807L);
    return null;
  }

  private Object a(Object paramObject, ak paramak1, ak paramak2)
  {
    int i1 = paramak1.a(paramObject);
    int i2 = paramak1.c();
    int i3 = 0;
    int i4 = -1;
    while (true)
    {
      int i5;
      if ((i3 < i2) && (i4 == -1))
      {
        i5 = paramak1.a(i1, this.l, this.k, this.A, this.B);
        if (i5 != -1);
      }
      else
      {
        if (i4 != -1)
          break;
        return null;
      }
      int i6 = paramak2.a(paramak1.a(i5));
      i3++;
      i4 = i6;
      i1 = i5;
    }
    return paramak2.a(i4);
  }

  private void a(float paramFloat)
  {
    for (t localt = this.s.e(); localt != null; localt = localt.h)
      if (localt.j != null)
        for (e locale : localt.j.c.a())
          if (locale != null)
            locale.a(paramFloat);
  }

  private void a(int paramInt1, boolean paramBoolean, int paramInt2)
    throws i
  {
    boolean bool1 = true;
    t localt = this.s.c();
    ad localad = this.a[paramInt1];
    this.w[paramInt2] = localad;
    ag localag;
    Format[] arrayOfFormat;
    boolean bool2;
    if (localad.g_() == 0)
    {
      localag = localt.j.b[paramInt1];
      arrayOfFormat = a(localt.j.c.a(paramInt1));
      if ((!this.y) || (this.u.f != 3))
        break label149;
      bool2 = bool1;
      if ((paramBoolean) || (!bool2))
        break label155;
    }
    while (true)
    {
      localad.a(localag, arrayOfFormat, localt.c[paramInt1], this.E, bool1, localt.a());
      this.o.a(localad);
      if (bool2)
        localad.h_();
      return;
      label149: bool2 = false;
      break;
      label155: bool1 = false;
    }
  }

  private void a(long paramLong)
    throws i
  {
    if (!this.s.f());
    while (true)
    {
      this.E = paramLong;
      this.o.a(this.E);
      ad[] arrayOfad = this.w;
      int i1 = arrayOfad.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfad[i2].a(this.E);
      paramLong = this.s.c().a(paramLong);
    }
  }

  private void a(long paramLong1, long paramLong2)
  {
    this.g.b(2);
    this.g.a(2, paramLong1 + paramLong2);
  }

  private void a(ad paramad)
    throws i
  {
    if (paramad.g_() == 2)
      paramad.k();
  }

  private void a(ai paramai)
  {
    this.t = paramai;
  }

  private void a(a parama)
    throws i
  {
    long l1 = 0L;
    if (parama.a != this.v);
    ak localak1;
    ak localak2;
    do
    {
      do
      {
        return;
        localak1 = this.u.a;
        localak2 = parama.b;
        Object localObject1 = parama.c;
        this.s.a(localak2);
        this.u = this.u.a(localak2, localObject1);
        i();
        if (this.C <= 0)
          break;
        this.p.a(this.C);
        this.C = 0;
        if (this.D != null)
        {
          Pair localPair4;
          try
          {
            localPair4 = a(this.D, true);
            this.D = null;
            if (localPair4 == null)
            {
              n();
              return;
            }
          }
          catch (q localq)
          {
            n.a locala6 = this.u.a(this.B, this.k);
            this.u = this.u.a(locala6, -9223372036854775807L, -9223372036854775807L);
            throw localq;
          }
          Object localObject7 = localPair4.first;
          long l10 = ((Long)localPair4.second).longValue();
          n.a locala7 = this.s.a(localObject7, l10);
          x localx3 = this.u;
          if (locala7.a());
          for (long l11 = l1; ; l11 = l10)
          {
            this.u = localx3.a(locala7, l11, l10);
            return;
          }
        }
      }
      while (this.u.d != -9223372036854775807L);
      if (localak2.a())
      {
        n();
        return;
      }
      Pair localPair3 = b(localak2, localak2.b(this.B), -9223372036854775807L);
      Object localObject6 = localPair3.first;
      long l8 = ((Long)localPair3.second).longValue();
      n.a locala5 = this.s.a(localObject6, l8);
      x localx2 = this.u;
      if (locala5.a());
      for (long l9 = l1; ; l9 = l8)
      {
        this.u = localx2.a(locala5, l9, l8);
        return;
      }
      if (!localak1.a())
        break;
    }
    while (localak2.a());
    Pair localPair2 = b(localak2, localak2.b(this.B), -9223372036854775807L);
    Object localObject5 = localPair2.first;
    long l6 = ((Long)localPair2.second).longValue();
    n.a locala4 = this.s.a(localObject5, l6);
    x localx1 = this.u;
    if (locala4.a());
    for (long l7 = l1; ; l7 = l6)
    {
      this.u = localx1.a(locala4, l7, l6);
      return;
    }
    t localt1 = this.s.e();
    long l2 = this.u.e;
    Object localObject2;
    if (localt1 == null)
      localObject2 = this.u.c.a;
    while (localak2.a(localObject2) == -1)
    {
      Object localObject3 = a(localObject2, localak1, localak2);
      if (localObject3 == null)
      {
        n();
        return;
        localObject2 = localt1.b;
      }
      else
      {
        Pair localPair1 = b(localak2, localak2.a(localObject3, this.l).c, -9223372036854775807L);
        Object localObject4 = localPair1.first;
        long l4 = ((Long)localPair1.second).longValue();
        n.a locala3 = this.s.a(localObject4, l4);
        if (localt1 != null)
        {
          t localt2 = localt1;
          while (localt2.h != null)
          {
            localt2 = localt2.h;
            if (localt2.g.a.equals(locala3))
              localt2.g = this.s.a(localt2.g);
          }
        }
        if (locala3.a());
        while (true)
        {
          long l5 = a(locala3, l1);
          this.u = this.u.a(locala3, l5, l4, r());
          return;
          l1 = l4;
        }
      }
    }
    n.a locala1 = this.u.c;
    if (locala1.a())
    {
      n.a locala2 = this.s.a(localObject2, l2);
      if (!locala2.equals(locala1))
      {
        if (locala2.a());
        while (true)
        {
          long l3 = a(locala2, l1);
          this.u = this.u.a(locala2, l3, l2, r());
          return;
          l1 = l2;
        }
      }
    }
    if (!this.s.a(locala1, this.E))
      g(false);
    i(false);
  }

  private void a(d paramd)
    throws i
  {
    this.p.a(1);
    Pair localPair = a(paramd, true);
    n.a locala;
    long l2;
    long l1;
    int i2;
    if (localPair == null)
    {
      locala = this.u.a(this.B, this.k);
      l2 = -9223372036854775807L;
      l1 = -9223372036854775807L;
      i2 = 1;
    }
    try
    {
      if ((this.v == null) || (this.C > 0))
        this.D = paramd;
      while (true)
      {
        label102: return;
        Object localObject1 = localPair.first;
        l1 = ((Long)localPair.second).longValue();
        locala = this.s.a(localObject1, l1);
        if (locala.a())
        {
          l2 = 0L;
          i2 = 1;
          break;
        }
        l2 = ((Long)localPair.second).longValue();
        if (paramd.c == -9223372036854775807L);
        for (int i1 = 1; ; i1 = 0)
        {
          i2 = i1;
          break;
        }
        if (l2 != -9223372036854775807L)
          break label251;
        b(4);
        a(false, true, false);
      }
    }
    finally
    {
      this.u = this.u.a(locala, l2, l1, r());
      if (i2 != 0)
        this.p.b(2);
    }
    label251: t localt;
    if (locala.equals(this.u.c))
    {
      localt = this.s.c();
      if ((localt == null) || (l2 == 0L))
        break label413;
    }
    label413: for (long l3 = localt.a.a(l2, this.t); ; l3 = l2)
    {
      if (c.a(l3) == c.a(this.u.m))
      {
        long l5 = this.u.m;
        this.u = this.u.a(locala, l5, l1, r());
        if (i2 == 0)
          break label102;
        this.p.b(2);
        return;
        l3 = l2;
      }
      long l4 = a(locala, l3);
      if (l2 != l4);
      for (int i3 = 1; ; i3 = 0)
      {
        i2 = i3 | i2;
        l2 = l4;
        break;
      }
    }
  }

  private void a(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.i parami)
  {
    this.e.a(this.a, paramTrackGroupArray, parami.c);
  }

  private void a(t paramt)
    throws i
  {
    t localt = this.s.c();
    if ((localt == null) || (paramt == localt))
      return;
    boolean[] arrayOfBoolean = new boolean[this.a.length];
    int i1 = 0;
    int i2 = 0;
    if (i1 < this.a.length)
    {
      ad localad = this.a[i1];
      if (localad.g_() != 0);
      for (int i3 = 1; ; i3 = 0)
      {
        arrayOfBoolean[i1] = i3;
        if (localt.j.a(i1))
          i2++;
        if ((arrayOfBoolean[i1] != 0) && ((!localt.j.a(i1)) || ((localad.i()) && (localad.f() == paramt.c[i1]))))
          b(localad);
        i1++;
        break;
      }
    }
    this.u = this.u.a(localt.i, localt.j);
    a(arrayOfBoolean, i2);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(true, paramBoolean1, paramBoolean1);
    c localc = this.p;
    int i1 = this.C;
    if (paramBoolean2);
    for (int i2 = 1; ; i2 = 0)
    {
      localc.a(i2 + i1);
      this.C = 0;
      this.e.b();
      b(1);
      return;
    }
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.g.b(2);
    this.z = false;
    this.o.b();
    this.E = 0L;
    ad[] arrayOfad = this.w;
    int i1 = arrayOfad.length;
    int i2 = 0;
    while (true)
    {
      ad localad;
      if (i2 < i1)
        localad = arrayOfad[i2];
      try
      {
        b(localad);
        i2++;
      }
      catch (i locali1)
      {
        while (true)
          l.b("ExoPlayerImplInternal", "Stop failed.", locali1);
        this.w = new ad[0];
        v localv = this.s;
        if (!paramBoolean2);
        for (boolean bool = true; ; bool = false)
        {
          localv.b(bool);
          d(false);
          if (paramBoolean2)
            this.D = null;
          if (!paramBoolean3)
            break label196;
          this.s.a(ak.a);
          Iterator localIterator = this.q.iterator();
          while (localIterator.hasNext())
            ((b)localIterator.next()).a.a(false);
        }
        this.q.clear();
        this.F = 0;
        label196: n.a locala;
        long l1;
        long l2;
        ak localak;
        Object localObject;
        int i3;
        TrackGroupArray localTrackGroupArray;
        if (paramBoolean2)
        {
          locala = this.u.a(this.B, this.k);
          if (!paramBoolean2)
            break label353;
          l1 = -9223372036854775807L;
          if (!paramBoolean2)
            break label365;
          l2 = -9223372036854775807L;
          if (!paramBoolean3)
            break label377;
          localak = ak.a;
          if (!paramBoolean3)
            break label389;
          localObject = null;
          i3 = this.u.f;
          if (!paramBoolean3)
            break label401;
          localTrackGroupArray = TrackGroupArray.EMPTY;
          label269: if (!paramBoolean3)
            break label413;
        }
        label389: label401: label413: for (com.google.android.exoplayer2.trackselection.i locali = this.d; ; locali = this.u.i)
        {
          this.u = new x(localak, localObject, locala, l1, l2, i3, false, localTrackGroupArray, locali, locala, l1, 0L, l1);
          if ((paramBoolean1) && (this.v != null))
          {
            this.v.a(this);
            this.v = null;
          }
          return;
          locala = this.u.c;
          break;
          label353: l1 = this.u.m;
          break label226;
          label365: l2 = this.u.e;
          break label235;
          label377: localak = this.u.a;
          break label244;
          localObject = this.u.b;
          break label251;
          localTrackGroupArray = this.u.h;
          break label269;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        label69: label226: label235: label244: label251: break label69;
      }
    }
  }

  private void a(boolean[] paramArrayOfBoolean, int paramInt)
    throws i
  {
    int i1 = 0;
    this.w = new ad[paramInt];
    t localt = this.s.c();
    int i2 = 0;
    while (i1 < this.a.length)
    {
      if (localt.j.a(i1))
      {
        int i3 = paramArrayOfBoolean[i1];
        int i4 = i2 + 1;
        a(i1, i3, i2);
        i2 = i4;
      }
      i1++;
    }
  }

  private boolean a(b paramb)
  {
    if (paramb.d == null)
    {
      Pair localPair = a(new d(paramb.a.a(), paramb.a.g(), c.b(paramb.a.f())), false);
      if (localPair == null)
        return false;
      paramb.a(this.u.a.a(localPair.first), ((Long)localPair.second).longValue(), localPair.first);
    }
    while (true)
    {
      return true;
      int i1 = this.u.a.a(paramb.d);
      if (i1 == -1)
        break;
      paramb.b = i1;
    }
  }

  private static Format[] a(e parame)
  {
    int i1 = 0;
    if (parame != null);
    Format[] arrayOfFormat;
    for (int i2 = parame.g(); ; i2 = 0)
    {
      arrayOfFormat = new Format[i2];
      while (i1 < i2)
      {
        arrayOfFormat[i1] = parame.a(i1);
        i1++;
      }
    }
    return arrayOfFormat;
  }

  private long b(long paramLong)
  {
    t localt = this.s.b();
    if (localt == null)
      return 0L;
    return paramLong - localt.b(this.E);
  }

  private Pair<Object, Long> b(ak paramak, int paramInt, long paramLong)
  {
    return paramak.a(this.k, this.l, paramInt, paramLong);
  }

  private void b(int paramInt)
  {
    if (this.u.f != paramInt)
      this.u = this.u.a(paramInt);
  }

  private void b(long paramLong1, long paramLong2)
    throws i
  {
    if ((this.q.isEmpty()) || (this.u.c.a()))
      return;
    if (this.u.d == paramLong1)
      paramLong1 -= 1L;
    int i1 = this.u.a.a(this.u.c.a);
    b localb1;
    if (this.F > 0)
      localb1 = (b)this.q.get(-1 + this.F);
    while ((localb1 != null) && ((localb1.b > i1) || ((localb1.b == i1) && (localb1.c > paramLong1))))
    {
      this.F = (-1 + this.F);
      if (this.F > 0)
      {
        localb1 = (b)this.q.get(-1 + this.F);
        continue;
        localb1 = null;
      }
      else
      {
        localb1 = null;
      }
    }
    b localb2;
    if (this.F < this.q.size())
      localb2 = (b)this.q.get(this.F);
    while ((localb2 != null) && (localb2.d != null) && ((localb2.b < i1) || ((localb2.b == i1) && (localb2.c <= paramLong1))))
    {
      this.F = (1 + this.F);
      if (this.F < this.q.size())
      {
        localb2 = (b)this.q.get(this.F);
        continue;
        localb2 = null;
      }
      else
      {
        localb2 = null;
      }
    }
    label303: label433: 
    while (true)
    {
      localb2 = null;
      if ((localb2 != null) && (localb2.d != null) && (localb2.b == i1) && (localb2.c > paramLong1) && (localb2.c <= paramLong2))
      {
        d(localb2.a);
        if ((!localb2.a.h()) && (!localb2.a.j()))
          break label422;
        this.q.remove(this.F);
      }
      while (true)
      {
        if (this.F >= this.q.size())
          break label433;
        localb2 = (b)this.q.get(this.F);
        break label303;
        break;
        this.F = (1 + this.F);
      }
    }
  }

  private void b(ad paramad)
    throws i
  {
    this.o.b(paramad);
    a(paramad);
    paramad.l();
  }

  private void b(com.google.android.exoplayer2.source.n paramn, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.C = (1 + this.C);
    a(true, paramBoolean1, paramBoolean2);
    this.e.a();
    this.v = paramn;
    b(2);
    paramn.a(this.j, true, this, this.f.b());
    this.g.a(2);
  }

  private void b(y paramy)
  {
    this.o.a(paramy);
  }

  private void c()
  {
    Handler localHandler;
    int i1;
    if (this.p.a(this.u))
    {
      localHandler = this.i;
      i1 = c.a(this.p);
      if (!c.b(this.p))
        break label71;
    }
    label71: for (int i2 = c.c(this.p); ; i2 = -1)
    {
      localHandler.obtainMessage(0, i1, i2, this.u).sendToTarget();
      this.p.b(this.u);
      return;
    }
  }

  private void c(int paramInt)
    throws i
  {
    this.A = paramInt;
    if (!this.s.a(paramInt))
      g(true);
    i(false);
  }

  private void c(ac paramac)
    throws i
  {
    if (paramac.f() == -9223372036854775807L)
    {
      d(paramac);
      return;
    }
    if ((this.v == null) || (this.C > 0))
    {
      this.q.add(new b(paramac));
      return;
    }
    b localb = new b(paramac);
    if (a(localb))
    {
      this.q.add(localb);
      Collections.sort(this.q);
      return;
    }
    paramac.a(false);
  }

  private void c(com.google.android.exoplayer2.source.m paramm)
    throws i
  {
    if (!this.s.a(paramm))
      return;
    t localt = this.s.b();
    localt.a(this.o.e().b);
    a(localt.i, localt.j);
    if (!this.s.f())
    {
      a(this.s.h().g.b);
      a(null);
    }
    q();
  }

  private void c(y paramy)
    throws i
  {
    this.i.obtainMessage(1, paramy).sendToTarget();
    a(paramy.b);
    for (ad localad : this.a)
      if (localad != null)
        localad.a(paramy.b);
  }

  private boolean c(ad paramad)
  {
    t localt = this.s.d();
    return (localt.h != null) && (localt.h.e) && (paramad.g());
  }

  private void d()
    throws i
  {
    int i1 = 0;
    this.z = false;
    this.o.a();
    ad[] arrayOfad = this.w;
    int i2 = arrayOfad.length;
    while (i1 < i2)
    {
      arrayOfad[i1].h_();
      i1++;
    }
  }

  private void d(ac paramac)
    throws i
  {
    if (paramac.e().getLooper() == this.g.a())
    {
      f(paramac);
      if ((this.u.f == 3) || (this.u.f == 2))
        this.g.a(2);
      return;
    }
    this.g.a(15, paramac).sendToTarget();
  }

  private void d(com.google.android.exoplayer2.source.m paramm)
  {
    if (!this.s.a(paramm))
      return;
    this.s.a(this.E);
    q();
  }

  private void d(boolean paramBoolean)
  {
    if (this.u.g != paramBoolean)
      this.u = this.u.a(paramBoolean);
  }

  private void e()
    throws i
  {
    this.o.b();
    ad[] arrayOfad = this.w;
    int i1 = arrayOfad.length;
    for (int i2 = 0; i2 < i1; i2++)
      a(arrayOfad[i2]);
  }

  private void e(ac paramac)
  {
    paramac.e().post(new n(this, paramac));
  }

  private void e(boolean paramBoolean)
    throws i
  {
    this.z = false;
    this.y = paramBoolean;
    if (!paramBoolean)
    {
      e();
      f();
    }
    do
    {
      return;
      if (this.u.f == 3)
      {
        d();
        this.g.a(2);
        return;
      }
    }
    while (this.u.f != 2);
    this.g.a(2);
  }

  private void f()
    throws i
  {
    if (!this.s.f())
      return;
    t localt1 = this.s.c();
    long l1 = localt1.a.c();
    if (l1 != -9223372036854775807L)
    {
      a(l1);
      if (l1 != this.u.m)
      {
        this.u = this.u.a(this.u.c, l1, this.u.e, r());
        this.p.b(4);
      }
    }
    while (true)
    {
      t localt2 = this.s.b();
      this.u.k = localt2.d();
      this.u.l = r();
      return;
      this.E = this.o.c();
      long l2 = localt1.b(this.E);
      b(this.u.m, l2);
      this.u.m = l2;
    }
  }

  private void f(ac paramac)
    throws i
  {
    if (paramac.j())
      return;
    try
    {
      paramac.b().a(paramac.c(), paramac.d());
      return;
    }
    finally
    {
      paramac.a(true);
    }
  }

  private void f(boolean paramBoolean)
    throws i
  {
    this.B = paramBoolean;
    if (!this.s.a(paramBoolean))
      g(true);
    i(false);
  }

  private void g()
    throws i, IOException
  {
    long l1 = this.r.b();
    o();
    if (!this.s.f())
    {
      m();
      a(l1, 10L);
      return;
    }
    t localt = this.s.c();
    ae.a("doSomeWork");
    f();
    long l2 = 1000L * SystemClock.elapsedRealtime();
    localt.a.a(this.u.m - this.m, this.n);
    ad[] arrayOfad1 = this.w;
    int i1 = arrayOfad1.length;
    boolean bool1 = true;
    int i2 = 1;
    int i3 = 0;
    if (i3 < i1)
    {
      ad localad = arrayOfad1[i3];
      localad.a(this.E, l2);
      label154: int i6;
      if ((i2 != 0) && (localad.v()))
      {
        i2 = 1;
        if ((!localad.u()) && (!localad.v()) && (!c(localad)))
          break label227;
        i6 = 1;
        label186: if (i6 == 0)
          localad.j();
        if ((!bool1) || (i6 == 0))
          break label233;
      }
      label227: label233: for (boolean bool2 = true; ; bool2 = false)
      {
        i3++;
        bool1 = bool2;
        break;
        i2 = 0;
        break label154;
        i6 = 0;
        break label186;
      }
    }
    if (!bool1)
      m();
    long l3 = localt.g.d;
    if ((i2 != 0) && ((l3 == -9223372036854775807L) || (l3 <= this.u.m)) && (localt.g.f))
    {
      b(4);
      e();
    }
    while (this.u.f == 2)
    {
      ad[] arrayOfad2 = this.w;
      int i4 = arrayOfad2.length;
      int i5 = 0;
      while (true)
        if (i5 < i4)
        {
          arrayOfad2[i5].j();
          i5++;
          continue;
          if ((this.u.f == 2) && (h(bool1)))
          {
            b(3);
            if (!this.y)
              break;
            d();
            break;
          }
          if (this.u.f != 3)
            break;
          if (this.w.length == 0)
            if (k())
              break;
          while (true)
          {
            this.z = this.y;
            b(2);
            e();
            break;
            if (bool1)
              break;
          }
        }
    }
    if (((this.y) && (this.u.f == 3)) || (this.u.f == 2))
      a(l1, 10L);
    while (true)
    {
      ae.a();
      return;
      if ((this.w.length != 0) && (this.u.f != 4))
        a(l1, 1000L);
      else
        this.g.b(2);
    }
  }

  private void g(boolean paramBoolean)
    throws i
  {
    n.a locala = this.s.c().g.a;
    long l1 = a(locala, this.u.m, true);
    if (l1 != this.u.m)
    {
      this.u = this.u.a(locala, l1, this.u.e, r());
      if (paramBoolean)
        this.p.b(4);
    }
  }

  private void h()
  {
    a(true, true, true);
    this.e.c();
    b(1);
    this.h.quit();
    try
    {
      this.x = true;
      notifyAll();
      return;
    }
    finally
    {
    }
  }

  private boolean h(boolean paramBoolean)
  {
    boolean bool1;
    if (this.w.length == 0)
      bool1 = k();
    do
    {
      return bool1;
      bool1 = false;
    }
    while (!paramBoolean);
    if (!this.u.g)
      return true;
    t localt = this.s.b();
    if ((localt.c()) && (localt.g.f));
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 == 0)
      {
        boolean bool2 = this.e.a(r(), this.o.e().b, this.z);
        bool1 = false;
        if (!bool2)
          break;
      }
      return true;
    }
  }

  private void i()
  {
    for (int i1 = -1 + this.q.size(); i1 >= 0; i1--)
      if (!a((b)this.q.get(i1)))
      {
        ((b)this.q.get(i1)).a.a(false);
        this.q.remove(i1);
      }
    Collections.sort(this.q);
  }

  private void i(boolean paramBoolean)
  {
    t localt = this.s.b();
    n.a locala;
    int i1;
    label37: x localx;
    if (localt == null)
    {
      locala = this.u.c;
      if (this.u.j.equals(locala))
        break label135;
      i1 = 1;
      if (i1 != 0)
        this.u = this.u.a(locala);
      localx = this.u;
      if (localt != null)
        break label141;
    }
    label135: label141: for (long l1 = this.u.m; ; l1 = localt.d())
    {
      localx.k = l1;
      this.u.l = r();
      if (((i1 != 0) || (paramBoolean)) && (localt != null) && (localt.e))
        a(localt.i, localt.j);
      return;
      locala = localt.g.a;
      break;
      i1 = 0;
      break label37;
    }
  }

  private void j()
    throws i
  {
    if (!this.s.f())
      return;
    float f1 = this.o.e().b;
    t localt1 = this.s.c();
    t localt2 = this.s.d();
    t localt3 = localt1;
    int i1 = 1;
    label44: t localt4;
    boolean[] arrayOfBoolean1;
    boolean[] arrayOfBoolean2;
    int i2;
    int i3;
    label202: ad localad;
    int i4;
    if ((localt3 != null) && (localt3.e))
      if (localt3.b(f1))
      {
        if (i1 == 0)
          break label403;
        localt4 = this.s.c();
        boolean bool = this.s.a(localt4);
        arrayOfBoolean1 = new boolean[this.a.length];
        long l1 = localt4.a(this.u.m, bool, arrayOfBoolean1);
        if ((this.u.f != 4) && (l1 != this.u.m))
        {
          this.u = this.u.a(this.u.c, l1, this.u.e, r());
          this.p.b(4);
          a(l1);
        }
        arrayOfBoolean2 = new boolean[this.a.length];
        i2 = 0;
        i3 = 0;
        if (i2 >= this.a.length)
          break label338;
        localad = this.a[i2];
        if (localad.g_() == 0)
          break label310;
        i4 = 1;
        label234: arrayOfBoolean2[i2] = i4;
        z localz = localt4.c[i2];
        if (localz != null)
          i3++;
        if (arrayOfBoolean2[i2] != 0)
        {
          if (localz == localad.f())
            break label316;
          b(localad);
        }
      }
    while (true)
    {
      i2++;
      break label202;
      if (localt3 == localt2)
        i1 = 0;
      localt3 = localt3.h;
      break label44;
      break;
      label310: i4 = 0;
      break label234;
      label316: if (arrayOfBoolean1[i2] != 0)
        localad.a(this.E);
    }
    label338: this.u = this.u.a(localt4.i, localt4.j);
    a(arrayOfBoolean2, i3);
    while (true)
    {
      i(true);
      if (this.u.f == 4)
        break;
      q();
      f();
      this.g.a(2);
      return;
      label403: this.s.a(localt3);
      if (localt3.e)
        localt3.a(Math.max(localt3.g.b, localt3.b(this.E)), false);
    }
  }

  private boolean k()
  {
    t localt = this.s.c();
    long l1 = localt.g.d;
    return (l1 == -9223372036854775807L) || (this.u.m < l1) || ((localt.h != null) && ((localt.h.e) || (localt.h.g.a.a())));
  }

  private void l()
    throws IOException
  {
    if (this.s.b() != null)
    {
      ad[] arrayOfad = this.w;
      int i1 = arrayOfad.length;
      for (int i2 = 0; i2 < i1; i2++)
        if (!arrayOfad[i2].g())
          return;
    }
    this.v.b();
  }

  private void m()
    throws IOException
  {
    t localt1 = this.s.b();
    t localt2 = this.s.d();
    ad[] arrayOfad;
    int i1;
    if ((localt1 != null) && (!localt1.e) && ((localt2 == null) || (localt2.h == localt1)))
    {
      arrayOfad = this.w;
      i1 = arrayOfad.length;
    }
    for (int i2 = 0; i2 < i1; i2++)
      if (!arrayOfad[i2].g())
        return;
    localt1.a.i_();
  }

  private void n()
  {
    b(4);
    a(false, true, false);
  }

  private void o()
    throws i, IOException
  {
    if (this.v == null);
    label53: t localt3;
    label85: label229: label231: label237: 
    do
      while (true)
      {
        return;
        if (this.C > 0)
        {
          this.v.b();
          return;
        }
        p();
        t localt1 = this.s.b();
        Object localObject;
        int i1;
        if ((localt1 == null) || (localt1.c()))
        {
          d(false);
          if (!this.s.f())
            break label229;
          t localt2 = this.s.c();
          localt3 = this.s.d();
          localObject = localt2;
          i1 = 0;
          if ((!this.y) || (localObject == localt3) || (this.E < ((t)localObject).h.b()))
            break label237;
          if (i1 != 0)
            c();
          if (!((t)localObject).g.e)
            break label231;
        }
        for (int i7 = 0; ; i7 = 3)
        {
          t localt5 = this.s.h();
          a((t)localObject);
          this.u = this.u.a(localt5.g.a, localt5.g.b, localt5.g.c, r());
          this.p.b(i7);
          f();
          i1 = 1;
          localObject = localt5;
          break label85;
          if (this.u.g)
            break label53;
          q();
          break label53;
          break;
        }
        boolean bool1 = localt3.g.f;
        int i2 = 0;
        if (!bool1)
          break;
        while (i2 < this.a.length)
        {
          ad localad3 = this.a[i2];
          z localz2 = localt3.c[i2];
          if ((localz2 != null) && (localad3.f() == localz2) && (localad3.g()))
            localad3.h();
          i2++;
        }
      }
    while (localt3.h == null);
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= this.a.length)
        break label393;
      ad localad2 = this.a[i3];
      z localz1 = localt3.c[i3];
      if ((localad2.f() != localz1) || ((localz1 != null) && (!localad2.g())))
        break;
    }
    label393: if (!localt3.h.e)
    {
      m();
      return;
    }
    com.google.android.exoplayer2.trackselection.i locali1 = localt3.j;
    t localt4 = this.s.g();
    com.google.android.exoplayer2.trackselection.i locali2 = localt4.j;
    int i4;
    label450: int i5;
    label453: ad localad1;
    if (localt4.a.c() != -9223372036854775807L)
    {
      i4 = 1;
      i5 = 0;
      if (i5 < this.a.length)
      {
        localad1 = this.a[i5];
        if (locali1.a(i5))
          break label494;
      }
    }
    while (true)
    {
      i5++;
      break label453;
      break;
      i4 = 0;
      break label450;
      label494: if (i4 != 0)
      {
        localad1.h();
      }
      else if (!localad1.i())
      {
        e locale = locali2.c.a(i5);
        boolean bool2 = locali2.a(i5);
        if (this.b[i5].a() == 6);
        for (int i6 = 1; ; i6 = 0)
        {
          ag localag1 = locali1.b[i5];
          ag localag2 = locali2.b[i5];
          if ((!bool2) || (!localag2.equals(localag1)) || (i6 != 0))
            break label634;
          localad1.a(a(locale), localt4.c[i5], localt4.a());
          break;
        }
        label634: localad1.h();
      }
    }
  }

  private void p()
    throws IOException
  {
    this.s.a(this.E);
    u localu;
    if (this.s.a())
    {
      localu = this.s.a(this.E, this.u);
      if (localu == null)
        l();
    }
    else
    {
      return;
    }
    this.s.a(this.b, this.c, this.e.d(), this.v, localu).a(this, localu.b);
    d(true);
    i(false);
  }

  private void q()
  {
    t localt = this.s.b();
    long l1 = localt.e();
    if (l1 == -9223372036854775808L)
      d(false);
    boolean bool;
    do
    {
      return;
      long l2 = b(l1);
      bool = this.e.a(l2, this.o.e().b);
      d(bool);
    }
    while (!bool);
    localt.d(this.E);
  }

  private long r()
  {
    return b(this.u.k);
  }

  public void a()
  {
    try
    {
      boolean bool1 = this.x;
      if (bool1);
      while (true)
      {
        return;
        this.g.a(7);
        int i1 = 0;
        while (true)
        {
          boolean bool2 = this.x;
          if (bool2)
            break;
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            i1 = 1;
          }
        }
        if (i1 != 0)
          Thread.currentThread().interrupt();
      }
    }
    finally
    {
    }
  }

  public void a(int paramInt)
  {
    this.g.a(12, paramInt, 0).sendToTarget();
  }

  public void a(ac paramac)
  {
    try
    {
      if (this.x)
      {
        l.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        paramac.a(false);
      }
      while (true)
      {
        return;
        this.g.a(14, paramac).sendToTarget();
      }
    }
    finally
    {
    }
  }

  public void a(ak paramak, int paramInt, long paramLong)
  {
    this.g.a(3, new d(paramak, paramInt, paramLong)).sendToTarget();
  }

  public void a(com.google.android.exoplayer2.source.m paramm)
  {
    this.g.a(9, paramm).sendToTarget();
  }

  public void a(com.google.android.exoplayer2.source.n paramn, ak paramak, Object paramObject)
  {
    this.g.a(8, new a(paramn, paramak, paramObject)).sendToTarget();
  }

  public void a(com.google.android.exoplayer2.source.n paramn, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 1;
    k localk = this.g;
    int i2;
    if (paramBoolean1)
    {
      i2 = i1;
      if (!paramBoolean2)
        break label44;
    }
    while (true)
    {
      localk.a(0, i2, i1, paramn).sendToTarget();
      return;
      i2 = 0;
      break;
      label44: i1 = 0;
    }
  }

  public void a(y paramy)
  {
    this.g.a(16, paramy).sendToTarget();
  }

  public void a(boolean paramBoolean)
  {
    k localk = this.g;
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      localk.a(1, i1, 0).sendToTarget();
      return;
    }
  }

  public Looper b()
  {
    return this.h.getLooper();
  }

  public void b(com.google.android.exoplayer2.source.m paramm)
  {
    this.g.a(10, paramm).sendToTarget();
  }

  public void b(boolean paramBoolean)
  {
    k localk = this.g;
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      localk.a(13, i1, 0).sendToTarget();
      return;
    }
  }

  public void c(boolean paramBoolean)
  {
    k localk = this.g;
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      localk.a(6, i1, 0).sendToTarget();
      return;
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    boolean bool4;
    boolean bool5;
    while (true)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 0:
          com.google.android.exoplayer2.source.n localn = (com.google.android.exoplayer2.source.n)paramMessage.obj;
          if (paramMessage.arg1 == 0)
            break label482;
          bool4 = true;
          if (paramMessage.arg2 == 0)
            break label488;
          bool5 = true;
          b(localn, bool4, bool5);
          c();
          break;
        case 1:
          label117: label127: if (paramMessage.arg1 != 0)
          {
            bool3 = true;
            e(bool3);
            continue;
          }
          break;
        case 12:
        case 13:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 9:
        case 8:
        case 10:
        case 11:
        case 16:
        case 14:
        case 15:
        case 7:
        }
      }
      catch (i locali)
      {
        l.b("ExoPlayerImplInternal", "Playback error.", locali);
        a(false, false);
        this.i.obtainMessage(2, locali).sendToTarget();
        c();
        break;
        boolean bool3 = false;
        continue;
        c(paramMessage.arg1);
        continue;
      }
      catch (IOException localIOException)
      {
        l.b("ExoPlayerImplInternal", "Source error.", localIOException);
        a(false, false);
        this.i.obtainMessage(2, i.a(localIOException)).sendToTarget();
        c();
        break;
        if (paramMessage.arg1 != 0)
        {
          bool2 = true;
          f(bool2);
          continue;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        l.b("ExoPlayerImplInternal", "Internal runtime error.", localRuntimeException);
        a(false, false);
        this.i.obtainMessage(2, i.a(localRuntimeException)).sendToTarget();
        c();
      }
      boolean bool2 = false;
      continue;
      g();
      continue;
      a((d)paramMessage.obj);
      continue;
      b((y)paramMessage.obj);
      continue;
      a((ai)paramMessage.obj);
    }
    if (paramMessage.arg1 != 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      a(bool1, true);
      break label127;
      c((com.google.android.exoplayer2.source.m)paramMessage.obj);
      break label127;
      a((a)paramMessage.obj);
      break label127;
      d((com.google.android.exoplayer2.source.m)paramMessage.obj);
      break label127;
      j();
      break label127;
      c((y)paramMessage.obj);
      break label127;
      c((ac)paramMessage.obj);
      break label127;
      e((ac)paramMessage.obj);
      break label127;
      h();
      return true;
      return false;
      return true;
      label482: bool4 = false;
      break;
      label488: bool5 = false;
      break label117;
    }
  }

  private static final class a
  {
    public final com.google.android.exoplayer2.source.n a;
    public final ak b;
    public final Object c;

    public a(com.google.android.exoplayer2.source.n paramn, ak paramak, Object paramObject)
    {
      this.a = paramn;
      this.b = paramak;
      this.c = paramObject;
    }
  }

  private static final class b
    implements Comparable<b>
  {
    public final ac a;
    public int b;
    public long c;
    public Object d;

    public b(ac paramac)
    {
      this.a = paramac;
    }

    public int a(b paramb)
    {
      int i = 1;
      int j;
      int k;
      if (this.d == null)
      {
        j = i;
        if (paramb.d != null)
          break label43;
        k = i;
        label21: if (j == k)
          break label49;
        if (this.d != null)
          i = -1;
      }
      label43: label49: 
      do
      {
        return i;
        j = 0;
        break;
        k = 0;
        break label21;
        if (this.d == null)
          return 0;
        i = this.b - paramb.b;
      }
      while (i != 0);
      return com.google.android.exoplayer2.g.ag.a(this.c, paramb.c);
    }

    public void a(int paramInt, long paramLong, Object paramObject)
    {
      this.b = paramInt;
      this.c = paramLong;
      this.d = paramObject;
    }
  }

  private static final class c
  {
    private x a;
    private int b;
    private boolean c;
    private int d;

    public void a(int paramInt)
    {
      this.b = (paramInt + this.b);
    }

    public boolean a(x paramx)
    {
      return (paramx != this.a) || (this.b > 0) || (this.c);
    }

    public void b(int paramInt)
    {
      boolean bool = true;
      if ((this.c) && (this.d != 4))
      {
        if (paramInt == 4);
        while (true)
        {
          a.a(bool);
          return;
          bool = false;
        }
      }
      this.c = bool;
      this.d = paramInt;
    }

    public void b(x paramx)
    {
      this.a = paramx;
      this.b = 0;
      this.c = false;
    }
  }

  private static final class d
  {
    public final ak a;
    public final int b;
    public final long c;

    public d(ak paramak, int paramInt, long paramLong)
    {
      this.a = paramak;
      this.b = paramInt;
      this.c = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.m
 * JD-Core Version:    0.6.2
 */