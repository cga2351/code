package com.vk.sdk.util;

import com.vk.sdk.api.model.VKApiModel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VKJsonHelper
{
  private static Object fromJson(Object paramObject)
    throws JSONException
  {
    if (paramObject == JSONObject.NULL)
      paramObject = null;
    do
    {
      return paramObject;
      if ((paramObject instanceof JSONObject))
        return toMap((JSONObject)paramObject);
    }
    while (!(paramObject instanceof JSONArray));
    return toList((JSONArray)paramObject);
  }

  public static Map<String, Object> getMap(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return toMap(paramJSONObject.getJSONObject(paramString));
  }

  public static boolean isEmptyObject(JSONObject paramJSONObject)
  {
    return paramJSONObject.names() == null;
  }

  public static Object toArray(JSONArray paramJSONArray, Class paramClass)
  {
    Object localObject1 = Array.newInstance(paramClass.getComponentType(), paramJSONArray.length());
    Class localClass = paramClass.getComponentType();
    int i = 0;
    while (true)
    {
      if (i < paramJSONArray.length());
      try
      {
        Object localObject2 = paramJSONArray.get(i);
        Object localObject3 = localClass.newInstance();
        if ((localObject2 instanceof JSONObject))
        {
          JSONObject localJSONObject = (JSONObject)localObject2;
          if ((localObject3 instanceof VKApiModel))
          {
            VKApiModel localVKApiModel = (VKApiModel)localObject3;
            ((VKApiModel)localObject3).parse(localJSONObject);
            Array.set(localObject1, i, localVKApiModel);
          }
        }
        label92: i++;
        continue;
        return localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label92;
      }
      catch (InstantiationException localInstantiationException)
      {
        break label92;
      }
      catch (JSONException localJSONException)
      {
        break label92;
      }
    }
  }

  public static Object toJSON(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Map))
    {
      localJSONObject = new JSONObject();
      localMap = (Map)paramObject;
      localIterator1 = localMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        localObject = localIterator1.next();
        localJSONObject.put(localObject.toString(), toJSON(localMap.get(localObject)));
      }
      paramObject = localJSONObject;
    }
    while (!(paramObject instanceof Iterable))
    {
      JSONObject localJSONObject;
      Map localMap;
      Iterator localIterator1;
      Object localObject;
      return paramObject;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator2 = ((Iterable)paramObject).iterator();
    while (localIterator2.hasNext())
      localJSONArray.put(localIterator2.next());
    return localJSONArray;
  }

  public static List toList(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(fromJson(paramJSONArray.get(i)));
    return localArrayList;
  }

  public static Map<String, Object> toMap(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, fromJson(paramJSONObject.get(str)));
    }
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.util.VKJsonHelper
 * JD-Core Version:    0.6.2
 */