package com.yandex.mobile.ads.nativeads.template;

import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdType;

public final class e
{
  private final NativeAdType a;
  private final String b;
  private final NativeAdImage c;
  private final Float d;
  private final String e;
  private final String f;

  public e(NativeAdAssets paramNativeAdAssets, NativeAdType paramNativeAdType)
  {
    this.b = paramNativeAdAssets.getCallToAction();
    this.c = paramNativeAdAssets.getImage();
    this.d = paramNativeAdAssets.getRating();
    this.e = paramNativeAdAssets.getReviewCount();
    this.f = paramNativeAdAssets.getWarning();
    this.a = paramNativeAdType;
  }

  private boolean g()
  {
    return (j()) && ((NativeAdType.CONTENT == this.a) || (i()));
  }

  private boolean h()
  {
    return (this.d != null) || (this.e != null);
  }

  private boolean i()
  {
    return !h();
  }

  private boolean j()
  {
    return this.b != null;
  }

  final boolean a()
  {
    return (this.c != null) && (("large".equals(this.c.a())) || ("wide".equals(this.c.a())));
  }

  final boolean b()
  {
    return (j()) && ((g()) || (a()));
  }

  final boolean c()
  {
    return (j()) || (h());
  }

  final boolean d()
  {
    return g();
  }

  final boolean e()
  {
    return (g()) || ((a()) && (i()));
  }

  public final boolean f()
  {
    return this.f != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.e
 * JD-Core Version:    0.6.2
 */