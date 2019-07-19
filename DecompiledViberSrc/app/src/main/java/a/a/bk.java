package a.a;

import com.appboy.f.c;
import com.appboy.f.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class bk
  implements bf
{
  private static final String a = c.a(bk.class);
  private final double b;
  private final double c;
  private final Double d;
  private final Double e;

  public bk(double paramDouble1, double paramDouble2, Double paramDouble3, Double paramDouble4)
  {
    if (!j.a(paramDouble1, paramDouble2))
      throw new IllegalArgumentException("Unable to create AppboyLocation. Latitude and longitude values are bounded by ±90 and ±180 respectively");
    this.b = paramDouble1;
    this.c = paramDouble2;
    this.d = paramDouble3;
    this.e = paramDouble4;
  }

  public double a()
  {
    return this.b;
  }

  public double b()
  {
    return this.c;
  }

  public Double c()
  {
    return this.d;
  }

  public Double d()
  {
    return this.e;
  }

  public boolean e()
  {
    return this.d != null;
  }

  public boolean f()
  {
    return this.e != null;
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("latitude", this.b);
      localJSONObject.put("longitude", this.c);
      if (e())
        localJSONObject.put("altitude", this.d);
      if (f())
        localJSONObject.put("ll_accuracy", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception creating location Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bk
 * JD-Core Version:    0.6.2
 */