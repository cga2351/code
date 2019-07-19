package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.trackselection.i;

final class x
{
  private static final n.a n = new n.a(new Object());
  public final ak a;
  public final Object b;
  public final n.a c;
  public final long d;
  public final long e;
  public final int f;
  public final boolean g;
  public final TrackGroupArray h;
  public final i i;
  public final n.a j;
  public volatile long k;
  public volatile long l;
  public volatile long m;

  public x(ak paramak, Object paramObject, n.a parama1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, TrackGroupArray paramTrackGroupArray, i parami, n.a parama2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.a = paramak;
    this.b = paramObject;
    this.c = parama1;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramInt;
    this.g = paramBoolean;
    this.h = paramTrackGroupArray;
    this.i = parami;
    this.j = parama2;
    this.k = paramLong3;
    this.l = paramLong4;
    this.m = paramLong5;
  }

  public static x a(long paramLong, i parami)
  {
    return new x(ak.a, null, n, paramLong, -9223372036854775807L, 1, false, TrackGroupArray.EMPTY, parami, n, paramLong, 0L, paramLong);
  }

  public n.a a(boolean paramBoolean, ak.b paramb)
  {
    if (this.a.a())
      return n;
    int i1 = this.a.a(this.a.b(paramBoolean), paramb).f;
    return new n.a(this.a.a(i1));
  }

  public x a(int paramInt)
  {
    return new x(this.a, this.b, this.c, this.d, this.e, paramInt, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
  }

  public x a(ak paramak, Object paramObject)
  {
    return new x(paramak, paramObject, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
  }

  public x a(TrackGroupArray paramTrackGroupArray, i parami)
  {
    return new x(this.a, this.b, this.c, this.d, this.e, this.f, this.g, paramTrackGroupArray, parami, this.j, this.k, this.l, this.m);
  }

  public x a(n.a parama)
  {
    return new x(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, parama, this.k, this.l, this.m);
  }

  public x a(n.a parama, long paramLong1, long paramLong2)
  {
    ak localak = this.a;
    Object localObject = this.b;
    if (parama.a());
    for (long l1 = paramLong2; ; l1 = -9223372036854775807L)
      return new x(localak, localObject, parama, paramLong1, l1, this.f, this.g, this.h, this.i, parama, paramLong1, 0L, paramLong1);
  }

  public x a(n.a parama, long paramLong1, long paramLong2, long paramLong3)
  {
    ak localak = this.a;
    Object localObject = this.b;
    if (parama.a());
    for (long l1 = paramLong2; ; l1 = -9223372036854775807L)
      return new x(localak, localObject, parama, paramLong1, l1, this.f, this.g, this.h, this.i, this.j, this.k, paramLong3, paramLong1);
  }

  public x a(boolean paramBoolean)
  {
    return new x(this.a, this.b, this.c, this.d, this.e, this.f, paramBoolean, this.h, this.i, this.j, this.k, this.l, this.m);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.x
 * JD-Core Version:    0.6.2
 */