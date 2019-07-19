package com.yandex.mobile.ads.impl;

import android.widget.ImageView.ScaleType;

public final class lw
{
  public static String a(lh paramlh)
  {
    return b(paramlh.c(), ImageView.ScaleType.CENTER_INSIDE);
  }

  static String a(String paramString, ImageView.ScaleType paramScaleType)
  {
    return b(paramString, paramScaleType);
  }

  private static String b(String paramString, ImageView.ScaleType paramScaleType)
  {
    return "#S" + paramScaleType.ordinal() + paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lw
 * JD-Core Version:    0.6.2
 */