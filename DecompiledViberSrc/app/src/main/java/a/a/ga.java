package a.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class ga
  implements gc
{
  public final fy a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    fy localfy = new fy();
    e("", paramJSONArray1, paramJSONArray2, localfy);
    return localfy;
  }

  public final fy a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    fy localfy = new fy();
    c("", paramJSONObject1, paramJSONObject2, localfy);
    return localfy;
  }

  protected void a(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, fy paramfy)
  {
    String str = gd.a(paramJSONArray1);
    if ((str == null) || (!gd.a(str, paramJSONArray2)))
      d(paramString, paramJSONArray1, paramJSONArray2, paramfy);
    while (true)
    {
      return;
      Map localMap1 = gd.a(paramJSONArray1, str);
      Map localMap2 = gd.a(paramJSONArray2, str);
      Iterator localIterator1 = localMap1.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject2 = localIterator1.next();
        if (!localMap2.containsKey(localObject2))
        {
          paramfy.a(gd.a(paramString, str, localObject2), localMap1.get(localObject2));
        }
        else
        {
          JSONObject localJSONObject1 = (JSONObject)localMap1.get(localObject2);
          JSONObject localJSONObject2 = (JSONObject)localMap2.get(localObject2);
          a(gd.a(paramString, str, localObject2), localJSONObject1, localJSONObject2, paramfy);
        }
      }
      Iterator localIterator2 = localMap2.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Object localObject1 = localIterator2.next();
        if (!localMap1.containsKey(localObject1))
          paramfy.b(gd.a(paramString, str, localObject1), localMap2.get(localObject1));
      }
    }
  }

  protected void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, fy paramfy)
  {
    Iterator localIterator = gd.a(paramJSONObject2).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramJSONObject1.has(str))
        paramfy.b(paramString, str);
    }
  }

  protected void b(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, fy paramfy)
  {
    Map localMap1 = gd.a(gd.b(paramJSONArray1));
    Map localMap2 = gd.a(gd.b(paramJSONArray2));
    Iterator localIterator1 = localMap1.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject2 = localIterator1.next();
      if (!localMap2.containsKey(localObject2))
        paramfy.a(paramString + "[]", localObject2);
      else if (!((Integer)localMap2.get(localObject2)).equals(localMap1.get(localObject2)))
        paramfy.a(paramString + "[]: Expected " + localMap1.get(localObject2) + " occurrence(s) of " + localObject2 + " but got " + localMap2.get(localObject2) + " occurrence(s)");
    }
    Iterator localIterator2 = localMap2.keySet().iterator();
    while (localIterator2.hasNext())
    {
      Object localObject1 = localIterator2.next();
      if (!localMap1.containsKey(localObject1))
        paramfy.b(paramString + "[]", localObject1);
    }
  }

  protected void b(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, fy paramfy)
  {
    Iterator localIterator = gd.a(paramJSONObject1).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject1.get(str);
      if (paramJSONObject2.has(str))
      {
        Object localObject2 = paramJSONObject2.get(str);
        a(gd.a(paramString, str), localObject1, localObject2, paramfy);
      }
      else
      {
        paramfy.a(paramString, str);
      }
    }
  }

  protected void c(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, fy paramfy)
  {
    for (int i = 0; i < paramJSONArray1.length(); i++)
    {
      Object localObject1 = paramJSONArray1.get(i);
      Object localObject2 = paramJSONArray2.get(i);
      a(paramString + "[" + i + "]", localObject1, localObject2, paramfy);
    }
  }

  protected void d(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, fy paramfy)
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    int j;
    Object localObject2;
    label80: int k;
    if (i < paramJSONArray1.length())
    {
      localObject1 = paramJSONArray1.get(i);
      j = 0;
      if (j >= paramJSONArray2.length())
        break label257;
      localObject2 = paramJSONArray2.get(j);
      if ((localHashSet.contains(Integer.valueOf(j))) || (!localObject2.getClass().equals(localObject1.getClass())));
      do
      {
        j++;
        break;
        if (!(localObject1 instanceof JSONObject))
          break label175;
      }
      while (!a((JSONObject)localObject1, (JSONObject)localObject2).a());
      localHashSet.add(Integer.valueOf(j));
      k = 1;
    }
    while (true)
    {
      if (k == 0)
      {
        paramfy.a(paramString + "[" + i + "] Could not find match for element " + localObject1);
        return;
        label175: if ((localObject1 instanceof JSONArray))
        {
          if (!a((JSONArray)localObject1, (JSONArray)localObject2).a())
            break label80;
          localHashSet.add(Integer.valueOf(j));
          k = 1;
          continue;
        }
        if (!localObject1.equals(localObject2))
          break label80;
        localHashSet.add(Integer.valueOf(j));
        k = 1;
        continue;
      }
      i++;
      break;
      label257: k = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ga
 * JD-Core Version:    0.6.2
 */