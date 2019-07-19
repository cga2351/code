package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.ak.a;
import com.google.android.exoplayer2.ak.b;
import com.google.android.exoplayer2.g.a;

public final class ab extends ak
{
  private static final Object b = new Object();
  private final long c;
  private final long d;
  private final long e;
  private final long f;
  private final long g;
  private final long h;
  private final boolean i;
  private final boolean j;
  private final Object k;

  public ab(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramLong4;
    this.g = paramLong5;
    this.h = paramLong6;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.k = paramObject;
  }

  public ab(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean1, paramBoolean2, paramObject);
  }

  public ab(long paramLong, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    this(paramLong, paramLong, 0L, 0L, paramBoolean1, paramBoolean2, paramObject);
  }

  public int a(Object paramObject)
  {
    if (b.equals(paramObject))
      return 0;
    return -1;
  }

  public ak.a a(int paramInt, ak.a parama, boolean paramBoolean)
  {
    a.a(paramInt, 0, 1);
    if (paramBoolean);
    for (Object localObject = b; ; localObject = null)
      return parama.a(null, localObject, 0, this.e, -this.g);
  }

  public ak.b a(int paramInt, ak.b paramb, boolean paramBoolean, long paramLong)
  {
    a.a(paramInt, 0, 1);
    Object localObject;
    long l;
    if (paramBoolean)
    {
      localObject = this.k;
      l = this.h;
      if ((this.j) && (paramLong != 0L))
      {
        if (this.f != -9223372036854775807L)
          break label94;
        l = -9223372036854775807L;
      }
    }
    while (true)
    {
      return paramb.a(localObject, this.c, this.d, this.i, this.j, l, this.f, 0, 0, this.g);
      localObject = null;
      break;
      label94: l += paramLong;
      if (l > this.f)
        l = -9223372036854775807L;
    }
  }

  public Object a(int paramInt)
  {
    a.a(paramInt, 0, 1);
    return b;
  }

  public int b()
  {
    return 1;
  }

  public int c()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ab
 * JD-Core Version:    0.6.2
 */