package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.cm;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.fd.a;
import com.yandex.mobile.ads.impl.fn;
import com.yandex.mobile.ads.impl.li;

public final class q
  implements an
{
  private final cm a;
  private NativeAdEventListener b;

  public q(Context paramContext, eo parameo)
  {
    this.a = new cm(paramContext, parameo);
  }

  public final void a()
  {
    d();
  }

  public final void a(fd.a parama)
  {
    this.a.a(parama);
  }

  public final void a(li paramli)
  {
    this.a.a(paramli.b());
  }

  final void a(NativeAdEventListener paramNativeAdEventListener)
  {
    this.b = paramNativeAdEventListener;
  }

  public final void b()
  {
    this.a.d();
  }

  public final void c()
  {
    if (this.b != null)
      this.b.onAdClosed();
    this.a.b();
  }

  public final void d()
  {
    if (this.b != null)
      fn.a(this.b, "onAdImpressionTracked", new Object[0]);
  }

  public final void e()
  {
    if (this.b != null)
      this.b.onAdLeftApplication();
    this.a.c();
  }

  public final void f()
  {
    if (this.b != null)
      this.b.onAdOpened();
    this.a.a();
  }

  public final void g()
  {
    if ((this.b instanceof ClosableNativeAdEventListener))
      ((ClosableNativeAdEventListener)this.b).closeNativeAd();
  }

  final void h()
  {
    this.a.e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.q
 * JD-Core Version:    0.6.2
 */