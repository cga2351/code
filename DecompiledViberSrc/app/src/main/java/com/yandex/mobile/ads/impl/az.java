package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Map;

public final class az
{
  static Map<String, String> a(v paramv)
  {
    HashMap localHashMap = new HashMap();
    if (paramv != null)
    {
      bf localbf = paramv.p();
      if (localbf != null)
        if (!localbf.c())
          break label43;
    }
    label43: for (String str = "server_side"; ; str = "client_side")
    {
      localHashMap.put("rewarding_side", str);
      return localHashMap;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.az
 * JD-Core Version:    0.6.2
 */