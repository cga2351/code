package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.AdRequestError;
import java.io.Serializable;
import java.util.Map;

public final class gy
  implements dn, dr, gp, j
{
  private final RelativeLayout a;
  private final cp b;
  private final m c;
  private final Context d;
  private final Window e;
  private final v<String> f;
  private final String g;
  private final cj h;
  private final ba i;
  private final fz j;
  private final hm k;
  private final ge l;

  gy(Context paramContext, RelativeLayout paramRelativeLayout, cp paramcp, m paramm, Window paramWindow, hc paramhc)
  {
    this.d = paramContext;
    this.a = paramRelativeLayout;
    this.b = paramcp;
    this.c = paramm;
    this.e = paramWindow;
    this.f = paramhc.a();
    this.g = paramhc.b();
    this.h = new cj(paramContext);
    this.i = new ba();
    this.j = new hd(this.d, this.f);
    new gg();
    boolean bool1 = gg.a(this.g);
    gj.a();
    this.l = gj.a(bool1).a(this.j, this, this, this);
    boolean bool2 = this.f.u();
    final ge localge = this.l;
    View localView = fx.g.a(this.d);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        localge.a();
        gy.this.h();
      }
    });
    new hn(new hg());
    this.k = hn.a(localView, bool1, bool2);
  }

  public final void a()
  {
    this.e.requestFeature(1);
    this.e.addFlags(1024);
    if (fl.a(11))
      this.e.addFlags(16777216);
    this.k.a(this.d, this.c, this.f.c());
  }

  public final void a(WebView paramWebView, Map<String, String> paramMap)
  {
    this.k.a();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_tracking_parameters", (Serializable)paramMap);
    this.c.a(0, localBundle);
  }

  public final void a(String paramString)
  {
    this.h.a(paramString, this.f, this.b);
  }

  public final void a(boolean paramBoolean)
  {
    this.k.a(paramBoolean);
  }

  public final void b()
  {
    this.l.a(this.g);
    this.k.a(this.a);
    this.j.setId(2);
    View localView = this.k.a(this.j, this.f);
    this.a.addView(localView);
    this.c.a(5, null);
  }

  public final void b(boolean paramBoolean)
  {
  }

  public final boolean c()
  {
    return false;
  }

  public final void d()
  {
    this.c.a(4, null);
  }

  public final void e()
  {
    this.j.f();
    this.c.a(2, null);
  }

  public final void f()
  {
    this.j.e();
    this.c.a(3, null);
  }

  public final void g()
  {
    this.j.g();
    this.l.b();
    this.k.b();
  }

  public final void h()
  {
    this.c.a();
  }

  public final void i()
  {
    ba.c(this.d, this.f);
    this.c.a(13, null);
  }

  public final void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
  }

  public final void onAdLoaded()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gy
 * JD-Core Version:    0.6.2
 */