package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.trackselection.h;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

final class l extends a
  implements j
{
  final com.google.android.exoplayer2.trackselection.i b;
  private final ad[] c;
  private final h d;
  private final Handler e;
  private final m f;
  private final Handler g;
  private final CopyOnWriteArraySet<aa.a> h;
  private final ak.a i;
  private final ArrayDeque<a> j;
  private n k;
  private boolean l;
  private boolean m;
  private int n;
  private boolean o;
  private int p;
  private boolean q;
  private boolean r;
  private y s;
  private ai t;
  private i u;
  private x v;
  private int w;
  private int x;
  private long y;

  @SuppressLint({"HandlerLeak"})
  public l(ad[] paramArrayOfad, h paramh, s params, d paramd, b paramb, Looper paramLooper)
  {
    com.google.android.exoplayer2.g.l.b("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.9.4" + "] [" + com.google.android.exoplayer2.g.ag.e + "]");
    if (paramArrayOfad.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.b(bool);
      this.c = ((ad[])com.google.android.exoplayer2.g.a.a(paramArrayOfad));
      this.d = ((h)com.google.android.exoplayer2.g.a.a(paramh));
      this.l = false;
      this.n = 0;
      this.o = false;
      this.h = new CopyOnWriteArraySet();
      this.b = new com.google.android.exoplayer2.trackselection.i(new ag[paramArrayOfad.length], new e[paramArrayOfad.length], null);
      this.i = new ak.a();
      this.s = y.a;
      this.t = ai.e;
      this.e = new Handler(paramLooper)
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          l.this.a(paramAnonymousMessage);
        }
      };
      this.v = x.a(0L, this.b);
      this.j = new ArrayDeque();
      this.f = new m(paramArrayOfad, paramh, this.b, params, paramd, this.l, this.n, this.o, this.e, this, paramb);
      this.g = new Handler(this.f.b());
      return;
    }
  }

  private boolean D()
  {
    return (this.v.a.a()) || (this.p > 0);
  }

  private long a(n.a parama, long paramLong)
  {
    long l1 = c.a(paramLong);
    this.v.a.a(parama.a, this.i);
    return l1 + this.i.b();
  }

  private x a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    n.a locala;
    label40: long l1;
    label47: long l2;
    label56: ak localak;
    label65: Object localObject;
    label72: TrackGroupArray localTrackGroupArray;
    if (paramBoolean1)
    {
      this.w = 0;
      this.x = 0;
      this.y = 0L;
      if (!paramBoolean1)
        break label149;
      locala = this.v.a(this.o, this.a);
      if (!paramBoolean1)
        break label161;
      l1 = 0L;
      if (!paramBoolean1)
        break label173;
      l2 = -9223372036854775807L;
      if (!paramBoolean2)
        break label185;
      localak = ak.a;
      if (!paramBoolean2)
        break label197;
      localObject = null;
      if (!paramBoolean2)
        break label209;
      localTrackGroupArray = TrackGroupArray.EMPTY;
      label81: if (!paramBoolean2)
        break label221;
    }
    label149: label161: label173: label185: label197: label209: label221: for (com.google.android.exoplayer2.trackselection.i locali = this.b; ; locali = this.v.i)
    {
      return new x(localak, localObject, locala, l1, l2, paramInt, false, localTrackGroupArray, locali, locala, l1, 0L, l1);
      this.w = r();
      this.x = q();
      this.y = t();
      break;
      locala = this.v.c;
      break label40;
      l1 = this.v.m;
      break label47;
      l2 = this.v.e;
      break label56;
      localak = this.v.a;
      break label65;
      localObject = this.v.b;
      break label72;
      localTrackGroupArray = this.v.h;
      break label81;
    }
  }

  private void a(x paramx, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.p -= paramInt1;
    if (this.p == 0)
      if (paramx.d != -9223372036854775807L)
        break label136;
    label136: for (x localx = paramx.a(paramx.c, 0L, paramx.e); ; localx = paramx)
    {
      if (((!this.v.a.a()) || (this.q)) && (localx.a.a()))
      {
        this.x = 0;
        this.w = 0;
        this.y = 0L;
      }
      if (this.q);
      for (int i1 = 0; ; i1 = 2)
      {
        boolean bool = this.r;
        this.q = false;
        this.r = false;
        a(localx, paramBoolean, paramInt2, i1, bool, false);
        return;
      }
    }
  }

  private void a(x paramx, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (!this.j.isEmpty())
    {
      i1 = 1;
      this.j.addLast(new a(paramx, this.v, this.h, this.d, paramBoolean1, paramInt1, paramInt2, paramBoolean2, this.l, paramBoolean3));
      this.v = paramx;
      if (i1 == 0)
        break label69;
    }
    while (true)
    {
      return;
      i1 = 0;
      break;
      label69: 
      while (!this.j.isEmpty())
      {
        ((a)this.j.peekFirst()).a();
        this.j.removeFirst();
      }
    }
  }

  public TrackGroupArray A()
  {
    return this.v.h;
  }

  public g B()
  {
    return this.v.i.c;
  }

  public ak C()
  {
    return this.v.a;
  }

  public ac a(ac.b paramb)
  {
    return new ac(this.f, paramb, this.v.a, r(), this.g);
  }

  public void a(int paramInt)
  {
    if (this.n != paramInt)
    {
      this.n = paramInt;
      this.f.a(paramInt);
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
        ((aa.a)localIterator.next()).onRepeatModeChanged(paramInt);
    }
  }

  public void a(int paramInt, long paramLong)
  {
    ak localak = this.v.a;
    if ((paramInt < 0) || ((!localak.a()) && (paramInt >= localak.b())))
      throw new q(localak, paramInt, paramLong);
    this.r = true;
    this.p = (1 + this.p);
    if (v())
    {
      com.google.android.exoplayer2.g.l.c("ExoPlayerImpl", "seekTo ignored because an ad is playing");
      this.e.obtainMessage(0, 1, -1, this.v).sendToTarget();
      return;
    }
    this.w = paramInt;
    if (localak.a())
    {
      if (paramLong == -9223372036854775807L);
      for (long l2 = 0L; ; l2 = paramLong)
      {
        this.y = l2;
        this.x = 0;
        this.f.a(localak, paramInt, c.b(paramLong));
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
          ((aa.a)localIterator.next()).onPositionDiscontinuity(1);
        break;
      }
    }
    if (paramLong == -9223372036854775807L);
    for (long l1 = localak.a(paramInt, this.a).b(); ; l1 = c.b(paramLong))
    {
      Pair localPair = localak.a(this.a, this.i, paramInt, l1);
      this.y = c.a(l1);
      this.x = localak.a(localPair.first);
      break;
    }
  }

  void a(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default:
      throw new IllegalStateException();
    case 0:
      x localx = (x)paramMessage.obj;
      int i1 = paramMessage.arg1;
      if (paramMessage.arg2 != -1)
      {
        bool = true;
        a(localx, i1, bool, paramMessage.arg2);
      }
      break;
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      bool = false;
      break;
      y localy = (y)paramMessage.obj;
      if (!this.s.equals(localy))
      {
        this.s = localy;
        Iterator localIterator2 = this.h.iterator();
        while (localIterator2.hasNext())
          ((aa.a)localIterator2.next()).onPlaybackParametersChanged(localy);
        continue;
        i locali = (i)paramMessage.obj;
        this.u = locali;
        Iterator localIterator1 = this.h.iterator();
        while (localIterator1.hasNext())
          ((aa.a)localIterator1.next()).onPlayerError(locali);
      }
    }
  }

  public void a(aa.a parama)
  {
    this.h.add(parama);
  }

  public void a(n paramn, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.u = null;
    this.k = paramn;
    x localx = a(paramBoolean1, paramBoolean2, 2);
    this.q = true;
    this.p = (1 + this.p);
    this.f.a(paramn, paramBoolean1, paramBoolean2);
    a(localx, false, 4, 1, false, false);
  }

  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2));
    for (boolean bool = true; ; bool = false)
    {
      if (this.m != bool)
      {
        this.m = bool;
        this.f.a(bool);
      }
      if (this.l != paramBoolean1)
      {
        this.l = paramBoolean1;
        a(this.v, false, 4, 1, false, true);
      }
      return;
    }
  }

  public int b(int paramInt)
  {
    return this.c[paramInt].a();
  }

  public void b(aa.a parama)
  {
    this.h.remove(parama);
  }

  public void b(boolean paramBoolean)
  {
    if (this.o != paramBoolean)
    {
      this.o = paramBoolean;
      this.f.b(paramBoolean);
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
        ((aa.a)localIterator.next()).onShuffleModeEnabledChanged(paramBoolean);
    }
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.u = null;
      this.k = null;
    }
    x localx = a(paramBoolean, paramBoolean, 1);
    this.p = (1 + this.p);
    this.f.c(paramBoolean);
    a(localx, false, 4, 1, false, false);
  }

  public aa.c g()
  {
    return null;
  }

  public aa.b h()
  {
    return null;
  }

  public Looper i()
  {
    return this.e.getLooper();
  }

  public int j()
  {
    return this.v.f;
  }

  public i k()
  {
    return this.u;
  }

  public boolean l()
  {
    return this.l;
  }

  public int m()
  {
    return this.n;
  }

  public boolean n()
  {
    return this.o;
  }

  public y o()
  {
    return this.s;
  }

  public void p()
  {
    com.google.android.exoplayer2.g.l.b("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.9.4" + "] [" + com.google.android.exoplayer2.g.ag.e + "] [" + o.a() + "]");
    this.k = null;
    this.f.a();
    this.e.removeCallbacksAndMessages(null);
  }

  public int q()
  {
    if (D())
      return this.x;
    return this.v.a.a(this.v.c.a);
  }

  public int r()
  {
    if (D())
      return this.w;
    return this.v.a.a(this.v.c.a, this.i).c;
  }

  public long s()
  {
    if (v())
    {
      n.a locala = this.v.c;
      this.v.a.a(locala.a, this.i);
      return c.a(this.i.c(locala.b, locala.c));
    }
    return f();
  }

  public long t()
  {
    if (D())
      return this.y;
    if (this.v.c.a())
      return c.a(this.v.m);
    return a(this.v.c, this.v.m);
  }

  public long u()
  {
    return Math.max(0L, c.a(this.v.l));
  }

  public boolean v()
  {
    return (!D()) && (this.v.c.a());
  }

  public int w()
  {
    if (v())
      return this.v.c.b;
    return -1;
  }

  public int x()
  {
    if (v())
      return this.v.c.c;
    return -1;
  }

  public long y()
  {
    if (v())
    {
      this.v.a.a(this.v.c.a, this.i);
      return this.i.b() + c.a(this.v.e);
    }
    return t();
  }

  public long z()
  {
    if (D())
      return this.y;
    if (this.v.j.d != this.v.c.d)
      return this.v.a.a(r(), this.a).c();
    long l1 = this.v.k;
    if (this.v.j.a())
    {
      ak.a locala = this.v.a.a(this.v.j.a, this.i);
      l1 = locala.a(this.v.j.b);
      if (l1 == -9223372036854775808L)
        l1 = locala.d;
    }
    return a(this.v.j, l1);
  }

  private static final class a
  {
    private final x a;
    private final Set<aa.a> b;
    private final h c;
    private final boolean d;
    private final int e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;

    public a(x paramx1, x paramx2, Set<aa.a> paramSet, h paramh, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.a = paramx1;
      this.b = paramSet;
      this.c = paramh;
      this.d = paramBoolean1;
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = paramBoolean2;
      this.h = paramBoolean3;
      boolean bool2;
      boolean bool3;
      label105: boolean bool4;
      if ((paramBoolean4) || (paramx2.f != paramx1.f))
      {
        bool2 = bool1;
        this.i = bool2;
        if ((paramx2.a == paramx1.a) && (paramx2.b == paramx1.b))
          break label156;
        bool3 = bool1;
        this.j = bool3;
        if (paramx2.g == paramx1.g)
          break label162;
        bool4 = bool1;
        label126: this.k = bool4;
        if (paramx2.i == paramx1.i)
          break label168;
      }
      while (true)
      {
        this.l = bool1;
        return;
        bool2 = false;
        break;
        label156: bool3 = false;
        break label105;
        label162: bool4 = false;
        break label126;
        label168: bool1 = false;
      }
    }

    public void a()
    {
      if ((this.j) || (this.f == 0))
      {
        Iterator localIterator1 = this.b.iterator();
        while (localIterator1.hasNext())
          ((aa.a)localIterator1.next()).onTimelineChanged(this.a.a, this.a.b, this.f);
      }
      if (this.d)
      {
        Iterator localIterator6 = this.b.iterator();
        while (localIterator6.hasNext())
          ((aa.a)localIterator6.next()).onPositionDiscontinuity(this.e);
      }
      if (this.l)
      {
        this.c.a(this.a.i.d);
        Iterator localIterator5 = this.b.iterator();
        while (localIterator5.hasNext())
          ((aa.a)localIterator5.next()).onTracksChanged(this.a.h, this.a.i.c);
      }
      if (this.k)
      {
        Iterator localIterator4 = this.b.iterator();
        while (localIterator4.hasNext())
          ((aa.a)localIterator4.next()).onLoadingChanged(this.a.g);
      }
      if (this.i)
      {
        Iterator localIterator3 = this.b.iterator();
        while (localIterator3.hasNext())
          ((aa.a)localIterator3.next()).onPlayerStateChanged(this.h, this.a.f);
      }
      if (this.g)
      {
        Iterator localIterator2 = this.b.iterator();
        while (localIterator2.hasNext())
          ((aa.a)localIterator2.next()).onSeekProcessed();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.l
 * JD-Core Version:    0.6.2
 */