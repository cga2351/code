package com.google.android.exoplayer2.b;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.lang.reflect.Method;

final class p
{
  private final a a;
  private final long[] b;
  private AudioTrack c;
  private int d;
  private int e;
  private o f;
  private int g;
  private boolean h;
  private long i;
  private long j;
  private long k;
  private Method l;
  private long m;
  private boolean n;
  private boolean o;
  private long p;
  private long q;
  private long r;
  private long s;
  private int t;
  private int u;
  private long v;
  private long w;
  private long x;
  private long y;

  public p(a parama)
  {
    this.a = ((a)a.a(parama));
    if (ag.a >= 18);
    try
    {
      this.l = AudioTrack.class.getMethod("getLatency", (Class[])null);
      label38: this.b = new long[10];
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
  }

  private void a(long paramLong1, long paramLong2)
  {
    o localo = (o)a.a(this.f);
    if (!localo.a(paramLong1))
      return;
    long l1 = localo.f();
    long l2 = localo.g();
    if (Math.abs(l1 - paramLong1) > 5000000L)
    {
      this.a.b(l2, l1, paramLong1, paramLong2);
      localo.a();
      return;
    }
    if (Math.abs(g(l2) - paramLong2) > 5000000L)
    {
      this.a.a(l2, l1, paramLong1, paramLong2);
      localo.a();
      return;
    }
    localo.b();
  }

  private static boolean a(int paramInt)
  {
    return (ag.a < 23) && ((paramInt == 5) || (paramInt == 6));
  }

  private void e()
  {
    long l1 = h();
    if (l1 == 0L);
    long l2;
    do
    {
      return;
      l2 = System.nanoTime() / 1000L;
      if (l2 - this.k >= 30000L)
      {
        this.b[this.t] = (l1 - l2);
        this.t = ((1 + this.t) % 10);
        if (this.u < 10)
          this.u = (1 + this.u);
        this.k = l2;
        this.j = 0L;
        for (int i1 = 0; i1 < this.u; i1++)
          this.j += this.b[i1] / this.u;
      }
    }
    while (this.h);
    a(l2, l1);
    f(l2);
  }

  private void f()
  {
    this.j = 0L;
    this.u = 0;
    this.t = 0;
    this.k = 0L;
  }

  private void f(long paramLong)
  {
    if ((this.o) && (this.l != null) && (paramLong - this.p >= 500000L));
    try
    {
      this.m = (1000L * ((Integer)ag.a((Integer)this.l.invoke(a.a(this.c), new Object[0]))).intValue() - this.i);
      this.m = Math.max(this.m, 0L);
      if (this.m > 5000000L)
      {
        this.a.a(this.m);
        this.m = 0L;
      }
      this.p = paramLong;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.l = null;
    }
  }

  private long g(long paramLong)
  {
    return 1000000L * paramLong / this.g;
  }

  private boolean g()
  {
    return (this.h) && (((AudioTrack)a.a(this.c)).getPlayState() == 2) && (i() == 0L);
  }

  private long h()
  {
    return g(i());
  }

  private long i()
  {
    AudioTrack localAudioTrack = (AudioTrack)a.a(this.c);
    if (this.v != -9223372036854775807L)
    {
      long l2 = (1000L * SystemClock.elapsedRealtime() - this.v) * this.g / 1000000L;
      return Math.min(this.y, l2 + this.x);
    }
    int i1 = localAudioTrack.getPlayState();
    if (i1 == 1)
      return 0L;
    long l1 = 0xFFFFFFFF & localAudioTrack.getPlaybackHeadPosition();
    if (this.h)
    {
      if ((i1 == 2) && (l1 == 0L))
        this.s = this.q;
      l1 += this.s;
    }
    if (ag.a <= 28)
    {
      if ((l1 == 0L) && (this.q > 0L) && (i1 == 3))
      {
        if (this.w == -9223372036854775807L)
          this.w = SystemClock.elapsedRealtime();
        return this.q;
      }
      this.w = -9223372036854775807L;
    }
    if (this.q > l1)
      this.r = (1L + this.r);
    this.q = l1;
    return l1 + (this.r << 32);
  }

  public long a(boolean paramBoolean)
  {
    if (((AudioTrack)a.a(this.c)).getPlayState() == 3)
      e();
    long l1 = System.nanoTime() / 1000L;
    o localo = (o)a.a(this.f);
    long l3;
    long l2;
    if (localo.c())
    {
      l3 = g(localo.g());
      if (!localo.d())
        l2 = l3;
    }
    while (true)
    {
      return l2;
      return l3 + (l1 - localo.f());
      if (this.u == 0);
      for (l2 = h(); !paramBoolean; l2 = l1 + this.j)
        return l2 - this.m;
    }
  }

  public void a()
  {
    ((o)a.a(this.f)).e();
  }

  public void a(AudioTrack paramAudioTrack, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramAudioTrack;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = new o(paramAudioTrack);
    this.g = paramAudioTrack.getSampleRate();
    this.h = a(paramInt1);
    this.o = ag.c(paramInt1);
    if (this.o);
    for (long l1 = g(paramInt3 / paramInt2); ; l1 = -9223372036854775807L)
    {
      this.i = l1;
      this.q = 0L;
      this.r = 0L;
      this.s = 0L;
      this.n = false;
      this.v = -9223372036854775807L;
      this.w = -9223372036854775807L;
      this.m = 0L;
      return;
    }
  }

  public boolean a(long paramLong)
  {
    int i1 = ((AudioTrack)a.a(this.c)).getPlayState();
    if (this.h)
    {
      if (i1 == 2)
      {
        this.n = false;
        return false;
      }
      if ((i1 == 1) && (i() == 0L))
        return false;
    }
    boolean bool = this.n;
    this.n = e(paramLong);
    if ((bool) && (!this.n) && (i1 != 1) && (this.a != null))
      this.a.a(this.e, c.a(this.i));
    return true;
  }

  public int b(long paramLong)
  {
    int i1 = (int)(paramLong - i() * this.d);
    return this.e - i1;
  }

  public boolean b()
  {
    return ((AudioTrack)a.a(this.c)).getPlayState() == 3;
  }

  public boolean c()
  {
    f();
    if (this.v == -9223372036854775807L)
    {
      ((o)a.a(this.f)).e();
      return true;
    }
    return false;
  }

  public boolean c(long paramLong)
  {
    return (this.w != -9223372036854775807L) && (paramLong > 0L) && (SystemClock.elapsedRealtime() - this.w >= 200L);
  }

  public void d()
  {
    f();
    this.c = null;
    this.f = null;
  }

  public void d(long paramLong)
  {
    this.x = i();
    this.v = (1000L * SystemClock.elapsedRealtime());
    this.y = paramLong;
  }

  public boolean e(long paramLong)
  {
    return (paramLong > i()) || (g());
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, long paramLong);

    public abstract void a(long paramLong);

    public abstract void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4);

    public abstract void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.p
 * JD-Core Version:    0.6.2
 */