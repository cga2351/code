package com.yandex.mobile.ads.mediation.nativeads;

import android.graphics.Bitmap;
import com.yandex.mobile.ads.impl.hx;
import com.yandex.mobile.ads.impl.hy;
import com.yandex.mobile.ads.impl.ie;
import com.yandex.mobile.ads.impl.if;
import com.yandex.mobile.ads.impl.le;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class l
{
  private final a a;
  private final hy b;
  private final if c;

  l(a parama)
  {
    this.a = parama;
    this.b = new hy();
    this.c = new if();
  }

  private <T> le a(String paramString, T paramT)
  {
    ie localie = this.c.a(paramString);
    if ((paramT != null) && (localie.a(paramT)))
      return this.b.a(paramString).a(paramString, paramT);
    return null;
  }

  private static List<le> a(List<le> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      le localle = (le)localIterator.next();
      if (localle != null)
        localArrayList.add(localle);
    }
    return localArrayList;
  }

  final List<le> a(MediatedNativeAdAssets paramMediatedNativeAdAssets, Map<String, Bitmap> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a("age", paramMediatedNativeAdAssets.getAge()));
    localArrayList.add(a("body", paramMediatedNativeAdAssets.getBody()));
    localArrayList.add(a("call_to_action", paramMediatedNativeAdAssets.getCallToAction()));
    localArrayList.add(a("domain", paramMediatedNativeAdAssets.getDomain()));
    localArrayList.add(a("favicon", this.a.b(paramMap, paramMediatedNativeAdAssets.getFavicon())));
    localArrayList.add(a("icon", this.a.b(paramMap, paramMediatedNativeAdAssets.getIcon())));
    localArrayList.add(a("media", this.a.a(paramMap, paramMediatedNativeAdAssets.getImage())));
    localArrayList.add(a("price", paramMediatedNativeAdAssets.getPrice()));
    localArrayList.add(a("rating", String.valueOf(paramMediatedNativeAdAssets.getRating())));
    localArrayList.add(a("review_count", paramMediatedNativeAdAssets.getReviewCount()));
    localArrayList.add(a("sponsored", paramMediatedNativeAdAssets.getSponsored()));
    localArrayList.add(a("title", paramMediatedNativeAdAssets.getTitle()));
    localArrayList.add(a("warning", paramMediatedNativeAdAssets.getWarning()));
    return a(localArrayList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.l
 * JD-Core Version:    0.6.2
 */