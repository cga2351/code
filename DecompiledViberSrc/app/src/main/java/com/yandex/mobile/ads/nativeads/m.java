package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.view.View;
import com.yandex.mobile.ads.impl.fd.a;
import com.yandex.mobile.ads.impl.ll;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.nativeads.template.NativeBannerView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class m extends aw
  implements av, w
{
  protected i a;
  private final ll b;
  private final u c;
  private final f d;
  private final bh e;
  private aw.a f = aw.a.a;
  private final fd.a g = new fd.a()
  {
    final p a = new p();

    public final Map<String, Object> a()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("bind_type", m.a(m.this).c);
      localHashMap.put("native_ad_type", m.b(m.this).b().getValue());
      List localList = p.a(m.b(m.this));
      if (localList.size() > 0)
        localHashMap.put("image_sizes", localList.toArray(new String[localList.size()]));
      return localHashMap;
    }
  };

  m(Context paramContext, ll paramll, u paramu, i parami, c paramc)
  {
    super(paramContext, paramc);
    this.b = paramll;
    this.c = paramu;
    this.a = parami;
    this.d = f.a(paramc.a().c().d());
    a(this.g);
    this.e = new bh();
  }

  private <T extends View> void a(T paramT, ai<T> paramai, f paramf)
    throws NativeAdException
  {
    a(paramT, this.a, paramai, paramf);
  }

  final void a(Context paramContext)
  {
    this.e.a(paramContext);
    super.a(paramContext);
  }

  final void a(ae paramae, ai paramai)
    throws NativeAdException
  {
    a(paramae, paramai, f.a());
  }

  public final void a(NativeBannerView paramNativeBannerView)
    throws NativeAdException
  {
    com.yandex.mobile.ads.nativeads.template.c localc = new com.yandex.mobile.ads.nativeads.template.c();
    this.f = aw.a.b;
    paramNativeBannerView.a(this);
    a(paramNativeBannerView, localc, this.d);
  }

  public void addImageLoadingListener(NativeAdImageLoadingListener paramNativeAdImageLoadingListener)
  {
    this.c.a(paramNativeAdImageLoadingListener);
  }

  public void bindNativeAd(NativeAdViewBinder paramNativeAdViewBinder)
    throws NativeAdException
  {
    View localView = paramNativeAdViewBinder.getNativeAdView();
    this.e.a(localView, new bh.b()
    {
      public final void a()
      {
        m.this.b();
      }

      public final void b()
      {
        m.this.c();
      }
    });
    a(localView, new ag(paramNativeAdViewBinder), f.a());
  }

  public NativeAdAssets getAdAssets()
  {
    return this.c.d();
  }

  public NativeAdType getAdType()
  {
    return this.c.a();
  }

  public String getInfo()
  {
    return this.c.b();
  }

  public void loadImages()
  {
    this.c.c();
  }

  public void removeImageLoadingListener(NativeAdImageLoadingListener paramNativeAdImageLoadingListener)
  {
    this.c.b(paramNativeAdImageLoadingListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.m
 * JD-Core Version:    0.6.2
 */