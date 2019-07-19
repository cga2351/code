package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.MobileAds;
import org.json.JSONException;
import org.json.JSONObject;

public final class bu
  implements bs<et>
{
  private final bs<String> a = new bv();
  private final ch b = new ch();

  private static et a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      boolean bool1 = localJSONObject.optBoolean("custom_click_handling_enabled");
      Boolean localBoolean1;
      String str;
      boolean bool2;
      Boolean localBoolean2;
      label73: boolean bool3;
      long l1;
      long l2;
      if (localJSONObject.has("visibility_error_indicator_enabled"))
      {
        localBoolean1 = Boolean.valueOf(localJSONObject.optBoolean("visibility_error_indicator_enabled"));
        str = localJSONObject.optString("mraid_controller", null);
        bool2 = localJSONObject.optBoolean("sensitive_mode_disabled");
        if (!localJSONObject.has("mediation_sensitive_mode_disabled"))
          break label186;
        localBoolean2 = Boolean.valueOf(localJSONObject.optBoolean("mediation_sensitive_mode_disabled"));
        bool3 = localJSONObject.optBoolean("custom_user_agent_enabled");
        l1 = localJSONObject.optLong("reload_timeout");
        l2 = System.currentTimeMillis();
        if (l1 <= 0L)
          break label192;
      }
      label186: label192: for (long l3 = l1 * 1000L; ; l3 = 86400000L)
      {
        long l4 = l3 + l2;
        et localet = new et.a().a(l4).a(str).a(bool1).a(localBoolean1).b(MobileAds.getLibraryVersion()).b(localBoolean2).b(bool2).c(bool3).c(es.a().e()).a();
        return localet;
        localBoolean1 = null;
        break;
        localBoolean2 = null;
        break label73;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bu
 * JD-Core Version:    0.6.2
 */