package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import com.yandex.mobile.ads.impl.le;
import com.yandex.mobile.ads.impl.lf;
import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.lj;
import com.yandex.mobile.ads.impl.lk;
import com.yandex.mobile.ads.impl.ll;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class u
{
  private final ll a;
  private final i b;
  private final h c;
  private final bb d;
  private final Set<NativeAdImageLoadingListener> e = new CopyOnWriteArraySet();

  public u(Context paramContext, ll paramll, i parami, bb parambb)
  {
    this.a = paramll;
    this.b = parami;
    this.d = parambb;
    this.c = new h(paramContext);
  }

  private static <T> T a(le<T> paramle)
  {
    if (paramle != null)
      return paramle.c();
    return null;
  }

  public final NativeAdType a()
  {
    return this.a.b();
  }

  final void a(NativeAdImageLoadingListener paramNativeAdImageLoadingListener)
  {
    this.e.add(paramNativeAdImageLoadingListener);
  }

  public final String b()
  {
    return this.a.f();
  }

  final void b(NativeAdImageLoadingListener paramNativeAdImageLoadingListener)
  {
    this.e.remove(paramNativeAdImageLoadingListener);
  }

  public final void c()
  {
    List localList = Collections.singletonList(this.a);
    Set localSet = this.c.a(localList);
    this.c.a(localSet, new j()
    {
      public final void a(Map<String, Bitmap> paramAnonymousMap)
      {
        u.a(u.this).a();
        Iterator localIterator = u.b(u.this).iterator();
        while (localIterator.hasNext())
        {
          NativeAdImageLoadingListener localNativeAdImageLoadingListener = (NativeAdImageLoadingListener)localIterator.next();
          if (localNativeAdImageLoadingListener != null)
            localNativeAdImageLoadingListener.onFinishLoadingImages();
        }
      }
    });
  }

  public final NativeAdAssets d()
  {
    k localk = new k();
    List localList = this.a.c();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      le localle = (le)localIterator.next();
      localHashMap.put(localle.a(), localle);
    }
    lk locallk = (lk)a((le)localHashMap.get("media"));
    localk.a((String)a((le)localHashMap.get("age")));
    localk.b((String)a((le)localHashMap.get("body")));
    localk.c((String)a((le)localHashMap.get("call_to_action")));
    localk.a((lf)a((le)localHashMap.get("close_button")));
    localk.d((String)a((le)localHashMap.get("domain")));
    localk.a((lh)a((le)localHashMap.get("favicon")), this.b);
    localk.b((lh)a((le)localHashMap.get("icon")), this.b);
    if (locallk != null);
    for (lh locallh = locallk.b(); ; locallh = null)
    {
      localk.c(locallh, this.b);
      lj locallj = null;
      if (locallk != null)
        locallj = locallk.a();
      localk.a(locallj);
      localk.e((String)a((le)localHashMap.get("price")));
      localk.f((String)a((le)localHashMap.get("rating")));
      localk.g((String)a((le)localHashMap.get("review_count")));
      localk.h((String)a((le)localHashMap.get("sponsored")));
      localk.i((String)a((le)localHashMap.get("title")));
      localk.j((String)a((le)localHashMap.get("warning")));
      return localk;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.u
 * JD-Core Version:    0.6.2
 */