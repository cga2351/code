package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ai;
import com.google.android.exoplayer2.trackselection.e;
import java.io.IOException;

public abstract interface m extends aa
{
  public abstract long a(long paramLong, ai paramai);

  public abstract long a(e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, z[] paramArrayOfz, boolean[] paramArrayOfBoolean2, long paramLong);

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, boolean paramBoolean);

  public abstract void a(a parama, long paramLong);

  public abstract long b(long paramLong);

  public abstract TrackGroupArray b();

  public abstract long c();

  public abstract boolean c(long paramLong);

  public abstract long d();

  public abstract long e();

  public abstract void i_()
    throws IOException;

  public static abstract interface a extends aa.a<m>
  {
    public abstract void a(m paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.m
 * JD-Core Version:    0.6.2
 */