package com.yandex.mobile.ads.nativeads;

import java.util.Arrays;
import java.util.List;

public final class NativeAdLoaderConfiguration
{
  public static final String NATIVE_IMAGE_SIZE_LARGE = "large";
  public static final String NATIVE_IMAGE_SIZE_MEDIUM = "medium";
  public static final String NATIVE_IMAGE_SIZE_SMALL = "small";
  private final String a;
  private final String[] b;
  private final boolean c;

  private NativeAdLoaderConfiguration(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
  }

  public final String getBlockId()
  {
    return this.a;
  }

  public final String[] getImageSizes()
  {
    return this.b;
  }

  public final boolean shouldLoadImagesAutomatically()
  {
    return this.c;
  }

  public static final class Builder
  {
    private final String a;
    private final boolean b;
    private String[] c;

    public Builder(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
      this.c = new String[] { "small", "medium", "large" };
    }

    public final NativeAdLoaderConfiguration build()
    {
      return new NativeAdLoaderConfiguration(this, (byte)0);
    }

    public final Builder setImageSizes(String[] paramArrayOfString)
    {
      if ((paramArrayOfString != null) && (paramArrayOfString.length != 0) && (!Arrays.asList(paramArrayOfString).contains(null)))
        this.c = paramArrayOfString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration
 * JD-Core Version:    0.6.2
 */