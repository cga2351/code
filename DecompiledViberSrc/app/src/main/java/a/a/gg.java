package a.a;

import com.appboy.f.c;
import java.net.URI;
import java.util.Map;
import org.json.JSONObject;

final class gg
  implements fg
{
  private static final String a = c.a(gg.class);
  private final fg b;

  public gg(fg paramfg)
  {
    this.b = paramfg;
  }

  public JSONObject a(URI paramURI, Map<String, String> paramMap)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = this.b.a(paramURI, paramMap);
      Object[] arrayOfObject2;
      String str2;
      long l3;
      return localJSONObject;
    }
    finally
    {
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramURI;
      arrayOfObject1[1] = paramMap;
      arrayOfObject1[2] = gu.a;
      String str1 = dp.a(arrayOfObject1);
      long l2 = System.currentTimeMillis();
      c.b(a, "Request(id = " + str1 + ") Executed in [" + (l2 - l1) + "ms] [" + gu.a.toString() + " : " + paramURI.toString() + "]");
    }
  }

  public JSONObject a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = this.b.a(paramURI, paramMap, paramJSONObject);
      Object[] arrayOfObject2;
      String str2;
      long l3;
      return localJSONObject;
    }
    finally
    {
      Object[] arrayOfObject1 = new Object[4];
      arrayOfObject1[0] = paramURI;
      arrayOfObject1[1] = paramMap;
      arrayOfObject1[2] = paramJSONObject;
      arrayOfObject1[3] = gu.b;
      String str1 = dp.a(arrayOfObject1);
      long l2 = System.currentTimeMillis();
      c.b(a, "Request(id = " + str1 + ") Executed in [" + (l2 - l1) + "ms] [" + gu.b.toString() + ":" + paramURI.toString() + "]");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gg
 * JD-Core Version:    0.6.2
 */