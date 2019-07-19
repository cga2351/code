package com.facebook.model;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class JsonUtil
{
  static void jsonObjectClear(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      localIterator.next();
      localIterator.remove();
    }
  }

  static boolean jsonObjectContainsValue(JSONObject paramJSONObject, Object paramObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject = paramJSONObject.opt((String)localIterator.next());
      if ((localObject != null) && (localObject.equals(paramObject)))
        return true;
    }
    return false;
  }

  static Set<Map.Entry<String, Object>> jsonObjectEntrySet(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashSet.add(new JSONObjectEntry(str, paramJSONObject.opt(str)));
    }
    return localHashSet;
  }

  static Set<String> jsonObjectKeySet(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
      localHashSet.add(localIterator.next());
    return localHashSet;
  }

  static void jsonObjectPutAll(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        paramJSONObject.putOpt((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalArgumentException(localJSONException);
      }
    }
  }

  static Collection<Object> jsonObjectValues(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
      localArrayList.add(paramJSONObject.opt((String)localIterator.next()));
    return localArrayList;
  }

  private static final class JSONObjectEntry
    implements Map.Entry<String, Object>
  {
    private final String key;
    private final Object value;

    JSONObjectEntry(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.value = paramObject;
    }

    @SuppressLint({"FieldGetter"})
    public String getKey()
    {
      return this.key;
    }

    public Object getValue()
    {
      return this.value;
    }

    public Object setValue(Object paramObject)
    {
      throw new UnsupportedOperationException("JSONObjectEntry is immutable");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.model.JsonUtil
 * JD-Core Version:    0.6.2
 */