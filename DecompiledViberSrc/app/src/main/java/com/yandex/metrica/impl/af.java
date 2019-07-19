package com.yandex.metrica.impl;

import android.location.Location;
import android.text.TextUtils;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.PreloadInfo.Builder;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.YandexMetricaConfig.Builder;
import com.yandex.metrica.impl.ob.nz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class af
{
  private static String a(Location paramLocation)
  {
    if (paramLocation == null)
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("provider", paramLocation.getProvider());
      localJSONObject.put("time", paramLocation.getTime());
      localJSONObject.put("accuracy", paramLocation.getAccuracy());
      localJSONObject.put("alt", paramLocation.getAltitude());
      localJSONObject.put("lng", paramLocation.getLongitude());
      localJSONObject.put("lat", paramLocation.getLatitude());
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private static String a(PreloadInfo paramPreloadInfo)
  {
    if (paramPreloadInfo == null)
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("trackid", paramPreloadInfo.getTrackingId());
      localJSONObject.put("params", nz.a(paramPreloadInfo.getAdditionalParams()));
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private static PreloadInfo b(String paramString)
    throws JSONException
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    PreloadInfo localPreloadInfo = null;
    if (!bool1)
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      boolean bool2 = localJSONObject.has("trackid");
      String str = null;
      if (bool2)
        str = localJSONObject.optString("trackid");
      PreloadInfo.Builder localBuilder = PreloadInfo.newBuilder(str);
      HashMap localHashMap = nz.a(localJSONObject.optString("params"));
      if ((localHashMap != null) && (localHashMap.size() > 0))
      {
        Iterator localIterator = localHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localBuilder.setAdditionalParams((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      localPreloadInfo = localBuilder.build();
    }
    return localPreloadInfo;
  }

  private static Location c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    while (true)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("provider"))
        {
          str = localJSONObject.optString("provider");
          Location localLocation = new Location(str);
          localLocation.setLongitude(localJSONObject.getDouble("lng"));
          localLocation.setLatitude(localJSONObject.getDouble("lat"));
          localLocation.setTime(localJSONObject.optLong("time"));
          localLocation.setAccuracy((float)localJSONObject.optDouble("accuracy"));
          localLocation.setAltitude((float)localJSONObject.optDouble("alt"));
          return localLocation;
        }
      }
      catch (JSONException localJSONException)
      {
        return null;
      }
      String str = null;
    }
  }

  public YandexMetricaConfig a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (!bool);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      YandexMetricaConfig.Builder localBuilder = YandexMetricaConfig.newConfigBuilder(localJSONObject.getString("apikey"));
      if (localJSONObject.has("app_version"))
        localBuilder.withAppVersion(localJSONObject.optString("app_version"));
      if (localJSONObject.has("session_timeout"))
        localBuilder.withSessionTimeout(localJSONObject.getInt("session_timeout"));
      localBuilder.withLocation(c(localJSONObject.optString("location")));
      localBuilder.withPreloadInfo(b(localJSONObject.optString("preload_info")));
      if (localJSONObject.has("collect_apps"))
        localBuilder.withInstalledAppCollecting(localJSONObject.optBoolean("collect_apps"));
      if ((localJSONObject.has("logs")) && (localJSONObject.optBoolean("logs")))
        localBuilder.withLogs();
      if (localJSONObject.has("crash_enabled"))
        localBuilder.withCrashReporting(localJSONObject.optBoolean("crash_enabled"));
      if (localJSONObject.has("crash_native_enabled"))
        localBuilder.withNativeCrashReporting(localJSONObject.optBoolean("crash_native_enabled"));
      if (localJSONObject.has("location_enabled"))
        localBuilder.withLocationTracking(localJSONObject.optBoolean("location_enabled"));
      YandexMetricaConfig localYandexMetricaConfig = localBuilder.build();
      localObject = localYandexMetricaConfig;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public String a(YandexMetricaConfig paramYandexMetricaConfig)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("apikey", paramYandexMetricaConfig.apiKey);
      localJSONObject.put("app_version", paramYandexMetricaConfig.appVersion);
      localJSONObject.put("session_timeout", paramYandexMetricaConfig.sessionTimeout);
      localJSONObject.put("location", a(paramYandexMetricaConfig.location));
      localJSONObject.put("preload_info", a(paramYandexMetricaConfig.preloadInfo));
      localJSONObject.put("collect_apps", paramYandexMetricaConfig.installedAppCollecting);
      localJSONObject.put("logs", paramYandexMetricaConfig.logs);
      localJSONObject.put("crash_enabled", paramYandexMetricaConfig.crashReporting);
      localJSONObject.put("crash_native_enabled", paramYandexMetricaConfig.nativeCrashReporting);
      localJSONObject.put("location_enabled", paramYandexMetricaConfig.locationTracking);
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.af
 * JD-Core Version:    0.6.2
 */