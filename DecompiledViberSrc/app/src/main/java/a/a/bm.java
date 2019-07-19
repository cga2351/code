package a.a;

import com.appboy.e.e;
import com.appboy.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public class bm
  implements e<JSONObject>
{
  private static final String a = c.a(bm.class);
  private final long b;

  public bm(long paramLong)
  {
    this.b = paramLong;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("config_time", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.a(a, "Caught exception creating config params json.", localJSONException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bm
 * JD-Core Version:    0.6.2
 */