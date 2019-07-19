package com.google.android.exoplayer2.source.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;

final class k
  implements z
{
  private final int a;
  private final l b;
  private int c;

  public k(l paraml, int paramInt)
  {
    this.b = paraml;
    this.a = paramInt;
    this.c = -1;
  }

  private boolean e()
  {
    return (this.c != -1) && (this.c != -3) && (this.c != -2);
  }

  public int a(long paramLong)
  {
    if (e())
      return this.b.a(this.c, paramLong);
    return 0;
  }

  public int a(p paramp, e parame, boolean paramBoolean)
  {
    if (e())
      return this.b.a(this.c, paramp, parame, paramBoolean);
    return -3;
  }

  public void a()
  {
    if (this.c == -1);
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      this.c = this.b.a(this.a);
      return;
    }
  }

  public boolean b()
  {
    return (this.c == -3) || ((e()) && (this.b.c(this.c)));
  }

  public void c()
    throws IOException
  {
    if (this.c == -2)
      throw new o(this.b.f().get(this.a).getFormat(0).sampleMimeType);
    this.b.i();
  }

  public void d()
  {
    if (this.c != -1)
    {
      this.b.b(this.a);
      this.c = -1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.k
 * JD-Core Version:    0.6.2
 */