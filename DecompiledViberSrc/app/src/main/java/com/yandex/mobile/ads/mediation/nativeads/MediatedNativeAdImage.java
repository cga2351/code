package com.yandex.mobile.ads.mediation.nativeads;

final class MediatedNativeAdImage
{
  private final int a;
  private final int b;
  private final String c;

  private MediatedNativeAdImage(Builder paramBuilder)
  {
    this.c = paramBuilder.c;
    this.a = paramBuilder.a;
    this.b = paramBuilder.b;
  }

  final int getHeight()
  {
    return this.b;
  }

  final String getUrl()
  {
    return this.c;
  }

  final int getWidth()
  {
    return this.a;
  }

  static final class Builder
  {
    private int a;
    private int b;
    private final String c;

    Builder(String paramString)
    {
      this.c = paramString;
    }

    public final MediatedNativeAdImage build()
    {
      return new MediatedNativeAdImage(this, null);
    }

    final Builder setHeight(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    final Builder setWidth(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdImage
 * JD-Core Version:    0.6.2
 */