package com.viber.voip.banner.e;

import com.google.d.f;
import com.google.d.g;
import com.google.d.j;
import com.google.d.k;
import com.google.d.l;
import com.google.d.o;
import com.google.d.p;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AdsAfterCallMetaInfoItem;
import com.viber.voip.banner.datatype.AppNexusStickerClickerMetaInfo;
import com.viber.voip.banner.datatype.Banner;
import com.viber.voip.banner.datatype.Banner.Size;
import com.viber.voip.banner.datatype.BannerItem;
import com.viber.voip.banner.datatype.BannerItem.Type;
import com.viber.voip.banner.datatype.ImageBannerItem.Size;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo;
import com.viber.voip.banner.datatype.Splash;
import com.viber.voip.banner.datatype.StickerClickerMetaInfo;
import com.viber.voip.banner.datatype.StickerClickerMetaInfoItem;
import com.viber.voip.banner.datatype.TextBannerItem.Alignment;
import java.lang.reflect.Type;

public class a
{
  public static StickerClickerMetaInfo a(String paramString)
  {
    return (StickerClickerMetaInfo)new g().a().a(paramString, StickerClickerMetaInfo.class);
  }

  public static String a(StickerClickerMetaInfoItem paramStickerClickerMetaInfoItem)
  {
    return new g().a().b(paramStickerClickerMetaInfoItem);
  }

  public static AppNexusStickerClickerMetaInfo b(String paramString)
  {
    return (AppNexusStickerClickerMetaInfo)new g().a().a(paramString, AppNexusStickerClickerMetaInfo.class);
  }

  public static StickerClickerMetaInfoItem c(String paramString)
  {
    return (StickerClickerMetaInfoItem)new g().a().a(paramString, StickerClickerMetaInfoItem.class);
  }

  public static PublicAccountsAdsMetaInfo d(String paramString)
  {
    return (PublicAccountsAdsMetaInfo)new g().a().a(paramString, PublicAccountsAdsMetaInfo.class);
  }

  public static AdsCallMetaInfo e(String paramString)
  {
    return (AdsCallMetaInfo)new g().a().a(paramString, AdsCallMetaInfo.class);
  }

  public static AdsCallMetaInfo.AdsAfterCallMetaInfoItem f(String paramString)
  {
    return (AdsCallMetaInfo.AdsAfterCallMetaInfoItem)new g().a().a(paramString, AdsCallMetaInfo.AdsAfterCallMetaInfoItem.class);
  }

  public static Banner g(String paramString)
  {
    g localg = new g();
    localg.a(BannerItem.class, new a());
    localg.a(ImageBannerItem.Size.class, new c());
    localg.a(Banner.Size.class, new b());
    localg.a(TextBannerItem.Alignment.class, new d());
    return (Banner)localg.a().a(paramString, Banner.class);
  }

  public static Splash h(String paramString)
  {
    return (Splash)new g().a().a(paramString, Splash.class);
  }

  static class a
    implements k<BannerItem>
  {
    public BannerItem a(l paraml, Type paramType, j paramj)
      throws p
    {
      o localo = paraml.k();
      boolean bool = localo.b("type");
      BannerItem localBannerItem = null;
      if (bool)
      {
        BannerItem.Type localType1 = BannerItem.Type.fromName(localo.c("type").b());
        BannerItem.Type localType2 = BannerItem.Type.INVALID;
        localBannerItem = null;
        if (localType1 != localType2)
          localBannerItem = (BannerItem)paramj.a(paraml, localType1.getCls());
      }
      if (localBannerItem == null)
        localBannerItem = Banner.INVALID_BANNER_ITEM;
      return localBannerItem;
    }
  }

  static class b
    implements k<Banner.Size>
  {
    public Banner.Size a(l paraml, Type paramType, j paramj)
      throws p
    {
      return Banner.Size.fromName(paraml.b());
    }
  }

  static class c
    implements k<ImageBannerItem.Size>
  {
    public ImageBannerItem.Size a(l paraml, Type paramType, j paramj)
      throws p
    {
      return ImageBannerItem.Size.fromName(paraml.b());
    }
  }

  static class d
    implements k<TextBannerItem.Alignment>
  {
    public TextBannerItem.Alignment a(l paraml, Type paramType, j paramj)
      throws p
    {
      return TextBannerItem.Alignment.fromName(paraml.b());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.e.a
 * JD-Core Version:    0.6.2
 */