package a.a;

import com.appboy.f.c;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

final class ge
  implements fg
{
  private static final String a = c.a(ge.class);
  private final fg b;

  public ge(fg paramfg)
  {
    this.b = paramfg;
  }

  private String a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localArrayList.add("(" + (String)localEntry.getKey() + " / " + (String)localEntry.getValue() + ")");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      localStringBuilder.append((String)localIterator2.next());
      localStringBuilder.append(", ");
    }
    if (localStringBuilder.length() == 0)
      return "";
    return localStringBuilder.substring(0, -2 + localStringBuilder.length());
  }

  private void a(URI paramURI, Map<String, String> paramMap, String paramString)
  {
    try
    {
      c.b(a, "Making request(id = " + paramString + ") to [" + paramURI.toString() + "] \nwith headers: [" + a(paramMap) + "]");
      return;
    }
    catch (Exception localException)
    {
      c.a(a, "Exception while logging request: ", localException);
    }
  }

  private void a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject, String paramString)
  {
    try
    {
      c.b(a, "Making request(id = " + paramString + ") to [" + paramURI.toString() + "] \nwith headers: [" + a(paramMap) + "] \nand JSON parameters: \n[" + dr.a(paramJSONObject) + "]");
      return;
    }
    catch (Exception localException)
    {
      c.a(a, "Exception while logging request: ", localException);
    }
  }

  private void a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (paramJSONObject == null)
      localObject = "none";
    try
    {
      while (true)
      {
        c.b(a, "Result(id = " + paramString + ") \n[" + (String)localObject + "]");
        return;
        String str = dr.a(paramJSONObject);
        localObject = str;
      }
    }
    catch (Exception localException)
    {
      c.a(a, "Exception while logging result: ", localException);
    }
  }

  public JSONObject a(URI paramURI, Map<String, String> paramMap)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramURI;
    arrayOfObject[1] = paramMap;
    arrayOfObject[2] = gu.a;
    String str = dp.a(arrayOfObject);
    a(paramURI, paramMap, str);
    JSONObject localJSONObject = this.b.a(paramURI, paramMap);
    a(localJSONObject, str);
    return localJSONObject;
  }

  public JSONObject a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramURI;
    arrayOfObject[1] = paramMap;
    arrayOfObject[2] = paramJSONObject;
    arrayOfObject[3] = gu.b;
    String str = dp.a(arrayOfObject);
    a(paramURI, paramMap, paramJSONObject, str);
    JSONObject localJSONObject = this.b.a(paramURI, paramMap, paramJSONObject);
    a(localJSONObject, str);
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ge
 * JD-Core Version:    0.6.2
 */