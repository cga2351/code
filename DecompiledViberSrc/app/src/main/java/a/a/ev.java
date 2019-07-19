package a.a;

import org.json.JSONException;
import org.json.JSONObject;

public class ev
  implements et
{
  private final long a;
  private final long b;
  private final int c;
  private final int d;
  private final int e;
  private final es f;
  private final int g;

  public ev(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optLong("start_time", -1L);
    this.b = paramJSONObject.optLong("end_time", -1L);
    this.c = paramJSONObject.optInt("priority", 0);
    this.g = paramJSONObject.optInt("min_seconds_since_last_trigger", -1);
    this.d = paramJSONObject.optInt("delay", 0);
    this.e = paramJSONObject.optInt("timeout", -1);
    this.f = new eu(paramJSONObject);
  }

  public long a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public es f()
  {
    return this.f;
  }

  public int g()
  {
    return this.g;
  }

  public JSONObject i()
  {
    try
    {
      JSONObject localJSONObject = (JSONObject)this.f.h();
      localJSONObject.put("start_time", this.a);
      localJSONObject.put("end_time", this.b);
      localJSONObject.put("priority", this.c);
      localJSONObject.put("min_seconds_since_last_trigger", this.g);
      localJSONObject.put("timeout", this.e);
      localJSONObject.put("delay", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ev
 * JD-Core Version:    0.6.2
 */