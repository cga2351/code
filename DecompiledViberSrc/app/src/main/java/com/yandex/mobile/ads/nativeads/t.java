package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.ac;
import com.yandex.mobile.ads.impl.ad;
import com.yandex.mobile.ads.impl.bm;
import com.yandex.mobile.ads.impl.ce;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.ik;
import com.yandex.mobile.ads.impl.il;
import com.yandex.mobile.ads.impl.kb;
import com.yandex.mobile.ads.impl.kc;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.ma;
import com.yandex.mobile.ads.impl.nc;
import com.yandex.mobile.ads.impl.r;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.mediation.nativeads.o;

public final class t extends com.yandex.mobile.ads.impl.y<lm>
{
  private final kb h;
  private final kc i;
  private final b j;
  private final ik k;
  private ce<lm> l;

  public t(Context paramContext, NativeAdLoaderConfiguration paramNativeAdLoaderConfiguration, b paramb)
  {
    super(paramContext, b.d);
    a_(paramNativeAdLoaderConfiguration.getBlockId());
    String[] arrayOfString1 = paramNativeAdLoaderConfiguration.getImageSizes();
    this.f.a(arrayOfString1);
    boolean bool = paramNativeAdLoaderConfiguration.shouldLoadImagesAutomatically();
    this.f.b(bool);
    String[] arrayOfString2 = nc.a(paramContext).a();
    this.f.b(arrayOfString2);
    this.j = paramb;
    this.h = new a();
    this.i = new kc(paramContext, r(), paramNativeAdLoaderConfiguration);
    this.k = new ik();
  }

  protected final bm<lm> a(String paramString1, String paramString2)
  {
    return new ma(this.b, this.l, this.f, paramString1, paramString2, this);
  }

  final void a()
  {
    this.c.a();
    a(com.yandex.mobile.ads.impl.s.a);
  }

  public final void a(AdRequest paramAdRequest)
  {
    try
    {
      b(paramAdRequest);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(AdRequest paramAdRequest, ce<lm> paramce, ac paramac, ad paramad)
  {
    this.l = paramce;
    if (paramce.a())
    {
      this.f.a(paramac);
      this.f.a(paramad);
      a(paramAdRequest);
      return;
    }
    onAdFailedToLoad(com.yandex.mobile.ads.impl.t.j);
  }

  protected final void a(AdRequestError paramAdRequestError)
  {
    this.j.a(paramAdRequestError);
  }

  public final void a(v<lm> paramv)
  {
    if (!k())
      ik.a(paramv).a(this).a(this.b, paramv);
  }

  public final void a(v<lm> paramv, s params)
  {
    if (!k())
      this.i.a(this.b, paramv, params, this.h);
  }

  protected final boolean d(AdRequest paramAdRequest)
  {
    return true;
  }

  protected final boolean m()
  {
    return n();
  }

  final class a
    implements kb
  {
    a()
    {
    }

    public final void a(AdRequestError paramAdRequestError)
    {
      t.this.onAdFailedToLoad(paramAdRequestError);
    }

    public final void a(NativeGenericAd paramNativeGenericAd)
    {
      t.this.s();
      t.a(t.this).a(paramNativeGenericAd);
    }

    public final void a(y paramy)
    {
      t.this.s();
      t.a(t.this).a(paramy);
    }
  }

  public static abstract interface b
  {
    public abstract void a(AdRequestError paramAdRequestError);

    public abstract void a(NativeGenericAd paramNativeGenericAd);

    public abstract void a(y paramy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.t
 * JD-Core Version:    0.6.2
 */