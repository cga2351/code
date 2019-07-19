package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.d;
import com.google.android.exoplayer2.source.b.e;
import java.util.List;

public final class c extends b
{
  private final int d;
  private final Object e;

  public c(TrackGroup paramTrackGroup, int paramInt)
  {
    this(paramTrackGroup, paramInt, 0, null);
  }

  public c(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, Object paramObject)
  {
    super(paramTrackGroup, new int[] { paramInt1 });
    this.d = paramInt2;
    this.e = paramObject;
  }

  public int a()
  {
    return 0;
  }

  public void a(long paramLong1, long paramLong2, long paramLong3, List<? extends d> paramList, e[] paramArrayOfe)
  {
  }

  public int b()
  {
    return this.d;
  }

  public Object c()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.c
 * JD-Core Version:    0.6.2
 */