package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.TrackGroupArray;

public abstract class h
{
  private a a;
  private d b;

  public abstract i a(af[] paramArrayOfaf, TrackGroupArray paramTrackGroupArray)
    throws com.google.android.exoplayer2.i;

  public final void a(a parama, d paramd)
  {
    this.a = parama;
    this.b = paramd;
  }

  public abstract void a(Object paramObject);

  protected final d c()
  {
    return (d)a.a(this.b);
  }

  public static abstract interface a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.h
 * JD-Core Version:    0.6.2
 */