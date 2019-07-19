package com.yandex.mobile.ads.nativeads;

public enum NativeAdType
{
  private final String a;

  static
  {
    APP_INSTALL = new NativeAdType("APP_INSTALL", 1, "app");
    IMAGE = new NativeAdType("IMAGE", 2, "image");
    NativeAdType[] arrayOfNativeAdType = new NativeAdType[3];
    arrayOfNativeAdType[0] = CONTENT;
    arrayOfNativeAdType[1] = APP_INSTALL;
    arrayOfNativeAdType[2] = IMAGE;
  }

  private NativeAdType(String paramString)
  {
    this.a = paramString;
  }

  public final String getValue()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdType
 * JD-Core Version:    0.6.2
 */