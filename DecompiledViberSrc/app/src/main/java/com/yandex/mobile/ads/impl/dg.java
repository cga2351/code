package com.yandex.mobile.ads.impl;

public final class dg
{
  public static String a(String paramString)
  {
    String str1 = "";
    String str2 = paramString.trim();
    if (!str2.isEmpty())
      str1 = "yma_".concat(String.valueOf(str2));
    return str1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dg
 * JD-Core Version:    0.6.2
 */