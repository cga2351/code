package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.List;

public abstract interface e
{
  public abstract int a();

  public abstract Format a(int paramInt);

  public abstract void a(float paramFloat);

  @Deprecated
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);

  public abstract void a(long paramLong1, long paramLong2, long paramLong3, List<? extends com.google.android.exoplayer2.source.b.d> paramList, com.google.android.exoplayer2.source.b.e[] paramArrayOfe);

  public abstract boolean a(int paramInt, long paramLong);

  public abstract int b();

  public abstract int b(int paramInt);

  public abstract int c(int paramInt);

  public abstract Object c();

  public abstract void d();

  public abstract void e();

  public abstract TrackGroup f();

  public abstract int g();

  public abstract Format h();

  public abstract int i();

  public static abstract interface a
  {
    public abstract e b(TrackGroup paramTrackGroup, com.google.android.exoplayer2.f.d paramd, int[] paramArrayOfInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.e
 * JD-Core Version:    0.6.2
 */