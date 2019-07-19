package a.a;

import com.appboy.e.e;
import com.appboy.f.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dr extends JSONObject
{
  private static final String a = c.a(dr.class);

  public static <TargetEnum extends Enum<TargetEnum>> TargetEnum a(JSONObject paramJSONObject, String paramString, Class<TargetEnum> paramClass)
  {
    return dj.a(paramJSONObject.getString(paramString).toUpperCase(Locale.US), paramClass);
  }

  public static <TargetEnum extends Enum<TargetEnum>> TargetEnum a(JSONObject paramJSONObject, String paramString, Class<TargetEnum> paramClass, TargetEnum paramTargetEnum)
  {
    try
    {
      Enum localEnum = a(paramJSONObject, paramString, paramClass);
      return localEnum;
    }
    catch (Exception localException)
    {
    }
    return paramTargetEnum;
  }

  public static String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return "";
    try
    {
      String str = paramJSONObject.toString(2);
      return str;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught JSONException while generating pretty printed json. Returning standard toString().", localJSONException);
    }
    return paramJSONObject.toString();
  }

  public static String a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool1 = paramJSONObject.has(paramString);
    String str = null;
    if (bool1)
    {
      boolean bool2 = paramJSONObject.isNull(paramString);
      str = null;
      if (!bool2)
        str = paramJSONObject.optString(paramString, null);
    }
    return str;
  }

  public static Map<String, String> a(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if (paramJSONObject == null)
    {
      if (paramMap == null)
      {
        c.b(a, "Cannot convert JSONObject to Map because JSONObject is null and no default was provided.");
        throw new JSONException("Cannot convert JSONObject to Map because JSONObject is null and no default was provided.");
      }
    }
    else
    {
      paramMap = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramMap.put(str, paramJSONObject.getString(str));
      }
    }
    return paramMap;
  }

  public static <T> JSONArray a(Collection<? extends e<T>> paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((e)localIterator.next()).h());
    return localJSONArray;
  }

  public static <T> JSONArray a(T[] paramArrayOfT)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
      localJSONArray.put(paramArrayOfT[j]);
    return localJSONArray;
  }

  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator1 = paramJSONObject1.keys();
      while (localIterator1.hasNext())
      {
        String str2 = (String)localIterator1.next();
        localJSONObject.put(str2, paramJSONObject1.get(str2));
      }
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception merging Json objects.", localJSONException);
      return null;
    }
    Iterator localIterator2 = paramJSONObject2.keys();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      localJSONObject.put(str1, paramJSONObject2.get(str1));
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dr
 * JD-Core Version:    0.6.2
 */