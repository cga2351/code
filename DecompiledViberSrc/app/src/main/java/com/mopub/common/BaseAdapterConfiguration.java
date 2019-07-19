package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Json;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseAdapterConfiguration
  implements AdapterConfiguration
{
  private Map<String, String> a;

  public Map<String, String> getCachedInitializationParameters(Context paramContext)
  {
    Map localMap1 = SharedPreferencesHelper.getSharedPreferences(paramContext, "mopubCustomEventSettings").getAll();
    MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject1 = new Object[1];
    Locale localLocale = Locale.US;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(localMap1.size());
    arrayOfObject2[1] = localMap1.keySet();
    arrayOfObject1[0] = String.format(localLocale, "fetched init settings for %s networks: %s", arrayOfObject2);
    MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
    String str1 = getClass().getName();
    String str2 = (String)localMap1.get(str1);
    HashMap localHashMap = new HashMap();
    try
    {
      Map localMap2 = Json.jsonStringToMap(str2);
      return localMap2;
    }
    catch (JSONException localJSONException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = ("Error fetching init settings for adapter configuration " + str1);
      MoPubLog.log(localSdkLogEvent2, arrayOfObject3);
    }
    return localHashMap;
  }

  public Map<String, String> getMoPubRequestOptions()
  {
    return this.a;
  }

  public void setCachedInitializationParameters(Context paramContext, Map<String, String> paramMap)
  {
    Preconditions.checkNotNull(paramContext);
    if ((paramMap == null) || (paramMap.isEmpty()))
      return;
    SharedPreferences localSharedPreferences = SharedPreferencesHelper.getSharedPreferences(paramContext, "mopubCustomEventSettings");
    String str1 = new JSONObject(paramMap).toString();
    String str2 = getClass().getName();
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = String.format(Locale.US, "Updating init settings for custom event %s with params %s", new Object[] { str2, str1 });
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
    localSharedPreferences.edit().putString(str2, str1).apply();
  }

  public void setMoPubRequestOptions(Map<String, String> paramMap)
  {
    this.a = paramMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.BaseAdapterConfiguration
 * JD-Core Version:    0.6.2
 */