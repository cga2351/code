package com.yandex.mobile.ads.impl;

import android.text.Html;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class da
{
  public static Map<String, String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, localJSONObject.getString(str));
    }
    return localHashMap;
  }

  private static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"null".equals(paramString));
  }

  public static List<String> b(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < localJSONArray.length(); i++)
        if (a(localJSONArray.optString(i)))
          localArrayList.add(localJSONArray.optString(i));
      return localArrayList;
    }
    return null;
  }

  public static String c(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    String str = paramJSONObject.getString(paramString);
    if (a(str))
      return String.valueOf(Html.fromHtml(str));
    throw new JSONException("Json value can not be null or empty");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.da
 * JD-Core Version:    0.6.2
 */