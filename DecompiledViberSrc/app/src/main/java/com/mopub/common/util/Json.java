package com.mopub.common.util;

import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Json
{
  public static <T> T getJsonValue(JSONObject paramJSONObject, String paramString, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramString == null) || (paramClass == null))
      throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
    Object localObject = paramJSONObject.opt(paramString);
    if (localObject == null)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ("Tried to get Json value with key: " + paramString + ", but it was null");
      MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      return null;
    }
    if (!paramClass.isInstance(localObject))
    {
      MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = ("Tried to get Json value with key: " + paramString + ", of type: " + paramClass.toString() + ", its type did not match");
      MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
      return null;
    }
    return paramClass.cast(localObject);
  }

  public static String[] jsonArrayToStringArray(String paramString)
  {
    String str = "{key:" + paramString + "}";
    String[] arrayOfString;
    try
    {
      JSONArray localJSONArray = ((JSONObject)new JSONTokener(str).nextValue()).getJSONArray("key");
      arrayOfString = new String[localJSONArray.length()];
      for (int i = 0; i < arrayOfString.length; i++)
        arrayOfString[i] = localJSONArray.getString(i);
    }
    catch (JSONException localJSONException)
    {
      arrayOfString = new String[0];
    }
    return arrayOfString;
  }

  public static Map<String, String> jsonStringToMap(String paramString)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString))
      return localHashMap;
    JSONObject localJSONObject = (JSONObject)new JSONTokener(paramString).nextValue();
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, localJSONObject.getString(str));
    }
    return localHashMap;
  }

  public static String mapToJsonString(Map<String, String> paramMap)
  {
    if (paramMap == null)
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    Iterator localIterator = paramMap.entrySet().iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (i == 0)
        localStringBuilder.append(",");
      localStringBuilder.append("\"");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("\":\"");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("\"");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Json
 * JD-Core Version:    0.6.2
 */