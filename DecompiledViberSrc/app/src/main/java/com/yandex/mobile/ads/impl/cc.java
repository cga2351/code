package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.b;
import java.util.HashMap;
import java.util.Map;

public abstract class cc<T>
  implements fe<eo, v<T>>
{
  protected Map<String, Object> a(eo parameo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("block_id", parameo.e());
    localHashMap.put("ad_type", parameo.a().a());
    if (parameo.p() == cv.a.b);
    for (boolean bool = true; ; bool = false)
    {
      localHashMap.put("is_passback", Boolean.valueOf(bool));
      return localHashMap;
    }
  }

  protected Map<String, Object> a(ok<v<T>> paramok, int paramInt, eo parameo)
  {
    HashMap localHashMap = new HashMap();
    String str1;
    if ((paramok != null) && (paramok.a != null))
      if (((v)paramok.a).q() != null)
        str1 = "mediation";
    while (true)
    {
      localHashMap.put("response_type", str1);
      localHashMap.put("block_id", parameo.e());
      localHashMap.put("ad_type", parameo.a().a());
      if (paramInt == -1);
      for (String str2 = "error_code"; ; str2 = "code")
      {
        localHashMap.put(str2, Integer.valueOf(paramInt));
        return localHashMap;
        if (((v)paramok.a).r() == null)
          break label133;
        str1 = "ad";
        break;
      }
      label133: str1 = "empty";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cc
 * JD-Core Version:    0.6.2
 */