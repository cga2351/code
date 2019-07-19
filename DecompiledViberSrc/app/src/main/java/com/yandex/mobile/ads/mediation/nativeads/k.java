package com.yandex.mobile.ads.mediation.nativeads;

import com.yandex.mobile.ads.impl.ll;
import com.yandex.mobile.ads.nativeads.bb;
import com.yandex.mobile.ads.nativeads.bc;
import com.yandex.mobile.ads.nativeads.bj;

public final class k
  implements bc
{
  private final MediatedNativeAd a;
  private final bc b;

  k(MediatedNativeAd paramMediatedNativeAd)
  {
    this.a = paramMediatedNativeAd;
    this.b = new bj();
  }

  public final bb a(ll paramll)
  {
    return new j(this.b.a(paramll), this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.k
 * JD-Core Version:    0.6.2
 */