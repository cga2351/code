package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class mh
{
  public static li a(JSONObject paramJSONObject)
    throws JSONException, x
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("actions");
    ArrayList localArrayList1;
    if (localJSONArray != null)
    {
      localArrayList1 = new ArrayList();
      new mj();
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        mi localmi = mj.a(localJSONObject);
        if (localmi != null)
          localArrayList1.add(localmi.a(localJSONObject));
      }
    }
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = null)
    {
      String str = mc.c(paramJSONObject, "falseClickUrl");
      Long localLong = Long.valueOf(paramJSONObject.optLong("falseClickInterval", 0L));
      cn localcn = null;
      if (str != null)
      {
        localcn = null;
        if (localLong != null)
          localcn = new cn(str, localLong.longValue());
      }
      return new li(localArrayList2, localcn, mc.c(paramJSONObject, "trackingUrl"), mc.c(paramJSONObject, "url"));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mh
 * JD-Core Version:    0.6.2
 */