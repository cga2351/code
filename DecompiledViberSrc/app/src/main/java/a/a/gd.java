package a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gd
{
  private static Integer a = new Integer(1);

  public static String a(String paramString1, String paramString2)
  {
    if ("".equals(paramString1))
      return paramString2;
    return paramString1 + "." + paramString2;
  }

  public static String a(String paramString1, String paramString2, Object paramObject)
  {
    return paramString1 + "[" + paramString2 + "=" + paramObject + "]";
  }

  public static String a(JSONArray paramJSONArray)
  {
    Iterator localIterator = a((JSONObject)paramJSONArray.get(0)).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (a(str, paramJSONArray))
        return str;
    }
    return null;
  }

  public static <T> Map<T, Integer> a(Collection<T> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Integer localInteger = (Integer)localHashMap.get(localObject);
      if (localInteger == null)
        localHashMap.put(localObject, a);
      else
        localHashMap.put(localObject, new Integer(1 + localInteger.intValue()));
    }
    return localHashMap;
  }

  public static Map<Object, JSONObject> a(JSONArray paramJSONArray, String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
      localHashMap.put(localJSONObject.get(paramString), localJSONObject);
    }
    return localHashMap;
  }

  public static Set<String> a(JSONObject paramJSONObject)
  {
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
      localTreeSet.add((String)localIterator.next());
    return localTreeSet;
  }

  public static boolean a(Object paramObject)
  {
    return (!(paramObject instanceof JSONObject)) && (!(paramObject instanceof JSONArray));
  }

  public static boolean a(String paramString, JSONArray paramJSONArray)
  {
    HashSet localHashSet = new HashSet();
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      Object localObject1 = paramJSONArray.get(i);
      boolean bool2 = localObject1 instanceof JSONObject;
      bool1 = false;
      if (!bool2)
        break label122;
      JSONObject localJSONObject = (JSONObject)localObject1;
      boolean bool3 = localJSONObject.has(paramString);
      bool1 = false;
      if (!bool3)
        break label122;
      Object localObject2 = localJSONObject.get(paramString);
      boolean bool4 = a(localObject2);
      bool1 = false;
      if (!bool4)
        break label122;
      boolean bool5 = localHashSet.contains(localObject2);
      bool1 = false;
      if (bool5)
        break label122;
      localHashSet.add(localObject2);
    }
    boolean bool1 = true;
    label122: return bool1;
  }

  public static List<Object> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(paramJSONArray.get(i));
    return localArrayList;
  }

  public static boolean c(JSONArray paramJSONArray)
  {
    for (int i = 0; i < paramJSONArray.length(); i++)
      if (!a(paramJSONArray.get(i)))
        return false;
    return true;
  }

  public static boolean d(JSONArray paramJSONArray)
  {
    for (int i = 0; i < paramJSONArray.length(); i++)
      if (!(paramJSONArray.get(i) instanceof JSONObject))
        return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gd
 * JD-Core Version:    0.6.2
 */