package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.dd;
import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.h;
import com.yandex.mobile.ads.nativeads.j;
import com.yandex.mobile.ads.nativeads.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class f
{
  private final h a;
  private final m b;
  private final c c = new c();
  private final Point d;

  f(Context paramContext)
  {
    this.a = new h(paramContext);
    this.d = dd.j(paramContext);
    this.b = new m(new a(paramContext, this.c));
  }

  final void a(final t paramt, final MediatedNativeAd paramMediatedNativeAd, final NativeAdType paramNativeAdType, final a parama)
  {
    MediatedNativeAdAssets localMediatedNativeAdAssets = paramMediatedNativeAd.getMediatedNativeAdAssets();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localMediatedNativeAdAssets.getFavicon());
    localArrayList.add(localMediatedNativeAdAssets.getIcon());
    localArrayList.add(localMediatedNativeAdAssets.getImage());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      MediatedNativeAdImage localMediatedNativeAdImage = (MediatedNativeAdImage)localIterator.next();
      if (localMediatedNativeAdImage != null)
      {
        String str = localMediatedNativeAdImage.getUrl();
        if ((!TextUtils.isEmpty(str)) && (!c.a(localMediatedNativeAdImage.getWidth(), localMediatedNativeAdImage.getHeight())))
        {
          lh locallh = new lh();
          locallh.a(str);
          locallh.a(this.d.x);
          locallh.b(this.d.y);
          localHashSet.add(locallh);
        }
      }
    }
    this.a.a(localHashSet, new j()
    {
      public final void a(Map<String, Bitmap> paramAnonymousMap)
      {
        f.a(f.this, paramMediatedNativeAd, paramAnonymousMap, paramNativeAdType, parama);
      }
    });
  }

  static abstract interface a
  {
    public abstract void a(v<lm> paramv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.f
 * JD-Core Version:    0.6.2
 */