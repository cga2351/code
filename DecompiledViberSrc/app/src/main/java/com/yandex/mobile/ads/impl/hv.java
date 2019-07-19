package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.mediation.interstitial.d;
import com.yandex.mobile.ads.mediation.rewarded.a;
import com.yandex.mobile.ads.rewarded.b;

final class hv
  implements ht
{
  private final bb a;

  hv(bb parambb)
  {
    this.a = parambb;
  }

  public final hs a(ft paramft)
  {
    return new d(paramft, this.a);
  }

  public final hs a(b paramb)
  {
    return new a(paramb, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.hv
 * JD-Core Version:    0.6.2
 */