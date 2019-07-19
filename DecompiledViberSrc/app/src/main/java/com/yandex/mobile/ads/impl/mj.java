package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class mj
{
  private static final Map<String, mi> a = new HashMap()
  {
  };

  public static mi a(JSONObject paramJSONObject)
    throws JSONException, x
  {
    String str = mc.a(paramJSONObject, "type");
    return (mi)a.get(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mj
 * JD-Core Version:    0.6.2
 */