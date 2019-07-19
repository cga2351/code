package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.e;
import java.util.List;

public class a extends b
{
  private final com.google.android.exoplayer2.f.d d;
  private final long e;
  private final long f;
  private final long g;
  private final float h;
  private final float i;
  private final long j;
  private final com.google.android.exoplayer2.g.b k;
  private float l;
  private int m;
  private int n;
  private long o;

  public a(TrackGroup paramTrackGroup, int[] paramArrayOfInt, com.google.android.exoplayer2.f.d paramd, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, long paramLong4, com.google.android.exoplayer2.g.b paramb)
  {
    super(paramTrackGroup, paramArrayOfInt);
    this.d = paramd;
    this.e = (1000L * paramLong1);
    this.f = (1000L * paramLong2);
    this.g = (1000L * paramLong3);
    this.h = paramFloat1;
    this.i = paramFloat2;
    this.j = paramLong4;
    this.k = paramb;
    this.l = 1.0F;
    this.n = 1;
    this.o = -9223372036854775807L;
    this.m = a(-9223372036854775808L);
  }

  private int a(long paramLong)
  {
    int i1 = 0;
    long l1 = ()((float)this.d.a() * this.h);
    int i2 = 0;
    while (i1 < this.b)
    {
      if ((paramLong == -9223372036854775808L) || (!b(i1, paramLong)))
      {
        if (Math.round(a(i1).bitrate * this.l) <= l1)
          return i1;
        i2 = i1;
      }
      i1++;
    }
    return i2;
  }

  private long b(long paramLong)
  {
    if ((paramLong != -9223372036854775807L) && (paramLong <= this.e));
    for (int i1 = 1; i1 != 0; i1 = 0)
      return ()((float)paramLong * this.i);
    return this.e;
  }

  public int a()
  {
    return this.m;
  }

  public void a(float paramFloat)
  {
    this.l = paramFloat;
  }

  public void a(long paramLong1, long paramLong2, long paramLong3, List<? extends com.google.android.exoplayer2.source.b.d> paramList, e[] paramArrayOfe)
  {
    long l1 = this.k.a();
    int i1 = this.m;
    this.m = a(l1);
    if (this.m == i1);
    while (true)
    {
      return;
      Format localFormat1;
      Format localFormat2;
      if (!b(i1, l1))
      {
        localFormat1 = a(i1);
        localFormat2 = a(this.m);
        if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong2 >= b(paramLong3)))
          break label111;
      }
      for (this.m = i1; this.m != i1; this.m = i1)
      {
        label96: this.n = 3;
        return;
        label111: if ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong2 < this.f))
          break label96;
      }
    }
  }

  public int b()
  {
    return this.n;
  }

  public Object c()
  {
    return null;
  }

  public void d()
  {
    this.o = -9223372036854775807L;
  }

  public static final class a
    implements e.a
  {
    private final com.google.android.exoplayer2.f.d a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;
    private final long g;
    private final com.google.android.exoplayer2.g.b h;

    public a()
    {
      this(10000, 25000, 25000, 0.75F, 0.75F, 2000L, com.google.android.exoplayer2.g.b.a);
    }

    public a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, long paramLong, com.google.android.exoplayer2.g.b paramb)
    {
      this(null, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramLong, paramb);
    }

    @Deprecated
    public a(com.google.android.exoplayer2.f.d paramd)
    {
      this(paramd, 10000, 25000, 25000, 0.75F, 0.75F, 2000L, com.google.android.exoplayer2.g.b.a);
    }

    @Deprecated
    public a(com.google.android.exoplayer2.f.d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, long paramLong, com.google.android.exoplayer2.g.b paramb)
    {
      this.a = paramd;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramFloat1;
      this.f = paramFloat2;
      this.g = paramLong;
      this.h = paramb;
    }

    public a a(TrackGroup paramTrackGroup, com.google.android.exoplayer2.f.d paramd, int[] paramArrayOfInt)
    {
      if (this.a != null);
      for (com.google.android.exoplayer2.f.d locald = this.a; ; locald = paramd)
        return new a(paramTrackGroup, paramArrayOfInt, locald, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.a
 * JD-Core Version:    0.6.2
 */