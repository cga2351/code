package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.a;

public abstract class d extends b
{
  public final long i;

  public d(h paramh, l paraml, Format paramFormat, int paramInt, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramh, paraml, 1, paramFormat, paramInt, paramObject, paramLong1, paramLong2);
    a.a(paramFormat);
    this.i = paramLong3;
  }

  public long g()
  {
    long l = -1L;
    if (this.i != l)
      l = 1L + this.i;
    return l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.d
 * JD-Core Version:    0.6.2
 */