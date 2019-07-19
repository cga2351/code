package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.m;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.u;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.g;

public class f
  implements s
{
  private final m a;
  private final long b;
  private final long c;
  private final long d;
  private final long e;
  private final int f;
  private final boolean g;
  private final u h;
  private final long i;
  private final boolean j;
  private int k;
  private boolean l;

  public f()
  {
    this(new m(true, 65536));
  }

  @Deprecated
  public f(m paramm)
  {
    this(paramm, 15000, 50000, 2500, 5000, -1, true);
  }

  @Deprecated
  public f(m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this(paramm, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, null);
  }

  @Deprecated
  public f(m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, u paramu)
  {
    this(paramm, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramu, 0, false);
  }

  protected f(m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, u paramu, int paramInt6, boolean paramBoolean2)
  {
    a(paramInt3, 0, "bufferForPlaybackMs", "0");
    a(paramInt4, 0, "bufferForPlaybackAfterRebufferMs", "0");
    a(paramInt1, paramInt3, "minBufferMs", "bufferForPlaybackMs");
    a(paramInt1, paramInt4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
    a(paramInt2, paramInt1, "maxBufferMs", "minBufferMs");
    a(paramInt6, 0, "backBufferDurationMs", "0");
    this.a = paramm;
    this.b = c.b(paramInt1);
    this.c = c.b(paramInt2);
    this.d = c.b(paramInt3);
    this.e = c.b(paramInt4);
    this.f = paramInt5;
    this.g = paramBoolean1;
    this.h = paramu;
    this.i = c.b(paramInt6);
    this.j = paramBoolean2;
  }

  private static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramInt1 >= paramInt2);
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool, paramString1 + " cannot be less than " + paramString2);
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    this.k = 0;
    if ((this.h != null) && (this.l))
      this.h.b(0);
    this.l = false;
    if (paramBoolean)
      this.a.d();
  }

  protected int a(ad[] paramArrayOfad, g paramg)
  {
    int m = 0;
    int n = 0;
    while (m < paramArrayOfad.length)
    {
      if (paramg.a(m) != null)
        n += ag.g(paramArrayOfad[m].a());
      m++;
    }
    return n;
  }

  public void a()
  {
    a(false);
  }

  public void a(ad[] paramArrayOfad, TrackGroupArray paramTrackGroupArray, g paramg)
  {
    if (this.f == -1);
    for (int m = a(paramArrayOfad, paramg); ; m = this.f)
    {
      this.k = m;
      this.a.a(this.k);
      return;
    }
  }

  public boolean a(long paramLong, float paramFloat)
  {
    boolean bool1 = true;
    int m;
    if (this.a.e() >= this.k)
    {
      m = bool1;
      boolean bool2 = this.l;
      long l1 = this.b;
      if (paramFloat > 1.0F)
        l1 = Math.min(ag.a(l1, paramFloat), this.c);
      if (paramLong >= l1)
        break label127;
      if ((!this.g) && (m != 0))
        break label121;
      label73: this.l = bool1;
      label79: if ((this.h != null) && (this.l != bool2))
      {
        if (!this.l)
          break label149;
        this.h.a(0);
      }
    }
    while (true)
    {
      return this.l;
      m = 0;
      break;
      label121: bool1 = false;
      break label73;
      label127: if ((paramLong < this.c) && (m == 0))
        break label79;
      this.l = false;
      break label79;
      label149: this.h.b(0);
    }
  }

  public boolean a(long paramLong, float paramFloat, boolean paramBoolean)
  {
    long l1 = ag.b(paramLong, paramFloat);
    if (paramBoolean);
    for (long l2 = this.e; (l2 <= 0L) || (l1 >= l2) || ((!this.g) && (this.a.e() >= this.k)); l2 = this.d)
      return true;
    return false;
  }

  public void b()
  {
    a(true);
  }

  public void c()
  {
    a(true);
  }

  public b d()
  {
    return this.a;
  }

  public long e()
  {
    return this.i;
  }

  public boolean f()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f
 * JD-Core Version:    0.6.2
 */