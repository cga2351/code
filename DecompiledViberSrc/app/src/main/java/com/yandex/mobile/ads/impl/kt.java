package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.nativeads.a;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.b;
import com.yandex.mobile.ads.nativeads.bg;
import com.yandex.mobile.ads.nativeads.q;

public final class kt
  implements a
{
  private final v a;
  private final eo b;
  private final q c;
  private final kw d;
  private final b e;
  private final bg f;
  private fd.a g;

  public kt(Context paramContext, v paramv, eo parameo, q paramq, bg parambg)
  {
    this.a = paramv;
    this.b = parameo;
    this.c = paramq;
    this.f = parambg;
    this.d = new kw(new cj(paramContext));
    this.e = new b(paramq);
  }

  public final void a(Context paramContext, li paramli, af paramaf)
  {
    this.c.a(paramli);
    cj localcj = new cj(paramContext);
    w localw = this.e.a();
    ca localca = new ca(paramContext, this.a, this.g);
    cp localcp = this.f.a(paramContext, this.b, localw);
    kv localkv = new kv(localcj, this.a, localcp, localca);
    kz localkz = new kz(localca, localkv, paramaf, this.c);
    this.d.a(paramli.c());
    localkz.a(paramContext, paramli.a());
    localkv.a(paramli.d());
  }

  public final void a(fd.a parama)
  {
    this.g = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kt
 * JD-Core Version:    0.6.2
 */