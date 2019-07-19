package com.yandex.mobile.ads.mediation.nativeads;

class MediatedNativeAdAssets
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final MediatedNativeAdImage e;
  private final MediatedNativeAdImage f;
  private final MediatedNativeAdImage g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;

  private MediatedNativeAdAssets(Builder paramBuilder)
  {
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
    this.c = paramBuilder.c;
    this.d = paramBuilder.d;
    this.e = paramBuilder.e;
    this.f = paramBuilder.f;
    this.g = paramBuilder.g;
    this.h = paramBuilder.h;
    this.i = paramBuilder.i;
    this.j = paramBuilder.j;
    this.k = paramBuilder.k;
    this.l = paramBuilder.l;
    this.m = paramBuilder.m;
  }

  String getAge()
  {
    return this.a;
  }

  String getBody()
  {
    return this.b;
  }

  String getCallToAction()
  {
    return this.c;
  }

  String getDomain()
  {
    return this.d;
  }

  MediatedNativeAdImage getFavicon()
  {
    return this.e;
  }

  MediatedNativeAdImage getIcon()
  {
    return this.f;
  }

  MediatedNativeAdImage getImage()
  {
    return this.g;
  }

  String getPrice()
  {
    return this.h;
  }

  String getRating()
  {
    return this.i;
  }

  String getReviewCount()
  {
    return this.j;
  }

  String getSponsored()
  {
    return this.k;
  }

  String getTitle()
  {
    return this.l;
  }

  String getWarning()
  {
    return this.m;
  }

  static final class Builder
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private MediatedNativeAdImage e;
    private MediatedNativeAdImage f;
    private MediatedNativeAdImage g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    final MediatedNativeAdAssets build()
    {
      return new MediatedNativeAdAssets(this, null);
    }

    final Builder setAge(String paramString)
    {
      this.a = paramString;
      return this;
    }

    final Builder setBody(String paramString)
    {
      this.b = paramString;
      return this;
    }

    final Builder setCallToAction(String paramString)
    {
      this.c = paramString;
      return this;
    }

    final Builder setDomain(String paramString)
    {
      this.d = paramString;
      return this;
    }

    final Builder setFavicon(MediatedNativeAdImage paramMediatedNativeAdImage)
    {
      this.e = paramMediatedNativeAdImage;
      return this;
    }

    final Builder setIcon(MediatedNativeAdImage paramMediatedNativeAdImage)
    {
      this.f = paramMediatedNativeAdImage;
      return this;
    }

    final Builder setImage(MediatedNativeAdImage paramMediatedNativeAdImage)
    {
      this.g = paramMediatedNativeAdImage;
      return this;
    }

    final Builder setPrice(String paramString)
    {
      this.h = paramString;
      return this;
    }

    final Builder setRating(String paramString)
    {
      this.i = paramString;
      return this;
    }

    final Builder setReviewCount(String paramString)
    {
      this.j = paramString;
      return this;
    }

    final Builder setSponsored(String paramString)
    {
      this.k = paramString;
      return this;
    }

    final Builder setTitle(String paramString)
    {
      this.l = paramString;
      return this;
    }

    final Builder setWarning(String paramString)
    {
      this.m = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdAssets
 * JD-Core Version:    0.6.2
 */