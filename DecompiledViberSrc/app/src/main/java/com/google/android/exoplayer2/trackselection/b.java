package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class b
  implements e
{
  protected final TrackGroup a;
  protected final int b;
  protected final int[] c;
  private final Format[] d;
  private final long[] e;
  private int f;

  public b(TrackGroup paramTrackGroup, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.a = ((TrackGroup)a.a(paramTrackGroup));
      this.b = paramArrayOfInt.length;
      this.d = new Format[this.b];
      for (int j = 0; j < paramArrayOfInt.length; j++)
        this.d[j] = paramTrackGroup.getFormat(paramArrayOfInt[j]);
    }
    Arrays.sort(this.d, new a(null));
    this.c = new int[this.b];
    while (i < this.b)
    {
      this.c[i] = paramTrackGroup.indexOf(this.d[i]);
      i++;
    }
    this.e = new long[this.b];
  }

  public final int a(Format paramFormat)
  {
    for (int i = 0; i < this.b; i++)
      if (this.d[i] == paramFormat)
        return i;
    return -1;
  }

  public final Format a(int paramInt)
  {
    return this.d[paramInt];
  }

  public void a(float paramFloat)
  {
  }

  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    f.a(this, paramLong1, paramLong2, paramLong3);
  }

  public void a(long paramLong1, long paramLong2, long paramLong3, List paramList, com.google.android.exoplayer2.source.b.e[] paramArrayOfe)
  {
    f.a(this, paramLong1, paramLong2, paramLong3, paramList, paramArrayOfe);
  }

  public final boolean a(int paramInt, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = b(paramInt, l);
    int i = 0;
    if ((i < this.b) && (!bool))
    {
      if ((i != paramInt) && (!b(i, l)));
      for (bool = true; ; bool = false)
      {
        i++;
        break;
      }
    }
    if (!bool)
      return false;
    this.e[paramInt] = Math.max(this.e[paramInt], ag.b(l, paramLong, 9223372036854775807L));
    return true;
  }

  public final int b(int paramInt)
  {
    return this.c[paramInt];
  }

  protected final boolean b(int paramInt, long paramLong)
  {
    return this.e[paramInt] > paramLong;
  }

  public final int c(int paramInt)
  {
    for (int i = 0; i < this.b; i++)
      if (this.c[i] == paramInt)
        return i;
    return -1;
  }

  public void d()
  {
  }

  public void e()
  {
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localb = (b)paramObject;
    }
    while ((this.a == localb.a) && (Arrays.equals(this.c, localb.c)));
    return false;
  }

  public final TrackGroup f()
  {
    return this.a;
  }

  public final int g()
  {
    return this.c.length;
  }

  public final Format h()
  {
    return this.d[a()];
  }

  public int hashCode()
  {
    if (this.f == 0)
      this.f = (31 * System.identityHashCode(this.a) + Arrays.hashCode(this.c));
    return this.f;
  }

  public final int i()
  {
    return this.c[a()];
  }

  private static final class a
    implements Comparator<Format>
  {
    public int a(Format paramFormat1, Format paramFormat2)
    {
      return paramFormat2.bitrate - paramFormat1.bitrate;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.b
 * JD-Core Version:    0.6.2
 */