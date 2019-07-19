package com.google.android.exoplayer2;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.n;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;

public abstract class b
  implements ad, af
{
  private final int a;
  private ag b;
  private int c;
  private int d;
  private z e;
  private Format[] f;
  private long g;
  private boolean h;
  private boolean i;

  public b(int paramInt)
  {
    this.a = paramInt;
    this.h = true;
  }

  protected static boolean a(l<?> paraml, DrmInitData paramDrmInitData)
  {
    if (paramDrmInitData == null)
      return true;
    if (paraml == null)
      return false;
    return paraml.a(paramDrmInitData);
  }

  public final int a()
  {
    return this.a;
  }

  protected final int a(p paramp, e parame, boolean paramBoolean)
  {
    int j = this.e.a(paramp, parame, paramBoolean);
    if (j == -4)
    {
      if (parame.c())
      {
        this.h = true;
        if (this.i)
          return -4;
        return -3;
      }
      parame.c += this.g;
    }
    while (true)
    {
      return j;
      if (j == -5)
      {
        Format localFormat = paramp.a;
        if (localFormat.subsampleOffsetUs != 9223372036854775807L)
          paramp.a = localFormat.copyWithSubsampleOffsetUs(localFormat.subsampleOffsetUs + this.g);
      }
    }
  }

  public void a(float paramFloat)
    throws i
  {
    ae.a(this, paramFloat);
  }

  public final void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(int paramInt, Object paramObject)
    throws i
  {
  }

  public final void a(long paramLong)
    throws i
  {
    this.i = false;
    this.h = false;
    a(paramLong, false);
  }

  protected void a(long paramLong, boolean paramBoolean)
    throws i
  {
  }

  public final void a(ag paramag, Format[] paramArrayOfFormat, z paramz, long paramLong1, boolean paramBoolean, long paramLong2)
    throws i
  {
    if (this.d == 0);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.b = paramag;
      this.d = 1;
      a(paramBoolean);
      a(paramArrayOfFormat, paramz, paramLong2);
      a(paramLong1, paramBoolean);
      return;
    }
  }

  protected void a(boolean paramBoolean)
    throws i
  {
  }

  protected void a(Format[] paramArrayOfFormat, long paramLong)
    throws i
  {
  }

  public final void a(Format[] paramArrayOfFormat, z paramz, long paramLong)
    throws i
  {
    if (!this.i);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.e = paramz;
      this.h = false;
      this.f = paramArrayOfFormat;
      this.g = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }

  protected int b(long paramLong)
  {
    return this.e.a(paramLong - this.g);
  }

  public final af b()
  {
    return this;
  }

  public n c()
  {
    return null;
  }

  public final z f()
  {
    return this.e;
  }

  public final boolean g()
  {
    return this.h;
  }

  public final int g_()
  {
    return this.d;
  }

  public final void h()
  {
    this.i = true;
  }

  public final void h_()
    throws i
  {
    int j = 1;
    if (this.d == j);
    while (true)
    {
      a.b(j);
      this.d = 2;
      n();
      return;
      int k = 0;
    }
  }

  public final boolean i()
  {
    return this.i;
  }

  public final void j()
    throws IOException
  {
    this.e.c();
  }

  public final void k()
    throws i
  {
    if (this.d == 2);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.d = 1;
      o();
      return;
    }
  }

  public final void l()
  {
    int j = 1;
    if (this.d == j);
    while (true)
    {
      a.b(j);
      this.d = 0;
      this.e = null;
      this.f = null;
      this.i = false;
      p();
      return;
      int k = 0;
    }
  }

  public int m()
    throws i
  {
    return 0;
  }

  protected void n()
    throws i
  {
  }

  protected void o()
    throws i
  {
  }

  protected void p()
  {
  }

  protected final Format[] q()
  {
    return this.f;
  }

  protected final ag r()
  {
    return this.b;
  }

  protected final int s()
  {
    return this.c;
  }

  protected final boolean t()
  {
    if (this.h)
      return this.i;
    return this.e.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b
 * JD-Core Version:    0.6.2
 */