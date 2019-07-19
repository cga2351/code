package com.appnexus.opensdk.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil
{
  public static JSONArray getJSONArray(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return null;
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
      int i = localJSONArray.length();
      if (i > 0);
      while (true)
      {
        return localJSONArray;
        localJSONArray = null;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static boolean getJSONBoolean(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return false;
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  public static double getJSONDouble(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return -1.0D;
    try
    {
      double d = paramJSONObject.getDouble(paramString);
      return d;
    }
    catch (JSONException localJSONException)
    {
    }
    return -1.0D;
  }

  public static int getJSONInt(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return -1;
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException localJSONException)
    {
    }
    return -1;
  }

  public static JSONObject getJSONObject(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return null;
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static JSONObject getJSONObjectFromArray(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null)
      return null;
    try
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static String getJSONString(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      return "";
    try
    {
      String str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }

  public static ArrayList<String> getStringArrayList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
      return null;
    try
    {
      if (paramJSONArray.length() > 0)
      {
        int i = paramJSONArray.length();
        ArrayList localArrayList = new ArrayList(i);
        for (int j = 0; j < i; j++)
          localArrayList.add((String)paramJSONArray.get(j));
        return localArrayList;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      return null;
    }
    catch (JSONException localJSONException)
    {
      label62: break label62;
    }
  }

  public static String getStringFromArray(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null)
      return "";
    try
    {
      String str = paramJSONArray.getString(paramInt);
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }

  public static HashMap<String, Object> getStringObjectHashMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    HashMap localHashMap;
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.getString(str));
      }
    }
    catch (JSONException localJSONException)
    {
      return null;
    }
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.JsonUtil
 * JD-Core Version:    0.6.2
 */