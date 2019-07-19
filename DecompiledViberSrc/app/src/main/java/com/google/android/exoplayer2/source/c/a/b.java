package com.google.android.exoplayer2.source.c.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.f.aa;
import com.google.android.exoplayer2.f.aa.a;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.f.z.a;
import com.google.android.exoplayer2.f.z.b;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.af;
import com.google.android.exoplayer2.source.o.a;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
  implements z.a<aa<f>>, i
{
  public static final i.a a = c.a;
  private final com.google.android.exoplayer2.source.c.e b;
  private final h c;
  private final y d;
  private final IdentityHashMap<d.a, a> e;
  private final List<i.b> f;
  private aa.a<f> g;
  private o.a h;
  private z i;
  private Handler j;
  private i.e k;
  private d l;
  private d.a m;
  private e n;
  private boolean o;
  private long p;

  public b(com.google.android.exoplayer2.source.c.e parame, y paramy, h paramh)
  {
    this.b = parame;
    this.c = paramh;
    this.d = paramy;
    this.f = new ArrayList();
    this.e = new IdentityHashMap();
    this.p = -9223372036854775807L;
  }

  private e a(e parame1, e parame2)
  {
    if (!parame2.a(parame1))
    {
      if (parame2.i)
        parame1 = parame1.b();
      return parame1;
    }
    return parame2.a(b(parame1, parame2), c(parame1, parame2));
  }

  private void a(d.a parama, e parame)
  {
    int i1 = 0;
    if (parama == this.m)
      if (this.n == null)
        if (parame.i)
          break label97;
    label97: for (boolean bool = true; ; bool = false)
    {
      this.o = bool;
      this.p = parame.c;
      this.n = parame;
      this.k.a(parame);
      int i2 = this.f.size();
      while (i1 < i2)
      {
        ((i.b)this.f.get(i1)).h();
        i1++;
      }
    }
  }

  private void a(List<d.a> paramList)
  {
    int i1 = paramList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      d.a locala = (d.a)paramList.get(i2);
      a locala1 = new a(locala);
      this.e.put(locala, locala1);
    }
  }

  private boolean a(d.a parama, long paramLong)
  {
    int i1 = this.f.size();
    int i2 = 0;
    boolean bool1 = false;
    if (i2 < i1)
    {
      if (!((i.b)this.f.get(i2)).a(parama, paramLong));
      for (boolean bool2 = true; ; bool2 = false)
      {
        bool1 |= bool2;
        i2++;
        break;
      }
    }
    return bool1;
  }

  private long b(e parame1, e parame2)
  {
    long l1;
    if (parame2.j)
      l1 = parame2.c;
    int i1;
    label72: 
    do
      while (true)
      {
        return l1;
        if (this.n != null);
        for (l1 = this.n.c; parame1 != null; l1 = 0L)
        {
          i1 = parame1.l.size();
          e.a locala = d(parame1, parame2);
          if (locala == null)
            break label72;
          return parame1.c + locala.f;
        }
      }
    while (i1 != parame2.f - parame1.f);
    return parame1.a();
  }

  private int c(e parame1, e parame2)
  {
    int i1;
    if (parame2.d)
      i1 = parame2.e;
    label76: 
    while (true)
    {
      return i1;
      if (this.n != null);
      for (i1 = this.n.e; ; i1 = 0)
      {
        if (parame1 == null)
          break label76;
        e.a locala = d(parame1, parame2);
        if (locala == null)
          break;
        return parame1.e + locala.e - ((e.a)parame2.l.get(0)).e;
      }
    }
  }

  private static e.a d(e parame1, e parame2)
  {
    int i1 = (int)(parame2.f - parame1.f);
    List localList = parame1.l;
    if (i1 < localList.size())
      return (e.a)localList.get(i1);
    return null;
  }

  private void d(d.a parama)
  {
    if ((parama == this.m) || (!this.l.b.contains(parama)) || ((this.n != null) && (this.n.i)))
      return;
    this.m = parama;
    ((a)this.e.get(this.m)).d();
  }

  private boolean f()
  {
    List localList = this.l.b;
    int i1 = localList.size();
    long l1 = SystemClock.elapsedRealtime();
    for (int i2 = 0; i2 < i1; i2++)
    {
      a locala = (a)this.e.get(localList.get(i2));
      if (l1 > a.a(locala))
      {
        this.m = a.b(locala);
        locala.d();
        return true;
      }
    }
    return false;
  }

  public z.b a(aa<f> paramaa, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
  {
    long l1 = this.d.b(paramaa.b, paramLong2, paramIOException, paramInt);
    if (l1 == -9223372036854775807L);
    for (boolean bool = true; ; bool = false)
    {
      this.h.a(paramaa.a, paramaa.e(), paramaa.f(), 4, paramLong1, paramLong2, paramaa.d(), paramIOException, bool);
      if (!bool)
        break;
      return z.d;
    }
    return z.a(false, l1);
  }

  public e a(d.a parama, boolean paramBoolean)
  {
    e locale = ((a)this.e.get(parama)).a();
    if ((locale != null) && (paramBoolean))
      d(parama);
    return locale;
  }

  public void a()
  {
    this.m = null;
    this.n = null;
    this.l = null;
    this.p = -9223372036854775807L;
    this.i.c();
    this.i = null;
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).c();
    this.j.removeCallbacksAndMessages(null);
    this.j = null;
    this.e.clear();
  }

  public void a(Uri paramUri, o.a parama, i.e parame)
  {
    this.j = new Handler();
    this.h = parama;
    this.k = parame;
    aa localaa = new aa(this.b.a(4), paramUri, 4, this.c.a());
    if (this.i == null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.i = new z("DefaultHlsPlaylistTracker:MasterPlaylist");
      long l1 = this.i.a(localaa, this, this.d.a(localaa.b));
      parama.a(localaa.a, localaa.b, l1);
      return;
    }
  }

  public void a(aa<f> paramaa, long paramLong1, long paramLong2)
  {
    f localf = (f)paramaa.c();
    boolean bool = localf instanceof e;
    d locald;
    a locala;
    if (bool)
    {
      locald = d.a(localf.n);
      this.l = locald;
      this.g = this.c.a(locald);
      this.m = ((d.a)locald.b.get(0));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(locald.b);
      localArrayList.addAll(locald.c);
      localArrayList.addAll(locald.d);
      a(localArrayList);
      locala = (a)this.e.get(this.m);
      if (!bool)
        break label189;
      a.a(locala, (e)localf, paramLong2);
    }
    while (true)
    {
      this.h.a(paramaa.a, paramaa.e(), paramaa.f(), 4, paramLong1, paramLong2, paramaa.d());
      return;
      locald = (d)localf;
      break;
      label189: locala.d();
    }
  }

  public void a(aa<f> paramaa, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.h.b(paramaa.a, paramaa.e(), paramaa.f(), 4, paramLong1, paramLong2, paramaa.d());
  }

  public void a(i.b paramb)
  {
    this.f.add(paramb);
  }

  public boolean a(d.a parama)
  {
    return ((a)this.e.get(parama)).b();
  }

  public d b()
  {
    return this.l;
  }

  public void b(d.a parama)
    throws IOException
  {
    ((a)this.e.get(parama)).e();
  }

  public void b(i.b paramb)
  {
    this.f.remove(paramb);
  }

  public long c()
  {
    return this.p;
  }

  public void c(d.a parama)
  {
    ((a)this.e.get(parama)).d();
  }

  public void d()
    throws IOException
  {
    if (this.i != null)
      this.i.d();
    if (this.m != null)
      b(this.m);
  }

  public boolean e()
  {
    return this.o;
  }

  private final class a
    implements z.a<aa<f>>, Runnable
  {
    private final d.a b;
    private final z c;
    private final aa<f> d;
    private e e;
    private long f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private IOException k;

    public a(d.a arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new z("DefaultHlsPlaylistTracker:MediaPlaylist");
      this.d = new aa(b.a(b.this).a(4), af.a(b.b(b.this).n, localObject.a), 4, b.c(b.this));
    }

    private void a(e parame, long paramLong)
    {
      e locale = this.e;
      long l1 = SystemClock.elapsedRealtime();
      this.f = l1;
      this.e = b.a(b.this, locale, parame);
      if (this.e != locale)
      {
        this.k = null;
        this.g = l1;
        b.a(b.this, this.b, this.e);
        if (this.e == locale)
          break label296;
      }
      label296: for (long l3 = this.e.h; ; l3 = this.e.h / 2L)
      {
        this.h = (l1 + com.google.android.exoplayer2.c.a(l3));
        if ((this.b == b.g(b.this)) && (!this.e.i))
          d();
        return;
        if (this.e.i)
          break;
        if (parame.f + parame.l.size() < this.e.f)
        {
          this.k = new i.c(this.b.a);
          b.a(b.this, this.b, -9223372036854775807L);
          break;
        }
        if (l1 - this.g <= 3.5D * com.google.android.exoplayer2.c.a(this.e.h))
          break;
        this.k = new i.d(this.b.a);
        long l2 = b.f(b.this).a(4, paramLong, this.k, 1);
        b.a(b.this, this.b, l2);
        if (l2 == -9223372036854775807L)
          break;
        a(l2);
        break;
      }
    }

    private boolean a(long paramLong)
    {
      this.i = (paramLong + SystemClock.elapsedRealtime());
      return (b.g(b.this) == this.b) && (!b.h(b.this));
    }

    private void f()
    {
      long l = this.c.a(this.d, this, b.f(b.this).a(this.d.b));
      b.e(b.this).a(this.d.a, this.d.b, l);
    }

    public z.b a(aa<f> paramaa, long paramLong1, long paramLong2, IOException paramIOException, int paramInt)
    {
      long l1 = b.f(b.this).a(paramaa.b, paramLong2, paramIOException, paramInt);
      int m;
      boolean bool1;
      if (l1 != -9223372036854775807L)
      {
        m = 1;
        if ((!b.a(b.this, this.b, l1)) && (m != 0))
          break label196;
        bool1 = true;
        label60: if (m == 0)
          break label224;
      }
      label196: label218: label224: for (boolean bool2 = bool1 | a(l1); ; bool2 = bool1)
      {
        z.b localb;
        label122: o.a locala;
        l locall;
        Uri localUri;
        Map localMap;
        long l2;
        if (bool2)
        {
          long l3 = b.f(b.this).b(paramaa.b, paramLong2, paramIOException, paramInt);
          if (l3 != -9223372036854775807L)
          {
            localb = z.a(false, l3);
            locala = b.e(b.this);
            locall = paramaa.a;
            localUri = paramaa.e();
            localMap = paramaa.f();
            l2 = paramaa.d();
            if (localb.a())
              break label218;
          }
        }
        for (boolean bool3 = true; ; bool3 = false)
        {
          locala.a(locall, localUri, localMap, 4, paramLong1, paramLong2, l2, paramIOException, bool3);
          return localb;
          m = 0;
          break;
          bool1 = false;
          break label60;
          localb = z.d;
          break label122;
          localb = z.c;
          break label122;
        }
      }
    }

    public e a()
    {
      return this.e;
    }

    public void a(aa<f> paramaa, long paramLong1, long paramLong2)
    {
      f localf = (f)paramaa.c();
      if ((localf instanceof e))
      {
        a((e)localf, paramLong2);
        b.e(b.this).a(paramaa.a, paramaa.e(), paramaa.f(), 4, paramLong1, paramLong2, paramaa.d());
        return;
      }
      this.k = new w("Loaded playlist has unexpected type.");
    }

    public void a(aa<f> paramaa, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      b.e(b.this).b(paramaa.a, paramaa.e(), paramaa.f(), 4, paramLong1, paramLong2, paramaa.d());
    }

    public boolean b()
    {
      if (this.e == null);
      long l1;
      long l2;
      do
      {
        return false;
        l1 = SystemClock.elapsedRealtime();
        l2 = Math.max(30000L, com.google.android.exoplayer2.c.a(this.e.m));
      }
      while ((!this.e.i) && (this.e.a != 2) && (this.e.a != 1) && (l2 + this.f <= l1));
      return true;
    }

    public void c()
    {
      this.c.c();
    }

    public void d()
    {
      this.i = 0L;
      if ((this.j) || (this.c.a()))
        return;
      long l = SystemClock.elapsedRealtime();
      if (l < this.h)
      {
        this.j = true;
        b.d(b.this).postDelayed(this, this.h - l);
        return;
      }
      f();
    }

    public void e()
      throws IOException
    {
      this.c.d();
      if (this.k != null)
        throw this.k;
    }

    public void run()
    {
      this.j = false;
      f();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b
 * JD-Core Version:    0.6.2
 */