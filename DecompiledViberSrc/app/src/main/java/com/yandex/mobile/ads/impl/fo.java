package com.yandex.mobile.ads.impl;

import android.text.TextUtils;

public final class fo
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "";
    return Character.toUpperCase(paramString.charAt(0)) + paramString.substring(1).toLowerCase();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fo
 * JD-Core Version:    0.6.2
 */