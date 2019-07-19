package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.ac;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.f.z.d;
import com.google.android.exoplayer2.g.a;
import java.util.List;
import java.util.Map;

public abstract class b
  implements z.d
{
  public final l a;
  public final int b;
  public final Format c;
  public final int d;
  public final Object e;
  public final long f;
  public final long g;
  protected final ac h;

  public b(h paramh, l paraml, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong1, long paramLong2)
  {
    this.h = new ac(paramh);
    this.a = ((l)a.a(paraml));
    this.b = paramInt1;
    this.c = paramFormat;
    this.d = paramInt2;
    this.e = paramObject;
    this.f = paramLong1;
    this.g = paramLong2;
  }

  public final long c()
  {
    return this.g - this.f;
  }

  public final long d()
  {
    return this.h.e();
  }

  public final Uri e()
  {
    return this.h.f();
  }

  public final Map<String, List<String>> f()
  {
    return this.h.g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.b
 * JD-Core Version:    0.6.2
 */