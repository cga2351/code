package com.yandex.mobile.ads.mediation.nativeads;

import com.yandex.mobile.ads.nativeads.NativeAdViewBinder;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.bb;
import com.yandex.mobile.ads.nativeads.e;

final class j
  implements bb
{
  private final bb a;
  private final MediatedNativeAd b;

  j(bb parambb, MediatedNativeAd paramMediatedNativeAd)
  {
    this.a = parambb;
    this.b = paramMediatedNativeAd;
  }

  public final void a()
  {
    this.a.a();
  }

  public final void a(af paramaf)
  {
    this.a.a(paramaf);
    NativeAdViewBinder localNativeAdViewBinder = paramaf.f();
    this.b.unbindNativeAd(localNativeAdViewBinder);
  }

  public final void a(af paramaf, e parame)
  {
    this.a.a(paramaf, parame);
    NativeAdViewBinder localNativeAdViewBinder = paramaf.f();
    this.b.bindNativeAd(localNativeAdViewBinder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.j
 * JD-Core Version:    0.6.2
 */