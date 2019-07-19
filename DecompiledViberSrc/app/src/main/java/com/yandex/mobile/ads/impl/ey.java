package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.util.Map;

final class ey
{
  static boolean a(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("yandex_mobile_metrica_uuid");
    String str2 = (String)paramMap.get("yandex_mobile_metrica_get_ad_url");
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      i = 1;
      if (i == 0)
        break label65;
      if (TextUtils.isEmpty(str2))
        break label59;
    }
    label59: for (int j = 1; ; j = 0)
    {
      if (j == 0)
        break label65;
      return true;
      i = 0;
      break;
    }
    label65: return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ey
 * JD-Core Version:    0.6.2
 */