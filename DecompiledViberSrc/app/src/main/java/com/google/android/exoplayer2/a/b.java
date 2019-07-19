package com.google.android.exoplayer2.a;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.o.b;
import com.google.android.exoplayer2.source.o.c;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.y;
import java.io.IOException;

public abstract interface b
{
  public abstract void a(a parama);

  public abstract void a(a parama, float paramFloat);

  public abstract void a(a parama, int paramInt);

  public abstract void a(a parama, int paramInt1, int paramInt2);

  public abstract void a(a parama, int paramInt1, int paramInt2, int paramInt3, float paramFloat);

  public abstract void a(a parama, int paramInt, long paramLong);

  public abstract void a(a parama, int paramInt, long paramLong1, long paramLong2);

  public abstract void a(a parama, int paramInt, Format paramFormat);

  public abstract void a(a parama, int paramInt, d paramd);

  public abstract void a(a parama, int paramInt, String paramString, long paramLong);

  public abstract void a(a parama, Surface paramSurface);

  public abstract void a(a parama, com.google.android.exoplayer2.b.b paramb);

  public abstract void a(a parama, i parami);

  public abstract void a(a parama, Metadata paramMetadata);

  public abstract void a(a parama, TrackGroupArray paramTrackGroupArray, g paramg);

  public abstract void a(a parama, o.b paramb, o.c paramc);

  public abstract void a(a parama, o.b paramb, o.c paramc, IOException paramIOException, boolean paramBoolean);

  public abstract void a(a parama, o.c paramc);

  public abstract void a(a parama, y paramy);

  public abstract void a(a parama, Exception paramException);

  public abstract void a(a parama, boolean paramBoolean);

  public abstract void a(a parama, boolean paramBoolean, int paramInt);

  public abstract void b(a parama);

  public abstract void b(a parama, int paramInt);

  public abstract void b(a parama, int paramInt, long paramLong1, long paramLong2);

  public abstract void b(a parama, int paramInt, d paramd);

  public abstract void b(a parama, o.b paramb, o.c paramc);

  public abstract void b(a parama, boolean paramBoolean);

  public abstract void c(a parama);

  public abstract void c(a parama, int paramInt);

  public abstract void c(a parama, o.b paramb, o.c paramc);

  public abstract void d(a parama);

  public abstract void d(a parama, int paramInt);

  public abstract void e(a parama);

  public abstract void f(a parama);

  public abstract void g(a parama);

  public abstract void h(a parama);

  public abstract void i(a parama);

  public static final class a
  {
    public final long a;
    public final ak b;
    public final int c;
    public final n.a d;
    public final long e;
    public final long f;
    public final long g;

    public a(long paramLong1, ak paramak, int paramInt, n.a parama, long paramLong2, long paramLong3, long paramLong4)
    {
      this.a = paramLong1;
      this.b = paramak;
      this.c = paramInt;
      this.d = parama;
      this.e = paramLong2;
      this.f = paramLong3;
      this.g = paramLong4;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.6.2
 */