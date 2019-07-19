package com.yandex.mobile.ads.mediation.nativeads;

import android.graphics.Bitmap;
import com.yandex.mobile.ads.impl.ll;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.impl.v.a;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class m
{
  private final l a;

  m(a parama)
  {
    this.a = new l(parama);
  }

  final v<lm> a(MediatedNativeAd paramMediatedNativeAd, Map<String, Bitmap> paramMap, NativeAdType paramNativeAdType)
  {
    MediatedNativeAdAssets localMediatedNativeAdAssets = paramMediatedNativeAd.getMediatedNativeAdAssets();
    List localList = this.a.a(localMediatedNativeAdAssets, paramMap);
    ll localll = new ll();
    localll.a(paramNativeAdType.getValue());
    localll.a(localList);
    lm locallm = new lm();
    locallm.b(Collections.singletonList(localll));
    return new v.a().a(locallm).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.m
 * JD-Core Version:    0.6.2
 */