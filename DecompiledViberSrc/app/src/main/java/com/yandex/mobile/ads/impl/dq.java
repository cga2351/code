package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Collections;
import java.util.Map;

public final class dq
  implements dn
{
  private final ds a;
  private final dj b;
  private final du c;
  private final gg d;
  private dv e;
  private jt f;

  dq(ds paramds, dv paramdv)
  {
    this.a = paramds;
    this.b = new dj();
    this.e = paramdv;
    this.d = new gg();
    this.c = new du(paramds);
  }

  final dv.a a(int paramInt1, int paramInt2)
  {
    return this.e.a(paramInt1, paramInt2);
  }

  final void a()
  {
    Map localMap = Collections.emptyMap();
    this.c.a(localMap);
  }

  public final void a(WebView paramWebView, Map<String, String> paramMap)
  {
  }

  final void a(dv paramdv)
  {
    this.e = paramdv;
  }

  final void a(jt paramjt)
  {
    this.f = paramjt;
  }

  public final void a(String paramString)
  {
    if (this.f != null)
      this.f.a(this.a, paramString);
  }

  final void b(String paramString)
  {
    boolean bool = gg.a(paramString);
    gj.a();
    gj.a(bool).a(this.a, this, this.b).a(paramString);
  }

  public final void b(boolean paramBoolean)
  {
  }

  public final void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
  }

  public final void onAdLoaded()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dq
 * JD-Core Version:    0.6.2
 */