package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.t;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.ab;
import com.google.android.exoplayer2.source.c.a.e.a;
import com.google.android.exoplayer2.source.c.a.h;
import com.google.android.exoplayer2.source.c.a.i.a;
import com.google.android.exoplayer2.source.c.a.i.e;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.o.a;
import java.io.IOException;
import java.util.List;

public final class j extends com.google.android.exoplayer2.source.a
  implements i.e
{
  private final f a;
  private final Uri b;
  private final e c;
  private final com.google.android.exoplayer2.source.e d;
  private final y e;
  private final boolean f;
  private final com.google.android.exoplayer2.source.c.a.i g;
  private final Object h;
  private ad i;

  static
  {
    o.a("goog.exo.hls");
  }

  private j(Uri paramUri, e parame, f paramf, com.google.android.exoplayer2.source.e parame1, y paramy, com.google.android.exoplayer2.source.c.a.i parami, boolean paramBoolean, Object paramObject)
  {
    this.b = paramUri;
    this.c = parame;
    this.a = paramf;
    this.d = parame1;
    this.e = paramy;
    this.g = parami;
    this.f = paramBoolean;
    this.h = paramObject;
  }

  public m a(n.a parama, com.google.android.exoplayer2.f.b paramb, long paramLong)
  {
    o.a locala = a(parama);
    return new i(this.a, this.g, this.c, this.i, this.e, locala, paramb, this.d, this.f);
  }

  public void a()
  {
    this.g.a();
  }

  public void a(com.google.android.exoplayer2.j paramj, boolean paramBoolean, ad paramad)
  {
    this.i = paramad;
    o.a locala = a(null);
    this.g.a(this.b, locala, this);
  }

  public void a(com.google.android.exoplayer2.source.c.a.e parame)
  {
    long l1;
    long l2;
    label34: long l3;
    long l4;
    long l5;
    label84: List localList;
    long l7;
    label112: long l6;
    boolean bool;
    if (parame.j)
    {
      l1 = c.a(parame.c);
      if ((parame.a != 2) && (parame.a != 1))
        break label190;
      l2 = l1;
      l3 = parame.b;
      if (!this.g.e())
        break label244;
      l4 = parame.c - this.g.c();
      if (!parame.i)
        break label198;
      l5 = l4 + parame.m;
      localList = parame.l;
      if (l3 == -9223372036854775807L)
      {
        if (!localList.isEmpty())
          break label206;
        l7 = 0L;
        l3 = l7;
      }
      l6 = parame.m;
      if (parame.i)
        break label238;
      bool = true;
    }
    label132: for (ab localab = new ab(l2, l1, l5, l6, l4, l3, true, bool, this.h); ; localab = new ab(l2, l1, parame.m, parame.m, 0L, l3, true, false, this.h))
    {
      a(localab, new g(this.g.b(), parame));
      return;
      l1 = -9223372036854775807L;
      break;
      label190: l2 = -9223372036854775807L;
      break label34;
      label198: l5 = -9223372036854775807L;
      break label84;
      label206: l7 = ((e.a)localList.get(Math.max(0, -3 + localList.size()))).f;
      break label112;
      label238: bool = false;
      break label132;
      label244: if (l3 == -9223372036854775807L)
        l3 = 0L;
    }
  }

  public void a(m paramm)
  {
    ((i)paramm).f();
  }

  public void b()
    throws IOException
  {
    this.g.d();
  }

  public static final class a
  {
    private final e a;
    private f b;
    private h c;
    private i.a d;
    private com.google.android.exoplayer2.source.e e;
    private y f;
    private boolean g;
    private boolean h;
    private Object i;

    public a(e parame)
    {
      this.a = ((e)com.google.android.exoplayer2.g.a.a(parame));
      this.c = new com.google.android.exoplayer2.source.c.a.a();
      this.d = com.google.android.exoplayer2.source.c.a.b.a;
      this.b = f.a;
      this.f = new t();
      this.e = new com.google.android.exoplayer2.source.f();
    }

    public j a(Uri paramUri)
    {
      this.h = true;
      return new j(paramUri, this.a, this.b, this.e, this.f, this.d.a(this.a, this.f, this.c), this.g, this.i, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.j
 * JD-Core Version:    0.6.2
 */