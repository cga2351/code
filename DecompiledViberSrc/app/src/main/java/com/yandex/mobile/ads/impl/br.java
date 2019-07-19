package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class br
  implements bs<bb>
{
  private final bj a = new bj();

  public static bb a(oh paramoh)
  {
    String str = bj.a(paramoh);
    boolean bool = TextUtils.isEmpty(str);
    bb localbb = null;
    if (!bool)
      localbb = a(str);
    return localbb;
  }

  private static bb a(String paramString)
  {
    while (true)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Map localMap = a(localJSONObject);
        if (!localMap.isEmpty())
        {
          JSONArray localJSONArray = localJSONObject.getJSONArray("networks");
          ArrayList localArrayList = new ArrayList();
          i = 0;
          if (i < localJSONArray.length())
          {
            bc localbc = b(localJSONArray.getJSONObject(i));
            if (localbc == null)
              break label111;
            localArrayList.add(localbc);
            break label111;
          }
          if (!localArrayList.isEmpty())
          {
            bb localbb = new bb(localArrayList, localMap);
            return localbb;
          }
        }
      }
      catch (JSONException localJSONException)
      {
      }
      return null;
      label111: i++;
    }
  }

  private static Map<String, String> a(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      Map localMap = da.a(paramJSONObject, "passback_parameters");
      return localMap;
    }
    catch (JSONException localJSONException)
    {
      throw new JSONException(localJSONException.getMessage());
    }
  }

  private static bc b(JSONObject paramJSONObject)
  {
    try
    {
      String str = da.c(paramJSONObject, "adapter");
      Map localMap = da.a(paramJSONObject, "network_data");
      boolean bool = localMap.isEmpty();
      Object localObject = null;
      if (!bool)
      {
        List localList1 = da.b(paramJSONObject, "click_tracking_urls");
        List localList2 = da.b(paramJSONObject, "impression_tracking_urls");
        List localList3 = da.b(paramJSONObject, "ad_response_tracking_urls");
        bc localbc = new bc.a(str, localMap).a(localList2).b(localList1).c(localList3).a();
        localObject = localbc;
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.br
 * JD-Core Version:    0.6.2
 */