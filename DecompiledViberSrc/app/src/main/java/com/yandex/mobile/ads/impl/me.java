package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class me
{
  private final mg a = new mg();

  public static lu a(JSONObject paramJSONObject, String paramString)
    throws JSONException, x
  {
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject(paramString);
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = localJSONObject1.optJSONArray("installedPackages");
    if (localJSONArray != null)
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
        if (!md.a(localJSONObject2, new String[] { "name" }))
          throw new x("Native Ad json has not required attributes");
        localArrayList.add(new lv(mc.a(localJSONObject2, "name"), cw.a(localJSONObject2, "minVersion", 0), cw.a(localJSONObject2, "maxVersion", 2147483647)));
      }
    return new lu(localArrayList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.me
 * JD-Core Version:    0.6.2
 */