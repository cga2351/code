package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.as;
import com.yandex.mobile.ads.impl.fd.b;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.q;
import com.yandex.mobile.ads.nativeads.s;
import com.yandex.mobile.ads.nativeads.t;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class n
  implements MediatedNativeAdapterListener
{
  private final as<MediatedNativeAdapter, MediatedNativeAdapterListener> a;
  private final WeakReference<t> b;
  private final e c;
  private final f d;
  private final Map<String, Object> e = new HashMap();
  private final Map<String, Object> f = new HashMap();
  private boolean g;

  n(t paramt, as<MediatedNativeAdapter, MediatedNativeAdapterListener> paramas)
  {
    Context localContext = paramt.l();
    this.a = paramas;
    this.b = new WeakReference(paramt);
    this.c = new e();
    this.d = new f(localContext);
  }

  private static Map<String, Object> a(MediatedNativeAd paramMediatedNativeAd)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("title", paramMediatedNativeAd.getMediatedNativeAdAssets().getTitle());
    return localHashMap;
  }

  private void a(Context paramContext, fd.b paramb)
  {
    HashMap localHashMap = new HashMap(this.e);
    localHashMap.put("event_type", paramb.a());
    localHashMap.put("ad_info", this.f);
    this.a.b(paramContext, localHashMap);
  }

  private void a(final MediatedNativeAd paramMediatedNativeAd, NativeAdType paramNativeAdType)
  {
    final t localt = (t)this.b.get();
    if (localt != null)
    {
      Context localContext = localt.l();
      this.e.put("native_ad_type", paramNativeAdType.getValue());
      this.a.d(localContext, this.e);
      Map localMap = a(paramMediatedNativeAd);
      this.f.putAll(localMap);
      this.d.a(localt, paramMediatedNativeAd, paramNativeAdType, new f.a()
      {
        public final void a(v<lm> paramAnonymousv)
        {
          k localk = new k(paramMediatedNativeAd);
          s locals = new s(new d(new d.a()
          {
            public final void a(q paramAnonymous2q)
            {
              n.a(n.this).a(paramAnonymous2q);
            }
          }), localk);
          localt.a(paramAnonymousv, locals);
        }
      });
    }
  }

  public final void onAdClicked()
  {
    t localt = (t)this.b.get();
    if (localt != null)
    {
      Context localContext = localt.l();
      this.a.a(localContext, this.e);
      a(localContext, fd.b.t);
    }
    this.c.a();
  }

  public final void onAdClosed()
  {
    this.c.b();
  }

  public final void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
    t localt = (t)this.b.get();
    if (localt != null)
    {
      Context localContext = localt.l();
      this.a.a(localContext, paramAdRequestError, this);
    }
  }

  public final void onAdImpression()
  {
    if (!this.g)
    {
      this.g = true;
      t localt = (t)this.b.get();
      if (localt != null)
      {
        Context localContext = localt.l();
        this.a.c(localContext, this.e);
        a(localContext, fd.b.l);
      }
      this.c.c();
    }
  }

  public final void onAdLeftApplication()
  {
    this.c.d();
  }

  public final void onAdOpened()
  {
    this.c.e();
  }

  public final void onAppInstallAdLoaded(MediatedNativeAd paramMediatedNativeAd)
  {
    a(paramMediatedNativeAd, NativeAdType.APP_INSTALL);
  }

  public final void onContentAdLoaded(MediatedNativeAd paramMediatedNativeAd)
  {
    a(paramMediatedNativeAd, NativeAdType.CONTENT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.n
 * JD-Core Version:    0.6.2
 */