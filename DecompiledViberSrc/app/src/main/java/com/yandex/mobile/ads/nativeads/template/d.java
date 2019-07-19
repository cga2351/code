package com.yandex.mobile.ads.nativeads.template;

import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdMedia;
import com.yandex.mobile.ads.nativeads.NativeAdType;

public final class d
{
  private final NativeAdImage a;
  private final NativeAdImage b;
  private final NativeAdImage c;
  private final NativeAdMedia d;
  private final NativeAdType e;

  public d(NativeAdAssets paramNativeAdAssets, NativeAdType paramNativeAdType)
  {
    this.a = paramNativeAdAssets.getFavicon();
    this.b = paramNativeAdAssets.getIcon();
    this.c = paramNativeAdAssets.getImage();
    this.d = paramNativeAdAssets.getMedia();
    this.e = paramNativeAdType;
  }

  static boolean a(NativeAdImage paramNativeAdImage)
  {
    return ("large".equals(paramNativeAdImage.a())) || ("wide".equals(paramNativeAdImage.a()));
  }

  static boolean b(NativeAdImage paramNativeAdImage)
  {
    return "fill".equals(paramNativeAdImage.a());
  }

  final boolean a()
  {
    if ((f()) || (this.c == null) || (a(this.c)));
    for (int i = 1; (this.a != null) && (i != 0); i = 0)
      return true;
    return false;
  }

  final boolean b()
  {
    return this.b != null;
  }

  final boolean c()
  {
    if (NativeAdType.APP_INSTALL == this.e);
    for (int i = 1; (!f()) && (this.c != null) && (!a(this.c)) && (i == 0); i = 0)
      return true;
    return false;
  }

  final boolean d()
  {
    return (!f()) && (this.c != null) && (a(this.c));
  }

  final boolean e()
  {
    return (!f()) && (this.c != null) && (b(this.c));
  }

  final boolean f()
  {
    return this.d != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.d
 * JD-Core Version:    0.6.2
 */