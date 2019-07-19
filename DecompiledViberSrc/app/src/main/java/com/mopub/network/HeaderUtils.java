package com.mopub.network;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ResponseHeader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HeaderUtils
{
  private static Integer a(String paramString)
  {
    try
    {
      Integer localInteger2 = Integer.valueOf(Integer.parseInt(paramString));
      return localInteger2;
    }
    catch (Exception localException1)
    {
      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
      localNumberFormat.setParseIntegerOnly(true);
      try
      {
        Integer localInteger1 = Integer.valueOf(localNumberFormat.parse(paramString.trim()).intValue());
        return localInteger1;
      }
      catch (Exception localException2)
      {
      }
    }
    return null;
  }

  static List<String> a(JSONObject paramJSONObject, ResponseHeader paramResponseHeader)
  {
    Preconditions.checkNotNull(paramJSONObject);
    Preconditions.checkNotNull(paramResponseHeader);
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramResponseHeader.getKey());
    if (localJSONArray == null)
      return localArrayList;
    int i = 0;
    while (true)
      if (i < localJSONArray.length())
        try
        {
          localArrayList.add(localJSONArray.getString(i));
          i++;
        }
        catch (JSONException localJSONException)
        {
          while (true)
          {
            MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = ("Unable to parse item " + i + " from " + paramResponseHeader.getKey());
            MoPubLog.log(localSdkLogEvent, arrayOfObject);
          }
        }
    return localArrayList;
  }

  private static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return paramBoolean;
    return paramString.equals("1");
  }

  private static Integer b(String paramString)
  {
    if (paramString == null);
    Integer localInteger;
    do
    {
      return null;
      localInteger = a(paramString.replace("%", ""));
    }
    while ((localInteger == null) || (localInteger.intValue() < 0) || (localInteger.intValue() > 100));
    return localInteger;
  }

  static String b(JSONObject paramJSONObject, ResponseHeader paramResponseHeader)
  {
    Integer localInteger = extractPercentHeader(paramJSONObject, paramResponseHeader);
    if (localInteger != null)
      return localInteger.toString();
    return null;
  }

  public static boolean extractBooleanHeader(JSONObject paramJSONObject, ResponseHeader paramResponseHeader, boolean paramBoolean)
  {
    return a(extractHeader(paramJSONObject, paramResponseHeader), paramBoolean);
  }

  public static String extractHeader(JSONObject paramJSONObject, ResponseHeader paramResponseHeader)
  {
    Preconditions.checkNotNull(paramResponseHeader);
    if (paramJSONObject == null)
      return "";
    return paramJSONObject.optString(paramResponseHeader.getKey());
  }

  public static Integer extractIntegerHeader(JSONObject paramJSONObject, ResponseHeader paramResponseHeader)
  {
    return a(extractHeader(paramJSONObject, paramResponseHeader));
  }

  public static JSONObject extractJsonObjectHeader(JSONObject paramJSONObject, ResponseHeader paramResponseHeader)
  {
    Preconditions.checkNotNull(paramResponseHeader);
    if (paramJSONObject == null)
      return null;
    return paramJSONObject.optJSONObject(paramResponseHeader.getKey());
  }

  public static Integer extractPercentHeader(JSONObject paramJSONObject, ResponseHeader paramResponseHeader)
  {
    return b(extractHeader(paramJSONObject, paramResponseHeader));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.HeaderUtils
 * JD-Core Version:    0.6.2
 */