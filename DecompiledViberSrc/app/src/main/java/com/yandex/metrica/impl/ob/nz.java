package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.bw;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nz
{
  public static Long a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    if (paramJSONObject != null)
    {
      boolean bool = paramJSONObject.has(paramString);
      localObject = null;
      if (!bool);
    }
    try
    {
      Long localLong = Long.valueOf(paramJSONObject.getLong(paramString));
      localObject = localLong;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Object a(Object paramObject)
  {
    if (paramObject == null)
      paramObject = null;
    while (true)
    {
      return paramObject;
      try
      {
        if (paramObject.getClass().isArray())
        {
          int i = Array.getLength(paramObject);
          ArrayList localArrayList2 = new ArrayList(i);
          for (int j = 0; j < i; j++)
            localArrayList2.add(a(Array.get(paramObject, j)));
          return new JSONArray(localArrayList2);
        }
        if ((paramObject instanceof Collection))
        {
          Collection localCollection = (Collection)paramObject;
          ArrayList localArrayList1 = new ArrayList(localCollection.size());
          Iterator localIterator2 = localCollection.iterator();
          while (localIterator2.hasNext())
            localArrayList1.add(a(localIterator2.next()));
          return new JSONArray(localArrayList1);
        }
        if ((paramObject instanceof Map))
        {
          Map localMap = (Map)paramObject;
          LinkedHashMap localLinkedHashMap = new LinkedHashMap();
          Iterator localIterator1 = localMap.entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            String str = localEntry.getKey().toString();
            if (str != null)
              localLinkedHashMap.put(str, a(localEntry.getValue()));
          }
          JSONObject localJSONObject = new JSONObject(localLinkedHashMap);
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
      }
    }
    return null;
  }

  public static String a(List<String> paramList)
  {
    if (bw.a(paramList))
      return null;
    if (bw.a(19))
      return new JSONArray(paramList).toString();
    return a(paramList).toString();
  }

  public static String a(Map paramMap)
  {
    if (bw.a(paramMap))
      return null;
    if (bw.a(19))
      return new JSONObject(paramMap).toString();
    return a(paramMap).toString();
  }

  public static HashMap<String, String> a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      try
      {
        HashMap localHashMap = a(new JSONObject(paramString));
        return localHashMap;
      }
      catch (JSONException localJSONException)
      {
      }
    return null;
  }

  public static HashMap<String, String> a(JSONObject paramJSONObject)
  {
    boolean bool = JSONObject.NULL.equals(paramJSONObject);
    Object localObject = null;
    if (!bool)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.optString(str1);
        if (str2 != null)
          localHashMap.put(str1, str2);
      }
      localObject = localHashMap;
    }
    return localObject;
  }

  public static JSONArray a(ng[] paramArrayOfng)
  {
    JSONArray localJSONArray = new JSONArray();
    int i;
    int j;
    if (paramArrayOfng != null)
    {
      i = paramArrayOfng.length;
      j = 0;
    }
    while (true)
    {
      ng localng;
      if (j < i)
        localng = paramArrayOfng[j];
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("cell_id", localng.e());
        localJSONObject.putOpt("signal_strength", localng.a());
        localJSONObject.putOpt("lac", localng.d());
        localJSONObject.putOpt("country_code", localng.b());
        localJSONObject.putOpt("operator_id", localng.c());
        localJSONObject.putOpt("operator_name", localng.f());
        localJSONObject.putOpt("is_connected", Boolean.valueOf(localng.h()));
        localJSONObject.putOpt("cell_type", Integer.valueOf(localng.i()));
        localJSONObject.putOpt("pci", localng.j());
        localJSONArray.put(localJSONObject);
        label166: j++;
        continue;
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        break label166;
      }
    }
  }

  public static Integer b(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    if (paramJSONObject != null)
    {
      boolean bool = paramJSONObject.has(paramString);
      localObject = null;
      if (!bool);
    }
    try
    {
      Integer localInteger = Integer.valueOf(paramJSONObject.getInt(paramString));
      localObject = localInteger;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  // ERROR //
  public static List<String> b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +62 -> 66
    //   7: new 59	org/json/JSONArray
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 238	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   15: astore_1
    //   16: new 43	java/util/ArrayList
    //   19: dup
    //   20: aload_1
    //   21: invokevirtual 241	org/json/JSONArray:length	()I
    //   24: invokespecial 47	java/util/ArrayList:<init>	(I)V
    //   27: astore_2
    //   28: iconst_0
    //   29: istore_3
    //   30: iload_3
    //   31: aload_1
    //   32: invokevirtual 241	org/json/JSONArray:length	()I
    //   35: if_icmpge +25 -> 60
    //   38: aload_2
    //   39: aload_1
    //   40: iload_3
    //   41: invokevirtual 245	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   44: invokeinterface 248 2 0
    //   49: pop
    //   50: iinc 3 1
    //   53: goto -23 -> 30
    //   56: astore 6
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_2
    //   61: areturn
    //   62: astore 4
    //   64: aload_2
    //   65: areturn
    //   66: aconst_null
    //   67: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	28	56	org/json/JSONException
    //   30	50	62	org/json/JSONException
  }

  public static Boolean c(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    if (paramJSONObject != null)
    {
      boolean bool = paramJSONObject.has(paramString);
      localObject = null;
      if (!bool);
    }
    try
    {
      Boolean localBoolean = Boolean.valueOf(paramJSONObject.getBoolean(paramString));
      localObject = localBoolean;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Float d(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    if (paramJSONObject != null)
    {
      boolean bool = paramJSONObject.has(paramString);
      localObject = null;
      if (!bool);
    }
    try
    {
      Float localFloat = Float.valueOf((float)paramJSONObject.getDouble(paramString));
      localObject = localFloat;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static class a extends JSONObject
  {
    public a()
    {
    }

    public a(String paramString)
      throws JSONException
    {
      super();
    }

    public Object a(String paramString, Object paramObject)
    {
      try
      {
        Object localObject = super.get(paramString);
        return localObject;
      }
      catch (Exception localException)
      {
      }
      return paramObject;
    }

    public String a(String paramString)
    {
      try
      {
        String str = super.getString(paramString);
        return str;
      }
      catch (JSONException localJSONException)
      {
        return "";
      }
      catch (Exception localException)
      {
      }
      return "";
    }

    public boolean b(String paramString)
    {
      try
      {
        Object localObject1 = NULL;
        Object localObject2 = super.get(paramString);
        boolean bool = false;
        if (localObject1 != localObject2)
          bool = true;
        return bool;
      }
      catch (Exception localException)
      {
      }
      return false;
    }

    public Long c(String paramString)
    {
      try
      {
        Long localLong = Long.valueOf(getLong(paramString));
        return localLong;
      }
      catch (JSONException localJSONException)
      {
      }
      return null;
    }

    public Boolean d(String paramString)
    {
      try
      {
        Boolean localBoolean = Boolean.valueOf(getBoolean(paramString));
        return localBoolean;
      }
      catch (JSONException localJSONException)
      {
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nz
 * JD-Core Version:    0.6.2
 */