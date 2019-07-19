package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class mp
{
  private final mo a = new mo();

  static lt a(JSONObject paramJSONObject)
    throws JSONException, x
  {
    String str1 = mc.a(paramJSONObject, "package");
    String str2 = mc.b(paramJSONObject, "url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("extras");
    HashMap localHashMap2;
    if (localJSONObject != null)
    {
      Iterator localIterator = localJSONObject.keys();
      if (localIterator.hasNext())
      {
        localHashMap2 = new HashMap();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          if (!localJSONObject.isNull(str3))
            localHashMap2.put(str3, localJSONObject.get(str3));
        }
      }
    }
    for (HashMap localHashMap1 = localHashMap2; ; localHashMap1 = null)
      return new lt(str1, str2, localHashMap1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mp
 * JD-Core Version:    0.6.2
 */