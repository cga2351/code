package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.h.a;
import com.google.android.exoplayer2.f.t;
import com.google.android.exoplayer2.f.y;
import java.io.IOException;

public final class l extends a
  implements i.c
{
  private final Uri a;
  private final h.a b;
  private final com.google.android.exoplayer2.extractor.j c;
  private final y d;
  private final String e;
  private final int f;
  private final Object g;
  private long h;
  private boolean i;
  private ad j;

  @Deprecated
  public l(Uri paramUri, h.a parama, com.google.android.exoplayer2.extractor.j paramj, Handler paramHandler, a parama1)
  {
    this(paramUri, parama, paramj, paramHandler, parama1, null);
  }

  @Deprecated
  public l(Uri paramUri, h.a parama, com.google.android.exoplayer2.extractor.j paramj, Handler paramHandler, a parama1, String paramString)
  {
    this(paramUri, parama, paramj, paramHandler, parama1, paramString, 1048576);
  }

  @Deprecated
  public l(Uri paramUri, h.a parama, com.google.android.exoplayer2.extractor.j paramj, Handler paramHandler, a parama1, String paramString, int paramInt)
  {
    this(paramUri, parama, paramj, new t(), paramString, paramInt, null);
    if ((parama1 != null) && (paramHandler != null))
      a(paramHandler, new b(parama1));
  }

  private l(Uri paramUri, h.a parama, com.google.android.exoplayer2.extractor.j paramj, y paramy, String paramString, int paramInt, Object paramObject)
  {
    this.a = paramUri;
    this.b = parama;
    this.c = paramj;
    this.d = paramy;
    this.e = paramString;
    this.f = paramInt;
    this.h = -9223372036854775807L;
    this.g = paramObject;
  }

  private void b(long paramLong, boolean paramBoolean)
  {
    this.h = paramLong;
    this.i = paramBoolean;
    a(new ab(this.h, this.i, false, this.g), null);
  }

  public m a(n.a parama, b paramb, long paramLong)
  {
    h localh = this.b.a();
    if (this.j != null)
      localh.a(this.j);
    return new i(this.a, localh, this.c.createExtractors(), this.d, a(parama), this, paramb, this.e, this.f);
  }

  public void a()
  {
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    if (paramLong == -9223372036854775807L)
      paramLong = this.h;
    if ((this.h == paramLong) && (this.i == paramBoolean))
      return;
    b(paramLong, paramBoolean);
  }

  public void a(com.google.android.exoplayer2.j paramj, boolean paramBoolean, ad paramad)
  {
    this.j = paramad;
    b(this.h, this.i);
  }

  public void a(m paramm)
  {
    ((i)paramm).f();
  }

  public void b()
    throws IOException
  {
  }

  @Deprecated
  public static abstract interface a
  {
    public abstract void a(IOException paramIOException);
  }

  @Deprecated
  private static final class b extends g
  {
    private final l.a a;

    public b(l.a parama)
    {
      this.a = ((l.a)com.google.android.exoplayer2.g.a.a(parama));
    }

    public void a(int paramInt, n.a parama, o.b paramb, o.c paramc, IOException paramIOException, boolean paramBoolean)
    {
      this.a.a(paramIOException);
    }
  }

  public static final class c
  {
    private final h.a a;
    private com.google.android.exoplayer2.extractor.j b;
    private String c;
    private Object d;
    private y e;
    private int f;
    private boolean g;

    public c(h.a parama)
    {
      this.a = parama;
      this.e = new t();
      this.f = 1048576;
    }

    public l a(Uri paramUri)
    {
      this.g = true;
      if (this.b == null)
        this.b = new e();
      return new l(paramUri, this.a, this.b, this.e, this.c, this.f, this.d, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.l
 * JD-Core Version:    0.6.2
 */