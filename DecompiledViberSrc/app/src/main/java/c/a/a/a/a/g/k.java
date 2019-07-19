package c.a.a.a.a.g;

import org.json.JSONException;
import org.json.JSONObject;

class k
  implements v
{
  private long a(c.a.a.a.a.b.k paramk, long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("expires_at"))
      return paramJSONObject.getLong("expires_at");
    return paramk.a() + 1000L * paramLong;
  }

  private e a(JSONObject paramJSONObject)
    throws JSONException
  {
    String str1 = paramJSONObject.getString("identifier");
    String str2 = paramJSONObject.getString("status");
    String str3 = paramJSONObject.getString("url");
    String str4 = paramJSONObject.getString("reports_url");
    String str5 = paramJSONObject.getString("ndk_reports_url");
    boolean bool1 = paramJSONObject.optBoolean("update_required", false);
    boolean bool2 = paramJSONObject.has("icon");
    c localc = null;
    if (bool2)
    {
      boolean bool3 = paramJSONObject.getJSONObject("icon").has("hash");
      localc = null;
      if (bool3)
        localc = b(paramJSONObject.getJSONObject("icon"));
    }
    return new e(str1, str2, str3, str4, str5, bool1, localc);
  }

  private c b(JSONObject paramJSONObject)
    throws JSONException
  {
    return new c(paramJSONObject.getString("hash"), paramJSONObject.getInt("width"), paramJSONObject.getInt("height"));
  }

  private m c(JSONObject paramJSONObject)
  {
    return new m(paramJSONObject.optBoolean("prompt_enabled", false), paramJSONObject.optBoolean("collect_logged_exceptions", true), paramJSONObject.optBoolean("collect_reports", true), paramJSONObject.optBoolean("collect_analytics", false), paramJSONObject.optBoolean("firebase_crashlytics_enabled", false));
  }

  private b d(JSONObject paramJSONObject)
  {
    return new b(paramJSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), paramJSONObject.optInt("flush_interval_secs", 600), paramJSONObject.optInt("max_byte_size_per_file", 8000), paramJSONObject.optInt("max_file_count_per_send", 1), paramJSONObject.optInt("max_pending_send_file_count", 100), paramJSONObject.optBoolean("forward_to_google_analytics", false), paramJSONObject.optBoolean("include_purchase_events_in_forwarded_events", false), paramJSONObject.optBoolean("track_custom_events", true), paramJSONObject.optBoolean("track_predefined_events", true), paramJSONObject.optInt("sampling_rate", 1), paramJSONObject.optBoolean("flush_on_background", true));
  }

  private p e(JSONObject paramJSONObject)
    throws JSONException
  {
    return new p(paramJSONObject.optInt("log_buffer_size", 64000), paramJSONObject.optInt("max_chained_exception_depth", 8), paramJSONObject.optInt("max_custom_exception_events", 64), paramJSONObject.optInt("max_custom_key_value_pairs", 64), paramJSONObject.optInt("identifier_mask", 255), paramJSONObject.optBoolean("send_session_without_crash", false), paramJSONObject.optInt("max_complete_sessions_count", 4));
  }

  private o f(JSONObject paramJSONObject)
    throws JSONException
  {
    return new o(paramJSONObject.optString("title", "Send Crash Report?"), paramJSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), paramJSONObject.optString("send_button_title", "Send"), paramJSONObject.optBoolean("show_cancel_button", true), paramJSONObject.optString("cancel_button_title", "Don't Send"), paramJSONObject.optBoolean("show_always_send_button", true), paramJSONObject.optString("always_send_button_title", "Always Send"));
  }

  private f g(JSONObject paramJSONObject)
    throws JSONException
  {
    return new f(paramJSONObject.optString("update_endpoint", u.a), paramJSONObject.optInt("update_suspend_duration", 3600));
  }

  public t a(c.a.a.a.a.b.k paramk, JSONObject paramJSONObject)
    throws JSONException
  {
    int i = paramJSONObject.optInt("settings_version", 0);
    int j = paramJSONObject.optInt("cache_duration", 3600);
    e locale = a(paramJSONObject.getJSONObject("app"));
    p localp = e(paramJSONObject.getJSONObject("session"));
    o localo = f(paramJSONObject.getJSONObject("prompt"));
    m localm = c(paramJSONObject.getJSONObject("features"));
    b localb = d(paramJSONObject.getJSONObject("analytics"));
    f localf = g(paramJSONObject.getJSONObject("beta"));
    return new t(a(paramk, j, paramJSONObject), locale, localp, localo, localm, localb, localf, i, j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.k
 * JD-Core Version:    0.6.2
 */