package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class aa<T>
  implements z.d
{
  public final l a;
  public final int b;
  private final ac c;
  private final a<? extends T> d;
  private volatile T e;

  public aa(h paramh, Uri paramUri, int paramInt, a<? extends T> parama)
  {
    this(paramh, new l(paramUri, 3), paramInt, parama);
  }

  public aa(h paramh, l paraml, int paramInt, a<? extends T> parama)
  {
    this.c = new ac(paramh);
    this.a = paraml;
    this.b = paramInt;
    this.d = parama;
  }

  public final void a()
  {
  }

  public final void b()
    throws IOException
  {
    this.c.d();
    k localk = new k(this.c, this.a);
    try
    {
      localk.a();
      Uri localUri = (Uri)a.a(this.c.a());
      this.e = this.d.b(localUri, localk);
      return;
    }
    finally
    {
      ag.a(localk);
    }
  }

  public final T c()
  {
    return this.e;
  }

  public long d()
  {
    return this.c.e();
  }

  public Uri e()
  {
    return this.c.f();
  }

  public Map<String, List<String>> f()
  {
    return this.c.g();
  }

  public static abstract interface a<T>
  {
    public abstract T b(Uri paramUri, InputStream paramInputStream)
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.aa
 * JD-Core Version:    0.6.2
 */