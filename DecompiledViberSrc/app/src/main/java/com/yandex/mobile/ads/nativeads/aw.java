package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.ae;
import com.yandex.mobile.ads.impl.ae.b;
import com.yandex.mobile.ads.impl.ak;
import com.yandex.mobile.ads.impl.ao;
import com.yandex.mobile.ads.impl.ao.c;
import com.yandex.mobile.ads.impl.ap;
import com.yandex.mobile.ads.impl.cw;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.fd.a;
import com.yandex.mobile.ads.impl.kq;
import com.yandex.mobile.ads.impl.kt;
import com.yandex.mobile.ads.impl.ny;
import com.yandex.mobile.ads.impl.nz;
import com.yandex.mobile.ads.impl.v;
import java.util.List;

public abstract class aw
{
  private final Context a;
  private final bb b;
  private final ba c;
  private final bd d;
  private final ao e;
  private final ap f;
  private final ae g;
  private final q h;
  private final e i;
  private final kt j;
  private final eo k;
  private final bg l;
  private final nz m;
  private final ny n;
  private final kq o;
  private af p;
  private final ae.b q = new ae.b()
  {
    public final void a(Intent paramAnonymousIntent)
    {
      if (!aw.a(aw.this).a());
      for (boolean bool = true; ; bool = false)
      {
        new StringBuilder("onPhoneStateChanged(), intent.getAction = ").append(paramAnonymousIntent.getAction()).append(", isNativeAdViewShown = ").append(bool).append(", clazz = ").append(getClass());
        aw.b(aw.this).a(paramAnonymousIntent, bool);
        return;
      }
    }
  };
  private final ao.c r = new ao.c()
  {
    public final ak a(int paramAnonymousInt)
    {
      if (!aw.d(aw.this).a(aw.c(aw.this)));
      for (boolean bool = true; ; bool = false)
      {
        ak localak = aw.a(aw.this).a(paramAnonymousInt, bool);
        View localView = aw.e(aw.this).b();
        aw.f(aw.this).a(localak, localView);
        return localak;
      }
    }
  };

  public aw(Context paramContext, c paramc)
  {
    this.a = paramContext;
    this.b = paramc.d();
    this.c = paramc.b();
    this.d = paramc.c();
    o localo = paramc.a();
    this.k = localo.a();
    String str = this.k.e();
    b localb = this.k.a();
    v localv = localo.b();
    this.h = paramc.e().a(paramContext, this.k);
    this.l = new bg();
    this.j = new kt(paramContext, localv, this.k, this.h, this.l);
    this.e = new ao(this.a, localb, this.r, cw.a(this));
    this.e.a(this.h);
    this.e.a(str, this.d.b());
    this.f = new ap(this.a, this.d.c());
    this.i = new e(this.j, this.e);
    this.g = ae.a();
    this.o = new kq();
    this.m = new nz(this.a, localb, str, this.d.a());
    this.n = new ny(this.a, str, this.d.a());
    this.n.a(a());
  }

  private void a(af paramaf)
  {
    if (paramaf != null)
      this.b.a(paramaf);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.f.a();
  }

  protected abstract List<String> a();

  public final void a(int paramInt)
  {
    new StringBuilder("onVisibilityChanged(), visibility = ").append(paramInt).append(", clazz = ").append(cw.a(this));
    if (paramInt == 0)
    {
      b();
      return;
    }
    c();
  }

  void a(Context paramContext)
  {
    c();
    this.h.h();
    a(this.p);
  }

  final <T extends View> void a(T paramT, i parami, ai<T> paramai, f paramf)
    throws NativeAdException
  {
    ah localah = ah.a();
    aw localaw = localah.a(paramT);
    if (!equals(localaw))
    {
      if (localaw != null)
        localaw.a(paramT.getContext());
      localah.a(paramT, this);
      af localaf = new af(paramT, paramai, parami, paramf);
      localaf.a();
      this.m.a(localaf);
      this.p = localaf;
      this.c.a(localaf);
      if (this.c.b())
      {
        a(localaf);
        this.b.a(localaf, this.i);
        new StringBuilder("renderAdView(), BIND, clazz = ").append(cw.a(this));
        b();
      }
    }
    else
    {
      return;
    }
    throw new NativeAdException("Resource for required view is not present");
  }

  final void a(fd.a parama)
  {
    this.j.a(parama);
    this.e.a(parama);
    this.m.a(parama);
    this.h.a(parama);
  }

  final void b()
  {
    if (!this.c.a());
    for (boolean bool = true; ; bool = false)
    {
      new StringBuilder("registerTrackers(), isNativeAdViewShown = ").append(bool).append(", clazz = ").append(cw.a(this));
      a(bool);
      this.e.a();
      this.g.a(this.q, this.a);
      return;
    }
  }

  final void c()
  {
    new StringBuilder("unregisterTrackers(), clazz = ").append(cw.a(this));
    this.e.b();
    this.g.b(this.q, this.a);
  }

  final ba d()
  {
    return this.c;
  }

  final bd e()
  {
    return this.d;
  }

  public void setAdEventListener(NativeAdEventListener paramNativeAdEventListener)
  {
    this.h.a(paramNativeAdEventListener);
  }

  public void setAdTapHandler(AdTapHandler paramAdTapHandler)
  {
    this.l.a(paramAdTapHandler);
  }

  public void shouldOpenLinksInApp(boolean paramBoolean)
  {
    this.k.a(paramBoolean);
  }

  static enum a
  {
    final String c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(String paramString)
    {
      this.c = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.aw
 * JD-Core Version:    0.6.2
 */