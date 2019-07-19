package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubRequestUtils
{
  public static int chooseMethod(String paramString)
  {
    if (isMoPubRequest(paramString))
      return 1;
    return 0;
  }

  public static Map<String, String> convertQueryToMap(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    return getQueryParamMap(Uri.parse(Networking.getUrlRewriter(paramContext).rewriteUrl(paramString)));
  }

  public static String generateBodyFromParams(Map<String, String> paramMap, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    if ((!isMoPubRequest(paramString)) || (paramMap == null) || (paramMap.isEmpty()))
      return null;
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, paramMap.get(str));
      }
      catch (JSONException localJSONException)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("Unable to add " + str + " to JSON body.");
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
    }
    return localJSONObject.toString();
  }

  public static Map<String, String> getQueryParamMap(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramUri.getQueryParameterNames().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, TextUtils.join(",", paramUri.getQueryParameters(str)));
    }
    return localHashMap;
  }

  public static boolean isMoPubRequest(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    String str1 = "http://" + Constants.HOST;
    String str2 = "https://" + Constants.HOST;
    return (paramString.startsWith(str1)) || (paramString.startsWith(str2));
  }

  public static String truncateQueryParamsIfPost(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    if (!isMoPubRequest(paramString));
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf('?');
    }
    while (i == -1);
    return paramString.substring(0, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MoPubRequestUtils
 * JD-Core Version:    0.6.2
 */